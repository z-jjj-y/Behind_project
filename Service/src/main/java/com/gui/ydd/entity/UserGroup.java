package com.gui.ydd.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(description = "用户小组数据")
@TableName("user_groups")
public class UserGroup {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "小组ID")
    @TableId(value = "group_id",type= IdType.AUTO)
    private Integer groupId;

    @ApiModelProperty(value = "小组名称")
    @TableField("group_name")
    private String groupName;

    @ApiModelProperty(value = "描述")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "用户ID")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty(value = "角色")
    @TableField("role")
    private String role;

    @ApiModelProperty(value = "创建日期")
    @TableField("createdate")
    private Date createdate;

    private UserGroup(Builder builder) {
        groupId = builder.groupId;
        groupName = builder.groupName;
        description = builder.description;
        userId = builder.userId;
        role = builder.role;
        createdate = builder.createdate;
    }

    // 建造者模式
    public static class Builder {
        private Integer groupId;
        private String groupName;
        private String description;
        private Integer userId;
        private String role;
        private Date createdate;

        public Builder groupId(Integer groupId) {
            this.groupId = groupId;
            return this;
        }

        public Builder groupName(String groupName) {
            this.groupName = groupName;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        public Builder createdate(Date createdate) {
            this.createdate = createdate;
            return this;
        }

        public UserGroup build() {
            return new UserGroup(this);
        }
    }
}
