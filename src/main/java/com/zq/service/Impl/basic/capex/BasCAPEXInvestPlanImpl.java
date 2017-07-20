package com.zq.service.Impl.basic.capex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.capex.IBasCAPEXInvestPlanRepository;
import com.zq.entity.basic.capex.BasCAPEXInvestPlan;
import com.zq.service.basic.capex.IBasCAPEXInvestPlanService;
import com.zq.vo.basic.capex.BasCAPEXInvestPlanVO;

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

	@Override
	public Page<BasCAPEXInvestPlan> getBasCAPEXInvestPlan(int pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasCAPEXInvestPlanRepository.findAll(request);
	}

	@Override
	public List<BasCAPEXInvestPlanVO> getBasCAPEXInvestPlanVOList(List<BasCAPEXInvestPlan> content) {
		return null;

	}
    
   

}