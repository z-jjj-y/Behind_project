package com.gui.ydd.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class GroupProjectMapperTest {

    @Autowired
    GroupProjectMapper groupProjectMapper;

    @Test
    void selectGroupProjectDetails() {
        System.out.println(groupProjectMapper.selectGroupProjectDetails(1));
    }
}