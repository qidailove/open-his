package com.qidaiai.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qidaiai.domain.User;

public interface UserMapper {

    User selectOne(QueryWrapper<User> queryWrapper);

    User selectById(Long userId);
}