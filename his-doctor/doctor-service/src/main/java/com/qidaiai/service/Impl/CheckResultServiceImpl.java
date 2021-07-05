package com.qidaiai.service.Impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qidaiai.constants.Constants;
import com.qidaiai.domain.CareOrderItem;
import com.qidaiai.domain.CheckResult;
import com.qidaiai.domain.OrderChargeItem;
import com.qidaiai.dto.CheckResultDto;
import com.qidaiai.dto.CheckResultFormDto;
import com.qidaiai.mapper.CareOrderItemMapper;
import com.qidaiai.mapper.CheckResultMapper;
import com.qidaiai.mapper.OrderChargeItemMapper;
import com.qidaiai.service.CheckResultService;
import com.qidaiai.vo.DataGridView;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service(methods = {@Method(name = "saveCheckResult",retries = 1)})
public class CheckResultServiceImpl implements CheckResultService {

    @Autowired
    private CheckResultMapper checkResultMapper;

    @Autowired
    private CareOrderItemMapper careOrderItemMapper;

    @Autowired
    private OrderChargeItemMapper orderChargeItemMapper;

    @Override
    public int saveCheckResult(CheckResult checkResult) {
        //保存检查项目
        int i=checkResultMapper.insert(checkResult);
        //更新收费详情的状态
        OrderChargeItem orderChargeItem=new OrderChargeItem();
        orderChargeItem.setItemId(checkResult.getItemId());
        orderChargeItem.setStatus(Constants.ORDER_DETAILS_STATUS_3);//已完成
        this.orderChargeItemMapper.updateById(orderChargeItem);
        //更新处方详情的状态
        CareOrderItem careOrderItem=new CareOrderItem();
        careOrderItem.setItemId(checkResult.getItemId());
        careOrderItem.setStatus(Constants.ORDER_DETAILS_STATUS_3);//已完成
        this.careOrderItemMapper.updateById(careOrderItem);
        return i;
    }

    @Override
    public DataGridView queryAllCheckResultForPage(CheckResultDto checkResultDto) {
        Page<CheckResult> page=new Page<>(checkResultDto.getPageNum(),checkResultDto.getPageSize());
        QueryWrapper<CheckResult> qw=new QueryWrapper<>();
        qw.in(checkResultDto.getCheckItemIds().size()>0,CheckResult.COL_CHECK_ITEM_ID,checkResultDto.getCheckItemIds());
        qw.like(StringUtils.isNotBlank(checkResultDto.getPatientName()),CheckResult.COL_PATIENT_NAME,checkResultDto.getPatientName());
        qw.like(StringUtils.isNotBlank(checkResultDto.getRegId()),CheckResult.COL_REG_ID,checkResultDto.getRegId());
        qw.eq(StringUtils.isNotBlank(checkResultDto.getResultStatus()),CheckResult.COL_RESULT_STATUS,checkResultDto.getResultStatus());
        this.checkResultMapper.selectPage(page,qw);
        return new DataGridView(page.getTotal(),page.getRecords());
    }

    @Override
    public int completeCheckResult(CheckResultFormDto checkResultFormDto) {
        CheckResult checkResult=new CheckResult();
        BeanUtil.copyProperties(checkResultFormDto,checkResult);
        checkResult.setResultStatus(Constants.RESULT_STATUS_1);//检查完成
        checkResult.setUpdateBy(checkResultFormDto.getSimpleUser().getUserName());
        return this.checkResultMapper.updateById(checkResult);
    }

}
