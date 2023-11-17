package com.juegazo.juegazo.models;

import com.juegazo.juegazo.authentication.User;
import com.juegazo.juegazo.enums.PlayerType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class Player {


    private Long idPlayer;
    private PlayerType type;
    private Integer experience;
    private User user;
    
    

    public Integer calculateLevel() {
        return 1;
    }

    
}
