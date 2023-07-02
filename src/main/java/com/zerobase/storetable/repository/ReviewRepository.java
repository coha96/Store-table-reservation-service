package com.zerobase.storetable.repository;

import com.zerobase.storetable.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
