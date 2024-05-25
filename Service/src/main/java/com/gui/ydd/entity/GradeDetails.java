package com.gui.ydd.entity;

import lombok.Data;

@Data
public class GradeDetails {
    private int gradeId;
    private int score;
    private String comment;
    private String createdate;
    private String teacherName;
    private int groupId;
    private int projectId;
}
