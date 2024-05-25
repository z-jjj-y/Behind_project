package com.gui.ydd.strategy.impl;

import com.gui.ydd.factory.ServiceFactory;
import com.gui.ydd.entity.User;
import com.gui.ydd.strategy.UserStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("login")
public class LoginStrategy implements UserStrategy {

    @Autowired
    private ServiceFactory serviceFactory;

    @Override
    public Object execute(String key, Map<String, String> params) {
        String account = params.get("account");
        String password = params.get("password");
        // 实现你的登录逻辑
        User user = serviceFactory.createUserService().login(account, password);
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
