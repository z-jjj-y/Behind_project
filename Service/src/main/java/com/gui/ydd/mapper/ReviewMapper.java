package com.gui.ydd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gui.ydd.entity.Review;
import com.gui.ydd.entity.ReviewDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReviewMapper extends BaseMapper<Review> {
    ReviewDetails selectDetailsById(@Param("reviewId") int reviewId);
    List<ReviewDetails> selectAllDetails();
}
