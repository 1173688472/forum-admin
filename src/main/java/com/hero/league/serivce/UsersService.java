package com.hero.league.serivce;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hero.league.entity.Users;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: shayu
 * @date: 2022/10/15
 * @ClassName: forum-admin
 * @Description: 用户服务
 */
public interface UsersService extends IService<Users> {

    /**
     *  用户登录
     * @param userAccount
     * @param userPassword
     * @param request
     * @return  脱敏后的用户信息
     */
    Users userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     *
     * @param originUser
     * @return
     */
    Users getSafetyUser(Users originUser);


}
