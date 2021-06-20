package com.qidaiai.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qidaiai.domain.DictType;
import com.qidaiai.dto.DictTypeDto;
import com.qidaiai.hiscommons.constants.Constants;
import com.qidaiai.hiscommons.vo.DataGridView;
import com.qidaiai.mapper.DictTypeMapper;
import com.qidaiai.service.DictTypeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;
/**
 * @Author: 尚学堂 雷哥
 */
@Service
public class DictTypeServiceImpl  implements DictTypeService {

    @Autowired
    private DictTypeMapper dictTypeMapper;

    @Override
    public DataGridView listPage(DictTypeDto dictTypeDto) {
        QueryWrapper<DictType> qw=new QueryWrapper<>();
        Page<DictType> page=new Page<>(dictTypeDto.getPageNum(),dictTypeDto.getPageSize());
        qw.like(StringUtils.isNotBlank(dictTypeDto.getDictName()), DictType.COL_DICT_NAME,dictTypeDto.getDictName());
        qw.like(StringUtils.isNotBlank(dictTypeDto.getDictType()), DictType.COL_DICT_TYPE,dictTypeDto.getDictType());
        qw.eq(StringUtils.isNotBlank(dictTypeDto.getStatus()), DictType.COL_STATUS,dictTypeDto.getStatus());
        qw.ge(null!=dictTypeDto.getBeginTime(), DictType.COL_CREATE_TIME,dictTypeDto.getBeginTime());
        qw.le(null!=dictTypeDto.getEndTime(), DictType.COL_CREATE_TIME,dictTypeDto.getEndTime());
        this.dictTypeMapper.selectPage(page,qw);
        return new DataGridView(page.getTotal(),page.getRecords());
    }

    @Override
    public DataGridView list() {
        QueryWrapper<DictType> qw=new QueryWrapper<>();
        //只查可用的
        qw.eq(DictType.COL_STATUS, Constants.STATUS_TRUE);
        return new DataGridView(null,this.dictTypeMapper.selectList(qw));
    }

    @Override
    public Boolean checkDictTypeUnique(Long dictId, String dictType) {
        dictId = (dictId == null) ? -1L : dictId;
        QueryWrapper<DictType> qw=new QueryWrapper<>();
        qw.eq(DictType.COL_DICT_TYPE, dictType);
        DictType sysDictType = this.dictTypeMapper.selectOne(qw);
        if(null!=sysDictType &&dictId.longValue()!=sysDictType.getDictId().longValue()){
            return true; //说明不存在
        }
        return false; //说明存在
    }

    @Override
    public int insert(DictTypeDto dictTypeDto) {
        DictType dictType = new DictType();
        BeanUtil.copyProperties(dictTypeDto, dictType);
        dictType.setCreateTime(DateUtil.date());
        dictType.setCreateBy(dictTypeDto.getSimpleUser().getUserName());
        return this.dictTypeMapper.insert(dictType);
    }

    @Override
    public int update(DictTypeDto dictTypeDto) {
        DictType dictType = new DictType();
        BeanUtil.copyProperties(dictTypeDto, dictType);
        dictType.setUpdateBy(dictTypeDto.getSimpleUser().getUserName());
        return this.dictTypeMapper.updateById(dictType);
    }

    @Override
    public int deleteDictTypeByIds(Long[] dictIds) {
        List<Long> ids = Arrays.asList(dictIds);
        if(null!=ids&&ids.size()>0){
            return this.dictTypeMapper.deleteBatchIds(ids);
        }else{
            return -1;
        }

    }

    @Override
    public DictType selectDictTypeById(Long dictId) {
        return this.dictTypeMapper.selectById(dictId);
    }
}