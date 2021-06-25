package com.qidaiai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qidaiai.domain.DictData;


public interface DictDataMapper extends BaseMapper {
    /**
     * delete by primary key
     * @param dictCode primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long dictCode);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(DictData record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(DictData record);

    /**
     * select by primary key
     * @param dictCode primary key
     * @return object by primary key
     */
    DictData selectById(Long dictCode);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(DictData record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(DictData record);

//    List<DictData> selectList(QueryWrapper queryWrapper);
}