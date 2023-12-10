package com.juegazo.juegazo.combat;

import com.juegazo.juegazo.enums.AttackType;
import com.juegazo.juegazo.enums.EntityState;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class Fighter {
    
    private Integer turn;
    private Integer maxHealth;
    private Integer health;
    private Integer baseDamage;
    private Integer phisicalArmor;
    private Integer magicalArmor;
    private EntityState state;

    /**
     * calculates the damage dealt base on Fighter Stadistics
     * @param damage
     * @return total health taken
     */
    public Integer getDamage(Integer totalDamage) {
        return 1;
    }

    abstract Integer calculateDamage(AttackType attackType);
}
