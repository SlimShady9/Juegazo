package com.juegazo.juegazo.models;

import com.juegazo.juegazo.authentication.User;
import com.juegazo.juegazo.enums.PlayerState;

import lombok.Getter;
import lombok.Setter;

/**
 * This class represent information of a player
 * inside a room
 */
@Getter @Setter
public class PlayerInfo {

    private Player player;
    private PlayerState playerState;
    private Integer xPosition;
    private Integer yPosition;
    private User user;
    
}
