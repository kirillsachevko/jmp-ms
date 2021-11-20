package guest.service.service;

import guest.service.domain.Guest;
import guest.service.repository.GuestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = {GuestServiceImpl.class})
class GuestServiceImplTest {

    @Autowired
    private GuestService guestService;

    @MockBean
    private GuestRepository repository;

    private Guest testGuest =
            new Guest("John", "Dorry", "jdorry@aol.com", "BakerStr", "UK", "Oxfordshere", "1-500-333");

    @Test
    void shouldReturnAllGuestsFromRepo() {
        when(repository.findAll())
                .thenReturn(List.of(new Guest(), new Guest(), new Guest()));

        List<Guest> guests = (List<Guest>) guestService.getListOfAllGuests();
        assertEquals(3, guests.size());

        verify(repository, times(1)).findAll();
    }

    @Test
    void shouldReturnGuestById() {
        when(repository.findById(1L))
                .thenReturn(java.util.Optional.ofNullable(testGuest));

        Guest guest = guestService.getGuestById(1);
        assertEquals("John", guest.getFirstName());
        assertEquals("Dorry", guest.getLastName());
        assertEquals("jdorry@aol.com", guest.getEmail());
        assertEquals("BakerStr", guest.getAddress());
        assertEquals("UK", guest.getCountry());
        assertEquals("Oxfordshere", guest.getState());
        assertEquals("1-500-333", guest.getPhoneNumber());

        verify(repository, times(1)).findById(1L);
    }

}