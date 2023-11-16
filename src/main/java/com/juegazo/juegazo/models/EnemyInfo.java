package com.juegazo.juegazo.models;

import com.juegazo.juegazo.enums.EnemyState;

public class EnemyInfo {

    private Enemy enemy;
    private EnemyState enemyState;
    private Integer xPosition;
    private Integer yPosition;


    public Integer getDeathExperience() {
        return 1;
    }
}
