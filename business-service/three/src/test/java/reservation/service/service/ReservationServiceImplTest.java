package reservation.service.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reservation.service.domain.Reservation;
import reservation.service.repository.ReservationRepository;

import java.sql.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {ReservationServiceImpl.class})
class ReservationServiceImplTest {

    @Autowired
    private ReservationService reservationService;

    @MockBean
    private ReservationRepository reservationRepository;

    private Date testDate = new Date(2020, 01, 01);
    private Reservation testReservation = new Reservation(1L, 2L, testDate);

    @Test
    void shouldReturnAllReservationFromRepo() {
        when(reservationRepository.findAll())
                .thenReturn(List.of(new Reservation(), new Reservation()));

        List<Reservation> reservations = (List<Reservation>) reservationService.getAllReservation();
        assertEquals(2, reservations.size());

        verify(reservationRepository, times(1)).findAll();
    }

    @Test
    void shouldReturnReservationByIdFromRepo() {
        when(reservationRepository.findById(1L))
                .thenReturn(java.util.Optional.ofNullable(testReservation));

        Reservation reservation = reservationService.getReservationById(1L);
        assertEquals(1L, reservation.getRoomId());
        assertEquals(2L, reservation.getGuestId());
        assertEquals(testDate.toString(), reservation.getDate().toString());

        verify(reservationRepository, times(1)).findById(1L);
    }

    @Test
    void shouldReturnReservationsByDateFromRepo() {
        when(reservationRepository.findAllByDate(testDate))
                .thenReturn(List.of(testReservation));

        Reservation reservation = reservationService.getAllReservationsByDate(testDate).iterator().next();
        assertEquals(1L, reservation.getRoomId());
        assertEquals(2L, reservation.getGuestId());
        assertEquals(testDate.toString(), reservation.getDate().toString());

        verify(reservationRepository, times(1)).findAllByDate(testDate);
    }
}