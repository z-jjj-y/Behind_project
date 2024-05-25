package com.gui.ydd.entity;

import lombok.Data;

@Data
public class ReviewDetails {
    private int reviewId;
    private int score;
    private String comment;
    private String createdate;
    private String reviewerName;
    private int groupId;
    private int projectId;
}
