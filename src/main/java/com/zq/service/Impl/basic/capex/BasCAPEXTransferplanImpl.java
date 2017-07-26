package com.zq.service.Impl.basic.capex;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.zq.commons.result.PageInfo;
import com.zq.commons.utils.TypeUtils;
import com.zq.dao.basic.capex.IBasCAPEXProjectRepository;
import com.zq.dao.basic.capex.IBasCAPEXTransferplanRepository;
import com.zq.entity.basic.capex.BasCAPEXProject;
import com.zq.entity.basic.capex.BasCAPEXTransferplan;
import com.zq.service.basic.capex.IBasCAPEXTransferplanService;
import com.zq.vo.basic.capex.BasCAPEXTransferplanVO;

/**
 *
 * BasCAPEXTransferplan 表数据服务层接口实现类
 *
 */
@Service
public class BasCAPEXTransferplanImpl implements IBasCAPEXTransferplanService {

    @Autowired
    private IBasCAPEXTransferplanRepository iBasCAPEXTransferplanRepository;
    @Autowired
    private IBasCAPEXProjectRepository iBasCAPEXProjectRepository;

	@Override
	public List<BasCAPEXTransferplan> getAllBasCAPEXTransferplanByYear(String year) {
		
		return iBasCAPEXTransferplanRepository.findByYear(year);
	}

	@Override
	public double getActualByYearAndCAPEXProjCode(String year, String projCode) {
		BasCAPEXTransferplan capexPlan = iBasCAPEXTransferplanRepository.findByYearAndProjCode(year, projCode);
		return TypeUtils.string2Double(capexPlan.getJanActual()) + TypeUtils.string2Double(capexPlan.getFebActual()) + TypeUtils.string2Double(capexPlan.getMarActual())
		+ TypeUtils.string2Double(capexPlan.getAprActual()) + TypeUtils.string2Double(capexPlan.getMayActual()) + TypeUtils.string2Double(capexPlan.getJunActual())
		+ TypeUtils.string2Double(capexPlan.getJulActual()) + TypeUtils.string2Double(capexPlan.getAugActual()) + TypeUtils.string2Double(capexPlan.getSepActual())
		+ TypeUtils.string2Double(capexPlan.getOctActual()) + TypeUtils.string2Double(capexPlan.getNovActual()) + TypeUtils.string2Double(capexPlan.getDecActual());
	}

	@Override
	public List<BasCAPEXTransferplan> getAllBasCAPEXTransferplan() {
		
		return iBasCAPEXTransferplanRepository.findAll();
	}

	@Override
	public Page<BasCAPEXTransferplan> getBasCAPEXTransferplan(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasCAPEXTransferplanRepository.findAll(request);
	}

	@Override
	public Page<BasCAPEXTransferplan> getCAPEXTransferplanByPageAndYear(int currentPage, int pageSize, String year) {
		Pageable request = new PageRequest(currentPage - 1, pageSize, null);
		return iBasCAPEXTransferplanRepository.findByYear(year,request);
	}
	public List<BasCAPEXTransferplanVO> getBasCAPEXTransferplanVOList(List<BasCAPEXTransferplan> content) {
		List<BasCAPEXTransferplanVO> voList = new ArrayList<>();		
		for(BasCAPEXTransferplan po:content){
			BasCAPEXTransferplanVO vo = new BasCAPEXTransferplanVO();
			BeanUtils.copyProperties(po, vo);			
			BasCAPEXProject proj = iBasCAPEXProjectRepository.findById(Integer.parseInt(po.getProjCode()));
			String projName = proj.getProjName();
			String projCode = proj.getProjCode();
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
			voList.add(vo);
		}
		return voList;
	}
    
   

}