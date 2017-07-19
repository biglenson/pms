package com.zq.service.basic.opex;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.opex.BasOPEXBudgetpool;

/**
 *
 * BasOPEXBudgetpool 表数据服务层接口
 *
 */
public interface IBasOPEXBudgetpoolService{

	Page<BasOPEXBudgetpool> getBasOPEXBudgetpool(Integer page, int pageSize);


}