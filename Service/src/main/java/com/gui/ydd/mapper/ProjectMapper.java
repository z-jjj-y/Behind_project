package com.gui.ydd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gui.ydd.entity.Project;
import com.gui.ydd.entity.ProjectDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProjectMapper extends BaseMapper<Project> {
    ProjectDetails selectDetailsById(@Param("projectId") int projectId);
}
