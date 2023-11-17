package com.juegazo.juegazo.models;

import com.juegazo.juegazo.enums.PlayerType;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Player {


    private Long idPlayer;
    private PlayerType type;
    private Integer experience;
    
    

    public Integer calculateExperience() {
        return 1;
    }
    
}
