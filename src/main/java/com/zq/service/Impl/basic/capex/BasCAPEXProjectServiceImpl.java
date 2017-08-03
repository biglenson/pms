package com.zq.service.Impl.basic.capex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
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
import com.zq.dao.basic.capex.IBasCAPEXProjectRepository;
import com.zq.dao.basic.capex.IBasCAPEXRequirmentRepository;

import com.zq.entity.basic.capex.BasCAPEXInvestPlan;
import com.zq.entity.basic.capex.BasCAPEXProject;
import com.zq.entity.basic.capex.BasCAPEXTransferplan;
import com.zq.entity.system.Department;
import com.zq.service.basic.capex.IBasCAPEXInvestPlanService;
import com.zq.entity.basic.capex.BasCAPEXRequirment;
import com.zq.service.basic.capex.IBasCAPEXProjectService;
import com.zq.service.basic.capex.IBasCAPEXTransferplanService;
import com.zq.service.system.IDepartmentService;
import com.zq.service.system.ISysDicService;
import com.zq.vo.basic.capex.BasCAPEXProjectVO;

/**
 *
 * BasCAPEXProject 表数据服务层接口实现类
 *
 */
@Service
public class BasCAPEXProjectServiceImpl implements IBasCAPEXProjectService {
	
	private static Logger logger = Logger.getLogger(BasCAPEXProjectServiceImpl.class);  

    @Autowired
    private IBasCAPEXProjectRepository iBasCAPEXProjectRepository;
    
    @Autowired

    private IBasCAPEXInvestPlanService iBasCAPEXInvestPlanService;
    
    @Autowired
    private IDepartmentService  iDepartmentService;
    
    @Autowired
    private IBasCAPEXTransferplanService iBasCAPEXTransferplanService;
    
    @Autowired
    private IBasCAPEXRequirmentRepository iBasCAPEXRequirmentRepository;
    
    @Autowired
    private IBasCAPEXInvestPlanRepository iBasCAPEXInvestPlanRepository;
    
    @Autowired
    private ISysDicService iSysDicService;
    
	@Override
	public List<BasCAPEXProject> getALLCAPEXProject() {
		
		return iBasCAPEXProjectRepository.findAll();
	}

	@Override
	public BasCAPEXProject getCAPEXProject() {
		
		return null;
	}

	@Override
	public List<BasCAPEXProject> getBasCAPEXProjectByYear(String year) {
		
		return iBasCAPEXProjectRepository.findByProjStartYear(year);
	}

	@Override
	public int getCurrentPhase(BasCAPEXProject capexProject) throws Exception{
		int count = 6;//完整capex流程
		int projectType = capexProject.getProjType();
		if(projectType == 2 || projectType == 3 || projectType == 5){
			count = 3;//工程项目（ICT）、工程项目（纯采购）、工程项目（零购）类型的项目状态
		}
		List<Date> dateList=new ArrayList<Date>();
		if(count == 6){
			Date[]PHASE_DATE_FIELDS={capexProject.getReqFreezeTime(),capexProject.getAvailableApprovalTime(),capexProject.getPaperContractTime(),capexProject.getDesignApprovalTime(),capexProject.getOnlineTime(),capexProject.getPfinalApprovalTime()};
			for(int i=0;i<count;i++){
				dateList.add((Date)PHASE_DATE_FIELDS[i]);
			}
		}else if(count == 3){
			Date[]PHASE_DATE_FIELDS={capexProject.getReqFreezeTime(),capexProject.getAvailableApprovalTime(),capexProject.getDesignApprovalTime()};
			for(int i=0;i<count;i++){
				dateList.add((Date) PHASE_DATE_FIELDS[i]);
			}
		}
		for(int i=count-1;i>0;i--){
			Date date=dateList.get(i);
			if(date!=null){
				return i;
			}
		}
		return 0;
	}

	public Page<BasCAPEXProject> getBasCAPEXProject(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasCAPEXProjectRepository.findAll(request);
	}

	@Override
	public HttpServletRequest getBasCAPEXInvestPlanUsage(String year, HttpServletRequest request) {
		double capexValue = 0d;
		double shiYongValue = 0d;
		List<Department> depMntList = new ArrayList<Department>(); 
		Map<Integer, Double> capexValueMap = new HashMap<Integer, Double>();
		Map<Integer, Double> shiYongValueMap = new HashMap<Integer, Double>();
		Date dataUpdateDate = null;
		List<BasCAPEXProject> projectList = this.getBasCAPEXProjectByYear(year);
		//TypeUtils.prepareForFormList(user, projectList, request);

		for (BasCAPEXProject project : projectList) {
			if (dataUpdateDate == null) {
				dataUpdateDate = project.getModifyTime();
			}
			if (dataUpdateDate != null && project.getModifyTime() != null
					&& dataUpdateDate.before(project.getModifyTime())) {
				dataUpdateDate = project.getModifyTime();
			}
			BasCAPEXInvestPlan plan = iBasCAPEXInvestPlanService.getBasCAPEXInvestPlanById(project.getId());
			String shuxing = "";
			if (plan != null) {
				shuxing = "新建"; // 后期根据BasCAPEXInvestPlan中attribute去代码表中查出具体值
			}
			if ("新建".equalsIgnoreCase(shuxing.trim())) {
				double tempCapexValue = TypeUtils.string2Double(project.getProjTotalInvest());
				double tempShiYongValue = TypeUtils.string2Double(project.getProjSetupAmount());
				capexValue += tempCapexValue;
				shiYongValue += tempShiYongValue;
				int depMnt = iBasCAPEXInvestPlanService.getBasCAPEXInvestPlanById(project.getId()).getDepartment();
				
				depMntList.add(iDepartmentService.getDepById(depMnt));
				if (depMnt != 0) {
					Double roleCapexValue = capexValueMap.get(depMnt);
					if (roleCapexValue == null) {
						roleCapexValue = 0d;
					}
					roleCapexValue += tempCapexValue;
					capexValueMap.put(depMnt, roleCapexValue);

					Double roleShiYongValue = shiYongValueMap.get(depMnt);
					if (roleShiYongValue == null) {
						roleShiYongValue = 0d;
					}
					roleShiYongValue += tempShiYongValue;
					shiYongValueMap.put(depMnt, roleShiYongValue);
				}
			}
		}
		request.setAttribute("depMntList", depMntList);
		request.setAttribute("capexValueMap", capexValueMap);
		request.setAttribute("shiYongValueMap", shiYongValueMap);
		request.setAttribute("capexValue", capexValue);
		request.setAttribute("shiYongValue", shiYongValue);
		return request;
	}

	@Override
	public HttpServletRequest getCAPEXProjectAsPage(PageInfo pageInfo, HttpServletRequest request) {
		Date dataUpdateDate = null;
		String year = request.getParameter("year");
		pageInfo.setPaged(false);
		Page<BasCAPEXProject> pageData = this.getBasCAPEXProjectByPageAndYear(pageInfo.getCurrentPage(),pageInfo.getPageSize(),year);
		pageInfo.setItems(pageData.getContent()); 
		PageInfo zhuanziPage = new PageInfo();
		// pageInfo.setOrderBy("a.id");
		// pageInfo.setOrderType("DESC");
		Properties zhuanziProperty = new Properties();
		zhuanziPage.setConditions(zhuanziProperty);
		zhuanziProperty.put("year", year);

		List<BasCAPEXProject> list = pageInfo.getItems();
		int pageCount = list.size() / pageInfo.getPageSize();
		int rowCount = pageInfo.getPageSize();
		if (list.size() % pageInfo.getPageSize() > 0) {
			pageCount += 1;
		}
		if (pageInfo.getCurrentPage() > pageCount) {
			pageInfo.setCurrentPage(pageCount); 
		}
		Collections.sort(list, new Comparator<BasCAPEXProject>() {

			@Override
			public int compare(BasCAPEXProject o1, BasCAPEXProject o2) {
				try {
					// return o2.getCurrentPhase()-o1.getCurrentPhase();
					return o2.getProjStatus()-o1.getProjStatus();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return 0;
			}

		});
		if (list.size() > 0) {
			if (list.size() % pageInfo.getPageSize() > 0 && pageInfo.getCurrentPage() == pageCount) {
				rowCount = list.size() % pageInfo.getPageSize();
				pageInfo.setItems(list.subList((pageInfo.getCurrentPage() - 1) * pageInfo.getPageSize(), list.size()));
			} else {
				pageInfo.setItems(list.subList((pageInfo.getCurrentPage() - 1) * pageInfo.getPageSize(), pageInfo.getCurrentPage() * pageInfo.getPageSize()));

			}
		} else {
			pageInfo.setItems(list);
		}
		// pageInfo.setItems(list.subList((currentPage - 1) * pageSize,
		// list.size()));
		pageInfo.setPageCount(pageCount);
		pageInfo.setTotalRows(list.size());
		pageInfo.setCurrentPage(pageInfo.getCurrentPage());
		pageInfo.setPaged(true);
		pageInfo.setPageSize(pageInfo.getPageSize());
		pageInfo.setRowCount(rowCount);

		Map<String, String> projectZhunziMoney = new HashMap();
		Map<String, Object> touziPlan = new HashMap();
		Set<Integer> capexProjectIDSet = new HashSet<Integer>();

		for (BasCAPEXProject project : pageData.getContent()) {
			if (dataUpdateDate == null) {
				dataUpdateDate = project.getModifyTime();
			}
			if (dataUpdateDate != null && project.getModifyTime() != null
					&& dataUpdateDate.before(project.getModifyTime())) {
				dataUpdateDate = project.getModifyTime();
			}
			capexProjectIDSet.add(project.getId());
		}
		zhuanziProperty.put("capexProjectIDSet", capexProjectIDSet);
		Page<BasCAPEXTransferplan> pageDataT = iBasCAPEXTransferplanService.getCAPEXTransferplanByPageAndYear(pageInfo.getCurrentPage(),pageInfo.getPageSize(), year);
		if (capexProjectIDSet.size() > 0) {
			zhuanziPage.setItems(pageDataT.getContent());
		} else {
			zhuanziPage.setItems(new ArrayList());
		}
		for (BasCAPEXProject project : pageData.getContent()) {
			if (dataUpdateDate == null) {
				dataUpdateDate = project.getModifyTime();
			}
			if (dataUpdateDate != null && project.getModifyTime() != null
					&& dataUpdateDate.before(project.getModifyTime())) {
				dataUpdateDate = project.getModifyTime();
			}
			Double totalMoney = 0d;
			for (BasCAPEXTransferplan plan : pageDataT.getContent()) {
				if (plan.getYear() == year && plan.getId() == project.getId()) {
					totalMoney += iBasCAPEXTransferplanService.getActualByYearAndCAPEXProjCode(year, String.valueOf(plan.getId()));
				}
			}
			BasCAPEXInvestPlan invPlan = iBasCAPEXInvestPlanService.getBasCAPEXInvestPlanById(project.getId());
			touziPlan.put(project.getProjCode(), invPlan);
			projectZhunziMoney.put(project.getProjCode(), totalMoney.toString());
		}
		request.setAttribute("projectZhunziMoney", projectZhunziMoney);
		request.setAttribute(CMCCConstant.LASUPDATE, TypeUtils.getRelativeTime(dataUpdateDate));
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("touziPlan", touziPlan);
		return request;
	}

	private Page<BasCAPEXProject> getBasCAPEXProjectByPageAndYear(Integer pageNumber, int pageSize,String year) {
		Pageable request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasCAPEXProjectRepository.findByProjStartYear(year,request);
	}
		
	public List<BasCAPEXProjectVO> getBasCAPEXProjectVOList(List<BasCAPEXProject> content) {
		List<BasCAPEXProjectVO> voList = new ArrayList<>();		
		for(BasCAPEXProject po:content){
			BasCAPEXProjectVO vo = new BasCAPEXProjectVO();
			BeanUtils.copyProperties(po, vo);			
			BasCAPEXRequirment req = iBasCAPEXRequirmentRepository.findById(Integer.parseInt(po.getReqCode()));
			String projType = iSysDicService.getNameByClasscodeAndCode("capex_proj_type",po.getProjType());
			String projStatus = iSysDicService.getNameByClasscodeAndCode("capex_proj_status",po.getProjStatus());
			if(projType==null||projType.equals("")){
				vo.setProjType("未录入数据");
			}else{
				vo.setProjType(projType);
			}
			if(projStatus==null||projStatus.equals("")){
				vo.setProjStatus("未录入数据");
			}else{
				vo.setProjStatus(projStatus);
			}
			String reqName = "";
			String reqDept = "";
			String investPlanCode = "";
			if(req == null){
				logger.info(po.getReqCode() + "CAPEX需求数据为空");
			}else{
				reqName = req.getReqName();
				reqDept = req.getReqDept();
				investPlanCode = req.getInvestPlanCode();
			}			
			if(reqName==null||reqName.equals("")){
				vo.setReqName("未录入名称");
			}else{
				vo.setReqName(reqName);
			}
			if(reqDept==null||reqDept.equals("")){
				vo.setReqDept("未录入部门");
			}else{
				vo.setReqDept(reqName);
			}
			if(investPlanCode==null||investPlanCode.equals("")){
				vo.setReqDept("未关联投资计划");
			}else{
				BasCAPEXInvestPlan inspl = iBasCAPEXInvestPlanRepository.findById(Integer.parseInt(investPlanCode));
				String investPlanProjName = inspl.getProjName();
				if(reqDept==null||reqDept.equals("")){
					vo.setInvestPlanProjName("未录入名称");
				}else{
					vo.setInvestPlanProjName(investPlanProjName);
				}
			}
			voList.add(vo);
		}
		return voList;
	}   

}