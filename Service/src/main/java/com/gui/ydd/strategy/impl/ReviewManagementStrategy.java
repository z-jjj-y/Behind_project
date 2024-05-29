package com.gui.ydd.strategy.impl;

import com.gui.ydd.factory.ServiceFactory;
import com.gui.ydd.entity.Review;
import com.gui.ydd.service.ReviewService;
import com.gui.ydd.strategy.ManagementStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component("review")
public class ReviewManagementStrategy implements ManagementStrategy<Review> {

    @Autowired
    private ServiceFactory serviceFactory;

    @Override
    public Object execute(String operation, Map<String, Object> params) {
        ReviewService reviewService = serviceFactory.createReviewService();
        switch (operation) {
            case "getAll":
                return getAll(reviewService);
            case "getById":
                return getById(reviewService, params);
            case "create":
                return create(reviewService, params);
            case "update":
                return update(reviewService, params);
            case "delete":
                return delete(reviewService, params);
            case "getDetails":
                return getDetails(reviewService, params);
            case "getAllDetails":
                return getAllDetails(reviewService);
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }

    private Object getAll(ReviewService reviewService) {
        return reviewService.getAll();
    }

    private Object getById(ReviewService reviewService, Map<String, Object> params) {
        return reviewService.getById((Integer) params.get("id"));
    }

    private Object create(ReviewService reviewService, Map<String, Object> params) {
        Review review = new Review.Builder()
                .reviewerId((Integer) params.get("reviewerId"))
                .groupProjectId((Integer) params.get("groupProjectId"))
                .score((Integer) params.get("score"))
                .comment((String) params.get("comment"))
                .createdate(new Date())
                .build();
        reviewService.create(review);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Create review successful");
        return response;
    }

    private Object update(ReviewService reviewService, Map<String, Object> params) {
        Review updateReview = new Review.Builder()
                .reviewId((Integer) params.get("reviewId"))
                .reviewerId((Integer) params.get("reviewerId"))
                .groupProjectId((Integer) params.get("groupProjectId"))
                .score((Integer) params.get("score"))
                .comment((String) params.get("comment"))
                .createdate(new Date())
                .build();
        reviewService.update(updateReview);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Update review successful");
        return response;
    }

    private Object delete(ReviewService reviewService, Map<String, Object> params) {
        reviewService.delete((Integer) params.get("id"));
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Delete review successful");
        return response;
    }

    private Object getDetails(ReviewService reviewService, Map<String, Object> params) {
        return reviewService.getDetails((Integer) params.get("id"));
    }

    private Object getAllDetails(ReviewService reviewService) {
        return reviewService.getAllDetails();
    }
}
