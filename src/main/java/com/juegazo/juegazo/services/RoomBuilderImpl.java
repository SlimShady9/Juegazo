package com.juegazo.juegazo.services;

import java.util.Arrays;

import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;

import com.juegazo.juegazo.authentication.User;
import com.juegazo.juegazo.enums.PlayerType;
import com.juegazo.juegazo.enums.RoomState;
import com.juegazo.juegazo.mechanics.RoomBuilder;
import com.juegazo.juegazo.models.Enemy;
import com.juegazo.juegazo.models.Player;
import com.juegazo.juegazo.models.PlayerInfo;
import com.juegazo.juegazo.models.Room;
import com.juegazo.juegazo.repositories.EnemyRepository;
import com.juegazo.juegazo.repositories.PlayerRepository;
import com.juegazo.juegazo.repositories.RoomRepository;

@Service("RoomService")
public class RoomBuilderImpl implements RoomBuilder{

    private RoomRepository roomRepository;
    private PlayerRepository playerRepository;
    private EnemyRepository enemyRepository;

    public RoomBuilderImpl(
        RoomRepository roomRepository,
        PlayerRepository playerRepository,
        EnemyRepository enemyRepository
        
    ) {
        this.roomRepository = roomRepository;
        this.playerRepository = playerRepository;
        this.enemyRepository = enemyRepository;
    }

    @Override
    public Room buildRoom(User user, String roomName) {

        /**
         * Check if user already has a player associated
         */
        Player player = playerRepository.findByUser(user);

        if (player == null) {
            player = Player.builder()
                .experience(0)
                .type(PlayerType.WARRIOR)
                .user(user)
                .build();
        }

        Player newPlayer = playerRepository.save(player);
        
        
        Room room = Room.builder()
        .roomState(RoomState.ACTIVE)
        .name(roomName)
        .build();
        
        room = roomRepository.save(room);
        Long idRoom = room.getIdRoom();
        playerRepository.savePlayerInfo(idRoom, newPlayer);
        
        room.setEnemies(Enemy.buildRandomEnemies());
        return roomRepository.findById(idRoom).get();
    }

    @Override
    public Room joinRoom(Room room, User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'joinRoom'");
    }

    @Override
    public Room leaveRoom(Room room, User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'leaveRoom'");
    }

    @Override
    public Room updateRoom(Room room) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateRoom'");
    }
    
}
