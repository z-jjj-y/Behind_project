package com.gui.ydd.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GradeMapperTest {

    @Autowired
    GradeMapper gradeMapper;

    @Test
    void selectDetailsById() {
        System.out.println(gradeMapper.selectDetailsById(1));
    }
}