package com.zq.service.basic.opex;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.opex.BasOPEXBudgetAdjust;

/**
 *
 * BasOPEXBudgetAdjust 表数据服务层接口
 *
 */
public interface IBasOPEXBudgetAdjustService{

	Page<BasOPEXBudgetAdjust> getBasOPEXBudgetAdjust(Integer page, int pageSize);


}