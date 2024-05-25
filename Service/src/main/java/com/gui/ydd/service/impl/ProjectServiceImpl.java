package com.gui.ydd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gui.ydd.entity.ProjectDetails;
import com.gui.ydd.mapper.ProjectMapper;
import com.gui.ydd.entity.Project;
import com.gui.ydd.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {
    @Override
    public List<Project> getAllProjects() {
        return list();
    }

    @Override
    public Project getProjectById(int projectId) {
        return lambdaQuery().eq(Project::getProjectId, projectId).one();
    }

    @Override
    public void createProject(Project project) {
        boolean insertResult = save(project);
        if (!insertResult) {
            throw new RuntimeException("Failed to insert project record");
        }else{
            System.out.println("Successfully inserted project record");
        }
    }

    @Override
    public void updateProject(Project project) {
        boolean updateResult = updateById(project);
        if (!updateResult) {
            throw new RuntimeException("Failed to update project record");
        }else{
            System.out.println("Successfully updated project record");
        }
    }

    @Override
    public void deleteProject(int projectId) {
        boolean deleteResult = removeById(projectId);
        if (!deleteResult) {
            throw new RuntimeException("Failed to delete project record");
        }else{
            System.out.println("Successfully deleted project record");
        }
    }

    @Override
    public ProjectDetails getDetails(int projectId) {
        return getBaseMapper().selectProjectDetails(projectId);
    }
}
