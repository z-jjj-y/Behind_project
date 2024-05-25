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
@ApiModel(description = "用户数据")
@TableName("users")
public class User {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID")
    @TableId(value = "user_id",type= IdType.AUTO)
    private Integer userId;

    @ApiModelProperty(value = "账户")
    @TableField("account")
    private String account;

    @ApiModelProperty(value = "用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty(value = "密码")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "角色")
    @TableField("role")
    private String role;

    @ApiModelProperty(value = "创建日期")
    @TableField("createdate")
    private Date createdate;

    private User(Builder builder) {
        userId = builder.userId;
        account = builder.account;
        username = builder.username;
        password = builder.password;
        role = builder.role;
        createdate = builder.createdate;
    }

    // 建造者模式
    public static class Builder {
        private Integer userId;
        private String account;
        private String username;
        private String password;
        private String role;
        private Date createdate;

        public Builder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Builder account(String account) {
            this.account = account;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
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

        public User build() {
            return new User(this);
        }
    }
}
