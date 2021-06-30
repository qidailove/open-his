package com.qidaiai.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qidaiai.constants.Constants;
import com.qidaiai.domain.PatientFile;
import com.qidaiai.dto.PatientDto;
import com.qidaiai.mapper.PatientFileMapper;
import com.qidaiai.utils.AppMd5Utils;
import com.qidaiai.vo.DataGridView;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.qidaiai.mapper.PatientMapper;
import com.qidaiai.domain.Patient;
import com.qidaiai.service.PatientService;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientMapper patientMapper;

    @Autowired
    private PatientFileMapper patientFileMapper;

    @Override
    public DataGridView listPatientForPage(PatientDto patientDto) {
        Page<Patient> page=new Page<>(patientDto.getPageNum(),patientDto.getPageSize());
//        QueryWrapper<Patient> qw=new QueryWrapper<>();
//        qw.like(StringUtils.isNotBlank(patientDto.getName()),Patient.COL_NAME,patientDto.getName());
//        qw.like(StringUtils.isNotBlank(patientDto.getIdCard()),Patient.COL_ID_CARD,patientDto.getIdCard());
//        qw.like(StringUtils.isNotBlank(patientDto.getPhone()),Patient.COL_PHONE,patientDto.getPhone());
        Patient patient = new Patient();
        BeanUtil.copyProperties(patientDto,patient);
//        this.patientMapper.selectPage(page,qw);
        //自定义sql查询
        List<Patient> patients = this.patientMapper.selectPageBysql(patient);
        page.setRecords(patients);
        return new DataGridView(page.getTotal(),page.getRecords());
    }

    @Override
    public Patient getPatientById(String patientId) {
        return this.patientMapper.selectById(patientId);
    }

    @Override
    public PatientFile getPatientFileById(String patientId) {
        if (null==patientId){
            return null;
        }
//        QueryWrapper<PatientFile> qw=new QueryWrapper<>();
//        qw.eq(PatientFile.COL_PATIENT_ID,patientId);
        //自定义查询语句
        return this.patientFileMapper.selectByOneSql(patientId);
//        return (PatientFile) this.patientFileMapper.selectOne(qw);
    }

    @Override
    public Patient getPatientByIdCard(String idCard) {
        QueryWrapper<Patient> qw=new QueryWrapper<>();
        qw.eq(Patient.COL_ID_CARD,idCard);
        return (Patient) this.patientMapper.selectOne(qw);
    }

    @Override
    public Patient addPatient(PatientDto patientDto) {
        Patient patient=new Patient();
        BeanUtil.copyProperties(patientDto,patient);
        patient.setCreateTime(DateUtil.date());
        patient.setIsFinal(Constants.IS_FINAL_FALSE);
        String defaultPwd=patient.getPhone().substring(5);
        patient.setPassword(AppMd5Utils.md5(defaultPwd,patient.getPhone(),2));
        this.patientMapper.insert(patient);
        return patient;
    }

}
