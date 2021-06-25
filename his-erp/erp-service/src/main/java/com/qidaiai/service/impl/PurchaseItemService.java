package com.qidaiai.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.qidaiai.domain.PurchaseItem;
import com.qidaiai.mapper.PurchaseItemMapper;
@Service
public class PurchaseItemService{

    @Resource
    private PurchaseItemMapper purchaseItemMapper;

    
    public int deleteByPrimaryKey(String itemId) {
        return purchaseItemMapper.deleteByPrimaryKey(itemId);
    }

    
    public int insert(PurchaseItem record) {
        return purchaseItemMapper.insert(record);
    }

    
    public int insertSelective(PurchaseItem record) {
        return purchaseItemMapper.insertSelective(record);
    }

    
    public PurchaseItem selectByPrimaryKey(String itemId) {
        return purchaseItemMapper.selectById(itemId);
    }

    
    public int updateByPrimaryKeySelective(PurchaseItem record) {
        return purchaseItemMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(PurchaseItem record) {
        return purchaseItemMapper.updateByPrimaryKey(record);
    }

}
