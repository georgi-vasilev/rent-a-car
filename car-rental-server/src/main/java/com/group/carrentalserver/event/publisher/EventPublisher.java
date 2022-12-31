package com.group.carrentalserver.event.publisher;

import com.group.carrentalserver.domain.entity.User;
import com.group.carrentalserver.event.OnRegistrationCompleteEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class EventPublisher {

    private static final String APP_URL = "http://%s:%s%s";

    private final ApplicationEventPublisher eventPublisher;


    public EventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void publishEvent(User registeredUser, HttpServletRequest request) {
        eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registeredUser, request.getLocale(),
                String.format(APP_URL, request.getServerName(), request.getServerPort(), request.getContextPath())));
    }
}
