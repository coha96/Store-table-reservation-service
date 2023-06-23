package com.zerobase.storetable.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRegistrationRequest {
    private String id;
    private String password;
    private String name;
    private String phone;

    public UserRegistrationRequest() {
        // 기본 생성자
    }
}