package com.zq.service.basic.capex;

import java.util.List;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.capex.BasCAPEXTotalInvestplan;

/**
 *
 * BasCapexTotalInvestplan 表数据服务层接口
 *
 */
public interface IBasCAPEXTotalInvestplanService{

	List<BasCAPEXTotalInvestplan> getAllCAPEXTotalInvestplanByYear(String year);

	Page<BasCAPEXTotalInvestplan> getBasCAPEXTotalInvestplan(Integer page, int pageSize);


}