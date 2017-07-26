package com.zq.service.Impl.basic.capex;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.zq.commons.result.PageInfo;
import com.zq.commons.utils.CMCCConstant;
import com.zq.commons.utils.TypeUtils;
import com.zq.dao.basic.capex.IBasCAPEXInvestPlanRepository;
import com.zq.entity.basic.capex.BasCAPEXInvestPlan;
import com.zq.entity.basic.capex.BasCAPEXProjInvestplan;
import com.zq.service.basic.capex.IBasCAPEXInvestPlanService;
import com.zq.service.basic.capex.IBasCAPEXProjInvestplanService;
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

    @Autowired
    private IBasCAPEXProjInvestplanService iBasCAPEXProjInvestplanService;

	@Override
	public Page<BasCAPEXInvestPlan> getBasCAPEXInvestPlan(int pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasCAPEXInvestPlanRepository.findAll(request);
	}
	
	@Override
	public Page<BasCAPEXInvestPlan> getBasCAPEXInvestPlanByPageAndYear(int pageNumber, int pageSize,String year) {
		Pageable request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasCAPEXInvestPlanRepository.findByYear(year,request);
	}

	@Override
	public BasCAPEXInvestPlan getBasCAPEXInvestPlanByProjCode(String projCode) {
		BasCAPEXProjInvestplan invPlan = iBasCAPEXProjInvestplanService.getBasCAPEXProjInvestplanByProjCode(projCode);
		return iBasCAPEXInvestPlanRepository.findByProjCode(invPlan.getInvestPlanCode());
	}

	@Override
	public HttpServletRequest getCAPEXInvestPlan(PageInfo pageInfo, HttpServletRequest request) {
		Date dataUpdateDate = null;
		String year = request.getParameter("year");
		Page<BasCAPEXInvestPlan> pageData = this.getBasCAPEXInvestPlanByPageAndYear(pageInfo.getCurrentPage(), pageInfo.getPageSize(),year);
		pageInfo.setItems(pageData.getContent()); 		
		List<BasCAPEXInvestPlan> touziPlanList = pageData.getContent();
		for (BasCAPEXInvestPlan touziPlan : touziPlanList) {
			if (dataUpdateDate == null) {
				dataUpdateDate = touziPlan.getModifyTime();
			}
			if (dataUpdateDate != null && touziPlan.getModifyTime() != null
					&& dataUpdateDate.before(touziPlan.getModifyTime())) {
				dataUpdateDate = touziPlan.getModifyTime();
			}
		}
        pageInfo.setTotalRows((int)pageData.getTotalElements());
        pageInfo.setPageCount(pageData.getTotalPages());
        pageInfo.setPageSize(pageData.getNumberOfElements());
		request.setAttribute(CMCCConstant.LASUPDATE, TypeUtils.getRelativeTime(dataUpdateDate));
		request.setAttribute("pageInfo", pageInfo);
		return request;
	}

	private List<BasCAPEXInvestPlan> getBasCAPEXInvestPlanByYear(String year) {
		
		return iBasCAPEXInvestPlanRepository.findByYear(year);
	}

	@Override
	public BasCAPEXInvestPlan getBasCAPEXInvestPlanById(int id) {
		BasCAPEXProjInvestplan invPlan = iBasCAPEXProjInvestplanService.getBasCAPEXProjInvestplanByProjCode(String.valueOf(id));
		if(invPlan!=null){
			return iBasCAPEXInvestPlanRepository.findById(Long.valueOf(invPlan.getInvestPlanCode()).longValue());
		}
		return null;
	}



	@Override
	public List<BasCAPEXInvestPlanVO> getBasCAPEXInvestPlanVOList(List<BasCAPEXInvestPlan> content) {
		return null;

	}
    
   

}