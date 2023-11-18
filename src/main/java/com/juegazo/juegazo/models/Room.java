package com.juegazo.juegazo.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.juegazo.juegazo.enums.RoomState;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder @Getter @Setter
@Entity
@Table(name = "Room")
public class Room {

    @Column(name = "idRoom")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRoom;

    @Column(name = "nameRoom")
    private String name;

    @Transient
    private List<PlayerInfo> players;

    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = {CascadeType.REMOVE, CascadeType.MERGE})
    @JsonIgnore
    private List<Player> registeredPlayers;

    @OneToMany(
        cascade = 
            {CascadeType.REMOVE, CascadeType.MERGE})
    private List<Enemy> enemies;

    @Enumerated(EnumType.STRING)
    @Column(name = "roomState")
    private RoomState roomState;
    
    
}
