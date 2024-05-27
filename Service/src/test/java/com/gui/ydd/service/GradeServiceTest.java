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
        List<Grade> grades = gradeService.getAll();
        for (Grade grade : grades) {
            System.out.println(grade);
        }
    }

    @Test
    void getGradeById() {
        GradeService gradeService = serviceFactory.createGradeService();
        Grade grade = gradeService.getById(1);
        System.out.println(grade);
    }

    @Test
    void createGrade() {
        GradeService gradeService = serviceFactory.createGradeService();
        Grade grade = new Grade.Builder().gradeId(1).groupProjectId(1).teacherId(1).score(100).comment("Good").createdate(null).build();
        gradeService.create(grade);
        assertNotNull(gradeService.getById(1), "Grade should not be null");
    }

    @Test
    void updateGrade() {
        GradeService gradeService = serviceFactory.createGradeService();
        Grade grade = gradeService.getById(1);
        grade.setScore(90);
        gradeService.update(grade);
        assertEquals(90, gradeService.getById(1).getScore(), "Score should be updated");
    }

    @Test
    void deleteGrade() {
        GradeService gradeService = serviceFactory.createGradeService();
        gradeService.delete(5);
        assertNull(gradeService.getById(5), "Grade should be deleted");
    }
}