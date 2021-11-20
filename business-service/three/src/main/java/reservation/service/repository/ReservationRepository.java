package reservation.service.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import reservation.service.domain.Reservation;

import java.sql.Date;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {

    Iterable<Reservation> findAllByDate(Date date);
}
