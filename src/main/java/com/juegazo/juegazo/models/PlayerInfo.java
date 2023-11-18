package com.juegazo.juegazo.models;

import com.juegazo.juegazo.enums.PlayerState;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * This class represent information of a player
 * inside a room
 */
@Getter @Setter
@Builder
public class PlayerInfo {

    private Player player;

    private PlayerState playerState;

    private Integer xPosition;

    private Integer yPosition;

    private Integer level;

    public static PlayerInfo build(Player player) {
        return PlayerInfo.builder()
            .playerState(PlayerState.FREE)
            .xPosition(0)
            .yPosition(0)
            .player(player)
            .level(player.calculateLevel())
            .build();
            
    }
    
}
