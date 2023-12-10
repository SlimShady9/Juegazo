package com.juegazo.juegazo.mechanics.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.juegazo.juegazo.enums.EnemyType;
import com.juegazo.juegazo.enums.EntityState;
import com.juegazo.juegazo.models.Enemy;


public class EnemyTests {

    @Test
    public void testEnemyBuilder() {
        List<Enemy> enemies = Enemy.buildRandomEnemies();

        Boolean hasBossBeetweenLvl10or20 = Boolean.FALSE;
        Boolean hasAtLeast3RandomGoblinEnemies = Boolean.FALSE;

        int countGobling = 0;
        
        for (Enemy enemy : enemies) {
            if (EnemyType.BOSS.equals(enemy.getEnemyType())
                && (enemy.getLevel() >= 10 && enemy.getLevel() <= 20)
                && EntityState.ALIVE.equals(enemy.getEnemyState())) {
                    hasBossBeetweenLvl10or20 = Boolean.TRUE;
                }
            if (EnemyType.GOBLIN.equals(enemy.getEnemyType())
                && enemy.getLevel() <= 15
                && EntityState.ALIVE.equals(enemy.getEnemyState())) {
                countGobling ++;
            }
        }

        hasAtLeast3RandomGoblinEnemies = countGobling >= 3;

        assertTrue(hasBossBeetweenLvl10or20);
        assertTrue(hasAtLeast3RandomGoblinEnemies);
    }

    @Test
    public void testDeathEnemyExperience() {
        Enemy enemyExp200 = Enemy.builder().enemyType(EnemyType.GOBLIN).level(2).build();
        Enemy enemyExp300 = Enemy.builder().enemyType(EnemyType.GOBLIN).level(3).build();
        Enemy enemyExp400 = Enemy.builder().enemyType(EnemyType.GOBLIN).level(4).build();
        Enemy enemyExp5000 = Enemy.builder().enemyType(EnemyType.BOSS).level(10).build();
        Enemy enemyExp6500 = Enemy.builder().enemyType(EnemyType.BOSS).level(13).build();
        Enemy enemyExp7500 = Enemy.builder().enemyType(EnemyType.BOSS).level(15).build();

        assertEquals(enemyExp200.getDeathExperience(), 200);
        assertEquals(enemyExp300.getDeathExperience(), 300);
        assertEquals(enemyExp400.getDeathExperience(), 400);
        assertEquals(enemyExp5000.getDeathExperience(), 5000);
        assertEquals(enemyExp6500.getDeathExperience(), 6500);
        assertEquals(enemyExp7500.getDeathExperience(), 7500);
    }
    
}
