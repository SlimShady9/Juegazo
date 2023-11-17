package com.juegazo.juegazo.services;

import org.springframework.stereotype.Service;

import com.juegazo.juegazo.combat.Arena;
import com.juegazo.juegazo.combat.Attacker;
import com.juegazo.juegazo.combat.Defender;
import com.juegazo.juegazo.enums.AttackType;
import com.juegazo.juegazo.mechanics.Combat;
import com.juegazo.juegazo.models.Enemy;
import com.juegazo.juegazo.models.Room;

@Service("Combat")
public class CombatImpl implements Combat {

    @Override
    public Arena beginCombat(Enemy enemy, Room room) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'beginCombat'");
    }

    @Override
    public Arena attack(Attacker attacker, AttackType attack) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attack'");
    }

    @Override
    public Arena guard(Attacker attacker) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guard'");
    }

    @Override
    public Arena defend(Attacker attacker) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'defend'");
    }

    @Override
    public Boolean checkIfVicotry(Arena arena) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkIfVicotry'");
    }

    @Override
    public Boolean checkIdDefeat(Arena arena) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkIdDefeat'");
    }

    @Override
    public Integer retrieveExperience(Attacker attacker, Defender defender) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retrieveExperience'");
    }

}