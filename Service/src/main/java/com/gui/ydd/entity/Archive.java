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
@ApiModel(description = "项目归档数据")
@TableName("archives")
public class Archive {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "归档ID")
    @TableId(value = "archive_id", type = IdType.AUTO)
    private Integer archiveId;

    @ApiModelProperty(value = "组项目ID")
    @TableField("group_project_id")
    private Integer groupProjectId;

    @ApiModelProperty(value = "最终得分")
    @TableField("final_score")
    private Integer finalScore;

    @ApiModelProperty(value = "评级")
    @TableField("rating")
    private String rating;

    @ApiModelProperty(value = "归档时间")
    @TableField("createdate")
    private Date createdate;

    private Archive(Builder builder) {
        archiveId = builder.archiveId;
        groupProjectId = builder.groupProjectId;
        finalScore = builder.finalScore;
        rating = builder.rating;
        createdate = builder.createdate;
    }

    // 建造者模式
    public static class Builder {
        private Integer archiveId;
        private Integer groupProjectId;
        private Integer finalScore;
        private String rating;
        private Date createdate;

        public Builder archiveId(Integer archiveId) {
            this.archiveId = archiveId;
            return this;
        }

        public Builder groupProjectId(Integer groupProjectId) {
            this.groupProjectId = groupProjectId;
            return this;
        }

        public Builder finalScore(Integer finalScore) {
            this.finalScore = finalScore;
            return this;
        }

        public Builder rating(String rating) {
            this.rating = rating;
            return this;
        }

        public Builder archivedAt(Date archivedAt) {
            this.createdate = archivedAt;
            return this;
        }

        public Archive build() {
            return new Archive(this);
        }
    }
}
