package com.juegazo.juegazo.models;

import java.util.Arrays;
import java.util.List;

import com.juegazo.juegazo.enums.EnemyState;
import com.juegazo.juegazo.enums.EnemyType;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
@Entity
public class Enemy {
    
    private Long idEnemy;
    private EnemyType enemyType;
    private Integer level;
    private EnemyState enemyState;
    private Integer xPosition;
    private Integer yPosition;

    @ManyToOne
    private Room room;


    public static List<Enemy> buildRandomEnemies() {
        Enemy e = Enemy.builder()
            .level(1)
            .enemyType(EnemyType.BOSS)
            .enemyState(EnemyState.ALIVE)
            .xPosition(0)
            .yPosition(0)
            .build();
        return Arrays.asList(e);
    }

    public Integer getDeathExperience() {
        return 1;
    }

}
