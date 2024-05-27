package com.gui.ydd.service.impl;

import com.gui.ydd.entity.Grade;
import com.gui.ydd.entity.GradeDetails;
import com.gui.ydd.mapper.GradeMapper;
import com.gui.ydd.service.GradeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl extends BaseServiceImpl<GradeMapper, Grade, GradeDetails> implements GradeService {

        @Override
        public GradeDetails getDetails(int id) {
            return baseMapper.selectDetailsById(id);
        }

        @Override
        public List<GradeDetails> getAllDetails() {
            return baseMapper.selectAllDetails();
        }
}
