package com.gui.ydd.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GradeMapperTest {

    @Autowired
    GradeMapper gradeMapper;

    @Test
    void selectGradeDetails() {
        System.out.println(gradeMapper.selectGradeDetails(1));
    }
}