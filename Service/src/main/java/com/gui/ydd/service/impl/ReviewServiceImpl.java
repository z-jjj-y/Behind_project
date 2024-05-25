package com.gui.ydd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gui.ydd.entity.ReviewDetails;
import com.gui.ydd.mapper.ReviewMapper;
import com.gui.ydd.entity.Review;
import com.gui.ydd.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl extends ServiceImpl<ReviewMapper, Review> implements ReviewService {
    @Override
    public List<Review> getAllReviews() {
        return list();
    }

    @Override
    public Review getReviewById(int reviewId) {
        return lambdaQuery().eq(Review::getReviewId, reviewId).one();
    }

    @Override
    public void createReview(Review review) {
        boolean insertResult = save(review);
        if (!insertResult) {
            throw new RuntimeException("Failed to insert review record");
        }else{
            System.out.println("Successfully inserted review record");
        }
    }

    @Override
    public void updateReview(Review review) {
        boolean updateResult = updateById(review);
        if (!updateResult) {
            throw new RuntimeException("Failed to update review record");
        }else{
            System.out.println("Successfully updated review record");
        }
    }

    @Override
    public void deleteReview(int reviewId) {
        boolean deleteResult = removeById(reviewId);
        if (!deleteResult) {
            throw new RuntimeException("Failed to delete review record");
        }else{
            System.out.println("Successfully deleted review record");
        }
    }

    @Override
    public ReviewDetails getDetails(int reviewId) {
        return getBaseMapper().selectReviewDetails(reviewId);
    }
}
