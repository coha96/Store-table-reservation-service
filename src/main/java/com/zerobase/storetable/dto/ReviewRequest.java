package com.zerobase.storetable.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewRequest {
    private String storeName;
    private String userid;
    private Integer rating;
    private String content;
}