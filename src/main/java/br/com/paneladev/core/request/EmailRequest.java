package br.com.paneladev.core.request;

public record EmailRequest(String to, String subject, String body) {
}
