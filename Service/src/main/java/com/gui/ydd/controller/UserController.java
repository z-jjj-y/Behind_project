package com.gui.ydd.controller;

import com.gui.ydd.strategy.impl.UserStrategyImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserStrategyImpl userStrategyImpl;

    @PostMapping("/{authType}")
    public Object auth(@PathVariable String authType, @RequestBody Map<String, String> params) {
        return userStrategyImpl.execute(authType, params);
    }
}
