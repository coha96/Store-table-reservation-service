package com.zerobase.storetable.controller;

import com.zerobase.storetable.dto.UserDto;
import com.zerobase.storetable.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> signUpUser(@Valid @RequestBody UserDto userDto) {
        userService.signUpUser(userDto);
        return ResponseEntity.ok("User signed up successfully.");
    }

}
