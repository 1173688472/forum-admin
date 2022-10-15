package com.hero.league.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Users)实体类
 *
 * @author makejava
 * @since 2022-10-15 13:38:56
 */
@Data
@TableName(value ="users")
public class Users implements Serializable {
    private static final long serialVersionUID = -75017671859714107L;
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 账户
     */
    private String useraccount;
    /**
     * 头像
     */
    private String avatarurl;
    /**
     * 性别
     */
    private String gender;
    /**
     * 密码
     */
    private String userpassword;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 状态 0 - 正常  1  - 被封
     */
    private String userstatus;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 更改时间
     */
    private Date updatetime;
    /**
     * 是否删除(逻辑删除)
     */
    private Integer isdelete;
    /**
     * 用户角色 0 - 普通用户 1 - 管理员
     */
    private String userrole;

}

