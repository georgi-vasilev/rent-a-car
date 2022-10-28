package com.group.carrentalserver.controller;

import com.group.carrentalserver.service.UserService;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller to manage {@link com.group.carrentalserver.domain.entity.User}
 */
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // TODO
}
