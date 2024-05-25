package com.gui.ydd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gui.ydd.entity.Review;
import com.gui.ydd.entity.ReviewDetails;

import java.util.List;

public interface ReviewService extends IService<Review> {
    List<Review> getAllReviews();
    Review getReviewById(int reviewId);
    void createReview(Review review);
    void updateReview(Review review);
    void deleteReview(int reviewId);
    ReviewDetails getDetails(int reviewId);
}
