package com.qidaiai.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qidaiai.domain.DictData;
import com.qidaiai.domain.DictType;
import com.qidaiai.dto.DictTypeDto;
import com.qidaiai.constants.Constants;
import com.qidaiai.vo.DataGridView;
import com.qidaiai.mapper.DictDataMapper;
import com.qidaiai.mapper.DictTypeMapper;
import com.qidaiai.service.DictTypeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class DictTypeServiceImpl  implements DictTypeService {

    @Autowired
    private DictTypeMapper dictTypeMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private DictDataMapper dictDataMapper;

    @Override
    public DataGridView listPage(DictTypeDto dictTypeDto) {
        QueryWrapper<DictType> qw = new QueryWrapper<>();
        Page<DictType> page = new Page<>(dictTypeDto.getPageNum(), dictTypeDto.getPageSize());
        qw.like(StringUtils.isNotBlank(dictTypeDto.getDictName()), DictType.COL_DICT_NAME, dictTypeDto.getDictName());
        qw.like(StringUtils.isNotBlank(dictTypeDto.getDictType()), DictType.COL_DICT_TYPE, dictTypeDto.getDictType());
        qw.eq(StringUtils.isNotBlank(dictTypeDto.getStatus()), DictType.COL_STATUS, dictTypeDto.getStatus());
        qw.ge(null != dictTypeDto.getBeginTime(), DictType.COL_CREATE_TIME, dictTypeDto.getBeginTime());
        qw.le(null != dictTypeDto.getEndTime(), DictType.COL_CREATE_TIME, dictTypeDto.getEndTime());
        this.dictTypeMapper.selectPage(page, qw);
        return new DataGridView(page.getTotal(), page.getRecords());
    }

    @Override
    public DataGridView list() {
        QueryWrapper<DictType> qw = new QueryWrapper<>();
        //只查可用的
        qw.eq(DictType.COL_STATUS, Constants.STATUS_TRUE);
        return new DataGridView(null, this.dictTypeMapper.selectList(qw));
    }

    @Override
    public Boolean checkDictTypeUnique(Long dictId, String dictType) {
        dictId = (dictId == null) ? -1L : dictId;
        QueryWrapper<DictType> qw = new QueryWrapper<>();
        qw.eq(DictType.COL_DICT_TYPE, dictType);
        DictType sysDictType = (DictType) this.dictTypeMapper.selectOne(qw);
        if (null != sysDictType && dictId.longValue() != sysDictType.getDictId().longValue()) {
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
        if (null != ids && ids.size() > 0) {
            return this.dictTypeMapper.deleteBatchIds(ids);
        } else {
            return -1;
        }

    }

    @Override
    public DictType selectDictTypeById(Long dictId) {
        return (DictType) this.dictTypeMapper.selectById(dictId);
    }

    @Override
    public void dictCacheAsync() {
        //查询所有可用的dictType
        QueryWrapper<DictType> qw = new QueryWrapper<>();
        qw.ge(DictType.COL_STATUS, Constants.STATUS_TRUE);
        List<DictType> dictTypes = this.dictTypeMapper.selectList(qw);
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        for (DictType dictType : dictTypes) {
            QueryWrapper<DictData> qdw = new QueryWrapper<>();
            qdw.ge(DictData.COL_STATUS, Constants.STATUS_TRUE);
            qdw.eq(DictData.COL_DICT_TYPE, dictType.getDictType());
            List<DictData> dictData = dictDataMapper.selectList(qdw);
            valueOperations.set(Constants.DICT_REDIS_PROFIX + dictType.getDictType(), JSON.toJSONString(dictData));
        }
    }

    /**
     * 之前是从数据库里面查询
     * 因为我们做到redis的缓存，所以 现在要去redis里面去查询
     *
     * @param dictType
     * @return
     */
    @Override
    public List<DictData> selectDictDataByDictType(String dictType) {
        String key = Constants.DICT_REDIS_PROFIX + dictType;
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        String json = opsForValue.get(key);
        List<DictData> dictDatas = JSON.parseArray(json, DictData.class);
        return dictDatas;
    }
}