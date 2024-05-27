package com.gui.ydd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gui.ydd.entity.Grade;
import com.gui.ydd.entity.GradeDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GradeMapper extends BaseMapper<Grade> {
    GradeDetails selectDetailsById(@Param("gradeId") int gradeId);
    List<GradeDetails> selectAllDetails();
}
