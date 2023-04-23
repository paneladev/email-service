package br.com.paneladev.service;

import br.com.paneladev.config.FeatureToggleProperties;
import br.com.paneladev.entity.Email;
import br.com.paneladev.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final EmailService emailService;

    private final EmailRepository repository;

    private final FeatureToggleProperties featureToggleProperties;

    //@Scheduled(initialDelay = 5000, fixedDelay = 5000) // executa a cada 5 segundas
    //@Scheduled(cron = "0/5 * * * * ?") // executa a cada 5 segundos utilizando cron
    @Scheduled(cron = "0 0 0/1 * * ?") // executa a cada hora
    public void retryEmail() {
        if (featureToggleProperties.isResendEmail()) {
            log.info("retentativa de email sendo executada");
            retrySendEmail();
        } else {
            log.warn("Reenvio de email está desligado");
        }
    }

    private void retrySendEmail() {
        List<Email> emails = repository.findBySendFalse();
        if (!emails.isEmpty()) {
            emails.forEach(email -> emailService.sendEmail(email));
        }
    }
}
