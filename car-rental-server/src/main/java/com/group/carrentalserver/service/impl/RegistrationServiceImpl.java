package com.group.carrentalserver.service.impl;

import com.group.carrentalserver.domain.entity.Role;
import com.group.carrentalserver.domain.entity.User;
import com.group.carrentalserver.domain.enumeration.RoleType;
import com.group.carrentalserver.domain.enumeration.UserStatus;
import com.group.carrentalserver.dto.RegistrationEntryDto;
import com.group.carrentalserver.dto.enumeration.RegistrationType;
import com.group.carrentalserver.exception.EmailAlreadyExistsException;
import com.group.carrentalserver.exception.UsernameAlreadyExistsException;
import com.group.carrentalserver.service.RegistrationService;
import com.group.carrentalserver.service.RoleService;
import com.group.carrentalserver.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public RegistrationServiceImpl(UserService userService, RoleService roleService,
                                   PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(RegistrationEntryDto dto) {
        User user = new User();

        checkIfEmailOrUsernameAlreadyExists(dto.getUsername(), dto.getEmail());

        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRoles(assignRolesToUserByRegistrationType(dto.getRegistrationType()));
        user.setStatus(UserStatus.CREATED);

        return userService.save(user);
    }

    private void checkIfEmailOrUsernameAlreadyExists(String username, String email) {
        log.debug("Check whether user with email: {}, or username: {} already exists", email, username);

        Optional<User> optionalUser = userService.findByUsername(username);
        if (optionalUser.isPresent()) {
            log.debug("User with email: {} already exists!", email);
            throw new EmailAlreadyExistsException(email);
        }
        optionalUser = userService.findByUsername(username);
        if (optionalUser.isPresent()) {
            log.debug("Username: {} already exists!", username);
            throw new UsernameAlreadyExistsException(username);
        }
    }

    private Set<Role> assignRolesToUserByRegistrationType(RegistrationType registrationType) {
        Set<Role> roles = new HashSet<>();

        if (registrationType == RegistrationType.BOTH) {
            Optional<Role> optionalTenantRole = roleService.findRoleByRoleType(RoleType.TENANT);
            if (optionalTenantRole.isPresent()) {
                roles.add(optionalTenantRole.get());
            } else {
                roles.add(new Role(RoleType.TENANT));
            }

            Optional<Role> optionalDealerRole = roleService.findRoleByRoleType(RoleType.DEALER);
            if (optionalDealerRole.isPresent()) {
                roles.add(optionalDealerRole.get());
            } else {
                roles.add(new Role(RoleType.DEALER));
            }
        } else if (registrationType == RegistrationType.TENANT) {
            Optional<Role> optionalTenantRole = roleService.findRoleByRoleType(RoleType.TENANT);
            if (optionalTenantRole.isPresent()) {
                roles.add(optionalTenantRole.get());
            } else {
                roles.add(new Role(RoleType.TENANT));
            }
        } else if (registrationType == RegistrationType.DEALER) {
            Optional<Role> optionalDealerRole = roleService.findRoleByRoleType(RoleType.DEALER);
            if (optionalDealerRole.isPresent()) {
                roles.add(optionalDealerRole.get());
            } else {
                roles.add(new Role(RoleType.DEALER));
            }
        }

        return roles;
    }
}
