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
        Map<String, Object> response = new HashMap<>();
        switch (operation) {
            case "getAll":
                return groupProjectService.getAllGroupProjects();
            case "getById":
                return groupProjectService.getGroupProjectById((Integer) params.get("id"));
            case "create":
                GroupProject groupProject = new GroupProject.Builder()
                        .groupId((Integer) params.get("groupId"))
                        .projectId((Integer) params.get("projectId"))
                        .status((String) params.get("status"))
                        .createdate(new Date())
                        .build();
                groupProjectService.createGroupProject(groupProject);
                response.put("message", "Create group project successful");
                return response;
            case "update":
                GroupProject updateGroupProject = new GroupProject.Builder()
                        .groupProjectId((Integer) params.get("groupProjectId"))
                        .groupId((Integer) params.get("groupId"))
                        .projectId((Integer) params.get("projectId"))
                        .status((String) params.get("status"))
                        .createdate(new Date())
                        .build();
                groupProjectService.updateGroupProject(updateGroupProject);
                response.put("message", "Update group project successful");
                return response;
            case "delete":
                groupProjectService.deleteGroupProject((Integer) params.get("id"));
                response.put("message", "Delete group project successful");
                return response;
            case "getDetails":
                return groupProjectService.getDetails((Integer) params.get("id"));
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }
}
