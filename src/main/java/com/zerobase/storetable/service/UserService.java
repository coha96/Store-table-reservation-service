package com.zerobase.storetable.service;

import com.zerobase.storetable.dto.UserRegistrationRequest;
import com.zerobase.storetable.entity.User;
import com.zerobase.storetable.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(UserRegistrationRequest request) {
        User user = new User(request.getId(), request.getPassword(),
                request.getName(), request.getPhone());
        return userRepository.save(user);
    }

    public User getUserById(String id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }
}