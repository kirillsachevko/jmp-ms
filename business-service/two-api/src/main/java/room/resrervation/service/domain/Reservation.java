package room.resrervation.service.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class Reservation {
    private long reservationId;
    private long roomId;
    private long guestId;
    private Date date;
}
