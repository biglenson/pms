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
		double a =TypeUtils.string2Double(capexPlan.getJanActual());
		double b=TypeUtils.string2Double(capexPlan.getFebActual());
		double c=TypeUtils.string2Double(capexPlan.getMarActual());
		double d=TypeUtils.string2Double(capexPlan.getAprActual());
		double e=TypeUtils.string2Double(capexPlan.getMayActual());
		double f=TypeUtils.string2Double(capexPlan.getJunActual());
		double g=TypeUtils.string2Double(capexPlan.getJulActual());
		double h=TypeUtils.string2Double(capexPlan.getAugActual());
		double i=TypeUtils.string2Double(capexPlan.getSepActual());
		double j=TypeUtils.string2Double(capexPlan.getOctActual());
		double k=TypeUtils.string2Double(capexPlan.getNovActual());
		double l=TypeUtils.string2Double(capexPlan.getDecActual());
		return  a+b+c+d+e+f+g+h+i+j+k+l;
	}

	@Override
	public List<BasCAPEXExpendplan> getAllCAPEXExpendplan() {
		
		return iBasCAPEXExpendplanRepository.findAll();
	}

}