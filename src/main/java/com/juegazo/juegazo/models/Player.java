package com.juegazo.juegazo.models;

import com.juegazo.juegazo.enums.TypePlayer;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Player {


    private Long idPlayer;
    private TypePlayer type;
    private Integer experience;
    
    

    public Integer calculateExperience() {
        return 1;
    }
    
}
