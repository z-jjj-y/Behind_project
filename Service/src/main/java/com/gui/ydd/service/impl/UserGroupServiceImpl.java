package com.gui.ydd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gui.ydd.entity.UserGroupDetails;
import com.gui.ydd.mapper.UserGroupMapper;
import com.gui.ydd.entity.UserGroup;
import com.gui.ydd.service.UserGroupService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGroupServiceImpl extends ServiceImpl<UserGroupMapper, UserGroup> implements UserGroupService {
    @Override
    public List<UserGroup> getAllUserGroups() {
        return list();
    }

    @Override
    public UserGroup getUserGroupById(int groupId) {
        return lambdaQuery().eq(UserGroup::getGroupId, groupId).one();
    }

    @Override
    public void createUserGroup(UserGroup userGroup) {
        boolean insertResult = save(userGroup);
        if (!insertResult) {
            throw new RuntimeException("Failed to insert user group record");
        }else{
            System.out.println("Successfully inserted user group record");
        }
    }

    @Override
    public void updateUserGroup(UserGroup userGroup) {
        boolean updateResult = updateById(userGroup);
        if (!updateResult) {
            throw new RuntimeException("Failed to update user group record");
        }else{
            System.out.println("Successfully updated user group record");
        }
    }

    @Override
    public void deleteUserGroup(int groupId) {
        boolean deleteResult = removeById(groupId);
        if (!deleteResult) {
            throw new RuntimeException("Failed to delete user group record");
        }else{
            System.out.println("Successfully deleted user group record");
        }
    }

    @Override
    public UserGroupDetails getDetails(int groupId) {
        return getBaseMapper().selectUserGroupDetails(groupId);
    }
}
