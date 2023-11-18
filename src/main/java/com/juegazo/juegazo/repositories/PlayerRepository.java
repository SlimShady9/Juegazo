package com.juegazo.juegazo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.juegazo.juegazo.authentication.RegisteredUser;
import com.juegazo.juegazo.models.Player;
import com.juegazo.juegazo.models.PlayerInfo;

public interface PlayerRepository extends CrudRepository<Player, Long> {
    
    Player findByUser(RegisteredUser user);

    PlayerInfo findPlayerInfoInRoom(Long idRoom, Long idPlayer);

    void updatePlayerInfo(Long idRoom, PlayerInfo playerInfo);

    void savePlayerInfo(Long idRoom, Player player);

    void deletePlayerInfo(Long idRoom, Player player);

    
}
