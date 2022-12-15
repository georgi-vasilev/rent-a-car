package com.group.carrentalserver.service.impl;

import com.group.carrentalserver.domain.entity.Role;
import com.group.carrentalserver.domain.entity.User;
import com.group.carrentalserver.domain.enumeration.RoleType;
import com.group.carrentalserver.domain.enumeration.UserStatus;
import com.group.carrentalserver.dto.RegistrationEntryDto;
import com.group.carrentalserver.dto.enumeration.RegistrationType;
import com.group.carrentalserver.exception.EmailAlreadyExistsException;
import com.group.carrentalserver.exception.UsernameAlreadyExistsException;
import com.group.carrentalserver.repository.UserRepository;
import com.group.carrentalserver.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Service Implementation to manage {@link com.group.carrentalserver.domain.entity.User}
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .orElseThrow();
    }

    @Override
    public User registerUser(RegistrationEntryDto dto) {
        User user = new User();

        if (!isEmailOrUsernameAlreadyExisting(dto.getEmail(), dto.getUsername())) {
            user.setUsername(dto.getUsername());
            user.setEmail(dto.getEmail());
        }

        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        user.setPassword(encodedPassword);

        user.setRoles(assignRolesToUserByRegistrationType(dto.getRegistrationType()));

        user.setStatus(UserStatus.CREATED);

        return save(user);
    }

    private boolean isEmailOrUsernameAlreadyExisting(String email, String username) {
        log.debug("Check whether user with email: {}, or username: {} already exists", email, username);

        if (userRepository.existsUserByEmail(email)) {
            log.debug("Email: {} already exists!", email);
            throw new EmailAlreadyExistsException(email);
        } else if (userRepository.existsUserByUsername(username)) {
            log.debug("Username: {} already exists!", username);
            throw new UsernameAlreadyExistsException(username);
        }

        return false;
    }

    private Set<Role> assignRolesToUserByRegistrationType(RegistrationType registrationType) {
        Set<Role> roles = new HashSet<>();

        switch (registrationType) {
            case TENANT -> roles.add(new Role(RoleType.TENANT));
            case DEALER -> roles.add(new Role(RoleType.DEALER));
            case BOTH -> roles.addAll(Set.of(new Role(RoleType.TENANT), new Role(RoleType.DEALER)));
            default -> throw new IllegalStateException("Unexpected value: " + registrationType);
        }

        return roles;
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
