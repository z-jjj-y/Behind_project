package com.gui.ydd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gui.ydd.entity.UserGroupDetails;
import com.gui.ydd.mapper.UserGroupMapper;
import com.gui.ydd.entity.UserGroup;
import com.gui.ydd.service.UserGroupService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGroupServiceImpl extends BaseServiceImpl<UserGroupMapper, UserGroup> implements UserGroupService {
    @Override
    public UserGroupDetails getDetails(int groupId) {
        return getBaseMapper().selectDetailsById(groupId);
    }
}
