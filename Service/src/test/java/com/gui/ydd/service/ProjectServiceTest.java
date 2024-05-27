package com.gui.ydd.service;

import com.gui.ydd.entity.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectServiceTest {

    @Autowired
    private ProjectService projectService;

    @Test
    void createProject() {
        Project project = new Project.Builder()
                .projectName("Test Project")
                .description("This is a test project")
                .build();
        projectService.create(project);

    }

    @Test
    void updateProject() {
    }
}