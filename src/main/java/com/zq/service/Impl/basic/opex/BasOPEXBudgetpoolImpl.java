package com.zq.service.Impl.basic.opex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.opex.IBasOPEXBudgetpoolRepository;
import com.zq.entity.basic.opex.BasOPEXBudgetpool;
import com.zq.service.basic.opex.IBasOPEXBudgetpoolService;

/**
 *
 * BasOPEXBudgetpool 表数据服务层接口实现类
 *
 */
@Service
public class BasOPEXBudgetpoolImpl implements IBasOPEXBudgetpoolService {

    @Autowired
    private IBasOPEXBudgetpoolRepository iBasOPEXBudgetpoolRepository;

	@Override
	public Page<BasOPEXBudgetpool> getBasOPEXBudgetpool(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasOPEXBudgetpoolRepository.findAll(request);
	}
    
   

}