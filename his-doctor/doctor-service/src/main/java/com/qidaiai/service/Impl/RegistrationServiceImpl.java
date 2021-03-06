package com.qidaiai.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qidaiai.constants.Constants;
import com.qidaiai.dto.RegistrationDto;
import com.qidaiai.mapper.RegistrationMapper;
import com.qidaiai.domain.Registration;
import com.qidaiai.service.RegistrationService;
import com.qidaiai.vo.DataGridView;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService{

    @Autowired
    private RegistrationMapper registrationMapper;

    @Override
    public void addRegistration(RegistrationDto registrationDto) {
        Registration registration=new Registration();
        BeanUtil.copyProperties(registrationDto,registration);
        registration.setRegStatus(Constants.REG_STATUS_0);
        registration.setCreateBy(registrationDto.getSimpleUser().getUserName());
        registration.setCreateTime(DateUtil.date());
        this.registrationMapper.insert(registration);
    }

    @Override
    public DataGridView queryRegistrationForPage(RegistrationDto registrationDto) {
        Page<Registration> page=new Page<>(registrationDto.getPageNum(),registrationDto.getPageSize());
        QueryWrapper<Registration> qw=new QueryWrapper<>();
        qw.eq(registrationDto.getDeptId()!=null,Registration.COL_DEPT_ID,registrationDto.getDeptId());
        qw.like(StringUtils.isNotBlank(registrationDto.getPatientName()),Registration.COL_PATIENT_NAME,registrationDto.getPatientName());
        qw.eq(StringUtils.isNotBlank(registrationDto.getSchedulingType()),Registration.COL_SCHEDULING_TYPE,registrationDto.getSchedulingType());
        qw.eq(StringUtils.isNotBlank(registrationDto.getSubsectionType()),Registration.COL_SUBSECTION_TYPE,registrationDto.getSubsectionType());
        qw.eq(StringUtils.isNotBlank(registrationDto.getRegStatus()),Registration.COL_REG_STATUS,registrationDto.getRegStatus());
        qw.eq(StringUtils.isNotBlank(registrationDto.getVisitDate()),Registration.COL_VISIT_DATE,registrationDto.getVisitDate());
        qw.orderByDesc(Registration.COL_CREATE_TIME);
        this.registrationMapper.selectPage(page,qw);
        return new DataGridView(page.getTotal(),page.getRecords());
    }

    @Override
    public int updateRegistrationByRegId(Registration registration) {
        return this.registrationMapper.updateById(registration);
    }

    @Override
    public Registration queryRegistrationByRegId(String registrationId) {
        return this.registrationMapper.selectById(registrationId);
    }

    /**
     * ??????????????????????????????
     * @param deptId ??????
     * @param subsectionType  ??????
     * @param scheudlingType  ??????  ?????? ??????
     * @param regStatus    ???????????????
     * @param userId   ??????ID
     * @return
     */
    @Override
    public List<Registration> queryRegistration(Long deptId, String subsectionType, String scheudlingType, String regStatus, Long userId) {
//        QueryWrapper<Registration> qw=new QueryWrapper<>();
//        qw.eq(Registration.COL_DEPT_ID,deptId);
//        qw.eq(StringUtils.isNotBlank(subsectionType),Registration.COL_SUBSECTION_TYPE,subsectionType);
//        qw.eq(Registration.COL_SCHEDULING_TYPE,scheudlingType);
//        qw.eq(Registration.COL_REG_STATUS,regStatus);
//        qw.eq(Registration.COL_VISIT_DATE,DateUtil.format(DateUtil.date(),"yyyy-MM-dd"));
//        qw.eq(null!=userId,Registration.COL_USER_ID,userId);
//        qw.orderByAsc(Registration.COL_REG_NUMBER);
        return this.registrationMapper.selectListBySql(deptId,subsectionType,scheudlingType,regStatus, new SimpleDateFormat("yyyy-MM-dd").format(DateUtil.date()), userId);

//        return this.registrationMapper.selectList(qw);
    }

}
