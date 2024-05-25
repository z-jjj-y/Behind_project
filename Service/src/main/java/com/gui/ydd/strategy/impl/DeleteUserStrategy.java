package com.gui.ydd.strategy.impl;

import com.gui.ydd.factory.ServiceFactory;
import com.gui.ydd.strategy.UserStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("deleteUser")
public class DeleteUserStrategy implements UserStrategy {
    @Autowired
    private ServiceFactory serviceFactory;

    @Override
    public Object execute(String key, Map<String, String> params) {
        int userId = Integer.parseInt(params.get("userId"));
        // 实现你的删除用户逻辑
        serviceFactory.createUserService().deleteUser(userId);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Delete user successful");
        return response;
    }

}
