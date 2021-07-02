package com.qidaiai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qidaiai.domain.OrderBackfee;

public interface OrderBackfeeMapper extends BaseMapper {
    /**
     * delete by primary key
     * @param backId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String backId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(OrderBackfee record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(OrderBackfee record);

    /**
     * select by primary key
     * @param backId primary key
     * @return object by primary key
     */
    OrderBackfee selectById(String backId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(OrderBackfee record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(OrderBackfee record);
}