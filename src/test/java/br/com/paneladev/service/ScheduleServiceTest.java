package br.com.paneladev.service;

import br.com.paneladev.repository.EmailRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@EnableAutoConfiguration
class ScheduleServiceTest {

    @Autowired
    ScheduleService scheduleService;

    @MockBean
    EmailRepository emailRepository;

    @MockBean
    EmailService emailService;

    @Test
    void testResendEmail() {
        scheduleService.retryEmail();
    }

}
