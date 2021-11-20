package room.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import room.service.domain.Room;
import room.service.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public Iterable<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable("id")long id) {
        return roomService.getRoomById(id);
    }
}
