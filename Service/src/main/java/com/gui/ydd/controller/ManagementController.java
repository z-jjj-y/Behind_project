package com.gui.ydd.controller;

import com.gui.ydd.strategy.ManagementStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/management")
@CrossOrigin
public class ManagementController {

    @Autowired
    private Map<String, ManagementStrategy> strategies;

    private Object executeStrategy(String type, String operation, Map<String, Object> requestBody) {
        ManagementStrategy strategy = strategies.get(type);
        if (strategy == null) {
            throw new IllegalArgumentException("Invalid management type: " + type);
        }
        return strategy.execute(operation, requestBody);
    }

    @PostMapping("/{type}/getAll")
    public Object getAll(@PathVariable String type) {
        return executeStrategy(type, "getAll", new HashMap<>());
    }

    @PostMapping("/{type}/getById")
    public Object getById(@PathVariable String type, @RequestBody Map<String, Object> requestBody) {
        return executeStrategy(type, "getById", requestBody);
    }

    @PostMapping("/{type}/create")
    public Object create(@PathVariable String type, @RequestBody Map<String, Object> requestBody) {
        return executeStrategy(type, "create", requestBody);
    }

    @PostMapping("/{type}/update")
    public Object update(@PathVariable String type, @RequestBody Map<String, Object> requestBody) {
        return executeStrategy(type, "update", requestBody);
    }

    @PostMapping("/{type}/delete")
    public Object delete(@PathVariable String type, @RequestBody Map<String, Object> requestBody) {
        return executeStrategy(type, "delete", requestBody);
    }

    @PostMapping("/{type}/getDetails")
    public Object getDetails(@PathVariable String type, @RequestBody Map<String, Object> requestBody) {
        return executeStrategy(type, "getDetails", requestBody);
    }
}
