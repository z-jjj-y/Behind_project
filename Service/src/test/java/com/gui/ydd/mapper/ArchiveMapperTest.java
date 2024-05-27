package com.gui.ydd.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ArchiveMapperTest {

    @Autowired
    ArchiveMapper archiveMapper;

    @Test
    void selectDetailsById() {
        System.out.println(archiveMapper.selectDetailsById(1));
    }

    @Test
    void selectAllDetails() {
        System.out.println(archiveMapper.selectAllDetails());
    }
}