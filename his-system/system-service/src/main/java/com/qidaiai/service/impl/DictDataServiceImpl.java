package com.qidaiai.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qidaiai.dto.DictDataDto;
import com.qidaiai.hiscommons.constants.Constants;
import com.qidaiai.hiscommons.vo.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qidaiai.mapper.DictDataMapper;
import com.qidaiai.domain.DictData;
import com.qidaiai.service.DictDataService;

import java.util.Arrays;
import java.util.List;

@Service
public class DictDataServiceImpl implements DictDataService{

    @Autowired
    private DictDataMapper dictDataMapper;


    @Override
    public DataGridView listPage(DictDataDto dictDataDto) {

        QueryWrapper<DictData> qw=new QueryWrapper<>();
        Page<DictData> page=new Page<>(dictDataDto.getPageNum(),dictDataDto.getPageSize());
        qw.eq(StringUtils.isNotBlank(dictDataDto.getDictType()), DictData.COL_DICT_TYPE,dictDataDto.getDictType());
        qw.like(StringUtils.isNotBlank(dictDataDto.getDictLabel()), DictData.COL_DICT_LABEL,dictDataDto.getDictLabel());
        qw.eq(StringUtils.isNotBlank(dictDataDto.getStatus()), DictData.COL_STATUS,dictDataDto.getStatus());
        this.dictDataMapper.selectPage(page,qw);
        return new DataGridView(page.getTotal(),page.getRecords());
    }

    @Override
    public int insert(DictDataDto dictDataDto) {
        DictData dictData=new DictData();
        BeanUtil.copyProperties(dictDataDto,dictData);
        //设置创建者，创建时间
        dictData.setCreateBy(dictDataDto.getSimpleUser().getUserName());
        dictData.setCreateTime(DateUtil.date());
        return this.dictDataMapper.insert(dictData);
    }

    @Override
    public int update(DictDataDto dictDataDto) {
        DictData dictData=new DictData();
        BeanUtil.copyProperties(dictDataDto,dictData);
        //设置修改人
        dictData.setUpdateBy(dictDataDto.getSimpleUser().getUserName());
        UpdateWrapper<DictData> updateWrapper = new UpdateWrapper<>();
        return this.dictDataMapper.update(dictData,updateWrapper);
    }

    @Override
    public int deleteDictDataByIds(Long[] dictCodeIds) {
        List<Long> ids= Arrays.asList(dictCodeIds);
        if(null!=ids&&ids.size()>0){
            return this.dictDataMapper.deleteBatchIds(ids);
        }else{
            return -1;
        }
    }

    @Override
    public List<DictData> selectDictDataByDictType(String dictType) {
        QueryWrapper<DictData> qw=new QueryWrapper<>();
        qw.eq(DictData.COL_DICT_TYPE,dictType);
        qw.eq(DictData.COL_STATUS, Constants.STATUS_TRUE);//可用的
        return this.dictDataMapper.selectList(qw);
    }

    @Override
    public DictData selectDictDataById(Long dictCode) {
        return (DictData) this.dictDataMapper.selectById(dictCode);
    }

}
