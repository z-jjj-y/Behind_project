package com.gui.ydd.service;

import com.gui.ydd.factory.ServiceFactory;
import com.gui.ydd.entity.Grade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GradeServiceTest {

    @Autowired
    private ServiceFactory serviceFactory;

    @Test
    void getAllGrades() {
        GradeService gradeService = serviceFactory.createGradeService();
        List<Grade> grades = gradeService.getAllGrades();
        for (Grade grade : grades) {
            System.out.println(grade);
        }
    }

    @Test
    void getGradeById() {
        GradeService gradeService = serviceFactory.createGradeService();
        Grade grade = gradeService.getGradeById(1);
        System.out.println(grade);
    }

    @Test
    void createGrade() {
        GradeService gradeService = serviceFactory.createGradeService();
        Grade grade = new Grade.Builder().gradeId(1).groupProjectId(1).teacherId(1).score(100).comment("Good").createdate(null).build();
        gradeService.createGrade(grade);
        assertNotNull(gradeService.getGradeById(1), "Grade should not be null");
    }

    @Test
    void updateGrade() {
        GradeService gradeService = serviceFactory.createGradeService();
        Grade grade = gradeService.getGradeById(1);
        grade.setScore(90);
        gradeService.updateGrade(grade);
        assertEquals(90, gradeService.getGradeById(1).getScore(), "Score should be updated");
    }

    @Test
    void deleteGrade() {
        GradeService gradeService = serviceFactory.createGradeService();
        gradeService.deleteGrade(5);
        assertNull(gradeService.getGradeById(5), "Grade should be deleted");
    }
}