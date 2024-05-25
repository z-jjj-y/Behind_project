package com.gui.ydd.strategy.impl;

import com.gui.ydd.factory.ServiceFactory;
import com.gui.ydd.entity.User;
import com.gui.ydd.strategy.UserStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component("register")
public class RegisterStrategy implements UserStrategy {

    @Autowired
    private ServiceFactory serviceFactory;

    @Override
    public Object execute(String key, Map<String, String> params) {
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
}
