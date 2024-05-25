package com.gui.ydd.service;

import com.gui.ydd.entity.ArchiveDetails;
import com.gui.ydd.factory.ServiceFactory;
import com.gui.ydd.entity.Archive;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArchiveServiceTest {

    @Autowired
    private ServiceFactory serviceFactory;

    @Test
    void getAllArchives() {
        ArchiveService archiveService = serviceFactory.createArchiveService();
        List<Archive> archives = archiveService.getAllArchives();
        assertNotNull(archives, "Archives list should not be null");
        assertFalse(archives.isEmpty(), "Archives list should not be empty");
    }

    @Test
    void getArchiveById() {
        ArchiveService archiveService = serviceFactory.createArchiveService();
        Archive archive = archiveService.getArchiveById(2); // Assuming an archive with id 1 exists
        assertNotNull(archive, "Archive should not be null");
    }

    @Test
    void createArchive() {
        ArchiveService archiveService = serviceFactory.createArchiveService();
        Archive archive = new Archive.Builder()
                .groupProjectId(1)
                .finalScore(95)
                .rating("excellent") // 确保此处符合数据库定义
                .archivedAt(new Date())
                .build();
        archiveService.createArchive(archive);
        assertNotNull(archive.getArchiveId(), "Newly created archive should have an id");
    }


    @Test
    void updateArchive() {
        ArchiveService archiveService = serviceFactory.createArchiveService();
        Archive archive = archiveService.getArchiveById(10); // Assuming an archive with id 1 exists
        archive.setFinalScore(50);
        archiveService.updateArchive(archive);
    }

    @Test
    void deleteArchive() {
        ArchiveService archiveService = serviceFactory.createArchiveService();
        archiveService.deleteArchive(9); // Assuming an archive with id 1 exists
        Archive archive = archiveService.getArchiveById(9);
        assertNull(archive, "Archive should be null after deletion");
    }

    @Test
    void getDetails(){
        ArchiveService archiveService = serviceFactory.createArchiveService();
        Archive archive = archiveService.getArchiveById(1);
        assertNotNull(archive, "Archive should not be null");
        assertNotNull(archive.getArchiveId(), "Archive id should not be null");
        ArchiveDetails archiveDetails = archiveService.getDetails(archive.getArchiveId());
        assertNotNull(archiveDetails, "Archive details should not be null");
    }
}