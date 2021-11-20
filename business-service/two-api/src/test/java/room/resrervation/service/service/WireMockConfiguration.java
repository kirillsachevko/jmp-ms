package room.resrervation.service.service;

import com.github.tomakehurst.wiremock.WireMockServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;

@TestConfiguration
@ActiveProfiles("test")
@Slf4j
public class WireMockConfiguration {

    @Autowired
    private WireMockServer wireMockServer;

    @Bean(initMethod = "start", destroyMethod = "stop")
    public WireMockServer mockGuestService() {
        log.info("MockServer initialized");
        return new WireMockServer(9561);
    }

}
