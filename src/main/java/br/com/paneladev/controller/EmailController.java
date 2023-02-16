package br.com.paneladev.controller;

import br.com.paneladev.dto.MessageDto;
import br.com.paneladev.entity.Email;
import br.com.paneladev.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {

    private final EmailService service;

    @PostMapping("/send")
    public ResponseEntity<Email> sendEmail(@Valid @RequestBody MessageDto messageDto) {

        Email email = new Email();
        email.setOwner(messageDto.getOwner());
        email.setEmailFrom(messageDto.getFrom());
        email.setEmailToto(messageDto.getTo());
        email.setTitle(messageDto.getTitle());
        email.setText(messageDto.getText());

        Email emailSent = service.sendEmail(email);
        return ResponseEntity.ok(emailSent);
    }
}
