package com.gui.ydd.service;

import com.gui.ydd.entity.UserGroup;
import com.gui.ydd.entity.UserGroupDetails;

import java.util.List;


public interface UserGroupService extends BaseService<UserGroup,UserGroupDetails> {
    List<UserGroupDetails> getAllDetailsByName(String groupName);
}
