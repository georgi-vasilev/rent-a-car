package com.group.carrentalserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidVerificationTokenForUserException extends RuntimeException {

    private static final String ERROR_MESSAGE = "Verification token with id: %s is not valid!";

    public InvalidVerificationTokenForUserException(String token) {
        super(String.format(ERROR_MESSAGE, token));
    }
}
