package room.resrervation.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import room.resrervation.service.domain.Guest;
import room.resrervation.service.domain.Reservation;
import room.resrervation.service.domain.Room;
import room.resrervation.service.domain.RoomReservation;
import room.resrervation.service.service.GuestClient;
import room.resrervation.service.service.ReservationClient;
import room.resrervation.service.service.RoomClient;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/room-reservations")
public class RoomReservationController {

    private final RoomClient roomClient;
    private final GuestClient guestClient;
    private final ReservationClient reservationClient;

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public RoomReservationController(RoomClient roomClient, GuestClient guestClient, ReservationClient reservationClient) {
        this.roomClient = roomClient;
        this.guestClient = guestClient;
        this.reservationClient = reservationClient;
    }

    @GetMapping
    public List<RoomReservation> getRoomReservations(@RequestParam(name = "date", required = false)String dateString) {
        Date date = convertDateFromString(dateString);
        List<Room> rooms = this.roomClient.getAllRooms();
        Map<Long, RoomReservation> roomReservations = new HashMap<>();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getRoomId());
            roomReservation.setRoomName(room.getName());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservations.put(room.getRoomId(), roomReservation);
        });
        List<Reservation> reservations = this.reservationClient.getAllReservations(new java.sql.Date(date.getTime()));
        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservations.get(reservation.getRoomId());
            roomReservation.setDate(date);
            Guest guest = this.guestClient.getGuestById(reservation.getGuestId());
            roomReservation.setGuestId(guest.getGuestId());
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
        });

        return new ArrayList<>(roomReservations.values());
    }

    private Date convertDateFromString(String dateString) {
        Date date;
        if (dateString != null) {
            try {
                date = DATE_FORMAT.parse(dateString);
            } catch (ParseException e) {
                date = new Date();
            }
        } else {
            date = new Date();
        }
        return date;
    }
}
