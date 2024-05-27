package com.gui.ydd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gui.ydd.entity.GroupProject;
import com.gui.ydd.entity.GroupProjectDetails;

import java.util.List;

public interface GroupProjectService extends BaseService<GroupProject> {
    GroupProjectDetails getDetails(int groupProjectId);
}
