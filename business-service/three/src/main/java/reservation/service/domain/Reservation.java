package reservation.service.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "RESERVATION")
@Getter
@Setter
@NoArgsConstructor
public class Reservation {
    @Id
    @Column(name = "RESERVATION_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long reservationId;
    @Column(name = "ROOM_ID")
    private long roomId;
    @Column(name = "GUEST_ID")
    private long guestId;
    @Column(name = "RES_DATE")
    private Date date;

    public Reservation(long roomId, long guestId, Date date) {
        this.roomId = roomId;
        this.guestId = guestId;
        this.date = date;
    }
}
