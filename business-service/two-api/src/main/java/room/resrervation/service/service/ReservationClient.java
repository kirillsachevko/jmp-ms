package room.resrervation.service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import room.resrervation.service.domain.Reservation;

import java.sql.Date;
import java.util.List;

@FeignClient("reservationservice")
public interface ReservationClient {

    @GetMapping("/reservations")
    List<Reservation> getAllReservations(@RequestParam(name = "date", required = false)Date date);

    @GetMapping("reservations/{id}")
    Reservation getReservationById(@PathVariable(name = "id")long id);
}
