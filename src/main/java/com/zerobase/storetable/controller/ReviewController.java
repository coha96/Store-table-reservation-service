package com.zerobase.storetable.controller;

import com.zerobase.storetable.dto.ReviewRequest;
import com.zerobase.storetable.entity.Review;
import com.zerobase.storetable.service.ReservationService;
import com.zerobase.storetable.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {
    private final ReviewService reviewService;
    private final ReservationService reservationService;

    public ReviewController(ReviewService reviewService, ReservationService reservationService) {
        this.reviewService = reviewService;
        this.reservationService = reservationService;
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> writeReview(@RequestParam("ordernumber") Long ordernumber,
                                              @Validated @RequestBody ReviewRequest request) {
        if (!reservationService.hasCheckedIn(ordernumber)) {
            return new ResponseEntity<>("리뷰를 작성할 수 없는 권한이 없습니다.", HttpStatus.FORBIDDEN);
        }

        try {
            Review review = reviewService.writeReview(request);
            return new ResponseEntity<>("리뷰가 성공적으로 작성되었습니다.", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }
}