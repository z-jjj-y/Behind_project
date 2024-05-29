package com.gui.ydd.strategy.impl;

import com.gui.ydd.factory.ServiceFactory;
import com.gui.ydd.entity.User;
import com.gui.ydd.filter.LoginValidationFilter;
import com.gui.ydd.strategy.UserStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.gui.ydd.filter.Filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Component("login")
public class LoginStrategy implements UserStrategy {

    @Autowired
    private ServiceFactory serviceFactory;

    private List<Filter> filters;

    public LoginStrategy() {
        filters = new ArrayList<>();
        filters.add(new LoginValidationFilter());
    }

    @Override
    public Object execute(String key, Map<String, String> params) {
        for (Filter filter : filters) {
            filter.execute(params);
        }

        String account = params.get("account");
        String password = params.get("password");
        String role = params.get("role");
        // 实现你的登录逻辑
        User user = serviceFactory.createUserService().login(account, password,role);
        if (user != null) {
            // 登录成功，返回用户的角色
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Login successful");
            response.put("role", user.getRole());
            return response;
        } else {
            // 登录失败，返回错误信息
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Invalid username or password");
            return response;
        }
    }
}
