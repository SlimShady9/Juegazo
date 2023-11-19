package com.juegazo.juegazo.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.juegazo.juegazo.authentication.RegisteredUser;
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
    public Room buildRoom(RegisteredUser user, String roomName) {
        
        
        Room room = Room.builder()
        .roomState(RoomState.ACTIVE)
        .name(roomName)
        .build();
        
        room = roomRepository.save(room);

        Player player = findOrMakePlayer(user, room);

        playerRepository.save(player);
        
        room.setEnemies(Enemy.buildRandomEnemies());
        room.setPlayers(Arrays.asList(PlayerInfo.build(player)));
        room.setRegisteredPlayers(Arrays.asList(player));

        return roomRepository.save(room);
    }

    

    @Override
    public Room joinRoom(Room room, RegisteredUser user) {
        Player player = findOrMakePlayer(user, room);
        player.setRoom(room);

        player = playerRepository.save(player);


        room.getPlayers().add(PlayerInfo.build(player));
        room.getRegisteredPlayers().add(player);
        
        return room;
    }

    @Override
    public Room leaveRoom(Room room, Player player) {

    
        playerRepository.delete(player);
        
        List<Player> registeredPlayers = room.getRegisteredPlayers().stream().filter(p -> p.getIdPlayer().equals(player.getIdPlayer())).collect(Collectors.toList());
        List<PlayerInfo> players = room.getPlayers().stream().filter(p -> p.getPlayer().getIdPlayer().equals(player.getIdPlayer())).collect(Collectors.toList());
        room.setRegisteredPlayers(registeredPlayers);
        room.setPlayers(players);
        
        return room;
    }

    @Override
    public Room updateRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Optional<Room> getRoom(Long roomId) {
        return roomRepository.findById(roomId);
    }

    private Player findOrMakePlayer(RegisteredUser user, Room room) {
        /**
         * Check if user already has a player associated
         */
        Player player = playerRepository.findByUserAndRoom(user, room);

        if (player == null) {
            player = Player.builder()
                .experience(0)
                .type(PlayerType.WARRIOR)
                .user(user)
                .room(room)
                .build();
        }

        return player;
    }
    
}
