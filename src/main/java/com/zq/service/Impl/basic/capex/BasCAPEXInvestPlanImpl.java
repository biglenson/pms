package com.zq.service.Impl.basic.capex;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zq.commons.result.PageInfo;
import com.zq.commons.utils.CMCCConstant;
import com.zq.commons.utils.TypeUtils;
import com.zq.dao.basic.capex.IBasCAPEXInvestPlanRepository;
import com.zq.entity.basic.capex.BasCAPEXInvestPlan;
import com.zq.entity.basic.capex.BasCAPEXProjInvestplan;
import com.zq.service.basic.capex.IBasCAPEXInvestPlanService;
import com.zq.service.basic.capex.IBasCAPEXProjInvestplanService;
import com.zq.service.system.ISysDicService;
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
    
    @Autowired
    private ISysDicService iSysDicService;

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
		List<BasCAPEXInvestPlanVO> voList = new ArrayList<>();		
		for(BasCAPEXInvestPlan po:content){
			BasCAPEXInvestPlanVO vo = new BasCAPEXInvestPlanVO();
			BeanUtils.copyProperties(po, vo);		
			String firstDomain = iSysDicService.getNameByClasscodeAndCode("Invest_domain",po.getFirstDomain());
			String attribute = iSysDicService.getNameByClasscodeAndCode("attr_code",po.getAttribute());
			if(firstDomain==null||firstDomain.equals("")){
				vo.setFirstDomain("未录入数据");
			}else{
				vo.setFirstDomain(firstDomain);
			}
			if(attribute==null||attribute.equals("")){
				vo.setAttribute("未录入数据");
			}else{
				vo.setAttribute(attribute);
			}
			voList.add(vo);
		}
		return voList;

	}
    
   

}