package com.gui.ydd.strategy.impl;

import com.gui.ydd.entity.User;
import com.gui.ydd.factory.ServiceFactory;
import com.gui.ydd.filter.Filter;
import com.gui.ydd.filter.LoginValidationFilter;
import com.gui.ydd.strategy.UserStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserStrategyImpl {

    @Autowired
    private ServiceFactory serviceFactory;

    private List<Filter> filters;

    public UserStrategyImpl() {
        filters = new ArrayList<>();
        filters.add(new LoginValidationFilter());
    }

    public Object execute(String authType, Map<String, String> params) {
        switch (authType) {
            case "updateUser":
                return updateUser(params);
            case "register":
                return register(params);
            case "login":
                return login(params);
            case "deleteUser":
                return deleteUser(params);
            default:
                throw new IllegalArgumentException("Invalid auth type: " + authType);
        }
    }

    private Object updateUser(Map<String, String> params) {
        int userId = Integer.parseInt(params.get("userId"));
        String account = params.get("account");
        String username = params.get("username");
        String password = params.get("password");
        String role = params.get("role");
        User user = new User.Builder()
                .userId(userId)
                .account(account)
                .username(username)
                .password(password)
                .role(role)
                .createdate(new Date())
                .build();
        serviceFactory.createUserService().updateUser(user);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Update successful");
        response.put("userId", user.getUserId());
        return response;
    }

    private Object register(Map<String, String> params) {
        String account = params.get("account");
        String username = params.get("username");
        String password = params.get("password");
        String role = params.get("role");
        User user = new User.Builder()
                .account(account)
                .username(username)
                .password(password)
                .role(role)
                .createdate(new Date())
                .build();
        user = serviceFactory.createUserService().register(user);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Registration successful");
        response.put("userId", user.getUserId());
        return response;
    }

    private Object login(Map<String, String> params) {
        for (Filter filter : filters) {
            filter.execute(params);
        }

        String account = params.get("account");
        String password = params.get("password");
        String role = params.get("role");
        User user = serviceFactory.createUserService().login(account, password, role);
        if (user != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Login successful");
            response.put("role", user.getRole());
            return response;
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Invalid username or password");
            return response;
        }
    }

    private Object deleteUser(Map<String, String> params) {
        int userId = Integer.parseInt(params.get("userId"));
        serviceFactory.createUserService().deleteUser(userId);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Delete user successful");
        return response;
    }
}
