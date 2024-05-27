package com.gui.ydd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gui.ydd.entity.GroupProject;
import com.gui.ydd.entity.GroupProjectDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GroupProjectMapper extends BaseMapper<GroupProject> {
    GroupProjectDetails selectDetailsById(@Param("groupProjectId") int groupProjectId);
    List<GroupProjectDetails> selectAllDetails();
}
