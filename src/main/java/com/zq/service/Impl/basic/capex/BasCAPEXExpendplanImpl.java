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
		return Double.parseDouble(capexPlan.getJan_actual()) + Double.parseDouble(capexPlan.getFeb_actual()) + Double.parseDouble(capexPlan.getMar_actual())
				+ Double.parseDouble(capexPlan.getApr_actual()) + Double.parseDouble(capexPlan.getMay_actual()) + Double.parseDouble(capexPlan.getJun_actual())
				+ Double.parseDouble(capexPlan.getJul_actual()) + Double.parseDouble(capexPlan.getAug_actual()) + Double.parseDouble(capexPlan.getSep_actual())
				+ Double.parseDouble(capexPlan.getOct_actual()) + Double.parseDouble(capexPlan.getNov_actual()) + Double.parseDouble(capexPlan.getDec_actual());
	}

}