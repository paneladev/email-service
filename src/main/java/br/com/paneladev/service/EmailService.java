package br.com.paneladev.service;

import br.com.paneladev.entity.Email;
import br.com.paneladev.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailRepository repository;
    private final JavaMailSender sender;

    public Email sendEmail(Email email) {

        try {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailToto());
            message.setSubject(email.getTitle());
            message.setText(email.getText());

            email.setSendDate(LocalDateTime.now());
            email.setSend(true);

            sender.send(message);
        } catch (MailException ex) {
            email.setSend(false);
            log.warn("Erro na tentativa de envio de email. Message: {}", ex.getMessage());
        } finally {
            repository.save(email);
        }

        return email;
    }
}
