package com.hero.league.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (Users)实体类
 *
 * @author makejava
 * @since 2022-11-01 21:40:10
 */
@Data
public class Users implements Serializable {
    @TableField(exist = false)
    private static final long serialVersionUID = 932978660703555339L;
    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 账户
     */
    private String userAccount;
    /**
     * 头像
     */
    private String avatarUrl;
    /**
     * 性别: 0-女；1-男；2-未知
     */
    private Integer gender;
    /**
     * 密码
     */
    private String userPassword;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 状态 1  - 正常  0 - 被封
     */
    private Integer userStatus;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更改时间
     */
    private Date updateTime;
    /**
     * 是否删除(逻辑删除)1-存在 0-删除
     */
    @TableLogic
    private Integer isDelete;

}

