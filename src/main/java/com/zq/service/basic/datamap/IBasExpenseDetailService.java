package com.zq.service.basic.datamap;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.datamap.BasExpenseDetail;

/**
 *
 * BasExpenseDetail 表数据服务层接口
 *
 */
public interface IBasExpenseDetailService{

	Page<BasExpenseDetail> getBasExpenseDetail(Integer page, int pageSize);


}