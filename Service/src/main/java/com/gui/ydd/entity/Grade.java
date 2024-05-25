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
@ApiModel(description = "成绩数据")
@TableName("grades")
public class Grade {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "成绩ID")
    @TableId(value = "grade_id",type = IdType.AUTO)
    private Integer gradeId;

    @ApiModelProperty(value = "组项目ID")
    @TableField("group_project_id")
    private Integer groupProjectId;

    @ApiModelProperty(value = "教师ID")
    @TableField("teacher_id")
    private Integer teacherId;

    @ApiModelProperty(value = "得分")
    @TableField("score")
    private Integer score;

    @ApiModelProperty(value = "评论")
    @TableField("comment")
    private String comment;

    @ApiModelProperty(value = "创建日期")
    @TableField("createdate")
    private Date createdate;

    private Grade(Builder builder) {
        gradeId = builder.gradeId;
        groupProjectId = builder.groupProjectId;
        teacherId = builder.teacherId;
        score = builder.score;
        comment = builder.comment;
        createdate = builder.createdate;
    }

    // 建造者模式
    public static class Builder {
        private Integer gradeId;
        private Integer groupProjectId;
        private Integer teacherId;
        private Integer score;
        private String comment;
        private Date createdate;

        public Builder gradeId(Integer gradeId) {
            this.gradeId = gradeId;
            return this;
        }

        public Builder groupProjectId(Integer groupProjectId) {
            this.groupProjectId = groupProjectId;
            return this;
        }

        public Builder teacherId(Integer teacherId) {
            this.teacherId = teacherId;
            return this;
        }

        public Builder score(Integer score) {
            this.score = score;
            return this;
        }

        public Builder comment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder createdate(Date createdate) {
            this.createdate = createdate;
            return this;
        }

        public Grade build() {
            return new Grade(this);
        }
    }
}
