package com.zerobase.storetable.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto {
    private String id;
    private String password;
    private String username;
    private String phoneNumber;

    public UserDto() {

    }
}
