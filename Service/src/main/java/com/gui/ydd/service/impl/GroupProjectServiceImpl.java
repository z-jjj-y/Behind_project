package com.gui.ydd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gui.ydd.entity.GroupProjectDetails;
import com.gui.ydd.mapper.GroupProjectMapper;
import com.gui.ydd.entity.GroupProject;
import com.gui.ydd.service.GroupProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupProjectServiceImpl extends BaseServiceImpl<GroupProjectMapper, GroupProject> implements GroupProjectService{

    @Override
    public GroupProjectDetails getDetails(int groupProjectId) {
        return getBaseMapper().selectDetailsById(groupProjectId);
    }
}
