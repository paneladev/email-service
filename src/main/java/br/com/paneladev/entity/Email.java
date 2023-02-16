package br.com.paneladev.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "email")
public class Email {

    @Id
    private String id;
    private String owner;
    private String emailFrom;
    private String emailToto;
    private String title;
    private String text;
    private boolean send;
    private LocalDateTime sendDate;
}
