package com.group.carrentalserver.controller;

import com.group.carrentalserver.domain.entity.User;
import com.group.carrentalserver.dto.RegistrationEntryDto;
import com.group.carrentalserver.dto.UserDto;
import com.group.carrentalserver.event.publisher.EventPublisher;
import com.group.carrentalserver.exception.EmailAlreadyExistsException;
import com.group.carrentalserver.exception.UsernameAlreadyExistsException;
import com.group.carrentalserver.mapper.UserMapper;
import com.group.carrentalserver.service.IRegistrationService;
import com.group.carrentalserver.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

/**
 * REST Controller to manage {@link com.group.carrentalserver.domain.entity.User}
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final IRegistrationService registrationService;
    private final IUserService userService;
    private final UserMapper userMapper;
    private final EventPublisher eventPublisher;

    public UserController(IRegistrationService registrationService,
                          IUserService userService,
                          UserMapper userMapper,
                          EventPublisher eventPublisher) {
        this.registrationService = registrationService;
        this.userService = userService;
        this.userMapper = userMapper;
        this.eventPublisher = eventPublisher;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid RegistrationEntryDto dto,
                                    HttpServletRequest request) {
        log.debug("REST request to register a user!");

        try {
            User registeredUser = registrationService.registerUser(dto);

            eventPublisher.publishEvent(registeredUser, request);

            UserDto result = userMapper.entityToDto(registeredUser);

            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (EmailAlreadyExistsException | UsernameAlreadyExistsException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/confirmRegistration")
    public ResponseEntity<String> confirmRegistration(@RequestParam("token") String token,
                                                      HttpServletRequest request) {
        log.debug("REST request to activate user by email confirmation!");

        registrationService.confirmRegistration(token);

        return ResponseEntity.ok("redirect:/login?lang=" + request.getLocale().getLanguage());
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        log.debug("REST request to delete a User with ID: {}!", id);

        Optional<User> optionalUser = userService.findOneById(id);
        if (optionalUser.isPresent()) {
            userService.deleteById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
