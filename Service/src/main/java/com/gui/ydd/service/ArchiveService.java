package com.gui.ydd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gui.ydd.entity.Archive;
import com.gui.ydd.entity.ArchiveDetails;

import java.util.List;

public interface ArchiveService extends IService<Archive> {
    List<Archive> getAllArchives();
    Archive getArchiveById(int archiveId);
    void createArchive(Archive archive);
    void updateArchive(Archive archive);
    void deleteArchive(int archiveId);
    ArchiveDetails getDetails(int archiveId);


}
