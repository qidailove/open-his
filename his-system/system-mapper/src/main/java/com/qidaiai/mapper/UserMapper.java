package com.qidaiai.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qidaiai.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

//    User selectOne(QueryWrapper<User> queryWrapper);
    User selectOne(String phone);

    User selectById(Long userId);
}