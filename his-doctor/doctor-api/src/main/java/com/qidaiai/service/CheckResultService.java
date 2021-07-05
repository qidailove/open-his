package com.qidaiai.service;

import com.qidaiai.domain.CheckResult;
import com.qidaiai.dto.CheckResultDto;
import com.qidaiai.dto.CheckResultFormDto;
import com.qidaiai.vo.DataGridView;

public interface CheckResultService {

    /**
     * 保存检查项目信息
     *
     * @param checkResult
     * @return
     */
    int saveCheckResult(CheckResult checkResult);

    /**
     * 根据条件查询所有检查中的和检查完成了的项目
     * @param checkResultDto
     * @return
     */
    DataGridView queryAllCheckResultForPage(CheckResultDto checkResultDto);

    /**
     * 完成检查
     * @param checkResultFormDto
     * @return
     */
    int completeCheckResult(CheckResultFormDto checkResultFormDto);

}
