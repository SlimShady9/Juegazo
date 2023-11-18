package com.juegazo.juegazo.mechanics;

import java.util.Optional;

import com.juegazo.juegazo.authentication.User;
import com.juegazo.juegazo.models.Room;

public interface RoomService {

    Room buildRoom(User user, String roomName);
    Room joinRoom(Room room, User user);
    Room leaveRoom(Room room, User user);
    Room updateRoom(Room room);
    Optional<Room> getRoom(Long roomId);
    
}
