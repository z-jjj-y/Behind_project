package com.gui.ydd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gui.ydd.entity.ProjectDetails;
import com.gui.ydd.mapper.ProjectMapper;
import com.gui.ydd.entity.Project;
import com.gui.ydd.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl extends BaseServiceImpl<ProjectMapper, Project> implements ProjectService {

    @Override
    public ProjectDetails getDetails(int projectId) {
        return getBaseMapper().selectDetailsById(projectId);
    }
}
