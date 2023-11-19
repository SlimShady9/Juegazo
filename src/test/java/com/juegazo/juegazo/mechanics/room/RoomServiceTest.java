package com.juegazo.juegazo.mechanics.room;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.juegazo.juegazo.authentication.RegisteredUser;
import com.juegazo.juegazo.models.Enemy;
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
    RegisteredUser user3;


    List<Enemy> enemies;


    @BeforeEach
    public void setup() {
        user1 = RegisteredUser.builder().name("Pepito").build();
        user2 = RegisteredUser.builder().name("Juanito").build();
        user3 = RegisteredUser.builder().name("Sofia").build();

        enemies = Enemy.buildRandomEnemies();
        
        //when()
    }

    @Test
    public void testSuccessfulRoomCreation() {

        //when(roomService.buildRoom(user1, "Sala1")).thenReturn(null)
        
    }

    @Test
    public void testRoomUsersJoin() {

        //roomService.
    }
    
}
