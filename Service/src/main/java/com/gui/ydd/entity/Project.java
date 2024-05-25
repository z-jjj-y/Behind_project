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
@ApiModel(description = "项目数据")
@TableName("projects")
public class Project {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "项目ID")
    @TableId(value = "project_id",type = IdType.AUTO)
    private Integer projectId;

    @ApiModelProperty(value = "项目名称")
    @TableField("project_name")
    private String projectName;

    @ApiModelProperty(value = "描述")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "创建日期")
    @TableField("createdate")
    private Date createdate;

    private Project(Builder builder) {
        projectId = builder.projectId;
        projectName = builder.projectName;
        description = builder.description;
        createdate = builder.createdate;
    }

    // 建造者模式
    public static class Builder {
        private Integer projectId;
        private String projectName;
        private String description;
        private Date createdate;

        public Builder projectId(Integer projectId) {
            this.projectId = projectId;
            return this;
        }

        public Builder projectName(String projectName) {
            this.projectName = projectName;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder createdate(Date createdate) {
            this.createdate = createdate;
            return this;
        }

        public Project build() {
            return new Project(this);
        }
    }
}
