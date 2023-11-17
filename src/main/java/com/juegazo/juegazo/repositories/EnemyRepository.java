package com.juegazo.juegazo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.juegazo.juegazo.models.Enemy;
import com.juegazo.juegazo.models.Room;

public interface EnemyRepository extends CrudRepository<Enemy, Long> {


    List<Enemy> findByRoom(Room room);

    
}
