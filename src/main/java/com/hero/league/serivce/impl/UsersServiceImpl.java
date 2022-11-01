package com.hero.league.serivce.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hero.league.constant.CodeEnums;
import com.hero.league.entity.Users;
import com.hero.league.exception.BusinessException;
import com.hero.league.mapper.UsersMapper;
import com.hero.league.serivce.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
            throw  new BusinessException(CodeEnums.NULL_ERROR);
        }
        if (userAccount.length() < 4 && userAccount.length() > 16) {
            throw  new BusinessException(CodeEnums.PARAMS_ERROR);
        }
        if (userPassword.length() < 4) {
            throw  new BusinessException(CodeEnums.PARAMS_ERROR);
        }
        // 账户不能包含特殊字符
        String validPattern = "[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Matcher matcher = Pattern.compile(validPattern).matcher(userAccount);
        if (matcher.find()) {
            return null;
        }
        // 2. 解密
//        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
        // 查询用户是否存在
        Users users = usersMapper.selectByNamePass(userAccount, userPassword);
        // 用户不存在
        if (users == null) {
            log.info("user login failed, userAccount cannot match userPassword");
            throw  new BusinessException(CodeEnums.NOT_USERS);
        }
        // 3. 用户脱敏  todo:没有写好
//        Users safetyUser = getSafetyUser(user);
        // 4. 记录用户的登录态
//        request.getSession().setAttribute(USER_LOGIN_STATE,user);
        return users;
    }

    @Override
    public long userRegister(String userAccount, String userPassword, String checkPassword, String userName) {
        // 1. 校验
        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword, userName)) {
            throw new BusinessException(CodeEnums.NULL_ERROR, "参数为空");
        }
        if (userAccount.length() < 4 && userAccount.length() > 16 ) {
            throw new BusinessException(CodeEnums.PARAMS_ERROR, "用户账号长度大于4小于16");
        }
        if (userPassword.length() < 6 && checkPassword.length() > 16) {
            throw new BusinessException(CodeEnums.PARAMS_ERROR, "用户账号长度大于6小于16");
        }
        if (userName.length() < 1 && userName.length() > 16) {
            throw new BusinessException(CodeEnums.PARAMS_ERROR, "用户名长度不为空小于16");
        }
        // 账户不能包含特殊字符
        String validPattern = "[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Matcher matcher = Pattern.compile(validPattern).matcher(userAccount);
        if (matcher.find()) {
            throw new BusinessException(CodeEnums.PARAMS_ERROR);
        }
        // 密码和校验密码相同
        if (!userPassword.equals(checkPassword)) {
            throw new BusinessException(CodeEnums.PARAMS_ERROR);
        }
        // 账户不能重复
        LambdaQueryWrapper<Users> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Users::getUserAccount, userAccount);

        long count = usersMapper.selectCount(queryWrapper);
        if (count > 0) {
            throw new BusinessException(CodeEnums.PARAMS_ERROR, "账号重复");
        }

        // 2. 加密
//        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
        // 3. 插入数据
        Users user = new Users();
        user.setUserAccount(userAccount);
        user.setUserPassword(userPassword);
        user.setUserName(userName);
        user.setUserStatus(1);
        user.setIsDelete(0);
        user.setCreateTime(new Date());
        boolean saveResult = this.save(user);
        if (!saveResult) {
            return -1;
        }
        return user.getId();
    }
}
