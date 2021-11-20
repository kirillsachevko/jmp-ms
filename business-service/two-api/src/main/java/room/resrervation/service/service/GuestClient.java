package room.resrervation.service.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import room.resrervation.service.domain.Guest;

import java.util.List;

@FeignClient("guestservice")
public interface GuestClient {

    @GetMapping("/guests")
    List<Guest> getAllGuests();

    @GetMapping("/guests/{id}")
    Guest getGuestById(@PathVariable("id")long id);
}
