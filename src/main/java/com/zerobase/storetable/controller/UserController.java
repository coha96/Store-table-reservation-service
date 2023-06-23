package com.zerobase.storetable.controller;

import com.zerobase.storetable.dto.UserRegistrationRequest;
import com.zerobase.storetable.entity.User;
import com.zerobase.storetable.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable String id) {
        User user = userService.getUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Validated @RequestBody UserRegistrationRequest request) {
        User user = userService.registerUser(request);
        return ResponseEntity.ok(user);
    }
}
