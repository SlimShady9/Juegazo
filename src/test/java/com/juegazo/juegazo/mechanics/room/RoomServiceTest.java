package com.juegazo.juegazo.mechanics.room;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.juegazo.juegazo.authentication.RegisteredUser;
import com.juegazo.juegazo.enums.RoomState;
import com.juegazo.juegazo.models.Enemy;
import com.juegazo.juegazo.models.Player;
import com.juegazo.juegazo.models.PlayerInfo;
import com.juegazo.juegazo.models.Room;
import com.juegazo.juegazo.repositories.EnemyRepository;
import com.juegazo.juegazo.repositories.PlayerRepository;
import com.juegazo.juegazo.repositories.RoomRepository;
import com.juegazo.juegazo.services.RoomServiceImpl;


/**
 * Unit testing for roomService
 */
@ExtendWith(MockitoExtension.class)
public class RoomServiceTest {


    @Mock
    EnemyRepository enemyRepository;

    @Mock
    PlayerRepository playerRepository;

    @Mock
    RoomRepository roomRepository;

    @InjectMocks
    RoomServiceImpl roomServiceImpl;


    RegisteredUser user1;
    RegisteredUser user2;


    List<Enemy> enemies;


    @BeforeEach
    public void setup() {
        user1 = RegisteredUser.builder().name("Sofia").idRegisteredUser(1L).build();
        user2 = RegisteredUser.builder().name("Pepito").idRegisteredUser(2L).build();

        enemies = Enemy.buildRandomEnemies();
        
        
    }

    @Test
    public void testSuccessfulRoomCreation() {

        String roomName = "Room 1";

        Room room = Room.builder()
            .roomState(RoomState.ACTIVE)
            .name(roomName)
            .idRoom(Long.valueOf(1))
            .build();

        when(roomRepository.save(any(Room.class)))
            .thenReturn(room);
        
        Room roomCreated = roomServiceImpl.buildRoom(user1, roomName);

        assertEquals(roomCreated.getRoomState(), roomCreated.getRoomState());
        assertEquals(roomCreated.getPlayers().size(), 1);
        assertEquals(roomCreated.getRegisteredPlayers().get(0).getUser().getName(), user1.getName());
        assertNotNull(roomCreated.getIdRoom());
        
    }

    @Test
    public void testRoomUserJoin() {
        
        String roomName = "Room 2";

        

        Room room = Room.builder()
            .roomState(RoomState.ACTIVE)
            .name(roomName)
            .idRoom(Long.valueOf(1))
            .enemies(Enemy.buildRandomEnemies())
            .players(new ArrayList<>())
            .build();

        Player player1 = Player.builder()
            .idPlayer(Long.valueOf(1L))
            .room(room)
            .user(user1)
            .experience(0)
            .build();
        
        room.setPlayers(new ArrayList<>(List.of(PlayerInfo.build(player1))));
        room.setRegisteredPlayers(new ArrayList<>(List.of(player1)));
        
        Player player2 = Player.builder()
            .idPlayer(Long.valueOf(1L))
            .room(room)
            .user(user2)
            .experience(0)
            .build();
        

        when(playerRepository.save(any(Player.class)))
            .thenReturn(player2);

        
        Room createdRoom = roomServiceImpl.joinRoom(room, user2);

        assertEquals(createdRoom.getPlayers().size(), 2);
        assertEquals(createdRoom.getRegisteredPlayers().size(), 2);
        assertEquals(createdRoom.getRoomState(), RoomState.ACTIVE);
        
    }
    

    @Test
    public void testRoomUserLeave() {

        String roomName = "Room 3";

        Room room = Room.builder()
            .roomState(RoomState.ACTIVE)
            .name(roomName)
            .idRoom(Long.valueOf(1))
            .enemies(Enemy.buildRandomEnemies())
            .players(new ArrayList<>())
            .build();

        Player player1 = Player.builder()
            .idPlayer(Long.valueOf(1L))
            .room(room)
            .experience(0)
            .user(user1)
            .build();

        Player player2 = Player.builder()
            .idPlayer(Long.valueOf(2L))
            .room(room)
            .user(user2)
            .experience(0)
            .build();

        room.setPlayers(new ArrayList<>(List.of(PlayerInfo.build(player1), PlayerInfo.build(player2))));
        room.setRegisteredPlayers(new ArrayList<>(List.of(player1, player2)));

        Room createdRoom = roomServiceImpl.leaveRoom(room, player1);

        assertEquals(createdRoom.getPlayers().size(), 1);
        assertEquals(createdRoom.getRegisteredPlayers().size(), 1);

        createdRoom = roomServiceImpl.leaveRoom(room, player2);

        assertEquals(createdRoom.getPlayers().size(), 0);
        assertEquals(createdRoom.getRegisteredPlayers().size(), 0);

        //assertTrue(RoomState.INACTIVE.equals(createdRoom.getRoomState()));

    }
}
