package com.juegazo.juegazo.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.juegazo.juegazo.authentication.RegisteredUser;
import com.juegazo.juegazo.models.Player;
import com.juegazo.juegazo.models.PlayerInfo;
import com.juegazo.juegazo.models.Room;

public interface PlayerRepository extends CrudRepository<Player, Long> {
    
    Player findByUser(RegisteredUser user);

    Player findByIdPlayerAndRoom(Long idPlayer, Room room);


    
}
