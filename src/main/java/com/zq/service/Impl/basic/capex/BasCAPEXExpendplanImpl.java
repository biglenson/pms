package com.zq.service.Impl.basic.capex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.commons.utils.TypeUtils;
import com.zq.dao.basic.capex.IBasCAPEXExpendplanRepository;
import com.zq.entity.basic.capex.BasCAPEXExpendplan;
import com.zq.service.basic.capex.IBasCAPEXExpendplanService;

/**
 *
 * BasCAPEXExpendplan 表数据服务层接口实现类
 *
 */
@Service
public class BasCAPEXExpendplanImpl implements IBasCAPEXExpendplanService {

	@Autowired
	private IBasCAPEXExpendplanRepository iBasCAPEXExpendplanRepository;

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

}