package room.resrervation.service.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Guest {
    private long guestId;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String country;
    private String state;
    private String phoneNumber;

    public Guest(String firstName, String lastName, String email, String address, String country, String state, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.country = country;
        this.state = state;
        this.phoneNumber = phoneNumber;
    }
}
