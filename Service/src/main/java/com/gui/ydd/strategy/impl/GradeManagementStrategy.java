package com.gui.ydd.strategy.impl;

import com.gui.ydd.factory.ServiceFactory;
import com.gui.ydd.entity.Grade;
import com.gui.ydd.service.GradeService;
import com.gui.ydd.strategy.ManagementStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component("grade")
public class GradeManagementStrategy implements ManagementStrategy<Grade> {
    @Autowired
    private ServiceFactory serviceFactory;

    @Override
    public Object execute(String operation, Map<String, Object> params) {
        GradeService gradeService = serviceFactory.createGradeService();
        Map<String, Object> response = new HashMap<>();
        switch (operation) {
            case "getAll":
                return gradeService.getAll();
            case "getById":
                return gradeService.getById((Integer) params.get("id"));
            case "create":
                Grade grade = new Grade.Builder()
                        .groupProjectId((Integer) params.get("groupProjectId"))
                        .teacherId((Integer) params.get("teacherId"))
                        .score((Integer) params.get("score"))
                        .comment((String) params.get("comment"))
                        .createdate(new Date())
                        .build();
                gradeService.create(grade);
                response.put("message", "Create grade successful");
                return response;
            case "update":
                Grade updateGrade = new Grade.Builder()
                        .gradeId((Integer) params.get("gradeId"))
                        .groupProjectId((Integer) params.get("groupProjectId"))
                        .teacherId((Integer) params.get("teacherId"))
                        .score((Integer) params.get("score"))
                        .comment((String) params.get("comment"))
                        .createdate(new Date())
                        .build();
                gradeService.update(updateGrade);
                response.put("message", "Update grade successful");
                return response;
            case "delete":
                gradeService.delete((Integer) params.get("id"));
                response.put("message", "Delete grade successful");
                return response;
            case "getDetails":
                return gradeService.getDetails((Integer) params.get("id"));
            case "getAllDetails":
                return gradeService.getAllDetails();
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }
}
