package com.gui.ydd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gui.ydd.entity.ArchiveDetails;
import com.gui.ydd.mapper.ArchiveMapper;
import com.gui.ydd.entity.Archive;
import com.gui.ydd.service.ArchiveService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchiveServiceImpl extends ServiceImpl<ArchiveMapper, Archive> implements ArchiveService {
    @Override
    public List<Archive> getAllArchives() {
        return list();
    }

    @Override
    public Archive getArchiveById(int archiveId) {
        return lambdaQuery().eq(Archive::getArchiveId, archiveId).one();
    }

    @Override
    public void createArchive(Archive archive) {
        boolean insertResult = save(archive);
        if (!insertResult) {
            throw new RuntimeException("Failed to insert archive record");
        }else{
            System.out.println("Successfully inserted archive record");
        }
    }

    @Override
    public void updateArchive(Archive archive) {
        boolean updateResult = updateById(archive);
        if (!updateResult) {
            throw new RuntimeException("Failed to update archive record");
        }else{
            System.out.println("Successfully updated archive record");
        }
    }

    @Override
    public void deleteArchive(int archiveId) {
        boolean deleteResult = removeById(archiveId);
        if (!deleteResult) {
            throw new RuntimeException("Failed to delete archive record");
        }else{
            System.out.println("Successfully deleted archive record");
        }
    }

    @Override
    public ArchiveDetails getDetails(int archiveId) {
        return getBaseMapper().selectArchiveDetails(archiveId);
    }
}
