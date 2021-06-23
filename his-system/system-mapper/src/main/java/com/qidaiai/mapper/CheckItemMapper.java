package com.qidaiai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qidaiai.domain.CheckItem;

public interface CheckItemMapper extends BaseMapper {
    /**
     * delete by primary key
     * @param checkItemId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long checkItemId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(CheckItem record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(CheckItem record);

    /**
     * select by primary key
     * @param checkItemId primary key
     * @return object by primary key
     */
    CheckItem selectById(Long checkItemId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateById(CheckItem record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(CheckItem record);
}