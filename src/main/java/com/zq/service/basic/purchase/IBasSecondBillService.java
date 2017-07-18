package com.zq.service.basic.purchase;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.purchase.BasSecondBill;

/**
 *
 * BasSecondBill 表数据服务层接口
 *
 */
public interface IBasSecondBillService{

	Page<BasSecondBill> getBasSecondBill(Integer page, int pageSize);


}