package com.gui.ydd.strategy.impl;

import com.gui.ydd.factory.ServiceFactory;
import com.gui.ydd.entity.Project;
import com.gui.ydd.service.ProjectService;
import com.gui.ydd.strategy.ManagementStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component("project")
public class ProjectManagementStrategy implements ManagementStrategy<Project> {

    @Autowired
    private ServiceFactory serviceFactory;

    @Override
    public Object execute(String operation, Map<String, Object> params) {
        ProjectService projectService = serviceFactory.createProjectService();
        Map<String, Object> response = new HashMap<>();
        switch (operation) {
            case "getAll":
                return projectService.getAllProjects();
            case "getById":
                return projectService.getProjectById((Integer) params.get("id"));
            case "create":
                Project project = new Project.Builder()
                        .projectName((String) params.get("projectName"))
                        .description((String) params.get("description"))
                        .createdate(new Date())
                        .build();
                projectService.createProject(project);
                response.put("message", "Create project successful");
                return response;
            case "update":
                Project updateProject = new Project.Builder()
                        .projectId((Integer) params.get("projectId"))
                        .projectName((String) params.get("projectName"))
                        .description((String) params.get("description"))
                        .createdate(new Date())
                        .build();
                projectService.updateProject(updateProject);
                response.put("message", "Update project successful");
                return response;
            case "delete":
                projectService.deleteProject((Integer) params.get("id"));
                response.put("message", "Delete project successful");
                return response;
            case "getDetails":
                return projectService.getDetails((Integer) params.get("id"));
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }
}
