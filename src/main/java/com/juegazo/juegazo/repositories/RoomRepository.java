package com.juegazo.juegazo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.juegazo.juegazo.models.Room;
import java.util.List;


public interface RoomRepository extends CrudRepository<Room, Long> {
    

}
