package com.juegazo.juegazo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.juegazo.juegazo.authentication.RegisteredUser;
import com.juegazo.juegazo.models.Player;
import com.juegazo.juegazo.models.Room;

public interface PlayerRepository extends CrudRepository<Player, Long> {
    
    Player findByUserAndRoom(RegisteredUser user, Room room);

    Player findByIdPlayerAndRoom(Long idPlayer, Room room);

    List<Player> findAllByRoom(Room room);


    
}
