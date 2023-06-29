package com.zerobase.storetable.controller;

import com.zerobase.storetable.dto.UserRegistrationRequest;
import com.zerobase.storetable.entity.User;
import com.zerobase.storetable.service.UserService;
import org.springframework.http.HttpStatus;
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

    // user id 검색(개발자 확인용)
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
    public ResponseEntity<String> registerUser(@Validated @RequestBody UserRegistrationRequest request) {
        User existingUser = userService.getUserById(request.getId());
        if (existingUser != null) {
            return ResponseEntity.badRequest().body("이미 사용 중인 ID입니다.");
        }

        User user = userService.registerUser(request);
        if (user != null) {
            return ResponseEntity.ok("회원 가입이 완료되었습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("회원 가입에 실패하였습니다.");
        }
    }
}