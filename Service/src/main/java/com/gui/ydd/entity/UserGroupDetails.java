package com.gui.ydd.entity;

import lombok.Data;

@Data
public class UserGroupDetails {
    private int groupId;
    private String groupName;
    private String description;
    private String leaderName;
    private String createdate;
}
