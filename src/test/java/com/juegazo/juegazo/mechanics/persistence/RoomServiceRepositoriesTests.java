package com.juegazo.juegazo.mechanics.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import com.juegazo.juegazo.authentication.RegisteredUser;
import com.juegazo.juegazo.enums.PlayerType;
import com.juegazo.juegazo.enums.RoomState;
import com.juegazo.juegazo.models.Player;
import com.juegazo.juegazo.models.Room;
import com.juegazo.juegazo.repositories.PlayerRepository;
import com.juegazo.juegazo.repositories.RoomRepository;

import lombok.extern.slf4j.Slf4j;

@DataJpaTest
@Slf4j
public class RoomServiceRepositoriesTests {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    public void testRoomCreationWith1User() {
        Room room = Room.builder()
        .roomState(RoomState.ACTIVE)
        .name("Room")
        .build();

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
        RegisteredUser userJdbc = jdbcTemplate.queryForObject("select * from registered_user where id_registered_user = ?", new RegisteredUserRowMapper() , player.getUser().getIdRegisteredUser());
        
        assertNotNull(userJdbc);
        assertEquals(userJdbc.getIdRegisteredUser(), user.getIdRegisteredUser());
        assertEquals(userJdbc.getName(), user.getName());

        room.setRegisteredPlayers(new ArrayList<Player>(List.of(player)));
        room = roomRepository.save(room);

        RowMapper<Room> queryRoomJoinPlayer = (rs, rowNum) -> {
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

        roomJdbc = jdbcTemplate.queryForObject("select * from room r inner join player p on p.room = r.id_room where r.id_room = ?", queryRoomJoinPlayer, room.getIdRoom());

        assertNotNull(roomJdbc);
        assertEquals(roomJdbc.getIdRoom(), room.getIdRoom());
        assertEquals(roomJdbc.getRegisteredPlayers().size(), room.getRegisteredPlayers().size());
        assertEquals(roomJdbc.getRegisteredPlayers().get(0).getIdPlayer(), room.getRegisteredPlayers().get(0).getIdPlayer());


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
