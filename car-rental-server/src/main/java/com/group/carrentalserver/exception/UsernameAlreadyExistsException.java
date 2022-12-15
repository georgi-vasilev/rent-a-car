package com.group.carrentalserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public final class UsernameAlreadyExistsException extends RuntimeException {

    private static final String ERROR_MESSAGE = "Entity with username: %s, already exists!";

    public UsernameAlreadyExistsException(String username) {
        super(String.format(ERROR_MESSAGE, username));
    }
}
