package com.gui.ydd.strategy.impl;

import com.gui.ydd.factory.ServiceFactory;
import com.gui.ydd.entity.UserGroup;
import com.gui.ydd.service.UserGroupService;
import com.gui.ydd.strategy.ManagementStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component("userGroup")
public class UserGroupManagementStrategy implements ManagementStrategy<UserGroup> {

    @Autowired
    private ServiceFactory serviceFactory;

    @Override
    public Object execute(String operation, Map<String, Object> params) {
        UserGroupService userGroupService = serviceFactory.createUserGroupService();
        switch (operation) {
            case "getAll":
                return getAll(userGroupService);
            case "getById":
                return getById(userGroupService, params);
            case "create":
                return create(userGroupService, params);
            case "update":
                return update(userGroupService, params);
            case "delete":
                return delete(userGroupService, params);
            case "getDetails":
                return getDetails(userGroupService, params);
            case "getAllDetails":
                return getAllDetails(userGroupService);
            case "getAllDetailsByName":
                return getAllDetailsByName(userGroupService, params);
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }

    private Object getAll(UserGroupService userGroupService) {
        return userGroupService.getAll();
    }

    private Object getById(UserGroupService userGroupService, Map<String, Object> params) {
        return userGroupService.getById((Integer) params.get("id"));
    }

    private Object create(UserGroupService userGroupService, Map<String, Object> params) {
        UserGroup userGroup = new UserGroup.Builder()
                .groupName((String) params.get("groupName"))
                .description((String) params.get("description"))
                .userId((Integer) params.get("userId"))
                .role((String) params.get("role"))
                .createdate(new Date())
                .build();
        userGroupService.create(userGroup);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Create user group successful");
        return response;
    }

    private Object update(UserGroupService userGroupService, Map<String, Object> params) {
        UserGroup updateUserGroup = new UserGroup.Builder()
                .groupId((Integer) params.get("groupId"))
                .groupName((String) params.get("groupName"))
                .description((String) params.get("description"))
                .userId((Integer) params.get("userId"))
                .role((String) params.get("role"))
                .createdate(new Date())
                .build();
        userGroupService.update(updateUserGroup);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Update user group successful");
        return response;
    }

    private Object delete(UserGroupService userGroupService, Map<String, Object> params) {
        userGroupService.delete((Integer) params.get("id"));
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Delete user group successful");
        return response;
    }

    private Object getDetails(UserGroupService userGroupService, Map<String, Object> params) {
        return userGroupService.getDetails((Integer) params.get("id"));
    }

    private Object getAllDetails(UserGroupService userGroupService) {
        return userGroupService.getAllDetails();
    }

    private Object getAllDetailsByName(UserGroupService userGroupService, Map<String, Object> params) {
        return userGroupService.getAllDetailsByName((String) params.get("groupName"));
    }
}
