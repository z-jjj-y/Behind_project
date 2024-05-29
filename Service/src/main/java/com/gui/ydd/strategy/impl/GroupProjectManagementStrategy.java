package com.gui.ydd.strategy.impl;

import com.gui.ydd.factory.ServiceFactory;
import com.gui.ydd.entity.GroupProject;
import com.gui.ydd.service.GroupProjectService;
import com.gui.ydd.strategy.ManagementStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component("groupProject")
public class GroupProjectManagementStrategy implements ManagementStrategy<GroupProject> {

    @Autowired
    private ServiceFactory serviceFactory;

    @Override
    public Object execute(String operation, Map<String, Object> params) {
        GroupProjectService groupProjectService = serviceFactory.createGroupProjectService();
        switch (operation) {
            case "getAll":
                return getAll(groupProjectService);
            case "getById":
                return getById(groupProjectService, params);
            case "create":
                return create(groupProjectService, params);
            case "update":
                return update(groupProjectService, params);
            case "delete":
                return delete(groupProjectService, params);
            case "getDetails":
                return getDetails(groupProjectService, params);
            case "getAllDetails":
                return getAllDetails(groupProjectService);
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }

    private Object getAll(GroupProjectService groupProjectService) {
        return groupProjectService.getAll();
    }

    private Object getById(GroupProjectService groupProjectService, Map<String, Object> params) {
        return groupProjectService.getById((Integer) params.get("id"));
    }

    private Object create(GroupProjectService groupProjectService, Map<String, Object> params) {
        GroupProject groupProject = new GroupProject.Builder()
                .groupId((Integer) params.get("groupId"))
                .projectId((Integer) params.get("projectId"))
                .status((String) params.get("status"))
                .createdate(new Date())
                .build();
        groupProjectService.create(groupProject);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Create group project successful");
        return response;
    }

    private Object update(GroupProjectService groupProjectService, Map<String, Object> params) {
        GroupProject updateGroupProject = new GroupProject.Builder()
                .groupProjectId((Integer) params.get("groupProjectId"))
                .groupId((Integer) params.get("groupId"))
                .projectId((Integer) params.get("projectId"))
                .status((String) params.get("status"))
                .createdate(new Date())
                .build();
        groupProjectService.update(updateGroupProject);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Update group project successful");
        return response;
    }

    private Object delete(GroupProjectService groupProjectService, Map<String, Object> params) {
        groupProjectService.delete((Integer) params.get("id"));
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Delete group project successful");
        return response;
    }

    private Object getDetails(GroupProjectService groupProjectService, Map<String, Object> params) {
        return groupProjectService.getDetails((Integer) params.get("id"));
    }

    private Object getAllDetails(GroupProjectService groupProjectService) {
        return groupProjectService.getAllDetails();
    }
}
