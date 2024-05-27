package com.gui.ydd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gui.ydd.entity.Grade;
import com.gui.ydd.entity.GradeDetails;

import java.util.List;

public interface GradeService extends BaseService<Grade> {
    GradeDetails getDetails(int gradeId);
}
