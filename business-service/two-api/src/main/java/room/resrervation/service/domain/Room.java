package room.resrervation.service.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Room {

    private long roomId;
    private String name;
    private String roomNumber;
    private String bedInfo;
}
