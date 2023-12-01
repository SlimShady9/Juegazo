package com.juegazo.juegazo.mechanics.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.juegazo.juegazo.combat.Defender;
import com.juegazo.juegazo.enums.EnemyState;
import com.juegazo.juegazo.enums.EnemyType;
import com.juegazo.juegazo.models.Enemy;

public class DefenderTests {

    @Nested
    class BossEnemyTests {

        Enemy bossEnemyLvl10;
        Enemy bossEnemyLvl15;
        Enemy bossEnemyLvl20;
        Defender bossDefLvl10;
        Defender bossDefLvl15;
        Defender bossDefLvl20;
        
        @BeforeEach
        public void setup() {
            bossEnemyLvl10 = Enemy.builder()
                .enemyState(EnemyState.ALIVE)
                .level(10)
                .enemyType(EnemyType.BOSS)
                .build();

            bossEnemyLvl15 = Enemy.builder()
                .enemyState(EnemyState.ALIVE)
                .level(15)
                .enemyType(EnemyType.BOSS)
                .build();

            bossEnemyLvl20 = Enemy.builder()
                .enemyState(EnemyState.ALIVE)
                .level(20)
                .enemyType(EnemyType.BOSS)
                .build();
        }

        @Test
        public void testBossLvl10() {
            bossDefLvl10 = Defender.makeFromEnemy(bossEnemyLvl10);

            assertEquals(EnemyType.BOSS, bossDefLvl10.getEnemyType());
            // Boss lvl 10 should have 2000 hp
            assertEquals(2000, bossDefLvl10.getMaxHealth());
            assertEquals(2000, bossDefLvl10.getHealth());
            assertEquals(10, bossDefLvl10.getBaseDamage());
            assertEquals(5, bossDefLvl10.getPhisicalArmor());
            assertEquals(5, bossDefLvl10.getMagicalArmor());
            
        }

        @Test
        public void testBossLvl15() {

            bossDefLvl15 = Defender.makeFromEnemy(bossEnemyLvl15);

            assertEquals(EnemyType.BOSS, bossDefLvl15.getEnemyType());
            // Boss lvl 10 should have 2000 hp
            assertEquals(4000, bossDefLvl15.getMaxHealth());
            assertEquals(4000, bossDefLvl15.getHealth());
            assertEquals(20, bossDefLvl15.getBaseDamage());
            assertEquals(10, bossDefLvl15.getPhisicalArmor());
            assertEquals(10, bossDefLvl15.getMagicalArmor());
            
        }

        @Test
        public void testBossLvl20() {

            bossDefLvl20 = Defender.makeFromEnemy(bossEnemyLvl20);

            assertEquals(EnemyType.BOSS, bossDefLvl20.getEnemyType());
            // Boss lvl 10 should have 2000 hp
            assertEquals(6000, bossDefLvl20.getMaxHealth());
            assertEquals(6000, bossDefLvl20.getHealth());
            assertEquals(30, bossDefLvl20.getBaseDamage());
            assertEquals(15, bossDefLvl20.getPhisicalArmor());
            assertEquals(15, bossDefLvl20.getMagicalArmor());
            
        }
    }


    @Nested
    class DumbEnemyTests {

        Enemy dumbEnemyLvl10;
        Enemy dumbEnemyLvl15;
        Enemy dumbEnemyLvl20;
        Defender dumbDefLvl10;
        Defender dumbDefLvl15;
        Defender dumbDefLvl20;
        
        @BeforeEach
        public void setup() {
            dumbEnemyLvl10 = Enemy.builder()
                .enemyState(EnemyState.ALIVE)
                .level(10)
                .enemyType(EnemyType.GOBLIN)
                .build();

            dumbEnemyLvl15 = Enemy.builder()
                .enemyState(EnemyState.ALIVE)
                .level(15)
                .enemyType(EnemyType.GOBLIN)
                .build();

            dumbEnemyLvl20 = Enemy.builder()
                .enemyState(EnemyState.ALIVE)
                .level(20)
                .enemyType(EnemyType.GOBLIN)
                .build();
        }

        @Test
        public void testBossLvl10() {
            dumbDefLvl10 = Defender.makeFromEnemy(dumbEnemyLvl10);

            assertEquals(EnemyType.GOBLIN, dumbDefLvl10.getEnemyType());
            // Boss lvl 10 should have 2000 hp
            assertEquals(2000, dumbDefLvl10.getMaxHealth());
            assertEquals(2000, dumbDefLvl10.getHealth());
            assertEquals(10, dumbDefLvl10.getBaseDamage());
            assertEquals(5, dumbDefLvl10.getPhisicalArmor());
            assertEquals(5, dumbDefLvl10.getMagicalArmor());
            
        }

        @Test
        public void testBossLvl15() {

            dumbDefLvl15 = Defender.makeFromEnemy(dumbEnemyLvl15);

            assertEquals(EnemyType.GOBLIN, dumbDefLvl15.getEnemyType());
            // Boss lvl 10 should have 2000 hp
            assertEquals(4000, dumbDefLvl15.getMaxHealth());
            assertEquals(4000, dumbDefLvl15.getHealth());
            assertEquals(20, dumbDefLvl15.getBaseDamage());
            assertEquals(10, dumbDefLvl15.getPhisicalArmor());
            assertEquals(10, dumbDefLvl15.getMagicalArmor());
            
        }

        @Test
        public void testBossLvl20() {

            dumbDefLvl20 = Defender.makeFromEnemy(dumbEnemyLvl20);

            assertEquals(EnemyType.GOBLIN, dumbDefLvl20.getEnemyType());
            // Boss lvl 10 should have 2000 hp
            assertEquals(6000, dumbDefLvl20.getMaxHealth());
            assertEquals(6000, dumbDefLvl20.getHealth());
            assertEquals(30, dumbDefLvl20.getBaseDamage());
            assertEquals(15, dumbDefLvl20.getPhisicalArmor());
            assertEquals(15, dumbDefLvl20.getMagicalArmor());
            
        }
    }


    
    
}
