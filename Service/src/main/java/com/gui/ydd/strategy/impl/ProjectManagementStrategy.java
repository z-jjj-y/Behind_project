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
        switch (operation) {
            case "getAll":
                return getAll(projectService);
            case "getById":
                return getById(projectService, params);
            case "create":
                return create(projectService, params);
            case "update":
                return update(projectService, params);
            case "delete":
                return delete(projectService, params);
            case "getDetails":
                return getDetails(projectService, params);
            case "getAllDetails":
                return getAllDetails(projectService);
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }

    private Object getAll(ProjectService projectService) {
        return projectService.getAll();
    }

    private Object getById(ProjectService projectService, Map<String, Object> params) {
        return projectService.getById((Integer) params.get("id"));
    }

    private Object create(ProjectService projectService, Map<String, Object> params) {
        Project project = new Project.Builder()
                .projectName((String) params.get("projectName"))
                .description((String) params.get("description"))
                .createdate(new Date())
                .build();
        projectService.create(project);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Create project successful");
        return response;
    }

    private Object update(ProjectService projectService, Map<String, Object> params) {
        Project updateProject = new Project.Builder()
                .projectId((Integer) params.get("projectId"))
                .projectName((String) params.get("projectName"))
                .description((String) params.get("description"))
                .createdate(new Date())
                .build();
        projectService.update(updateProject);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Update project successful");
        return response;
    }

    private Object delete(ProjectService projectService, Map<String, Object> params) {
        projectService.delete((Integer) params.get("id"));
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Delete project successful");
        return response;
    }

    private Object getDetails(ProjectService projectService, Map<String, Object> params) {
        return projectService.getDetails((Integer) params.get("id"));
    }

    private Object getAllDetails(ProjectService projectService) {
        return projectService.getAllDetails();
    }
}
