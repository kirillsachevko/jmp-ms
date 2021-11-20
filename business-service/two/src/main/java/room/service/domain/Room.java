package room.service.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ROOM")
@NoArgsConstructor
public class Room {
    @Id
    @Column(name = "ROOM_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roomId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ROOM_NUMBER")
    private String number;
    @Column(name = "BED_INFO")
    private String bedInfo;

    public Room(String name, String number, String bedInfo) {
        this.name = name;
        this.number = number;
        this.bedInfo = bedInfo;
    }
}
