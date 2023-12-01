package com.juegazo.juegazo.combat;

import com.juegazo.juegazo.enums.AttackType;
import com.juegazo.juegazo.enums.EnemyType;
import com.juegazo.juegazo.models.Enemy;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Defender extends Fighter{

    private EnemyType enemyType;

    public static Defender makeFromEnemy(Enemy enemy) {
        return new Defender();
    }

    @Override
    Integer calculateDamage(AttackType attackType) {
        return 1;
    }
    
}
