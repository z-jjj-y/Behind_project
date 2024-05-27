package com.gui.ydd.service.impl;

import com.gui.ydd.entity.Project;
import com.gui.ydd.entity.ProjectDetails;
import com.gui.ydd.mapper.ProjectMapper;
import com.gui.ydd.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl extends BaseServiceImpl<ProjectMapper, Project, ProjectDetails> implements ProjectService {

        @Override
        public ProjectDetails getDetails(int id) {
            return baseMapper.selectDetailsById(id);
        }

        @Override
        public List<ProjectDetails> getAllDetails() {
            return baseMapper.selectAllDetails();
        }
}
