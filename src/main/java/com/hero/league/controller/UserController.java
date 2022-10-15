package com.hero.league.controller;


import com.hero.league.constant.BaseResponse;
import com.hero.league.constant.CodeEnums;
import com.hero.league.constant.ResultUtils;
import com.hero.league.entity.Users;
import com.hero.league.serivce.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: shayu
 * @date: 2022/10/14 10:34
 * @ClassName: SwaggerConfig
 * @Description:        用户登录注册
 */
@Controller
@Api(value = "用户登录注册")
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UsersService usersService;

    /**
     *    登录
     * @param userLoginRequest
     * @param request
     * @return
     */
    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public BaseResponse<Users> userLogin(@RequestBody Users userLoginRequest, HttpServletRequest request) {

        String userAccount = userLoginRequest.getUseraccount();
        String userPassword = userLoginRequest.getUserpassword();
        if (StringUtils.isAnyBlank(userAccount, userPassword)) {
            return ResultUtils.error(CodeEnums.PARAMS_ERROR);
        }
        Users user = usersService.userLogin(userAccount, userPassword, request);
        return ResultUtils.success(user);
    }

//    @PostMapping("/register")
//    public BaseResponse<Long> userRegister(@RequestBody Users userRegisterRequest) {
//        if (userRegisterRequest == null) {
//            throw new BusinessException(CodeEnums.PARAMS_ERROR);
//        }
//        String userAccount = userRegisterRequest.getUseraccount();
//        String userPassword = userRegisterRequest.getUserpassword();
//        String checkPassword = userRegisterRequest.getCheckPassword();
//        String planetCode = userRegisterRequest.getPlanetCode();
//        if (StringUtils.isAnyBlank(userAccount, userPassword, checkPassword, planetCode)) {
//            return null;
//        }
//        long result = userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
//        return ResultUtils.success(result);
//    }
}
