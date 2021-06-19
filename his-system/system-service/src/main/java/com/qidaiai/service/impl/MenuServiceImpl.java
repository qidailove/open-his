package com.qidaiai.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qidaiai.hiscommons.constants.Constants;
import com.qidaiai.hiscommons.domain.SimpleUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.qidaiai.domain.Menu;
import com.qidaiai.mapper.MenuMapper;
import com.qidaiai.service.MenuService;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> selectMenuTree(boolean isAdmin, SimpleUser simpleUser) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(Menu.COL_STATUS, Constants.STATUS_TRUE);
        queryWrapper.in(Menu.COL_MENU_TYPE,Constants.MENU_TYPE_M,Constants.MENU_TYPE_C);
        queryWrapper.orderByDesc(Menu.COL_PARENT_ID);
        if (isAdmin){
            return menuMapper.selectList(queryWrapper);
        }else {
            return menuMapper.selectList(queryWrapper);
        }
    }
}

