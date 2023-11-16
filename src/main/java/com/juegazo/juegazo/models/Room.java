package com.juegazo.juegazo.models;

import java.util.List;

import com.juegazo.juegazo.enums.RoomState;

public class Room {

    private Long idRoom;
    private List<PlayerInfo> players;
    private List<EnemyInfo> enemies;
    private RoomState roomState;
    
    
}
