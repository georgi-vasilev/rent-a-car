package com.group.carrentalserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    private static final String ERROR_MESSAGE = "Bad request encountered, for class %s!";

    public BadRequestException(String classType) {
        super(String.format(ERROR_MESSAGE, classType));
    }
}
