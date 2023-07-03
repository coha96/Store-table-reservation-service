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

    /**
     * 사용자를 등록합니다.
     *
     * @param request 사용자 등록 요청 객체
     * @return 등록된 사용자 객체
     */
    public User registerUser(UserRegistrationRequest request) {
        User user = new User(request.getId(), request.getPassword(),
                request.getName(), request.getPhone());
        return userRepository.save(user);
    }

    /**
     * 지정된 사용자 ID로 사용자를 조회합니다.
     *
     * @param id 사용자 ID
     * @return 사용자 엔티티 객체 (존재하지 않을 경우 null 반환)
     */
    public User getUserById(String id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }
}