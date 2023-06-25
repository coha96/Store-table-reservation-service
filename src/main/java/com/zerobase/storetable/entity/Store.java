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
    private String name; // 매장명
    private String location; // 상점 위치
    private String description; // 상점 설명

    @ManyToOne
    @JoinColumn(name = "partner_id")
    private Partner partner;

    public Store() {
        // 기본 생성자
    }

    public Store(String name, String location, String description, Partner partner) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.partner = partner;
    }
}