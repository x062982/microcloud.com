package com.shanezhou.springcloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shanezhou.springcloud.entity.User;
import com.shanezhou.springcloud.dao.UserMapper;
import com.shanezhou.springcloud.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @Author ZhouWX
 * @CreateDate 2020/8/13 星期四
 */
@Service
public class UserServiceImpl implements IUserService {

    private UserMapper mapper;


    @Override
    public User findByName(String name) {
        return mapper.selectOne(new QueryWrapper<User>().eq("NAME", name));
    }
}
