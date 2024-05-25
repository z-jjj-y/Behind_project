package com.gui.ydd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gui.ydd.entity.GroupProject;
import com.gui.ydd.entity.GroupProjectDetails;

import java.util.List;

public interface GroupProjectService extends IService<GroupProject> {
    List<GroupProject> getAllGroupProjects();
    GroupProject getGroupProjectById(int groupProjectId);
    void createGroupProject(GroupProject groupProject);
    void updateGroupProject(GroupProject groupProject);
    void deleteGroupProject(int groupProjectId);
    GroupProjectDetails getDetails(int groupProjectId);
}
