package com.gui.ydd.strategy.impl;

import com.gui.ydd.factory.ServiceFactory;
import com.gui.ydd.entity.Archive;
import com.gui.ydd.service.ArchiveService;
import com.gui.ydd.strategy.ManagementStrategy;
import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component("archive")
public class ArchiveStrategy implements ManagementStrategy<Archive> {

    @Autowired
    private ServiceFactory serviceFactory;

    @Override
    public Object execute(String operation, Map<String, Object> params) {
        ArchiveService archiveService = serviceFactory.createArchiveService();
        switch (operation) {
            case "getAll":
                return getAll(archiveService);
            case "getById":
                return getById(archiveService, params);
            case "create":
                return create(archiveService, params);
            case "update":
                return update(archiveService, params);
            case "delete":
                return delete(archiveService, params);
            case "getDetails":
                return getDetails(archiveService, params);
            case "getAllDetails":
                return getAllDetails(archiveService);
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }

    private Object getAll(ArchiveService archiveService) {
        return archiveService.getAll();
    }

    private Object getById(ArchiveService archiveService, Map<String, Object> params) {
        return archiveService.getById((Integer) params.get("id"));
    }

    private Object create(ArchiveService archiveService, Map<String, Object> params) {
        Archive archive = new Archive.Builder()
                .finalScore((Integer) params.get("finalScore"))
                .archivedAt(new Date())
                .groupProjectId((Integer) params.get("groupProjectId"))
                .rating((String) params.get("rating"))
                .build();
        archiveService.create(archive);
        Map<String, Object> response = new HashedMap<>();
        response.put("message", "Create archive successful");
        return response;
    }

    private Object update(ArchiveService archiveService, Map<String, Object> params) {
        Archive updateArchive = new Archive.Builder()
                .archiveId((Integer) params.get("archiveId"))
                .finalScore((Integer) params.get("finalScore"))
                .archivedAt(new Date())
                .groupProjectId((Integer) params.get("groupProjectId"))
                .rating((String) params.get("rating"))
                .build();
        archiveService.update(updateArchive);
        Map<String, Object> response = new HashedMap<>();
        response.put("message", "Update archive successful");
        return response;
    }

    private Object delete(ArchiveService archiveService, Map<String, Object> params) {
        archiveService.delete((Integer) params.get("id"));
        Map<String, Object> response = new HashedMap<>();
        response.put("message", "Delete archive successful");
        return response;
    }

    private Object getDetails(ArchiveService archiveService, Map<String, Object> params) {
        return archiveService.getDetails((Integer) params.get("id"));
    }

    private Object getAllDetails(ArchiveService archiveService) {
        return archiveService.getAllDetails();
    }
}
