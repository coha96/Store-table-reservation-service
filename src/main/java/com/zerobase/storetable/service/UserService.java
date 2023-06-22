package com.zerobase.storetable.service;

import com.zerobase.storetable.dto.UserDto;
import com.zerobase.storetable.entity.User;
import com.zerobase.storetable.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signUpUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());
        user.setPhoneNumber(userDto.getPhoneNumber());
        userRepository.save(user);
    }

}
