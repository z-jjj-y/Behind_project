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
@ApiModel(description = "项目评价数据")
@TableName("reviews")
public class Review {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评价ID")
    @TableId(value = "review_id",type = IdType.AUTO)
    private Integer reviewId;

    @ApiModelProperty(value = "评价人ID")
    @TableField("reviewer_id")
    private Integer reviewerId;

    @ApiModelProperty(value = "组项目ID")
    @TableField("group_project_id")
    private Integer groupProjectId;

    @ApiModelProperty(value = "得分")
    @TableField("score")
    private Integer score;

    @ApiModelProperty(value = "评论")
    @TableField("comment")
    private String comment;

    @ApiModelProperty(value = "创建日期")
    @TableField("createdate")
    private Date createdate;

    private Review(Builder builder) {
        reviewId = builder.reviewId;
        reviewerId = builder.reviewerId;
        groupProjectId = builder.groupProjectId;
        score = builder.score;
        comment = builder.comment;
        createdate = builder.createdate;
    }

    // 建造者模式
    public static class Builder {
        private Integer reviewId;
        private Integer reviewerId;
        private Integer groupProjectId;
        private Integer score;
        private String comment;
        private Date createdate;

        public Builder reviewId(Integer reviewId) {
            this.reviewId = reviewId;
            return this;
        }

        public Builder reviewerId(Integer reviewerId) {
            this.reviewerId = reviewerId;
            return this;
        }

        public Builder groupProjectId(Integer groupProjectId) {
            this.groupProjectId = groupProjectId;
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

        public Review build() {
            return new Review(this);
        }
    }
}
