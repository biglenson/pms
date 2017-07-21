package com.zq.service.Impl.basic.capex;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.commons.utils.TypeUtils;
import com.zq.dao.basic.capex.IBasCAPEXExpendplanRepository;
import com.zq.dao.basic.capex.IBasCAPEXProjectRepository;
import com.zq.entity.basic.capex.BasCAPEXExpendplan;
import com.zq.entity.basic.capex.BasCAPEXProject;
import com.zq.service.basic.capex.IBasCAPEXExpendplanService;
import com.zq.vo.basic.capex.BasCAPEXExpendplanVO;

/**
 *
 * BasCAPEXExpendplan 表数据服务层接口实现类
 *
 */
@Service
public class BasCAPEXExpendplanImpl implements IBasCAPEXExpendplanService {

	@Autowired
	private IBasCAPEXExpendplanRepository iBasCAPEXExpendplanRepository;
	@Autowired
	private IBasCAPEXProjectRepository iBasCAPEXProjectRepository;
	@Override
	public List<BasCAPEXExpendplan> getAllCAPEXExpendplanByYear(String year) {

		return iBasCAPEXExpendplanRepository.findByYear(year);
	}

	@Override
	public double getActualByYearAndCAPEXProjCode(String year, String proj_code) {
		BasCAPEXExpendplan capexPlan = iBasCAPEXExpendplanRepository.findByYearAndProjCode(year,proj_code);
		return TypeUtils.string2Double(capexPlan.getJanActual()) + TypeUtils.string2Double(capexPlan.getFebActual()) + TypeUtils.string2Double(capexPlan.getMarActual())
		+ TypeUtils.string2Double(capexPlan.getAprActual()) + TypeUtils.string2Double(capexPlan.getMayActual()) + TypeUtils.string2Double(capexPlan.getJunActual())
		+ TypeUtils.string2Double(capexPlan.getJulActual()) + TypeUtils.string2Double(capexPlan.getAugActual()) + TypeUtils.string2Double(capexPlan.getSepActual())
		+ TypeUtils.string2Double(capexPlan.getOctActual()) + TypeUtils.string2Double(capexPlan.getNovActual()) + TypeUtils.string2Double(capexPlan.getDecActual());

	}

	@Override
	public List<BasCAPEXExpendplan> getAllCAPEXExpendplan() {
		
		return iBasCAPEXExpendplanRepository.findAll();
	}

	@Override
	public Page<BasCAPEXExpendplan> getBasCAPEXExpendplan(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasCAPEXExpendplanRepository.findAll(request);
	}

	@Override
	public List<BasCAPEXExpendplanVO> getBasCAPEXExpendplanVOList(List<BasCAPEXExpendplan> content) {
		List<BasCAPEXExpendplanVO> voList = new ArrayList<>();		
		for(BasCAPEXExpendplan po:content){
			BasCAPEXExpendplanVO vo = new BasCAPEXExpendplanVO();
			BeanUtils.copyProperties(po, vo);			
			BasCAPEXProject proj = iBasCAPEXProjectRepository.findById(Integer.parseInt(po.getProjCode()));
			String projName = proj.getProjName();
			String projCode = proj.getProjCode();
			String anualCapexPlan = proj.getAnualCapexPlan();
			int capexPlanStatus = proj.getCapexPlanStatus();
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
			if(anualCapexPlan==null||anualCapexPlan.equals("")){
				vo.setAnualCapexPlan("未录入");
			}else{
				vo.setAnualCapexPlan(anualCapexPlan);
			}
			vo.setCapexPlanStatus(String.valueOf(capexPlanStatus));
			voList.add(vo);
		}
		return voList;
	}

}