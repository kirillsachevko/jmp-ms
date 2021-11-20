package room.resrervation.service.service;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@ActiveProfiles("test")
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {WireMockConfiguration.class})
class RoomReservationServiceIntegrationTest {
    @Autowired
    private WireMockServer mockGuestService;

    @Autowired
    private GuestClient guestClient;

    @BeforeEach
    void setUp() throws IOException {
        GuestMock.setupMockGuestResponse(mockGuestService);
    }

    @Test
    public void whenGetBooks_thenBooksShouldBeReturned() {
        assertFalse(guestClient.getAllGuests().isEmpty());
    }

}