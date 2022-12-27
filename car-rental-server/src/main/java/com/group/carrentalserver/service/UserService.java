package com.group.carrentalserver.service;

import com.group.carrentalserver.domain.entity.User;
import com.group.carrentalserver.service.base.BaseService;

import java.util.Optional;

/**
 * Interface to a {@link User} service.
 */
public interface UserService extends BaseService<User> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
}
