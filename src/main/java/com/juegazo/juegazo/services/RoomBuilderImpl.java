package com.juegazo.juegazo.services;

import org.springframework.stereotype.Service;

import com.juegazo.juegazo.authentication.User;
import com.juegazo.juegazo.mechanics.RoomBuilder;
import com.juegazo.juegazo.models.Room;

@Service("RoomBuilder")
public class RoomBuilderImpl implements RoomBuilder{

    @Override
    public Room buildRoom(User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buildRoom'");
    }

    @Override
    public Room joinRoom(Room room, User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'joinRoom'");
    }

    @Override
    public Room leaveRoom(Room room, User user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'leaveRoom'");
    }

    @Override
    public Room updateRoom(Room room) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateRoom'");
    }
    
}
