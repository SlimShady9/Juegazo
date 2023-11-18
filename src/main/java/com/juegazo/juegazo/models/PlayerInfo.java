package com.juegazo.juegazo.models;

import com.juegazo.juegazo.enums.PlayerState;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * This class represent information of a player
 * inside a room
 */
@Getter @Setter
@Entity
@Table(name = "PlayerInfo")
public class PlayerInfo {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player")
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room")
    private Room room;

    @Enumerated(EnumType.STRING)
    @Column(name = "playerState")
    private PlayerState playerState;

    @Column(name = "xPosition")
    private Integer xPosition;

    @Column(name = "yPosition")
    private Integer yPosition;
    
}
