package com.qidaiai.mapper;

import com.qidaiai.domain.Drug;
import com.qidaiai.domain.DrugStat;
import com.qidaiai.dto.DrugQueryDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DrugMapper {

    /**
     * 药品统计列表
     *
     * @param drugQueryDto
     * @return
     */
    List<Drug> queryDrug(@Param("drug") DrugQueryDto drugQueryDto);

    /**
     * 药品数量统计列表
     *
     * @param drugQueryDto
     * @return
     */
    List<DrugStat> queryDrugStat(@Param("drug") DrugQueryDto drugQueryDto);

}
