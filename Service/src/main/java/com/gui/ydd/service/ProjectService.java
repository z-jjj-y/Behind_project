package com.gui.ydd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gui.ydd.entity.Project;
import com.gui.ydd.entity.ProjectDetails;

import java.util.List;

public interface ProjectService extends IService<Project> {
    List<Project> getAllProjects();
    Project getProjectById(int projectId);
    void createProject(Project project);
    void updateProject(Project project);
    void deleteProject(int projectId);
    ProjectDetails getDetails(int projectId);
}
