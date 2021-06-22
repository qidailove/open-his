package com.qidaiai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qidaiai.domain.LoginInfo;

public interface LoginInfoMapper extends BaseMapper {
    /**
     * delete by primary key
     * @param infoId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long infoId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(LoginInfo record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(LoginInfo record);

    /**
     * select by primary key
     * @param infoId primary key
     * @return object by primary key
     */
    LoginInfo selectByPrimaryKey(Long infoId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(LoginInfo record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(LoginInfo record);
}