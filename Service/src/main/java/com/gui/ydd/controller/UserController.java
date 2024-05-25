package com.gui.ydd.controller;

import com.gui.ydd.strategy.UserStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private Map<String, UserStrategy> authStrategies;

    @PostMapping("/{authType}")
    public Object auth(@PathVariable String authType, @RequestBody Map<String, String> params) {
        UserStrategy strategy = authStrategies.get(authType);
        if (strategy == null) {
            throw new IllegalArgumentException("Invalid auth type: " + authType);
        }
        return strategy.execute(authType, params);
    }
}
