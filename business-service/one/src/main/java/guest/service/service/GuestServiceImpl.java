package guest.service.service;

import guest.service.domain.Guest;
import guest.service.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestServiceImpl implements GuestService {

    private final GuestRepository repository;

    @Autowired
    public GuestServiceImpl(GuestRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Guest> getListOfAllGuests() {
        return repository.findAll();
    }

    @Override
    public Guest getGuestById(long id) {
        return repository.findById(id).get();
    }
}
