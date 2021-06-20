package com.qidaiai.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.qidaiai.domain.DictType;
import com.qidaiai.mapper.DictTypeMapper;
import com.qidaiai.service.DictTypeService;
@Service
public class DictTypeServiceImpl implements DictTypeService{

    @Resource
    private DictTypeMapper dictTypeMapper;

    @Override
    public int deleteByPrimaryKey(Long dictId) {
        return dictTypeMapper.deleteByPrimaryKey(dictId);
    }

    @Override
    public int insert(DictType record) {
        return dictTypeMapper.insert(record);
    }

    @Override
    public int insertSelective(DictType record) {
        return dictTypeMapper.insertSelective(record);
    }

    @Override
    public DictType selectByPrimaryKey(Long dictId) {
        return dictTypeMapper.selectByPrimaryKey(dictId);
    }

    @Override
    public int updateByPrimaryKeySelective(DictType record) {
        return dictTypeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(DictType record) {
        return dictTypeMapper.updateByPrimaryKey(record);
    }

}
