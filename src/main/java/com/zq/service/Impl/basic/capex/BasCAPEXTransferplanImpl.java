package com.zq.service.Impl.basic.capex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<BasCAPEXTransferplan> getAllBasCAPEXTransferplanByYear(int year) {
		
		return iBasCAPEXTransferplanRepository.findByYear(year);
	}

	@Override
	public double getActualByYearAndCAPEXProjCode(int year, String projCode) {
		BasCAPEXTransferplan capexPlan = iBasCAPEXTransferplanRepository.findByYearAndProjCode(year, projCode);
		return Double.parseDouble(capexPlan.getJanActual()) + Double.parseDouble(capexPlan.getFebActual()) + Double.parseDouble(capexPlan.getMarActual())
				+ Double.parseDouble(capexPlan.getAprActual()) + Double.parseDouble(capexPlan.getMayActual()) + Double.parseDouble(capexPlan.getJunActual())
				+ Double.parseDouble(capexPlan.getJulActual()) + Double.parseDouble(capexPlan.getAugActual()) + Double.parseDouble(capexPlan.getSepActual())
				+ Double.parseDouble(capexPlan.getOctActual()) + Double.parseDouble(capexPlan.getNovActual()) + Double.parseDouble(capexPlan.getDecActual());
	}
    
   

}