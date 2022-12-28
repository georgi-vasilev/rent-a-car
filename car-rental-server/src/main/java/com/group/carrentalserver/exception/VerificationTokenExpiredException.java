package com.group.carrentalserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class VerificationTokenExpiredException extends RuntimeException {

    private static final String ERROR_MESSAGE = "Verification token with id: %s | expiry date: %s has expired!";

    public VerificationTokenExpiredException(String token, Date expiryDate) {
        super(String.format(ERROR_MESSAGE, token, expiryDate.toString()));
    }
}
