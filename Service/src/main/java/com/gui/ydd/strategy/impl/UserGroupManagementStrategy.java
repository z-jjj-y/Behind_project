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
        Map<String,Object> response  = new HashMap<>();
        switch (operation) {
            case "getAll":
                return userGroupService.getAll();
            case "getById":
                return userGroupService.getById((Integer) params.get("id"));
            case "create":
                UserGroup userGroup = new UserGroup.Builder()
                        .groupName((String) params.get("groupName"))
                        .description((String) params.get("description"))
                        .userId((Integer) params.get("userId"))
                        .role((String) params.get("role"))
                        .createdate(new Date())
                        .build();
                userGroupService.create(userGroup);
                response.put("message","Create user group successful");
                return response;
            case "update":
                UserGroup updateUserGroup = new UserGroup.Builder()
                        .groupId((Integer) params.get("groupId"))
                        .groupName((String) params.get("groupName"))
                        .description((String) params.get("description"))
                        .userId((Integer) params.get("userId"))
                        .role((String) params.get("role"))
                        .createdate(new Date())
                        .build();
                userGroupService.update(updateUserGroup);
                response.put("message","Update user group successful");
                return response;
            case "delete":
                userGroupService.delete((Integer) params.get("id"));
                response.put("message","Delete user group successful");
                return response;
            case "getDetails":
                return userGroupService.getDetails((Integer) params.get("id"));
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }
}
