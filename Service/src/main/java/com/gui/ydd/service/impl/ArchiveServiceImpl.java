package com.gui.ydd.service.impl;

import com.gui.ydd.entity.Archive;
import com.gui.ydd.entity.ArchiveDetails;
import com.gui.ydd.mapper.ArchiveMapper;
import com.gui.ydd.service.ArchiveService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArchiveServiceImpl extends BaseServiceImpl<ArchiveMapper, Archive,ArchiveDetails> implements ArchiveService {

        @Override
        public ArchiveDetails getDetails(int id) {
            return baseMapper.selectDetailsById(id);
        }

        @Override
        public List<ArchiveDetails> getAllDetails() {
            return baseMapper.selectAllDetails();
        }
}
