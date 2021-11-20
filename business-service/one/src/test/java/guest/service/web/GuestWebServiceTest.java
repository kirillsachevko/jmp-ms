package guest.service.web;

import guest.service.domain.Guest;
import guest.service.service.GuestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GuestWebServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GuestService guestService;

    private static final String PATH = "/guests";
    private static final String PATH_VAR = "/{id}";

    @Test
    void shouldReturnAllGuestsAndStatusOk() throws Exception {
        mockMvc.perform(get(PATH)
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(guestService, times(1)).getListOfAllGuests();
    }

    @Test
    void shouldReturnGuestByIdAndStatusOk() throws Exception {
        when(guestService.getGuestById(Long.parseLong("1")))
                .thenReturn(any(Guest.class));

        mockMvc.perform(get(PATH + PATH_VAR, "1")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(guestService, times(1)).getGuestById(Long.parseLong("1"));
    }

}