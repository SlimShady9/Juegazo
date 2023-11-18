package com.juegazo.juegazo.services;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.juegazo.juegazo.authentication.User;
import com.juegazo.juegazo.enums.PlayerType;
import com.juegazo.juegazo.enums.RoomState;
import com.juegazo.juegazo.mechanics.RoomService;
import com.juegazo.juegazo.models.Enemy;
import com.juegazo.juegazo.models.Player;
import com.juegazo.juegazo.models.PlayerInfo;
import com.juegazo.juegazo.models.Room;
import com.juegazo.juegazo.repositories.EnemyRepository;
import com.juegazo.juegazo.repositories.PlayerRepository;
import com.juegazo.juegazo.repositories.RoomRepository;

@Service("RoomService")
public class RoomServiceImpl implements RoomService{

    private RoomRepository roomRepository;
    private PlayerRepository playerRepository;
    private EnemyRepository enemyRepository;

    public RoomServiceImpl(
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

        Player newPlayer = findOrMakePlayer(user);
        
        
        Room room = Room.builder()
        .roomState(RoomState.ACTIVE)
        .name(roomName)
        .build();
        
        room = roomRepository.save(room);
        Long idRoom = room.getIdRoom();
        playerRepository.savePlayerInfo(idRoom, newPlayer);
        
        room.setEnemies(Enemy.buildRandomEnemies());
        roomRepository.save(room);
        return roomRepository.findById(idRoom).get();
    }

    

    @Override
    public Room joinRoom(Room room, User user) {
        Player player = findOrMakePlayer(user);

        playerRepository.savePlayerInfo(room.getIdRoom(), player);

        PlayerInfo playerInfo = playerRepository.findPlayerInfoInRoom(room.getIdRoom(), player.getIdPlayer());

        room.getPlayers().add(playerInfo);

        
        return updateRoom(room);
    }

    @Override
    public Room leaveRoom(Room room, User user) {

        Player player = findOrMakePlayer(user);
        PlayerInfo playerInfo = playerRepository.findPlayerInfoInRoom(room.getIdRoom(), player.getIdPlayer());
        
        playerRepository.deletePlayerInfo(room.getIdRoom(), player);

        room.getPlayers().remove(playerInfo);

        return updateRoom(room);
    }

    @Override
    public Room updateRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Optional<Room> getRoom(Long roomId) {
        return roomRepository.findById(roomId);
    }

    private Player findOrMakePlayer(User user) {
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
        return newPlayer;
    }
    
}
