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
        Map<String, Object> response = new HashedMap<>();
        switch (operation) {
            case "getAll":
                return archiveService.getAllArchives();
            case "getById":
                return archiveService.getArchiveById((Integer) params.get("id"));
            case "create":
                Archive archive = new Archive.Builder()
                        .finalScore((Integer) params.get("finalScore"))
                        .archivedAt(new Date())
                        .groupProjectId((Integer) params.get("groupProjectId"))
                        .rating((String) params.get("rating"))
                        .build();
                archiveService.createArchive(archive);
                response.put("message", "Create archive successful");
                return response;
            case "update":
                Archive updateArchive = new Archive.Builder()
                        .archiveId((Integer) params.get("archiveId"))
                        .finalScore((Integer) params.get("finalScore"))
                        .archivedAt(new Date())
                        .groupProjectId((Integer) params.get("groupProjectId"))
                        .rating((String) params.get("rating"))
                        .build();
                archiveService.updateArchive(updateArchive);
                response.put("message", "Update archive successful");
                return response;
            case "delete":
                archiveService.deleteArchive((Integer) params.get("id"));
                response.put("message", "Delete archive successful");
                return response;
            case "getDetails":
                return archiveService.getDetails((Integer) params.get("id"));
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }
}
