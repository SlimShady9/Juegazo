package com.juegazo.juegazo.models;

import java.util.Arrays;
import java.util.List;

import com.juegazo.juegazo.enums.EnemyState;
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

@Getter @Setter @Builder
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
    private EnemyState enemyState;

    @Column(name = "xPosition")
    private Integer xPosition;

    @Column(name = "yPostition")
    private Integer yPosition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room")
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
