package com.juegazo.juegazo.models;

import com.juegazo.juegazo.enums.EnemyType;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Enemy {
    
    private Long idEnemy;
    private Integer heath;
    private Integer damage;
    private EnemyType enemyType;
    private Integer level;


}
