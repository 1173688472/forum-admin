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
    private Long ID;

    /** 用户名 */
    private String userName;

    /** 账户 */
    private String userAccount;

    /** 头像 */
    private String avatarUrl;

    /** 性别 */
    private String gender;

    /** 密码 */
    private String userPassword;

    /** 手机号 */
    private String phone;

    /** 邮箱 */
    private String email;

    /** 状态 1  - 正常  0 - 被封 */
    private String userStatus;

    /** 创建时间 */
    private Date createTime;

    /** 更改时间 */
    private Date updateTime;

    /** 是否删除(逻辑删除)1-存在 0-删除 */
    private Long isDelete;

    /** 用户角色 0 - 普通用户 1 - 管理员 */
    private String userRole;

}
