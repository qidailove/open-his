package com.qidaiai.controller.docter;

import cn.hutool.core.bean.BeanUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qidaiai.constants.Constants;
import com.qidaiai.controller.BaseController;
import com.qidaiai.domain.CareHistory;
import com.qidaiai.domain.CareOrder;
import com.qidaiai.domain.CareOrderItem;
import com.qidaiai.service.CareService;
import com.qidaiai.vo.AjaxResult;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

/**
 * 收费管理控制器
 * @author qidaiai
 * @date 2021/0628
 */
@RestController
@RequestMapping("doctor/charge")
public class OrderChargeController extends BaseController {

    @Reference
    private CareService careService;

    /**
     * 根据挂号ID查询未支付的处方信息及详情
     */
    @GetMapping("getNoChargeCareHistoryByRegId/{regId}")
    @HystrixCommand
    public AjaxResult getNoChargeCareHistoryByRegId(@PathVariable String regId){
        //声明返回的Map对象
        Map<String,Object> res=new HashMap<>();
        //根据挂号单ID查询病例信息
        CareHistory careHistory=this.careService.queryCareHistoryByRegId(regId);
        if(null==careHistory){
            return AjaxResult.fail("【"+regId+"】的挂号单没有对应的病例信息，请核对后再查询");
        }
        //放入默认值
        res.put("careHistory",careHistory);
        res.put("careOrders", Collections.EMPTY_LIST);
        //声明一个可以存放careOrders的集合
        List<Map<String,Object>> mapList=new ArrayList<>();
        //根据病例编号查询处方
        List<CareOrder> careOrders=this.careService.queryCareOrdersByChId(careHistory.getChId());
        if(careOrders.isEmpty()){
            return AjaxResult.fail("【"+regId+"】的挂号单没相关的处方信息，请核对后再查询");
        }
        for (CareOrder careOrder : careOrders) {
            Map<String,Object> beanToMap= BeanUtil.beanToMap(careOrder);
            beanToMap.put("careOrderItems",Collections.EMPTY_LIST);
            BigDecimal allAmount=new BigDecimal("0");
            //根据处方ID查询未支持的处方详情列表
            List<CareOrderItem> careOrderItems=this.careService.queryCareOrderItemsByCoId(careOrder.getCoId(), Constants.ORDER_DETAILS_STATUS_0);
            //如果当前处方未支付的详情为空 结束当前循环
            if(careOrderItems.isEmpty()){
                continue;
            }else{
                //重新计算总价
                for (CareOrderItem careOrderItem : careOrderItems) {
                    allAmount=allAmount.add(careOrderItem.getAmount());
                }
                beanToMap.put("careOrderItems",careOrderItems);
                beanToMap.put("allAmount",allAmount);
                mapList.add(beanToMap);
            }
        }
        if(mapList.isEmpty()){
            return AjaxResult.fail("【"+regId+"】的挂号单没未支付的处方信息，请核对后再查询");
        }else{
            res.put("careOrders",mapList);
            return AjaxResult.success(res);
        }
    }
}
