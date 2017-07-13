package com.zq.service.basic.capex;

import java.util.List;

import com.zq.entity.basic.capex.BasCAPEXAmountPool;

/**
 *
 * BasCapexAmountPool 表数据服务层接口
 *
 */
public interface IBasCAPEXAmountPoolService{

	List<BasCAPEXAmountPool> getAllCAPEXAmountPoolByYear(int year);


}