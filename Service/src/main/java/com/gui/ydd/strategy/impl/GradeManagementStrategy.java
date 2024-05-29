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
        switch (operation) {
            case "getAll":
                return getAll(gradeService);
            case "getById":
                return getById(gradeService, params);
            case "create":
                return create(gradeService, params);
            case "update":
                return update(gradeService, params);
            case "delete":
                return delete(gradeService, params);
            case "getDetails":
                return getDetails(gradeService, params);
            case "getAllDetails":
                return getAllDetails(gradeService);
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }

    private Object getAll(GradeService gradeService) {
        return gradeService.getAll();
    }

    private Object getById(GradeService gradeService, Map<String, Object> params) {
        return gradeService.getById((Integer) params.get("id"));
    }

    private Object create(GradeService gradeService, Map<String, Object> params) {
        Grade grade = new Grade.Builder()
                .groupProjectId((Integer) params.get("groupProjectId"))
                .teacherId((Integer) params.get("teacherId"))
                .score((Integer) params.get("score"))
                .comment((String) params.get("comment"))
                .createdate(new Date())
                .build();
        gradeService.create(grade);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Create grade successful");
        return response;
    }

    private Object update(GradeService gradeService, Map<String, Object> params) {
        Grade updateGrade = new Grade.Builder()
                .gradeId((Integer) params.get("gradeId"))
                .groupProjectId((Integer) params.get("groupProjectId"))
                .teacherId((Integer) params.get("teacherId"))
                .score((Integer) params.get("score"))
                .comment((String) params.get("comment"))
                .createdate(new Date())
                .build();
        gradeService.update(updateGrade);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Update grade successful");
        return response;
    }

    private Object delete(GradeService gradeService, Map<String, Object> params) {
        gradeService.delete((Integer) params.get("id"));
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Delete grade successful");
        return response;
    }

    private Object getDetails(GradeService gradeService, Map<String, Object> params) {
        return gradeService.getDetails((Integer) params.get("id"));
    }

    private Object getAllDetails(GradeService gradeService) {
        return gradeService.getAllDetails();
    }
}
