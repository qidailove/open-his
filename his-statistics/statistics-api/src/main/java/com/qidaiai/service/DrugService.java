package com.qidaiai.service;

import com.qidaiai.domain.Drug;
import com.qidaiai.domain.DrugStat;
import com.qidaiai.dto.DrugQueryDto;

import java.util.List;

public interface DrugService {

    /**
     * 查询发药统计列表
     * @param drugQueryDto
     * @return
     */
    List<Drug> queryDrug(DrugQueryDto drugQueryDto);

    /**
     * 查询发药数量统计列表
     * @param drugQueryDto
     * @return
     */
    List<DrugStat> queryDrugStat(DrugQueryDto drugQueryDto);

}
