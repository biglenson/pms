package com.zq.service.Impl.basic.capex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<BasCAPEXExpendplan> getAllCAPEXExpendplanByYear(int year) {

		return iBasCAPEXExpendplanRepository.findByYear(year);
	}

	@Override
	public double getActualByYearAndCAPEXProjCode(int year, String proj_code) {
		BasCAPEXExpendplan capexPlan = iBasCAPEXExpendplanRepository.findByYearAndProjCode();
		return Double.parseDouble(capexPlan.getJanActual()) + Double.parseDouble(capexPlan.getFebActual()) + Double.parseDouble(capexPlan.getMarActual())
				+ Double.parseDouble(capexPlan.getAprActual()) + Double.parseDouble(capexPlan.getMayActual()) + Double.parseDouble(capexPlan.getJunActual())
				+ Double.parseDouble(capexPlan.getJulActual()) + Double.parseDouble(capexPlan.getAugActual()) + Double.parseDouble(capexPlan.getSepActual())
				+ Double.parseDouble(capexPlan.getOctActual()) + Double.parseDouble(capexPlan.getNovActual()) + Double.parseDouble(capexPlan.getDecActual());
	}

}