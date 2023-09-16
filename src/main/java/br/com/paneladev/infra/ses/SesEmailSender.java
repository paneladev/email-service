package br.com.paneladev.infra.ses;

import br.com.paneladev.adapters.EmailSenderGateway;
import br.com.paneladev.core.exceptions.EmailServiceException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SesEmailSender implements EmailSenderGateway {

    private final AmazonSimpleEmailService amazonSimpleEmailService;

    @Override
    public void sendEmail(String to, String subject, String body) {
        SendEmailRequest request = new SendEmailRequest().withSource("paneladev@gmail.com")
                .withDestination(new Destination().withToAddresses(to))
                .withMessage(new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content(body))));

        try {
            this.amazonSimpleEmailService.sendEmail(request);
        } catch (AmazonServiceException ex) {
            throw new EmailServiceException("Failure while sending email", ex);
        }

    }
}
