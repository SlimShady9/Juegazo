package com.juegazo.juegazo.models;

import java.util.List;

import com.juegazo.juegazo.enums.RoomState;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder @Getter @Setter
@Entity
public class Room {

    private Long idRoom;
    private String name;
    private List<PlayerInfo> players;

    @OneToMany
    private List<Enemy> enemies;

    @Enumerated(EnumType.STRING)
    private RoomState roomState;
    
    
}
