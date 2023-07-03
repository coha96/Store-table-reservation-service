package com.zerobase.storetable.service;

import com.zerobase.storetable.dto.ReviewRequest;
import com.zerobase.storetable.entity.Review;
import com.zerobase.storetable.entity.Store;
import com.zerobase.storetable.entity.User;
import com.zerobase.storetable.repository.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final StoreService storeService;
    private final UserService userService;

    public ReviewService(ReviewRepository reviewRepository, StoreService storeService, UserService userService) {
        this.reviewRepository = reviewRepository;
        this.storeService = storeService;
        this.userService = userService;
    }


    /**
     * 리뷰를 작성합니다.
     *
     * @param request 리뷰 요청 정보
     * @return 작성된 리뷰
     * @throws IllegalArgumentException 해당 상점이나 사용자를 찾을 수 없을 경우 예외가 발생합니다.
     */
    public Review writeReview(ReviewRequest request) {
        Store store = storeService.getStoreByName(request.getStoreName());
        if (store == null) {
            throw new IllegalArgumentException("해당 상점을 찾을 수 없습니다.");
        }

        User user = userService.getUserById(request.getUserid());
        if (user == null) {
            throw new IllegalArgumentException("해당 사용자를 찾을 수 없습니다.");
        }

        Review review = new Review(store, user, request.getRating(), request.getContent());
        return reviewRepository.save(review);
    }
}