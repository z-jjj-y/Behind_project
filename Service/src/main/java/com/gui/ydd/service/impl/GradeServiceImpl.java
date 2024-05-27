package com.gui.ydd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gui.ydd.entity.GradeDetails;
import com.gui.ydd.mapper.GradeMapper;
import com.gui.ydd.entity.Grade;
import com.gui.ydd.service.GradeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl extends BaseServiceImpl<GradeMapper, Grade> implements GradeService {
    @Override
    public GradeDetails getDetails(int gradeId) {
        return getBaseMapper().selectDetailsById(gradeId);
    }
}
