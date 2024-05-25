package com.gui.ydd.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArchiveMapperTest {

    @Autowired
    ArchiveMapper archiveMapper;

    @Test
    void selectArchiveDetails() {
        System.out.println(archiveMapper.selectArchiveDetails(1));
    }
}