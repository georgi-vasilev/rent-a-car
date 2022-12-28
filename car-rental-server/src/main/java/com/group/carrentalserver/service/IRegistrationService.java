package com.group.carrentalserver.service;

import com.group.carrentalserver.domain.entity.User;
import com.group.carrentalserver.dto.RegistrationEntryDto;
import com.group.carrentalserver.exception.EmailAlreadyExistsException;
import com.group.carrentalserver.exception.InvalidVerificationTokenForUserException;
import com.group.carrentalserver.exception.UsernameAlreadyExistsException;
import com.group.carrentalserver.exception.VerificationTokenExpiredException;

public interface IRegistrationService {
    User registerUser(RegistrationEntryDto entryDto) throws EmailAlreadyExistsException, UsernameAlreadyExistsException;

    void confirmRegistration(String token) throws InvalidVerificationTokenForUserException, VerificationTokenExpiredException;
}
