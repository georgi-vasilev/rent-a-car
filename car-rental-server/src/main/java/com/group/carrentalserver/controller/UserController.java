package com.group.carrentalserver.controller;

import com.group.carrentalserver.domain.entity.User;
import com.group.carrentalserver.domain.enumeration.UserStatus;
import com.group.carrentalserver.dto.RegistrationDto;
import com.group.carrentalserver.dto.UserDto;
import com.group.carrentalserver.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.group.carrentalserver.Mapper.UserMapper;

import javax.validation.Valid;

/**
 * REST Controller to manage {@link com.group.carrentalserver.domain.entity.User}
 */
@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid RegistrationDto dto) {
        System.out.println("hmm");
        return null;
    }

}
