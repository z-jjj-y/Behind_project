package com.gui.ydd.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GroupProjectMapperTest {

    @Autowired
    GroupProjectMapper groupProjectMapper;

    @Test
    void selectDetailsById() {
        System.out.println(groupProjectMapper.selectDetailsById(1));
    }
}