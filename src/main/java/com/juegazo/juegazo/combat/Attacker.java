package com.juegazo.juegazo.combat;


import com.juegazo.juegazo.enums.AttackType;
import com.juegazo.juegazo.enums.PlayerType;
import com.juegazo.juegazo.models.Player;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Attacker extends Fighter{

    private Integer phisicalDamage;
    private Integer magicalDamage;
    private PlayerType PlayerType;


    @Override
    public Integer calculateDamage(AttackType attackType) {
        return 1;
    }

    public static Attacker makeFromPlayer(Player player) {
        return new Attacker();
    }
    
}
