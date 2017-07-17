package com.zq.service.Impl.basic.capex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.capex.IBasCAPEXInvestPlanRepository;
import com.zq.entity.basic.capex.BasCAPEXInvestPlan;
import com.zq.service.basic.capex.IBasCAPEXInvestPlanService;

/**
 *
 * BasCAPEXInvestPlan 表数据服务层接口实现类
 *
 */
@Service
public class BasCAPEXInvestPlanImpl implements IBasCAPEXInvestPlanService {

    @Autowired
    private IBasCAPEXInvestPlanRepository iBasCAPEXInvestPlanRepository;

	@Override
	public BasCAPEXInvestPlan getBasCAPEXInvestPlanByYearAndBasCAPEXProject(String year, String proj_code) {
		
		return iBasCAPEXInvestPlanRepository.findByYearAndProjCode(year,proj_code);
	}
    
   

}