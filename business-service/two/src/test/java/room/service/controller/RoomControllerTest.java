package room.service.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import room.service.domain.Room;
import room.service.service.RoomService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RoomControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoomService roomService;

    private static final String PATH = "/rooms";
    private static final String PATH_VAR = "/{id}";

    @Test
    void shouldReturnAllRoomsAndStatusOk() throws Exception {
        mockMvc.perform(get(PATH)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(roomService, times(1)).getAllRooms();
    }

    @Test
    void shouldReturnRoomByIdAndStatusOk() throws Exception {
        when(roomService.getRoomById(Long.parseLong("1")))
                .thenReturn(any(Room.class));

        mockMvc.perform(get(PATH + PATH_VAR, "1")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(roomService, times(1)).getRoomById(Long.parseLong("1"));
    }

}