package com.qidaiai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qidaiai.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper {

    List<User> selectListForScheduling(@Param(value = "userId") Long userId, @Param(value = "deptId") Long deptId, @Param(value = "flag") Integer flag);

}