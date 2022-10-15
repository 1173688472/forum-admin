package com.hero.league.serivce.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hero.league.entity.Users;
import com.hero.league.mapper.UsersMapper;
import com.hero.league.serivce.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.hero.league.constant.UserConstant.USER_LOGIN_STATE;


/**
 * @author: shayu
 * @date: 2022/10/15
 * @ClassName: forum-admin
 * @Description: 用户服务实现类
 */
@Service
@Slf4j
public class UsersServiceImpl  extends ServiceImpl<UsersMapper, Users> implements UsersService {

    @Autowired
    private UsersMapper usersMapper;
    /**
     * 盐值，混淆密码
     */
    private static final String SALT = "zhujiu";

    @Override
    public Users userLogin(String userAccount, String userPassword, HttpServletRequest request) {
        // 1. 校验
        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            return null;
        }
        if (userAccount.length() < 4) {
            return null;
        }
        if (userPassword.length() < 8) {
            return null;
        }
        // 账户不能包含特殊字符
        String validPattern = "[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Matcher matcher = Pattern.compile(validPattern).matcher(userAccount);
        if (matcher.find()) {
            return null;
        }
        // 2. 加密
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
        // 查询用户是否存在
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount", userAccount);
        queryWrapper.eq("userPassword", encryptPassword);
        Users user = usersMapper.selectOne(queryWrapper);
        // 用户不存在
        if (user == null) {
            log.info("user login failed, userAccount cannot match userPassword");
            return null;
        }
        // 3. 用户脱敏  todo:没有写好
//        Users safetyUser = getSafetyUser(user);
        // 4. 记录用户的登录态
        request.getSession().setAttribute(USER_LOGIN_STATE,user);
        return user;
    }



    @Override
    public Users getSafetyUser(Users originUser) {
//        if (originUser == null) {
//            return null;
//        }
//        Users safetyUser = new Users();
//        safetyUser.setId(originUser.getId());
//        safetyUser.setUsername(originUser.getUsername());
//        safetyUser.setUserAccount(originUser.getUserAccount());
//        safetyUser.setAvatarUrl(originUser.getAvatarUrl());
//        safetyUser.setGender(originUser.getGender());
//        safetyUser.setPhone(originUser.getPhone());
//        safetyUser.setEmail(originUser.getEmail());
//        safetyUser.setPlanetCode(originUser.getPlanetCode());
//        safetyUser.setUserRole(originUser.getUserRole());
//        safetyUser.setUserStatus(originUser.getUserStatus());
//        safetyUser.setCreateTime(originUser.getCreateTime());
//        return safetyUser;
        return null;
    }
}
