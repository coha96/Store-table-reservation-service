package com.zerobase.storetable.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "user")
public class User {
    @Id
    @NotBlank(message = "아이디는 필수 입력 항목입니다.")
    @Column(name = "id") // 컬럼명을 "id"로 지정
    private String id;

    @NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
    private String password;

    @NotBlank(message = "이름은 필수 입력 항목입니다.")
    private String name;

    @NotBlank(message = "전화번호는 필수 입력 항목입니다.")
    @Column(name = "phone") // 컬럼명을 "phone"으로 지정
    private String phoneNumber;

    public User() {
        // 기본 생성자
    }

    public User(String id, String password, String name, String phoneNumber) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
