package com.hero.league.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 对象 users
 *
 * @author shayu
 * @date 2022-10-17
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("users")
public class Users implements Serializable {

private static final long serialVersionUID=1L;


    /** 主键ID */
    @TableId(value = "id")
    private Long id;

    /** 用户名 */
    @TableField(value="user_name")
    private String userName;

    /** 账户 */
    @TableField(value="user_account")
    private String userAccount;

    /** 头像 */
    @TableField(value="avatar_url")
    private String avatarUrl;

    /** 性别 */
    @TableField(value="gender")
    private Integer gender;

    /** 密码 */
    @TableField(value="user_password")
    private String userPassword;

    /** 手机号 */
    @TableField(value="phone")
    private String phone;

    /** 邮箱 */
    @TableField(value="email")
    private String email;

    /** 状态 1  - 正常  0 - 被封 */
    @TableField(value="user_status")
    private Integer userStatus;

    /** 创建时间 */
    @TableField(value="create_time")
    private Date createTime;

    /** 更改时间 */
    @TableField(value="update_time")
    private Date updateTime;

    /** 是否删除(逻辑删除)1-存在 0-删除 */
    @TableField(value="is_delete")
    private Integer isDelete;
}
