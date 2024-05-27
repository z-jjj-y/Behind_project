package com.gui.ydd.service.impl;

import com.gui.ydd.entity.UserGroup;
import com.gui.ydd.entity.UserGroupDetails;
import com.gui.ydd.mapper.UserGroupMapper;
import com.gui.ydd.service.UserGroupService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserGroupServiceImpl extends BaseServiceImpl<UserGroupMapper, UserGroup,UserGroupDetails> implements UserGroupService {

    @Override
    public UserGroupDetails getDetails(int id) {
        return baseMapper.selectDetailsById(id);
    }

    @Override
    public List<UserGroupDetails> getAllDetails() {
        return baseMapper.selectAllDetails();
    }
}
