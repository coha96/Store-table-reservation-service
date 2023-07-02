package com.zerobase.storetable.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull(message = "평점은 필수 입력 항목입니다.")
    private Integer rating;

    @NotBlank(message = "리뷰 내용은 필수 입력 항목입니다.")
    private String content;

    public Review() {
        // 기본 생성자
    }

    public Review(Store store, User user, Integer rating, String content) {
        this.store = store;
        this.user = user;
        this.rating = rating;
        this.content = content;
    }
}
