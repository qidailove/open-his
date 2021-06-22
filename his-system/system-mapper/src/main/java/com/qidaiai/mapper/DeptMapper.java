package com.qidaiai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qidaiai.domain.Dept;

public interface DeptMapper extends BaseMapper {
    /**
     * delete by primary key
     * @param deptId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long deptId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Dept record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Dept record);

    /**
     * select by primary key
     * @param deptId primary key
     * @return object by primary key
     */
    Dept selectByPrimaryKey(Long deptId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateById(Dept record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Dept record);
}