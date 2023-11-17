package com.juegazo.juegazo.enums;

import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AttackType {
    
    PHISICAL(Arrays.asList("Punch", "Stab")),
    MAGICAL(Arrays.asList("Spell", "Curse"));




    private List<String> attackNames;
    
}
