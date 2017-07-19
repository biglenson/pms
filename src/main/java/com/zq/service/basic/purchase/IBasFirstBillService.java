package com.zq.service.basic.purchase;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.purchase.BasFirstBill;

import java.util.List;

/**
 *
 * BasFirstBill 表数据服务层接口
 *
 */
public interface IBasFirstBillService{


	Page<BasFirstBill> getBasFirstBill(Integer page, int pageSize);

	List getFirstBillByYear(String year);


}