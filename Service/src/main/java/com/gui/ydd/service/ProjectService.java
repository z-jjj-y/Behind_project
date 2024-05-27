package com.gui.ydd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gui.ydd.entity.Project;
import com.gui.ydd.entity.ProjectDetails;

import java.util.List;

public interface ProjectService extends BaseService<Project> {
    ProjectDetails getDetails(int projectId);
}
