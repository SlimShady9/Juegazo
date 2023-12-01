package com.juegazo.juegazo.mechanics.combat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.juegazo.juegazo.combat.Arena;
import com.juegazo.juegazo.combat.Defender;
import com.juegazo.juegazo.mechanics.Combat;
import com.juegazo.juegazo.models.Enemy;
import com.juegazo.juegazo.models.Room;
import com.juegazo.juegazo.services.CombatImpl;

@ExtendWith(MockitoExtension.class)
public class CombatServiceTests {

    Combat combat;

    @Mock
    Room room;

    @Mock
    Enemy bossEnemy;

    @Mock
    Enemy dumbEnemy;

    

    @BeforeEach
    public void setup() {
        combat = new CombatImpl();
    }


    @Nested
    class OnePlayerConfigurationTests {

        @BeforeEach
        public void setup() {

            when(room.getPlayers().size()).thenReturn(1);
            //when
            
        }

        public void testCombatBegin() {
            
            Arena arena = combat.beginCombat(room, bossEnemy);

            //assertEquals(, arena);

        }
    }

    

    
    
}
