package com.zq.service.basic.capex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;

import com.zq.commons.result.PageInfo;
import com.zq.entity.basic.capex.BasCAPEXInvestPlan;

/**
 *
 * BasCapexInvestPlan 表数据服务层接口
 *
 */
public interface IBasCAPEXInvestPlanService{

	Page<BasCAPEXInvestPlan> getBasCAPEXInvestPlan(int pageNumber, int pageSize);

	BasCAPEXInvestPlan getBasCAPEXInvestPlanByProjCode(String projCode);

	HttpServletRequest getCAPEXInvestPlan(PageInfo pageInfo, HttpServletRequest request);

	Page<BasCAPEXInvestPlan> getBasCAPEXInvestPlanByPageAndYear(int pageNumber, int pageSize, String year);

	BasCAPEXInvestPlan getBasCAPEXInvestPlanById(int id);




}