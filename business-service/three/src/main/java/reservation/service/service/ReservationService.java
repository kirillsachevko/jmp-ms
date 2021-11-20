package reservation.service.service;

import reservation.service.domain.Reservation;

import java.sql.Date;

public interface ReservationService {
    Iterable<Reservation> getAllReservation();
    Reservation getReservationById(Long id);
    Iterable<Reservation> getAllReservationsByDate(Date date);
}
