package com.zq.service.basic.capex;

import com.zq.entity.basic.capex.BasCAPEXInvestPlan;

/**
 *
 * BasCapexInvestPlan 表数据服务层接口
 *
 */
public interface IBasCAPEXInvestPlanService{

	BasCAPEXInvestPlan getBasCAPEXInvestPlanByYearAndBasCAPEXProject(String year, String proj_code);


}