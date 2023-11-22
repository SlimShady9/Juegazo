package com.juegazo.juegazo.mechanics.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.juegazo.juegazo.enums.PlayerState;
import com.juegazo.juegazo.models.Player;
import com.juegazo.juegazo.models.PlayerInfo;
import com.juegazo.juegazo.models.Room;


@ExtendWith(MockitoExtension.class)
public class PlayerTests {


    Player player1, player2, player3, player4, player5;

    @Mock
    Room room;
    

    @BeforeEach
    public void setup() {
        player1 = Player.builder().experience(99).room(room).build();
        player2 = Player.builder().experience(100).room(room).build();
        player3 = Player.builder().experience(1000).room(room).build();
        player4 = Player.builder().experience(2000).room(room).build();
        player5 = Player.builder().experience(1500).room(room).build();

    }

    @Test
    public void testPLayerInfoBuild() {
        PlayerInfo pInfo1 = PlayerInfo.build(player1);

        assertEquals(PlayerState.FREE, pInfo1.getPlayerState());
        assertEquals(player1, pInfo1.getPlayer());
        assertEquals(0, pInfo1.getXPosition());
        assertEquals(0, pInfo1.getYPosition());


    }


    @Test
    public void testLevelPlayer() {
        assertEquals(0, player1.calculateLevel());
        assertEquals(1, player2.calculateLevel());
        assertEquals(10, player3.calculateLevel());
        assertEquals(20, player4.calculateLevel());
        assertEquals(15, player5.calculateLevel());
    }
    
}
