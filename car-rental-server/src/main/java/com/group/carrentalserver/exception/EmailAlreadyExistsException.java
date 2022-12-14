package com.group.carrentalserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public final class EmailAlreadyExistsException extends RuntimeException {

    private static final String ERROR_MESSAGE = "User entity with email: %s, already exists!";

    public EmailAlreadyExistsException(String email) {
        super(String.format(ERROR_MESSAGE, email));
    }
}
