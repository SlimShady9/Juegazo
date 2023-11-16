package com.juegazo.juegazo.mechanics;

import com.juegazo.juegazo.combat.Arena;
import com.juegazo.juegazo.combat.Attack;
import com.juegazo.juegazo.combat.Attacker;
import com.juegazo.juegazo.combat.Defender;
import com.juegazo.juegazo.models.Enemy;
import com.juegazo.juegazo.models.Room;

public interface Combat {
    
    Arena beginCombat(Enemy enemy, Room room);
    Arena attack(Attacker attacker, Attack attack);
    Arena guard(Attacker attacker);
    Arena defend(Attacker attacker);
    Boolean checkIfVicotry(Arena arena);
    Boolean checkIdDefeat(Arena arena);
    Integer retrieveExperience(Attacker attacker, Defender defender);


}