package com.gui.ydd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gui.ydd.entity.ReviewDetails;
import com.gui.ydd.mapper.ReviewMapper;
import com.gui.ydd.entity.Review;
import com.gui.ydd.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl extends BaseServiceImpl<ReviewMapper, Review> implements ReviewService {
    @Override
    public ReviewDetails getDetails(int reviewId) {
        return getBaseMapper().selectDetailsById(reviewId);
    }
}
