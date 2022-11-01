package com.hero.league.controller;


import com.hero.league.entity.Users;
import com.hero.league.mapper.UsersMapper;
import com.hero.league.serivce.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: wenjx
 * @date: 2022/10/14 10:34
 * @ClassName: SwaggerConfig
 * @Description:        用户登录之后的操作
 */
@RestController
@Api(value = "用户登录之后的操作")
@RequestMapping("/operate")
@Slf4j
public class OperateController {

    @Autowired
    private UsersService usersService;


    @Autowired
    UsersMapper usersMapper;
    @ApiOperation(value = "查询用户")
    @PostMapping("/list")
    public List<Users> userList() {
        return usersMapper.list();
    }

}
