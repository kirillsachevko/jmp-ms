package room.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import room.service.domain.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
}
