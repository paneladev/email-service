package br.com.paneladev.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("feature-toggle")
public class FeatureToggleProperties {

    private boolean resendEmail;

    public boolean isResendEmail() {
        return resendEmail;
    }

    public void setResendEmail(boolean resendEmail) {
        this.resendEmail = resendEmail;
    }
}
