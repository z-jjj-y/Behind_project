package com.gui.ydd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gui.ydd.entity.UserGroup;
import com.gui.ydd.entity.UserGroupDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserGroupMapper extends BaseMapper<UserGroup> {
    UserGroupDetails selectDetailsById(@Param("groupId") int groupId);
    List<UserGroupDetails> selectAllDetails();
    List<UserGroupDetails> selectAllDetailsByName(@Param("groupName") String groupName);
}
