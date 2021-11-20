package reservation.service.service;

import org.springframework.stereotype.Service;
import reservation.service.domain.Reservation;
import reservation.service.repository.ReservationRepository;

import java.sql.Date;

@Service
public class ReservationServiceImpl implements ReservationService{

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Iterable<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).get();
    }

    @Override
    public Iterable<Reservation> getAllReservationsByDate(Date date) {
        return reservationRepository.findAllByDate(date);
    }
}
