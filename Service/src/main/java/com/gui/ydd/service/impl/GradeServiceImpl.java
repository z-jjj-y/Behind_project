package com.gui.ydd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gui.ydd.entity.GradeDetails;
import com.gui.ydd.mapper.GradeMapper;
import com.gui.ydd.entity.Grade;
import com.gui.ydd.service.GradeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl extends ServiceImpl<GradeMapper, Grade> implements GradeService {
    @Override
    public List<Grade> getAllGrades() {
        return list();
    }

    @Override
    public Grade getGradeById(int gradeId) {
        return lambdaQuery().eq(Grade::getGradeId, gradeId).one();
    }

    @Override
    public void createGrade(Grade grade) {
        boolean insertResult = save(grade);
        if (!insertResult) {
            throw new RuntimeException("Failed to insert grade record");
        }else{
            System.out.println("Successfully inserted grade record");

        }
    }

    @Override
    public void updateGrade(Grade grade) {
        boolean updateResult = updateById(grade);
        if (!updateResult) {
            throw new RuntimeException("Failed to update grade record");
        }else{
            System.out.println("Successfully updated grade record");
        }
    }

    @Override
    public void deleteGrade(int gradeId) {
        boolean deleteResult = removeById(gradeId);
        if (!deleteResult) {
            throw new RuntimeException("Failed to delete grade record");
        } else {
            System.out.println("Successfully deleted grade record");
        }
    }

    @Override
    public GradeDetails getDetails(int gradeId) {
        return getBaseMapper().selectGradeDetails(gradeId);
    }
}
