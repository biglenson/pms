package com.zq.service.basic.datamap;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.datamap.BasProductIncome;

/**
 *
 * BasProductIncome 表数据服务层接口
 *
 */
public interface IBasProductIncomeService{

	Page<BasProductIncome> getBasProductIncome(Integer page, int pageSize);


}