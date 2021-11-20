package reservation.service.controller;

import org.springframework.web.bind.annotation.*;
import reservation.service.domain.Reservation;
import reservation.service.service.ReservationService;

import java.sql.Date;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public Iterable<Reservation> getAllReservations(@RequestParam(name = "date", required = false)Date date) {
        if (date != null) {
            return reservationService.getAllReservationsByDate(date);
        }
        return reservationService.getAllReservation();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable("id")long id) {
        return reservationService.getReservationById(id);
    }
}
