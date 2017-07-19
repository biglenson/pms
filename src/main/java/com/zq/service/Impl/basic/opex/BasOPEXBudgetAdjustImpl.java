package com.zq.service.Impl.basic.opex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.opex.IBasOPEXBudgetAdjustRepository;
import com.zq.entity.basic.opex.BasOPEXBudgetAdjust;
import com.zq.service.basic.opex.IBasOPEXBudgetAdjustService;

/**
 *
 * BasOPEXBudgetAdjust 表数据服务层接口实现类
 *
 */
@Service
public class BasOPEXBudgetAdjustImpl implements IBasOPEXBudgetAdjustService {

    @Autowired
    private IBasOPEXBudgetAdjustRepository iBasOPEXBudgetAdjustRepository;

	@Override
	public Page<BasOPEXBudgetAdjust> getBasOPEXBudgetAdjust(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasOPEXBudgetAdjustRepository.findAll(request);
	}
    
   

}