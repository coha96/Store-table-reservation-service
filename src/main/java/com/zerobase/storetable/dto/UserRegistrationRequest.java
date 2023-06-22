package com.zerobase.storetable.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRegistrationRequest {

    @NotBlank(message = "아이디는 필수 입력 항목입니다.")
    private String id;

    @NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
    private String password;

    @NotBlank(message = "사용자명은 필수 입력 항목입니다.")
    private String username;

    @NotBlank(message = "핸드폰 번호는 필수 입력 항목입니다.")
    private String phoneNumber;

    public UserRegistrationRequest() {
        // 기본 생성자
    }

    public UserRegistrationRequest(String id, String password, String username, String phoneNumber) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.phoneNumber = phoneNumber;
    }
}