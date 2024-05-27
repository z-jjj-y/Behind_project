package com.gui.ydd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gui.ydd.entity.UserGroup;
import com.gui.ydd.entity.UserGroupDetails;

import java.util.List;

public interface UserGroupService extends BaseService<UserGroup,UserGroupDetails> {
    UserGroupDetails getDetails(int groupId);
}
