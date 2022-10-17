package com.hero.league.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 *
 * @author yupi
 */
@Data
public class UserRegisterRequestBo implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    /**
     * 用户名
     */
    private String userName;
    /**
     * 账户
     */
    private String userAccount;
    /**
     * 密码
     */
    private String userPassword;
    /**
     * 重复
     */
    private String checkPassword;


}
