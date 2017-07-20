package com.zq.service.Impl.basic.capex;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.capex.IBasCAPEXInvestPlanRepository;
import com.zq.dao.basic.capex.IBasCAPEXProjectRepository;
import com.zq.dao.basic.capex.IBasCAPEXRequirmentRepository;
import com.zq.entity.basic.capex.BasCAPEXInvestPlan;
import com.zq.entity.basic.capex.BasCAPEXProject;
import com.zq.entity.basic.capex.BasCAPEXRequirment;
import com.zq.service.basic.capex.IBasCAPEXProjectService;
import com.zq.vo.basic.capex.BasCAPEXProjectVO;

/**
 *
 * BasCAPEXProject 表数据服务层接口实现类
 *
 */
@Service
public class BasCAPEXProjectServiceImpl implements IBasCAPEXProjectService {

    @Autowired
    private IBasCAPEXProjectRepository iBasCAPEXProjectRepository;
    
    @Autowired
    private IBasCAPEXRequirmentRepository iBasCAPEXRequirmentRepository;
    
    @Autowired
    private IBasCAPEXInvestPlanRepository iBasCAPEXInvestPlanRepository;

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
		int count = 5;//完整capex流程
		int projectType = capexProject.getProjType();
		if(projectType == 2 || projectType == 3 || projectType == 5){
			count = 2;//工程项目（ICT）、工程项目（纯采购）、工程项目（零购）类型的项目状态
		}
		List<Date> dateList=new ArrayList<Date>();
		if(count == 5){
			Date[]PHASE_DATE_FIELDS={capexProject.getAvailableApprovalTime(),capexProject.getAvailableApprovalTime(),capexProject.getAvailableApprovalTime(),capexProject.getDesignApprovalTime(),capexProject.getOnlineTime(),capexProject.getPfinalApprovalTime()};
			for(int i=0;i<count;i++){
				dateList.add((Date)PHASE_DATE_FIELDS[i]);
			}
		}else if(count == 2){
			Date[]PHASE_DATE_FIELDS={capexProject.getAvailableApprovalTime(),capexProject.getDesignApprovalTime(),capexProject.getOnlineTime()};
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
	public List<BasCAPEXProjectVO> getBasCAPEXProjectVOList(List<BasCAPEXProject> content) {
		List<BasCAPEXProjectVO> voList = new ArrayList<>();		
		for(BasCAPEXProject po:content){
			BasCAPEXProjectVO vo = new BasCAPEXProjectVO();
			BeanUtils.copyProperties(po, vo);			
			BasCAPEXRequirment req = iBasCAPEXRequirmentRepository.findById(Integer.parseInt(po.getReqCode()));
			String reqName = req.getReqName();
			String reqDept = req.getReqDept();
			String investPlanCode = req.getInvestPlanCode();
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