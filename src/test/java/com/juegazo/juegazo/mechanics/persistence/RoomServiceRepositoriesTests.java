package com.juegazo.juegazo.mechanics.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.test.annotation.Commit;

import com.juegazo.juegazo.authentication.RegisteredUser;
import com.juegazo.juegazo.enums.PlayerType;
import com.juegazo.juegazo.enums.RoomState;
import com.juegazo.juegazo.models.Player;
import com.juegazo.juegazo.models.Room;
import com.juegazo.juegazo.repositories.PlayerRepository;
import com.juegazo.juegazo.repositories.RoomRepository;


@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RoomServiceRepositoriesTests {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Room> queryRoomJoinPlayer = (rs, rowNum) -> {
        Room r = Room.builder()
            .idRoom(rs.getLong("id_room"))
            .name(rs.getString("name_room"))
            .roomState(RoomState.valueOf(rs.getString("room_state")))
            .build();

        List<Player> p = new ArrayList<>();
        do {
            p.add(Player.builder()
                .idPlayer(rs.getLong("id_player"))
                .type(PlayerType.valueOf(rs.getString("player_type")))
                .experience(rs.getInt("experience"))
                .room(r)
                .build());
        } while (rs.next());

        r.setRegisteredPlayers(p);
        return r;
    };

    private Room room = Room.builder()
        .roomState(RoomState.ACTIVE)
        .name("Room")
        .registeredPlayers(new ArrayList<Player>())
        .build();



    @Test
    @Commit
    @Order(1)
    public void testRoomCreationWith1User() {
        roomRepository.save(room);

        Room roomJdbc = jdbcTemplate.queryForObject("select * from Room where id_room = ?", new RoomRowMapper() , room.getIdRoom());
        
        assertNotNull(roomJdbc);
        assertEquals(roomJdbc.getIdRoom(), room.getIdRoom());
        assertEquals(roomJdbc.getRoomState(), room.getRoomState());

        RegisteredUser user = RegisteredUser.builder().name("Juan").build();

        Player player = Player.builder()
                .experience(0)
                .type(PlayerType.WARRIOR)
                .user(user)
                .room(room)
                .build();

        playerRepository.save(player);
        room.setRegisteredPlayers(new ArrayList<>(List.of(player)));
        RegisteredUser userJdbc = jdbcTemplate.queryForObject("select * from registered_user where id_registered_user = ?", new RegisteredUserRowMapper() , player.getUser().getIdRegisteredUser());
        
        assertNotNull(userJdbc);
        assertEquals(userJdbc.getIdRegisteredUser(), user.getIdRegisteredUser());
        assertEquals(userJdbc.getName(), user.getName());



        roomJdbc = jdbcTemplate.queryForObject("select * from room r inner join player p on p.room = r.id_room where r.id_room = ?", queryRoomJoinPlayer, room.getIdRoom());
        room = roomRepository.findById(room.getIdRoom()).get();
        
        assertNotNull(roomJdbc);
        
        List<Player> playerRoom = room.getRegisteredPlayers();
        List<Player> jdbcPlayerRoom = roomJdbc.getRegisteredPlayers();


        assertEquals(roomJdbc.getIdRoom(), room.getIdRoom());
        assertEquals(jdbcPlayerRoom.size(), playerRoom.size());
        assertEquals(jdbcPlayerRoom.get(0).getIdPlayer(), playerRoom.get(0).getIdPlayer());
    }


    @Test
    @Commit
    @Order(2)
    public void testPLayerJointAndLeft() {

        RegisteredUser user = RegisteredUser.builder().name("Sofia").build();
        room = roomRepository.findById(1L).get();

        Player player = Player.builder()
                .experience(0)
                .type(PlayerType.MAGE)
                .user(user)
                .room(room)
                .build();
        
        playerRepository.save(player);

        room.setRegisteredPlayers(playerRepository.findAllByRoom(room));
        Room roomJdbc = jdbcTemplate.queryForObject("select * from room r inner join player p on p.room = r.id_room where r.id_room = ?", queryRoomJoinPlayer, room.getIdRoom());
        
        assertNotNull(roomJdbc);
        List<Player> playerRoom = room.getRegisteredPlayers();
        List<Player> jdbcPlayerRoom = roomJdbc.getRegisteredPlayers();

        assertEquals(roomJdbc.getIdRoom(), room.getIdRoom());
        assertEquals(roomJdbc.getRegisteredPlayers().size(), room.getRegisteredPlayers().size());
        assertEquals(jdbcPlayerRoom.get(0).getIdPlayer(), playerRoom.get(0).getIdPlayer());

        room = roomRepository.findById(1L).get();
        player = playerRepository.findByIdPlayerAndRoom(1L, room);
        

        playerRepository.delete(player);

        room.getRegisteredPlayers().remove(player);

        
        playerRoom = room.getRegisteredPlayers();
        List<Player> tranPlayers = playerRepository.findAllByRoom(room);

        assertEquals(roomJdbc.getIdRoom(), room.getIdRoom());
        assertEquals(tranPlayers.size(), room.getRegisteredPlayers().size());
        assertEquals(tranPlayers.get(0).getIdPlayer(), playerRoom.get(0).getIdPlayer());
    }



    private class RoomRowMapper implements RowMapper<Room> {

        @Override
        @Nullable
        public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Room.builder()
                .idRoom(rs.getLong("id_room"))
                .name(rs.getString("name_room"))
                .roomState(RoomState.valueOf(rs.getString("room_state")))
                .build();
        }
    }

    private class RegisteredUserRowMapper implements RowMapper<RegisteredUser> {

        @Override
        @Nullable
        public RegisteredUser mapRow(ResultSet rs, int rowNum) throws SQLException {
            return RegisteredUser.builder()
                .idRegisteredUser(rs.getLong("id_registered_user"))
                .name(rs.getString("name_user"))
                .build();
        }
    }
    
}
