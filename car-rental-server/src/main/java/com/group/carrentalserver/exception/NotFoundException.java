package com.group.carrentalserver.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public final class NotFoundException extends RuntimeException {

    private static final String ERROR_MESSAGE = "No such entity of type %s with ID: %s exists!";

    public NotFoundException(Class<?> classType, Integer id) {
        super(String.format(ERROR_MESSAGE, classType, id));
    }
}