package com.group.carrentalserver.service.impl;

import com.group.carrentalserver.domain.entity.Role;
import com.group.carrentalserver.domain.entity.User;
import com.group.carrentalserver.domain.entity.VerificationToken;
import com.group.carrentalserver.domain.enumeration.RoleType;
import com.group.carrentalserver.domain.enumeration.UserStatus;
import com.group.carrentalserver.dto.RegistrationEntryDto;
import com.group.carrentalserver.dto.enumeration.RegistrationType;
import com.group.carrentalserver.exception.EmailAlreadyExistsException;
import com.group.carrentalserver.exception.InvalidVerificationTokenForUserException;
import com.group.carrentalserver.exception.UsernameAlreadyExistsException;
import com.group.carrentalserver.exception.VerificationTokenExpiredException;
import com.group.carrentalserver.service.IRegistrationService;
import com.group.carrentalserver.service.IRoleService;
import com.group.carrentalserver.service.IUserService;
import com.group.carrentalserver.service.IVerificationTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RegistrationService implements IRegistrationService {

    private final IUserService userService;
    private final IRoleService roleService;
    private final IVerificationTokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    public RegistrationService(IUserService userService, IRoleService roleService,
                               IVerificationTokenService tokenService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User registerUser(RegistrationEntryDto dto) throws EmailAlreadyExistsException,
            UsernameAlreadyExistsException {
        User user = new User();

        if (emailExists(dto.getEmail())) {
            log.debug("User with email: {} already exists!", dto.getEmail());
            throw new EmailAlreadyExistsException(dto.getEmail());
        }

        if (usernameExists(dto.getUsername())) {
            log.debug("Username: {} already exists!", dto.getUsername());
            throw new UsernameAlreadyExistsException(dto.getUsername());
        }

        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRoles(assignRolesToUserByRegistrationType(dto.getRegistrationType()));
        user.setStatus(UserStatus.CREATED);

        return userService.save(user);
    }

    @Override
    public void confirmRegistration(String token) throws InvalidVerificationTokenForUserException,
            VerificationTokenExpiredException {
        Optional<VerificationToken> optionalUserToken = tokenService.getVerificationToken(token);
        if (optionalUserToken.isEmpty()) {
            throw new InvalidVerificationTokenForUserException(token);
        }

        VerificationToken verificationToken = optionalUserToken.get();
        Calendar calendar = Calendar.getInstance();

        if ((verificationToken.getExpiryDate().getTime() - calendar.getTime().getTime()) <= 0) {
            throw new VerificationTokenExpiredException(token, verificationToken.getExpiryDate());
        }

        User user = verificationToken.getUser();
        user.setStatus(UserStatus.ACTIVE);
        userService.save(user);
    }

    private boolean emailExists(String email) {
        return userService.findByEmail(email).isPresent();
    }

    private boolean usernameExists(String username) {
        return userService.findByUsername(username).isPresent();
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
