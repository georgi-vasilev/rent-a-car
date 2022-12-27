package com.group.carrentalserver.controller;

import com.group.carrentalserver.domain.entity.User;
import com.group.carrentalserver.dto.RegistrationEntryDto;
import com.group.carrentalserver.dto.UserDto;
import com.group.carrentalserver.mapper.UserMapper;
import com.group.carrentalserver.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/sign-up")
public class AuthenticationController {

    private final RegistrationService registrationService;
    private final UserMapper userMapper;

    public AuthenticationController(RegistrationService registrationService, UserMapper userMapper) {
        this.registrationService = registrationService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public ResponseEntity<UserDto> register(@RequestBody @Valid RegistrationEntryDto dto) {
        log.debug("REST request to register a user!");

        User registeredUser = registrationService.registerUser(dto);

        UserDto result = userMapper.entityToDto(registeredUser);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
