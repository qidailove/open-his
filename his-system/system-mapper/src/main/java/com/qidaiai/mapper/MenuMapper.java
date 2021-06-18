package com.qidaiai.mapper;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qidaiai.domain.Menu;

import java.util.List;

public interface MenuMapper {

    List<Menu> selectList(QueryWrapper<Menu> queryWrapper);

}