package com.qidaiai.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qidaiai.domain.User;
import com.qidaiai.mapper.UserMapper;
import com.qidaiai.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserByPhone(String phone) {

//        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
//        queryWrapper.eq(User.COL_PHONE,phone);
        User user = this.userMapper.selectOne(phone);
        return user;
    }

    @Override
    public User getOne(Long userId) {
        return this.userMapper.selectById(userId);
    }
}

