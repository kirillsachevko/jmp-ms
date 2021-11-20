package guest.service.web;

import guest.service.domain.Guest;
import guest.service.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guests")
public class GuestWebService {

    private final GuestService guestService;

    @Autowired
    public GuestWebService(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public Iterable<Guest> getAllGuests() {
        return guestService.getListOfAllGuests();
    }

    @GetMapping("/{id}")
    public Guest getGuestById(@PathVariable("id") long id) {
        return guestService.getGuestById(id);
    }
}

