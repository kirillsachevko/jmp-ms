package guest.service.service;

import guest.service.domain.Guest;

public interface GuestService {

    Iterable<Guest> getListOfAllGuests();

    Guest getGuestById(long id);
}
