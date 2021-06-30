package com.qidaiai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qidaiai.domain.CareOrderItem;

import java.util.List;

public interface CareOrderItemMapper extends BaseMapper {
    /**
     * delete by primary key
     * @param itemId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(String itemId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(CareOrderItem record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(CareOrderItem record);

    /**
     * select by primary key
     * @param itemId primary key
     * @return object by primary key
     */
    CareOrderItem selectById(String itemId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(CareOrderItem record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(CareOrderItem record);


    List<CareOrderItem> selectListBySql(String coId, String status);
}