package com.qidaiai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qidaiai.domain.RegisteredItem;

public interface RegisteredItemMapper extends BaseMapper {
    /**
     * delete by primary key
     * @param regItemId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long regItemId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(RegisteredItem record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(RegisteredItem record);

    /**
     * select by primary key
     * @param regItemId primary key
     * @return object by primary key
     */
    RegisteredItem selectById(Long regItemId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(RegisteredItem record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateById(RegisteredItem record);
}