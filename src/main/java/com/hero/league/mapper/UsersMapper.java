package com.hero.league.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hero.league.entity.Users;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: shayu
 * @date: 2022/10/15
 * @ClassName: forum-admin
 * @Description:
 */
@Mapper
public interface UsersMapper extends BaseMapper<Users> {

    List<Users> list();
    Users selectByNamePass(String userAccount,String userPassword);
}
