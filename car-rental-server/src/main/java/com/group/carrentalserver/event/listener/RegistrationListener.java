package com.group.carrentalserver.event.listener;

import com.group.carrentalserver.domain.entity.User;
import com.group.carrentalserver.event.OnRegistrationCompleteEvent;
import com.group.carrentalserver.service.IVerificationTokenService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {

    private final IVerificationTokenService tokenService;
    private final MessageSource messageSource;
    private final JavaMailSender mailSender;

    public RegistrationListener(IVerificationTokenService tokenService,
                                MessageSource messageSource,
                                JavaMailSender mailSender) {
        this.tokenService = tokenService;
        this.messageSource = messageSource;
        this.mailSender = mailSender;
    }

    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent event) {
        this.confirmRegistration(event);
    }

    private void confirmRegistration(OnRegistrationCompleteEvent event) {
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        tokenService.createVerificationToken(user, token);

        String recipientAddress = user.getEmail();
        String subject = "Registration Confirmation";
        String confirmationUrl
                = event.getAppUrl() + "/confirmRegistration?token=" + token;
        String message = messageSource.getMessage("message.regSuccessful", null, event.getLocale());

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + "\r\n" + "http://localhost:8080" + confirmationUrl);
        mailSender.send(email);
    }
}
