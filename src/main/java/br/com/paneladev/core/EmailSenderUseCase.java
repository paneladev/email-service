package br.com.paneladev.core;

public interface EmailSenderUseCase {

    void sendEmail(String to, String subject, String body);
}