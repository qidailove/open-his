package com.qidaiai.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qidaiai.dto.RoleDto;
import com.qidaiai.hiscommons.constants.Constants;
import com.qidaiai.hiscommons.vo.DataGridView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qidaiai.domain.Role;
import com.qidaiai.mapper.RoleMapper;
import com.qidaiai.service.RoleService;

import java.util.Arrays;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private  RoleMapper roleMapper;

    @Override
    public DataGridView listRolePage(RoleDto roleDto) {
        Page<Role> page=new Page<>(roleDto.getPageNum(), roleDto.getPageSize());
        QueryWrapper<Role> qw=new QueryWrapper<>();
        qw.like(StringUtils.isNotBlank(roleDto.getRoleName()), Role.COL_ROLE_NAME, roleDto.getRoleName());
        qw.like(StringUtils.isNotBlank(roleDto.getRoleCode()), Role.COL_ROLE_CODE, roleDto.getRoleCode());
        qw.eq(StringUtils.isNotBlank(roleDto.getStatus()), Role.COL_STATUS, roleDto.getStatus());
        qw.ge(null!= roleDto.getBeginTime(), Role.COL_CREATE_TIME, roleDto.getBeginTime());
        qw.le(null!= roleDto.getEndTime(), Role.COL_CREATE_TIME, roleDto.getEndTime());
        qw.orderByAsc(Role.COL_ROLE_SORT);
        this.roleMapper.selectPage(page,qw);
        return new DataGridView(page.getTotal(),page.getRecords());
    }

    @Override
    public List<Role> listAllRoles() {
        QueryWrapper<Role> qw=new QueryWrapper<>();
        qw.eq(Role.COL_STATUS, Constants.STATUS_TRUE);
        qw.orderByAsc(Role.COL_ROLE_SORT);
        return this.roleMapper.selectList(qw);
    }

    @Override
    public Role getOne(Long roleId) {
        return this.roleMapper.selectById(roleId);
    }

    @Override
    public int addRole(RoleDto roleDto) {
        Role role =new Role();
        BeanUtil.copyProperties(roleDto,role);
        //设置创建人和创建时间
        role.setCreateBy(roleDto.getSimpleUser().getUserName());
        role.setCreateTime(DateUtil.date());
        return this.roleMapper.insert(role);
    }

    @Override
    public int updateRole(RoleDto roleDto) {
        Role role =new Role();
        BeanUtil.copyProperties(roleDto,role);
        //设置修改人
        role.setUpdateBy(roleDto.getSimpleUser().getUserName());
        return this.roleMapper.updateById(role);
    }

    @Override
    public int deleteRoleByIds(Long[] roleIds) {
        List<Long> ids = Arrays.asList(roleIds);
        Role role =new Role();
        if(null!=roleIds&&roleIds.length>0){
            //还要删除sys_role_menu
            this.roleMapper.deleteRoleMenuByRoleIds(ids);
            //还要删除sys_role_user
            this.roleMapper.deleteRoleUserByRoleIds(ids);
            return this.roleMapper.deleteBatchIds(ids);
        }
        return 0;
    }

}
