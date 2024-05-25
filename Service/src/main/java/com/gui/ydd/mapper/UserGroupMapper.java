package com.gui.ydd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gui.ydd.entity.UserGroup;
import com.gui.ydd.entity.UserGroupDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserGroupMapper extends BaseMapper<UserGroup> {
    UserGroupDetails selectUserGroupDetails(@Param("groupId") int groupId);
}
