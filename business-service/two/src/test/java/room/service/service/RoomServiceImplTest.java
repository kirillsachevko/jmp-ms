package room.service.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import room.service.domain.Room;
import room.service.repository.RoomRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {RoomServiceImpl.class})
class RoomServiceImplTest {

    @Autowired
    private RoomService roomService;

    @MockBean
    private RoomRepository repository;

    private Room testRoom = new Room("Lux", "2233", "Euro");

    @Test
    void shouldReturnAllRoomsFromRepo() {
        when(repository.findAll())
                .thenReturn(List.of(new Room(), new Room()));

        List<Room> rooms = (List<Room>) roomService.getAllRooms();
        assertEquals(2, rooms.size());

        verify(repository, times(1)).findAll();
    }

    @Test
    void shouldReturnRoomByIdFromRepo() {
        when(repository.findById(1L))
                .thenReturn(java.util.Optional.ofNullable(testRoom));

        Room room = roomService.getRoomById(1L);
        assertEquals("Lux", room.getName());
        assertEquals("2233", room.getNumber());
        assertEquals("Euro", room.getBedInfo());

        verify(repository, times(1)).findById(1L);
    }

}