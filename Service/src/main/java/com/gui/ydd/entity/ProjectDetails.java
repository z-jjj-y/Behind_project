package com.gui.ydd.entity;

import lombok.Data;

@Data
public class ProjectDetails {
    private int projectId;
    private String projectName;
    private String description;
    private String createdate;
    private int groupProjectId;
    private int groupId;
}
