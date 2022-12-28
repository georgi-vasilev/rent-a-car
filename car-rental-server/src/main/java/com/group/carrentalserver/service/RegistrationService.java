package com.group.carrentalserver.service;

import com.group.carrentalserver.domain.entity.User;
import com.group.carrentalserver.dto.RegistrationEntryDto;

public interface RegistrationService {
    User registerUser(RegistrationEntryDto entryDto);
}
