package com.zerobase.storetable.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class User {
    @Id
    @NotBlank(message = "아이디는 필수 입력 항목입니다.")
    private String id;

    @NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
    private String password;

    @NotBlank(message = "사용자 이름은 필수 입력 항목입니다.")
    private String username;

    @Column(name = "phone_number")
    @NotBlank(message = "전화번호는 필수 입력 항목입니다.")
    private String phoneNumber;

    public User() {
    }

    public User(String id, String password, String username, String phoneNumber) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.phoneNumber = phoneNumber;
    }
}