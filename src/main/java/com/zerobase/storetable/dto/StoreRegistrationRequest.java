package com.zerobase.storetable.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StoreRegistrationRequest {

    @NotBlank(message = "매장 이름은 필수 입력 항목입니다.")
    private String name;

    @NotBlank(message = "상점 위치는 필수 입력 항목입니다.")
    private String location;

    private String description;

    public StoreRegistrationRequest() {
        // 기본 생성자
    }

    public StoreRegistrationRequest(String name, String location, String description) {
        this.name = name;
        this.location = location;
        this.description = description;
    }
}
