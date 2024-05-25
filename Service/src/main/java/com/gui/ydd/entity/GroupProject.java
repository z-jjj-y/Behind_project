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
@ApiModel(description = "组项目数据")
@TableName("group_projects")
public class GroupProject {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "组项目ID")
    @TableId( value = "group_project_id", type = IdType.AUTO)
    private Integer groupProjectId;

    @ApiModelProperty(value = "小组ID")
    @TableField("group_id")
    private Integer groupId;

    @ApiModelProperty(value = "项目ID")
    @TableField("project_id")
    private Integer projectId;

    @ApiModelProperty(value = "状态")
    @TableField("status")
    private String status;

    @ApiModelProperty(value = "创建日期")
    @TableField("createdate")
    private Date createdate;

    private GroupProject(Builder builder) {
        groupProjectId = builder.groupProjectId;
        groupId = builder.groupId;
        projectId = builder.projectId;
        status = builder.status;
        createdate = builder.createdate;
    }

    // 建造者模式
    public static class Builder {
        private Integer groupProjectId;
        private Integer groupId;
        private Integer projectId;
        private String status;
        private Date createdate;

        public Builder groupProjectId(Integer groupProjectId) {
            this.groupProjectId = groupProjectId;
            return this;
        }

        public Builder groupId(Integer groupId) {
            this.groupId = groupId;
            return this;
        }

        public Builder projectId(Integer projectId) {
            this.projectId = projectId;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder createdate(Date createdate) {
            this.createdate = createdate;
            return this;
        }

        public GroupProject build() {
            return new GroupProject(this);
        }
    }
}
