package com.juegazo.juegazo.mechanics.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.juegazo.juegazo.combat.Defender;
import com.juegazo.juegazo.enums.AttackType;
import com.juegazo.juegazo.enums.EnemyType;
import com.juegazo.juegazo.enums.EntityState;
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
                .enemyState(EntityState.ALIVE)
                .level(10)
                .enemyType(EnemyType.BOSS)
                .build();

            bossEnemyLvl15 = Enemy.builder()
                .enemyState(EntityState.ALIVE)
                .level(15)
                .enemyType(EnemyType.BOSS)
                .build();

            bossEnemyLvl20 = Enemy.builder()
                .enemyState(EntityState.ALIVE)
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
            // Attack types
            assertEquals(50, bossDefLvl10.calculateDamage(AttackType.MAGICAL));
            assertEquals(50, bossDefLvl10.calculateDamage(AttackType.PHISICAL));
            assertEquals(100, bossDefLvl10.calculateDamage(AttackType.SPECIAL));
            
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
            // Attack types
            assertEquals(200, bossDefLvl15.calculateDamage(AttackType.MAGICAL));
            assertEquals(200, bossDefLvl15.calculateDamage(AttackType.PHISICAL));
            assertEquals(400, bossDefLvl15.calculateDamage(AttackType.SPECIAL));
            
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
            // Attack types
            assertEquals(450, bossDefLvl20.calculateDamage(AttackType.MAGICAL));
            assertEquals(450, bossDefLvl20.calculateDamage(AttackType.PHISICAL));
            assertEquals(900, bossDefLvl20.calculateDamage(AttackType.SPECIAL));
            
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
                .enemyState(EntityState.ALIVE)
                .level(10)
                .enemyType(EnemyType.GOBLIN)
                .build();

            dumbEnemyLvl15 = Enemy.builder()
                .enemyState(EntityState.ALIVE)
                .level(15)
                .enemyType(EnemyType.GOBLIN)
                .build();

            dumbEnemyLvl20 = Enemy.builder()
                .enemyState(EntityState.ALIVE)
                .level(20)
                .enemyType(EnemyType.GOBLIN)
                .build();
        }

        @Test
        public void testDummyLvl10() {
            dumbDefLvl10 = Defender.makeFromEnemy(dumbEnemyLvl10);

            assertEquals(EnemyType.GOBLIN, dumbDefLvl10.getEnemyType());
            // Boss lvl 10 should have 2000 hp
            assertEquals(500, dumbDefLvl10.getMaxHealth());
            assertEquals(500, dumbDefLvl10.getHealth());
            assertEquals(4, dumbDefLvl10.getBaseDamage());
            assertEquals(1, dumbDefLvl10.getPhisicalArmor());
            assertEquals(1, dumbDefLvl10.getMagicalArmor());

            // Attack types
            assertEquals(4, dumbDefLvl10.calculateDamage(AttackType.MAGICAL));
            assertEquals(4, dumbDefLvl10.calculateDamage(AttackType.PHISICAL));
            assertEquals(8, dumbDefLvl10.calculateDamage(AttackType.SPECIAL));
            
        }

        @Test
        public void testDummyLvl15() {

            dumbDefLvl15 = Defender.makeFromEnemy(dumbEnemyLvl15);

            assertEquals(EnemyType.GOBLIN, dumbDefLvl15.getEnemyType());
            // Boss lvl 10 should have 2000 hp
            assertEquals(1250, dumbDefLvl15.getMaxHealth());
            assertEquals(1250, dumbDefLvl15.getHealth());
            assertEquals(9, dumbDefLvl15.getBaseDamage());
            assertEquals(6, dumbDefLvl15.getPhisicalArmor());
            assertEquals(6, dumbDefLvl15.getMagicalArmor());
            

            // Attack types
            assertEquals(54, dumbDefLvl15.calculateDamage(AttackType.MAGICAL));
            assertEquals(54, dumbDefLvl15.calculateDamage(AttackType.PHISICAL));
            assertEquals(108, dumbDefLvl15.calculateDamage(AttackType.SPECIAL));
        }

        @Test
        public void testDummyLvl20() {

            dumbDefLvl20 = Defender.makeFromEnemy(dumbEnemyLvl20);

            assertEquals(EnemyType.GOBLIN, dumbDefLvl20.getEnemyType());
            // Boss lvl 10 should have 2000 hp
            assertEquals(2000, dumbDefLvl20.getMaxHealth());
            assertEquals(2000, dumbDefLvl20.getHealth());
            assertEquals(14, dumbDefLvl20.getBaseDamage());
            assertEquals(11, dumbDefLvl20.getPhisicalArmor());
            assertEquals(11, dumbDefLvl20.getMagicalArmor());

            // Attack types
            assertEquals(154, dumbDefLvl20.calculateDamage(AttackType.MAGICAL));
            assertEquals(154, dumbDefLvl20.calculateDamage(AttackType.PHISICAL));
            assertEquals(308, dumbDefLvl20.calculateDamage(AttackType.SPECIAL));
            
        }
    }


    
    
}
