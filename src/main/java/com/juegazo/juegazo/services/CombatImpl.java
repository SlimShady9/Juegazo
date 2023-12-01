package com.juegazo.juegazo.services;

import org.springframework.stereotype.Service;

import com.juegazo.juegazo.combat.Arena;
import com.juegazo.juegazo.combat.Attacker;
import com.juegazo.juegazo.combat.Defender;
import com.juegazo.juegazo.enums.AttackType;
import com.juegazo.juegazo.mechanics.Combat;
import com.juegazo.juegazo.models.Enemy;
import com.juegazo.juegazo.models.Room;

@Service("CombatService")
public class CombatImpl implements Combat {

    @Override
    public Arena beginCombat(Room room, Enemy enemy) {
        return new Arena();
    }

    @Override
    public Arena attack(Attacker attacker, AttackType attack) {
        return new Arena();
    }

    @Override
    public Arena guard(Attacker attacker) {
        return new Arena();
    }

    @Override
    public Arena defend(Attacker attacker) {
       return new Arena();
    }

    @Override
    public Boolean checkIfVicotry(Arena arena) {
        return Boolean.TRUE;
    }

    @Override
    public Boolean checkIdDefeat(Arena arena) {
        return Boolean.TRUE;
    }

    @Override
    public Integer retrieveExperience(Attacker attacker, Defender defender) {
        return 1;
    }

}