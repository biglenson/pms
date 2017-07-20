package com.zq.service.basic.capex;

import java.util.List;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.capex.BasCAPEXInvestPlan;
import com.zq.vo.basic.capex.BasCAPEXInvestPlanVO;

/**
 *
 * BasCapexInvestPlan 表数据服务层接口
 *
 */
public interface IBasCAPEXInvestPlanService{

	BasCAPEXInvestPlan getBasCAPEXInvestPlanByYearAndBasCAPEXProject(String year, String proj_code);

	Page<BasCAPEXInvestPlan> getBasCAPEXInvestPlan(int pageNumber, int pageSize);

	List<BasCAPEXInvestPlanVO> getBasCAPEXInvestPlanVOList(List<BasCAPEXInvestPlan> content);


}