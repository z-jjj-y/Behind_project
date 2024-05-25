package com.gui.ydd.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserGroupMapperTest {

    @Autowired
    UserGroupMapper userGroupMapper;

    @Test
    void selectUserGroupDetails() {
        System.out.println(userGroupMapper.selectUserGroupDetails(1));
    }
}