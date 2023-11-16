package com.juegazo.juegazo.mechanics;

import com.juegazo.juegazo.authentication.User;
import com.juegazo.juegazo.models.Room;

public interface RoomBuilder {

    Room buildRoom(User user);
    Room joinRoom(Room room, User user);
    Room leaveRoom(Room room, User user);
    Room updateRoom(Room room);
    
}
