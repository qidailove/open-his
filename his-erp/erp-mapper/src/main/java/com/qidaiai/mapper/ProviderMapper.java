package com.qidaiai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qidaiai.domain.Provider;

public interface ProviderMapper extends BaseMapper {
    /**
     * delete by primary key
     * @param providerId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long providerId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Provider record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Provider record);

    /**
     * select by primary key
     * @param providerId primary key
     * @return object by primary key
     */
    Provider selectById(Long providerId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Provider record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateById(Provider record);
}