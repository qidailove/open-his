package com.qidaiai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qidaiai.domain.Producter;

public interface ProducterMapper extends BaseMapper {
    /**
     * delete by primary key
     * @param producterId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long producterId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Producter record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Producter record);

    /**
     * select by primary key
     * @param producterId primary key
     * @return object by primary key
     */
    Producter selectById(Long producterId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Producter record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Producter record);
}