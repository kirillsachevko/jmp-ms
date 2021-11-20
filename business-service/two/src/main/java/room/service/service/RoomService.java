package room.service.service;

import room.service.domain.Room;

public interface RoomService {

    Iterable<Room> getAllRooms();
    Room getRoomById(long id);
}
