package com.group.carrentalserver.service;

import com.group.carrentalserver.domain.entity.User;
import com.group.carrentalserver.exception.InvalidVerificationTokenForUserException;
import com.group.carrentalserver.service.base.IBaseService;

import java.util.Optional;

/**
 * Interface to a {@link User} service.
 */
public interface IUserService extends IBaseService<User> {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    User getUserByToken(String token) throws InvalidVerificationTokenForUserException;
}
