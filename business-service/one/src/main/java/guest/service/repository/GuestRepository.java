package guest.service.repository;

import guest.service.domain.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {
}
