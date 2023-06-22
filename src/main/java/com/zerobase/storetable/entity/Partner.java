package com.zerobase.storetable.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@ToString
public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "partner_id")  // partner_id 칼럼과 매핑
    private Long id;

    @NotBlank(message = "이름은 필수 입력 항목입니다.")
    private String name;

    @Email(message = "유효한 이메일 형식이 아닙니다.")
    @NotBlank(message = "이메일은 필수 입력 항목입니다.")
    private String email;

    @NotNull(message = "비밀번호는 필수 입력 항목입니다.")
    private String password;

    // 기본 생성자
    public Partner() {
    }

    // 생성자: name, email, password 를 받는 생성자 추가
    public Partner(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}