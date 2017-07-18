package com.zq.service.basic.purchase;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.purchase.BasOPEXPurchaseplan;

/**
 *
 * BasOPEXPurchaseplan 表数据服务层接口
 *
 */
public interface IBasOPEXPurchaseplanService{

	Page<BasOPEXPurchaseplan> getBasOPEXPurchaseplan(Integer page, int pageSize);


}