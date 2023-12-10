package com.juegazo.juegazo.models;

import java.util.ArrayList;
import java.util.List;

import com.juegazo.juegazo.enums.EntityState;
import com.juegazo.juegazo.enums.EnemyType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @Builder @ToString
@Entity
public class Enemy {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEnemy")
    private Long idEnemy;

    @Enumerated(EnumType.STRING)
    @Column(name = "enemyType")
    private EnemyType enemyType;

    @Column(name = "levelEnemy")
    private Integer level;

    @Column(name = "enemyState")
    @Enumerated(EnumType.STRING)
    private EntityState enemyState;

    @Column(name = "xPosition")
    private Integer xPosition;

    @Column(name = "yPostition")
    private Integer yPosition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room")
    private Room room;


    public static List<Enemy> buildRandomEnemies() {

        List<Enemy> enemies = new ArrayList<>();
        Long nRandomBosses = Math.round(Math.random() * (3 - 1)) + 1;
        Long nRandomEnemies = Math.round(Math.random() * (10 - 3)) + 3;

        for (int i = 0; i < nRandomBosses; i++) {
            Integer ath = (int) Math.round(Math.random() * (20 - 10)) + 10;
            Enemy e = Enemy.builder()
                .enemyState(EntityState.ALIVE)
                .enemyType(EnemyType.BOSS)
                .level(ath)
                .xPosition(0)
                .yPosition(0)
                .build();
            enemies.add(e);
        }

        for (int i = 0; i < nRandomEnemies; i++) {
            Integer ath = (int) Math.round(Math.random() * (15 - 1)) + 1;
            Enemy e = Enemy.builder()
                .enemyState(EntityState.ALIVE)
                .enemyType(EnemyType.GOBLIN)
                .level(ath)
                .xPosition(0)
                .yPosition(0)
                .build();
            enemies.add(e);
        }
        return enemies;
    }

    public Integer getDeathExperience() {
        Integer experience = this.getLevel() * 100;
        if (EnemyType.BOSS.equals(this.getEnemyType())) experience *= 5;
        return experience;
    }

}
