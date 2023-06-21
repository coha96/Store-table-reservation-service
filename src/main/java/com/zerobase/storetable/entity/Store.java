package com.zerobase.storetable.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;

    private String name; // 매장명
    private String location; // 상점 위치
    private String description; // 상점 설명

    public Store() {
        // 기본 생성자
    }

    public Store(String name, String location, String description) {
        this.name = name;
        this.location = location;
        this.description = description;
    }
}
