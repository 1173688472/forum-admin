package com.hero.league.controller;


import com.hero.league.bo.UserLoginRequestBo;
import com.hero.league.constant.BaseResponse;
import com.hero.league.constant.CodeEnums;
import com.hero.league.constant.ResultUtils;
import com.hero.league.entity.Users;
import com.hero.league.exception.BusinessException;
import com.hero.league.mapper.UsersMapper;
import com.hero.league.serivce.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: shayu
 * @date: 2022/10/14 10:34
 * @ClassName: SwaggerConfig
 * @Description:        用户登录注册
 */
@RestController
@Api(value = "用户登录注册")
@RequestMapping("/user")
@Slf4j
public class UserController {


    @Autowired
    private UsersService usersService;

    /**
     *  登录
     * @param userLoginRequest
     * @param request
     * @return
     */
    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public BaseResponse<Users> userLogin(@RequestBody UserLoginRequestBo userLoginRequest , HttpServletRequest request) {

        if (userLoginRequest == null) {
            throw  new BusinessException(CodeEnums.NULL_ERROR);
        }
        String userAccount = userLoginRequest.getUserAccount();
        String userPassword = userLoginRequest.getUserPassword();
        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            return ResultUtils.error(CodeEnums.PARAMS_ERROR);
        }
        Users user = usersService.userLogin(userAccount, userPassword, request);
        return ResultUtils.success(user);
    }

    @Autowired
    UsersMapper usersMapper;
    @ApiOperation(value = "查询用户")
    @PostMapping("/list")
    public List<Users> userList() {
        return usersMapper.list();
    }
}
