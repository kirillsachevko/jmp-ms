package reservation.service.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import reservation.service.domain.Reservation;
import reservation.service.service.ReservationService;

import java.sql.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ReservationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReservationService reservationService;

    private static final String PATH = "/reservations";
    private static final String PATH_VAR = "/{id}";
    private Date date = new Date(2020, 01, 01);

    @Test
    void shouldReturnAllReservationsAndStatusOk() throws Exception {
        mockMvc.perform(get(PATH)
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(reservationService, times(1)).getAllReservation();
    }

    @Test
    void shouldReturnReservationByDateAndStatusOk() throws Exception {
        when(reservationService.getAllReservationsByDate(date))
                .thenReturn(List.of(new Reservation(), new Reservation()));

        mockMvc.perform(get(PATH).param("date", String.valueOf(date))
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(reservationService, times(1)).getAllReservationsByDate(date);
    }

    @Test
    void shouldReturnReservationByIdAndStatusOk() throws Exception {
        when(reservationService.getReservationById(1L))
                .thenReturn(any(Reservation.class));

        mockMvc.perform(get(PATH+PATH_VAR, "1")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(reservationService, times(1)).getReservationById(1L);
    }


}