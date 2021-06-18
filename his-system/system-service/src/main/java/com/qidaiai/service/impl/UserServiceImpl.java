package com.qidaiai.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.qidaiai.domain.User;
import com.qidaiai.mapper.UserMapper;
import com.qidaiai.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User queryUserByPhone(String phone) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.eq(User.COL_PHONE,phone);
        User user = this.userMapper.selectOne(queryWrapper);
        return user;
    }

    @Override
    public User getOne(Long userId) {
        return this.userMapper.selectById(userId);
    }
}

