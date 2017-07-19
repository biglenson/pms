package com.zq.service.basic.opex;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.opex.BasOpexBudgetpoolDetail;

/**
 *
 * BasOpexBudgetpoolDetail 表数据服务层接口
 *
 */
public interface IBasOpexBudgetpoolDetailService{

	Page<BasOpexBudgetpoolDetail> getBasOpexBudgetpoolDetail(Integer page, int pageSize);


}