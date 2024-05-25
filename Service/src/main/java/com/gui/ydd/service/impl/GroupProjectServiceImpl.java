package com.gui.ydd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gui.ydd.entity.GroupProjectDetails;
import com.gui.ydd.mapper.GroupProjectMapper;
import com.gui.ydd.entity.GroupProject;
import com.gui.ydd.service.GroupProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupProjectServiceImpl extends ServiceImpl<GroupProjectMapper, GroupProject> implements GroupProjectService{
    @Override
    public List<GroupProject> getAllGroupProjects() {
        return list();
    }

    @Override
    public GroupProject getGroupProjectById(int groupProjectId) {
        return lambdaQuery().eq(GroupProject::getGroupProjectId, groupProjectId).one();
    }

    @Override
    public void createGroupProject(GroupProject groupProject) {
        boolean insertResult = save(groupProject);
        if (!insertResult) {
            throw new RuntimeException("Failed to insert group project record");
        }else{
            System.out.println("Successfully inserted group project record");
        }
    }

    @Override
    public void updateGroupProject(GroupProject groupProject) {
        boolean updateResult = updateById(groupProject);
        if (!updateResult) {
            throw new RuntimeException("Failed to update group project record");
        }else{
            System.out.println("Successfully updated group project record");
        }
    }

    @Override
    public void deleteGroupProject(int groupProjectId) {
        boolean deleteResult = removeById(groupProjectId);
        if (!deleteResult) {
            throw new RuntimeException("Failed to delete group project record");
        }else{
            System.out.println("Successfully deleted group project record");
        }
    }

    @Override
    public GroupProjectDetails getDetails(int groupProjectId) {
        return getBaseMapper().selectGroupProjectDetails(groupProjectId);
    }
}
