package com.zq.service.Impl.basic.capex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.commons.utils.TypeUtils;
import com.zq.dao.basic.capex.IBasCAPEXTransferplanRepository;
import com.zq.entity.basic.capex.BasCAPEXTransferplan;
import com.zq.service.basic.capex.IBasCAPEXTransferplanService;

/**
 *
 * BasCAPEXTransferplan 表数据服务层接口实现类
 *
 */
@Service
public class BasCAPEXTransferplanImpl implements IBasCAPEXTransferplanService {

    @Autowired
    private IBasCAPEXTransferplanRepository iBasCAPEXTransferplanRepository;

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
    
   

}