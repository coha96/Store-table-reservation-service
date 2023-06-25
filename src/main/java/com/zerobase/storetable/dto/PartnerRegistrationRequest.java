package com.zerobase.storetable.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
// HTTP 요청을 통해 전달되는 데이터를 담기 위한 목적으로 사용되는 DTO(데이터 전송 객체)
public class PartnerRegistrationRequest {
    private String name;
    private String email;
    private String password;

    public PartnerRegistrationRequest() {
        // 기본 생성자
    }
}