package com.qidaiai.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qidaiai.dto.CheckItemDto;
import com.qidaiai.hiscommons.constants.Constants;
import com.qidaiai.hiscommons.vo.DataGridView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.qidaiai.mapper.CheckItemMapper;
import com.qidaiai.domain.CheckItem;
import com.qidaiai.service.CheckItemService;

import java.util.Arrays;
import java.util.List;

@Service
public class CheckItemServiceImpl implements CheckItemService{

    @Autowired
    private CheckItemMapper checkItemMapper;

    @Override
    public DataGridView listCheckItemPage(CheckItemDto checkItemDto) {
        Page<CheckItem> page=new Page<>(checkItemDto.getPageNum(),checkItemDto.getPageSize());
        QueryWrapper<CheckItem> qw=new QueryWrapper<>();
        qw.like(StringUtils.isNotBlank(checkItemDto.getCheckItemName()),CheckItem.COL_CHECK_ITEM_NAME,checkItemDto.getCheckItemName());
        qw.like(StringUtils.isNotBlank(checkItemDto.getKeywords()),CheckItem.COL_KEYWORDS,checkItemDto.getKeywords());
        qw.eq(StringUtils.isNotBlank(checkItemDto.getTypeId()),CheckItem.COL_TYPE_ID,checkItemDto.getTypeId());
        qw.eq(StringUtils.isNotBlank(checkItemDto.getStatus()),CheckItem.COL_STATUS,checkItemDto.getStatus());
        this.checkItemMapper.selectPage(page,qw);
        return new DataGridView(page.getTotal(),page.getRecords());
    }

    @Override
    public CheckItem getOne(Long checkItemId) {
        return this.checkItemMapper.selectById(checkItemId);
    }

    @Override
    public int addCheckItem(CheckItemDto checkItemDto) {
        CheckItem checkItem=new CheckItem();
        BeanUtil.copyProperties(checkItemDto,checkItem);
        checkItem.setCreateTime(DateUtil.date());
        checkItem.setCreateBy(checkItemDto.getSimpleUser().getUserName());
        return this.checkItemMapper.insert(checkItem);
    }

    @Override
    public int updateCheckItem(CheckItemDto checkItemDto) {
        CheckItem checkItem=new CheckItem();
        BeanUtil.copyProperties(checkItemDto,checkItem);
        checkItem.setUpdateBy(checkItemDto.getSimpleUser().getUserName());
        return this.checkItemMapper.updateById(checkItem);
    }

    @Override
    public int deleteCheckItemByIds(Long[] checkItemIds) {
        List<Long> ids= Arrays.asList(checkItemIds);
        if(ids.size()>0){
            return this.checkItemMapper.deleteBatchIds(ids);
        }
        return 0;
    }

    @Override
    public List<CheckItem> queryAllCheckItems() {
        QueryWrapper<CheckItem> qw=new QueryWrapper<>();
        qw.eq(CheckItem.COL_STATUS, Constants.STATUS_TRUE);
        return this.checkItemMapper.selectList(qw);
    }

}
