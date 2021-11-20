package room.resrervation.service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import room.resrervation.service.domain.Room;

import java.util.List;

@FeignClient("roomservice")
public interface RoomClient {

    @GetMapping("/rooms")
    List<Room> getAllRooms();

    @GetMapping("/rooms/{id}")
    Room getRoomById(@PathVariable("id")long id);
}
