package com.group.carrentalserver.service;

import com.group.carrentalserver.domain.entity.User;
import com.group.carrentalserver.dto.RegistrationEntryDto;
import com.group.carrentalserver.service.base.BaseService;

/**
 * Interface to a {@link User} service.
 */
public interface UserService extends BaseService<User> {
    User registerUser(RegistrationEntryDto dto);
}
