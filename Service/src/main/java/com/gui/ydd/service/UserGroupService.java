package com.gui.ydd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gui.ydd.entity.UserGroup;
import com.gui.ydd.entity.UserGroupDetails;

import java.util.List;

public interface UserGroupService extends IService<UserGroup> {
    List<UserGroup> getAllUserGroups();
    UserGroup getUserGroupById(int groupId);
    void createUserGroup(UserGroup userGroup);
    void updateUserGroup(UserGroup userGroup);
    void deleteUserGroup(int groupId);
    UserGroupDetails getDetails(int groupId);
}
