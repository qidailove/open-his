package com.qidaiai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qidaiai.domain.Notice;

public interface NoticeMapper extends BaseMapper {
    /**
     * delete by primary key
     * @param noticeId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer noticeId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Notice record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Notice record);

    /**
     * select by primary key
     * @param noticeId primary key
     * @return object by primary key
     */
    Notice selectById(Long noticeId);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateById(Notice record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Notice record);
}