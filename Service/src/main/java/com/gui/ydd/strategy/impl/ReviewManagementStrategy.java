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
        Map<String, Object> response = new HashMap<>();
        switch (operation) {
            case "getAll":
                return reviewService.getAll();
            case "getById":
                return reviewService.getById((Integer) params.get("id"));
            case "create":
                Review review = new Review.Builder()
                        .reviewerId((Integer) params.get("reviewerId"))
                        .groupProjectId((Integer) params.get("groupProjectId"))
                        .score((Integer) params.get("score"))
                        .comment((String) params.get("comment"))
                        .createdate(new Date())
                        .build();
                reviewService.create(review);
                response.put("message", "Create review successful");
                return response;
            case "update":
                Review updateReview = new Review.Builder()
                        .reviewId((Integer) params.get("reviewId"))
                        .reviewerId((Integer) params.get("reviewerId"))
                        .groupProjectId((Integer) params.get("groupProjectId"))
                        .score((Integer) params.get("score"))
                        .comment((String) params.get("comment"))
                        .createdate(new Date())
                        .build();
                reviewService.update(updateReview);
                response.put("message", "Update review successful");
                return response;
            case "delete":
                reviewService.delete((Integer) params.get("id"));
                response.put("message", "Delete review successful");
                return response;
            case "getDetails":
                return reviewService.getDetails((Integer) params.get("id"));
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }
}
