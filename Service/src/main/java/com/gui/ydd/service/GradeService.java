package com.gui.ydd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gui.ydd.entity.Grade;
import com.gui.ydd.entity.GradeDetails;

import java.util.List;

public interface GradeService extends IService<Grade> {
    List<Grade> getAllGrades();
    Grade getGradeById(int gradeId);
    void createGrade(Grade grade);
    void updateGrade(Grade grade);
    void deleteGrade(int gradeId);
    GradeDetails getDetails(int gradeId);
}
