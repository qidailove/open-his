package com.qidaiai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qidaiai.domain.CareHistory;

public interface CareHistoryMapper extends BaseMapper {
    /**
     * delete by primary key
     * @param chId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String chId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(CareHistory record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(CareHistory record);

    /**
     * select by primary key
     * @param chId primary key
     * @return object by primary key
     */
    CareHistory selectById(String chId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(CareHistory record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(CareHistory record);
}