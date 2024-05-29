package com.gui.ydd.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserGroupMapperTest {

    @Autowired
    UserGroupMapper userGroupMapper;

    @Test
    void selectDetailsById() {
        System.out.println(userGroupMapper.selectDetailsById(1));
    }

    @Test
    void selectAllDetailsByName(){
        System.out.println(userGroupMapper.selectAllDetailsByName("小组1"));
    }
}