package com.juegazo.juegazo.mechanics;

import java.util.Optional;

import com.juegazo.juegazo.authentication.RegisteredUser;
import com.juegazo.juegazo.models.Player;
import com.juegazo.juegazo.models.Room;

public interface RoomService {

    Room buildRoom(RegisteredUser user, String roomName);
    Room joinRoom(Room room, RegisteredUser user);
    Room leaveRoom(Room room, Player player);
    Room updateRoom(Room room);
    Optional<Room> getRoom(Long roomId);
    
}
