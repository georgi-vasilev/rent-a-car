package com.group.carrentalserver.service.impl;

import com.group.carrentalserver.domain.entity.User;
import com.group.carrentalserver.domain.entity.VerificationToken;
import com.group.carrentalserver.exception.InvalidVerificationTokenForUserException;
import com.group.carrentalserver.repository.UserRepository;
import com.group.carrentalserver.service.IUserService;
import com.group.carrentalserver.service.IVerificationTokenService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation to manage {@link com.group.carrentalserver.domain.entity.User}
 */
@Slf4j
@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final IVerificationTokenService tokenService;

    public UserService(UserRepository userRepository,
                       IVerificationTokenService tokenService) {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User getUserByToken(String token) throws InvalidVerificationTokenForUserException {
        return tokenService.getVerificationToken(token).map(VerificationToken::getUser)
                .orElseThrow(() -> new InvalidVerificationTokenForUserException(token));
    }

    @Override
    public JpaRepository<User, Integer> getJpaRepository() {
        return userRepository;
    }

    @Override
    public Logger getLogger() {
        return log;
    }

    @Override
    public Class<?> getType() {
        return User.class;
    }
}
