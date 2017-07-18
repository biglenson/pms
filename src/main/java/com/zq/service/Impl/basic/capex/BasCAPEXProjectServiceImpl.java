package com.zq.service.Impl.basic.capex;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.capex.IBasCAPEXProjectRepository;
import com.zq.entity.basic.capex.BasCAPEXProject;
import com.zq.service.basic.capex.IBasCAPEXProjectService;

/**
 *
 * BasCAPEXProject 表数据服务层接口实现类
 *
 */
@Service
public class BasCAPEXProjectServiceImpl implements IBasCAPEXProjectService {

    @Autowired
    private IBasCAPEXProjectRepository iBasCAPEXProjectRepository;

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


}