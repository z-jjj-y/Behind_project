package com.gui.ydd.factory;

import com.gui.ydd.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ServiceFactoryImpl implements ServiceFactory {

    @Autowired
    private ApplicationContext context;

    @Override
    public ArchiveService createArchiveService() {
        return context.getBean(ArchiveService.class);
    }

    @Override
    public GradeService createGradeService() {
        return context.getBean(GradeService.class);
    }

    @Override
    public GroupProjectService createGroupProjectService() {
        return context.getBean(GroupProjectService.class);
    }

    @Override
    public ProjectService createProjectService() {
        return context.getBean(ProjectService.class);
    }

    @Override
    public ReviewService createReviewService() {
        return context.getBean(ReviewService.class);
    }

    @Override
    public UserGroupService createUserGroupService() {
        return context.getBean(UserGroupService.class);
    }

    @Override
    public UserService createUserService() {
        return context.getBean(UserService.class);
    }
}
