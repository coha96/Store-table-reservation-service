package com.zerobase.storetable.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PartnerRegistrationRequest {
    private String name;
    private String email;
    private String password;

    public PartnerRegistrationRequest() {
        // 기본 생성자
    }

    public PartnerRegistrationRequest(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
