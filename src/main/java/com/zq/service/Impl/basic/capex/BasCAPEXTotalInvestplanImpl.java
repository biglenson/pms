package com.zq.service.Impl.basic.capex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.capex.IBasCAPEXTotalInvestplanRepository;
import com.zq.entity.basic.capex.BasCAPEXTotalInvestplan;
import com.zq.service.basic.capex.IBasCAPEXTotalInvestplanService;

/**
 *
 * BasCAPEXTotalInvestplan 表数据服务层接口实现类
 *
 */
@Service
public class BasCAPEXTotalInvestplanImpl implements IBasCAPEXTotalInvestplanService {

    @Autowired
    private IBasCAPEXTotalInvestplanRepository iBasCAPEXTotalInvestplanRepository;

	@Override
	public List<BasCAPEXTotalInvestplan> getAllCAPEXTotalInvestplanByYear(String year) {
		
		return iBasCAPEXTotalInvestplanRepository.findByAnnual(Integer.parseInt(year));
	}

	@Override
	public Page<BasCAPEXTotalInvestplan> getBasCAPEXTotalInvestplan(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasCAPEXTotalInvestplanRepository.findAll(request);
	}
    
   

}