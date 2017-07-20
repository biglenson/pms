package com.zq.service.Impl.basic.capex;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.capex.IBasCAPEXInvestPlanRepository;
import com.zq.dao.basic.capex.IBasCAPEXProjInvestplanRepository;
import com.zq.dao.basic.capex.IBasCAPEXProjectRepository;
import com.zq.entity.basic.capex.BasCAPEXExpendplan;
import com.zq.entity.basic.capex.BasCAPEXInvestPlan;
import com.zq.entity.basic.capex.BasCAPEXProjInvestplan;
import com.zq.entity.basic.capex.BasCAPEXProject;
import com.zq.service.basic.capex.IBasCAPEXProjInvestplanService;
import com.zq.vo.basic.capex.BasCAPEXExpendplanVO;
import com.zq.vo.basic.capex.BasCAPEXProjInvestplanVO;

/**
 *
 * BasCAPEXProjInvestplan 表数据服务层接口实现类
 *
 */
@Service
public class BasCAPEXProjInvestplanImpl implements IBasCAPEXProjInvestplanService {

    @Autowired
    private IBasCAPEXProjInvestplanRepository iBasCAPEXProjInvestplanRepository;    
    @Autowired
    private IBasCAPEXProjectRepository iBasCAPEXProjectRepository;       
    @Autowired
    private IBasCAPEXInvestPlanRepository iBasCAPEXInvestPlanRepository;

	@Override
	public Page<BasCAPEXProjInvestplan> getBasCAPEXProjInvestplan(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasCAPEXProjInvestplanRepository.findAll(request);
	}

	@Override
	public List<BasCAPEXProjInvestplanVO> getBasCAPEXProjInvestplanVOList(List<BasCAPEXProjInvestplan> content) {
		List<BasCAPEXProjInvestplanVO> voList = new ArrayList<>();		
		for(BasCAPEXProjInvestplan po:content){
			BasCAPEXProjInvestplanVO vo = new BasCAPEXProjInvestplanVO();
			BeanUtils.copyProperties(po, vo);			
			BasCAPEXProject proj = iBasCAPEXProjectRepository.findById(Integer.parseInt(po.getProjCode()));
			BasCAPEXInvestPlan inspl = iBasCAPEXInvestPlanRepository.findById(Integer.parseInt(po.getInvestPlanCode()));
			String projName = proj.getProjName();
			String projCode = proj.getProjCode();
			String investPlanProjName = inspl.getProjName();
			String investPlanCode = inspl.getProjCode();
			String year = inspl.getYear();
			int firstDomain = inspl.getFirstDomain();//枚举值
			int attribute = inspl.getAttribute();//枚举值
			if(projCode==null||projCode.equals("")){
				vo.setProjCode("未录入编码");
			}else{
				vo.setProjCode(projCode);
			}
			if(projName==null||projName.equals("")){
				vo.setProjName("未录入名称");
			}else{
				vo.setProjName(projName);
			}
			if(investPlanCode==null||investPlanCode.equals("")){
				vo.setInvestPlanCode("未录入编码");
			}else{
				vo.setInvestPlanCode(investPlanCode);
			}
			if(investPlanProjName==null||investPlanProjName.equals("")){
				vo.setInvestPlanProjName("未录入名称");
			}else{
				vo.setInvestPlanProjName(investPlanProjName);
			}
			if(year==null||year.equals("")){
				vo.setYear("未录入年");
			}else{
				vo.setYear(year);
			}
			vo.setFirstDomain(String.valueOf(firstDomain));
			vo.setAttribute(String.valueOf(attribute));
			voList.add(vo);
		}
		return voList;
	}
   

}