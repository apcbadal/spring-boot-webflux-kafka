package com.example.webflux.controller;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import com.example.webflux.service.UserService;
import com.example.webflux.model.User;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/email/{email}")
    public Mono<User> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping
    public Mono<User> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

}
