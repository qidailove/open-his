package com.qidaiai.service;

import com.qidaiai.domain.Registration;
import com.qidaiai.dto.RegistrationDto;
import com.qidaiai.vo.DataGridView;

import java.util.List;

public interface RegistrationService{

    /**
     * 保存挂号单信息
     * @param registrationDto
     */
    void addRegistration(RegistrationDto registrationDto);

    /**
     * 分页查询挂号单
     * @param registrationDto
     * @return
     */
    DataGridView queryRegistrationForPage(RegistrationDto registrationDto);

    /**
     * 根据ID更新挂号单的信息
     * @param registration
     * @return
     */
    int updateRegistrationByRegId(Registration registration);

    /**
     * 根据挂号ID查询挂号信息
     * @param registrationId
     * @return
     */
    Registration queryRegistrationByRegId(String registrationId);

    /**
     * 根据条件查询挂号信息
     * @param deptId 部门
     * @param subsectionType  时段
     * @param scheudlingType  类型  门诊 急诊
     * @param regStatus    挂号单状态
     * @param userId   医生ID
     * @return
     */
    List<Registration> queryRegistration(Long deptId, String subsectionType, String scheudlingType, String regStatus, Long userId);

}
