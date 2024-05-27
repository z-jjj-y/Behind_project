package com.gui.ydd.service.impl;

import com.gui.ydd.entity.Archive;
import com.gui.ydd.entity.ArchiveDetails;
import com.gui.ydd.mapper.ArchiveMapper;
import com.gui.ydd.service.ArchiveService;
import org.springframework.stereotype.Service;


@Service
public class ArchiveServiceImpl extends BaseServiceImpl<ArchiveMapper, Archive> implements ArchiveService {
    @Override
    public ArchiveDetails getDetails(int archiveId) {
        return getBaseMapper().selectDetailsById(archiveId);
    }
}
