package com.qidaiai.impl;

import com.qidaiai.domain.Drug;
import com.qidaiai.domain.DrugStat;
import com.qidaiai.dto.DrugQueryDto;
import com.qidaiai.mapper.DrugMapper;
import com.qidaiai.service.DrugService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugMapper drugMapper;

    @Override
    public List<Drug> queryDrug(DrugQueryDto drugQueryDto) {
        return this.drugMapper.queryDrug(drugQueryDto);
    }

    @Override
    public List<DrugStat> queryDrugStat(DrugQueryDto drugQueryDto) {
        return this.drugMapper.queryDrugStat(drugQueryDto);
    }

}
