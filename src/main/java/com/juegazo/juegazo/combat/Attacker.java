package com.juegazo.juegazo.combat;

import java.util.List;

import com.juegazo.juegazo.enums.AttackType;
import com.juegazo.juegazo.enums.PlayerType;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Attacker extends Fighter{

    private Integer phisicalDamage;
    private Integer magicalDamage;
    private PlayerType PlayerType;


    public Integer calculateDamage(AttackType attackType) {
        return 1;
    }
    
}
