package com.qidaiai.service;

import com.qidaiai.domain.DictType;
public interface DictTypeService{


    int deleteByPrimaryKey(Long dictId);

    int insert(DictType record);

    int insertSelective(DictType record);

    DictType selectByPrimaryKey(Long dictId);

    int updateByPrimaryKeySelective(DictType record);

    int updateByPrimaryKey(DictType record);

}
