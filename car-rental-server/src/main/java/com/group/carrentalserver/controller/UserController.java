package com.group.carrentalserver.controller;

import com.group.carrentalserver.domain.entity.User;
import com.group.carrentalserver.dto.RegistrationEntryDto;
import com.group.carrentalserver.dto.UserDto;
import com.group.carrentalserver.mapper.UserMapper;
import com.group.carrentalserver.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * REST Controller to manage {@link com.group.carrentalserver.domain.entity.User}
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<UserDto> register(@RequestBody @Valid RegistrationEntryDto dto) {
        log.debug("REST request to register a user!");

        User registeredUser = userService.registerUser(dto);

        UserDto result = userMapper.entityToDto(registeredUser);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(result);
    }
}
