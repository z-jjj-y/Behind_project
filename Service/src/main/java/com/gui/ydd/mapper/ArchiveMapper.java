package com.gui.ydd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gui.ydd.entity.Archive;
import com.gui.ydd.entity.ArchiveDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArchiveMapper extends BaseMapper<Archive> {
    ArchiveDetails selectArchiveDetails(@Param("archiveId") int archiveId);
}
