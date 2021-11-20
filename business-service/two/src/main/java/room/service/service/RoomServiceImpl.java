package room.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import room.service.domain.Room;
import room.service.repository.RoomRepository;
import room.service.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository repository;

    @Autowired
    public RoomServiceImpl(RoomRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Room> getAllRooms() {
        return repository.findAll();
    }

    @Override
    public Room getRoomById(long id) {
        return repository.findById(id).get();
    }
}
