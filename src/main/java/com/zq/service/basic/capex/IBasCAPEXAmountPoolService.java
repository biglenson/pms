package com.zq.service.basic.capex;

import java.util.List;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.capex.BasCAPEXAmountPool;
import com.zq.entity.basic.capex.BasCAPEXInvestPlan;

/**
 *
 * BasCapexAmountPool 表数据服务层接口
 *
 */
public interface IBasCAPEXAmountPoolService{

	List<BasCAPEXAmountPool> getAllCAPEXAmountPoolByYear(String year);

	Page<BasCAPEXAmountPool> getBasCAPEXAmountPool(Integer page, int pageSize);


}