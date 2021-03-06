package com.qidaiai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qidaiai.domain.Menu;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 根据菜单ID查询当前菜单的子节点的个数
     *
     * @param menuId
     * @return
     */
    Long queryChildCountByMenuId(@Param("menuId") Long menuId);

    /**
     * 根据角色ID查询所有选中的权限菜单ID【只查子节点的】
     *
     * @param roleId
     * @return
     */
    List<Long> queryMenuIdsByRoleId(@Param("roleId") Long roleId);

    int deleteById(@Param(value = "menuId") Long menuId);

    List<Menu> selectMenuListByUserId(@Param("userId")Serializable userId);

}