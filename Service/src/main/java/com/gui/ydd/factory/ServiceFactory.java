package com.gui.ydd.factory;

import com.gui.ydd.service.*;

public interface ServiceFactory {
    ArchiveService createArchiveService();
    GradeService createGradeService();
    GroupProjectService createGroupProjectService();
    ProjectService createProjectService();
    ReviewService createReviewService();
    UserGroupService createUserGroupService();
    UserService createUserService();
}
