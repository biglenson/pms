package com.zq.service.Impl.basic.datamap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.datamap.IBasProductIncomeRepository;
import com.zq.entity.basic.datamap.BasProductIncome;
import com.zq.service.basic.datamap.IBasProductIncomeService;

/**
 *
 * BasProductIncome 表数据服务层接口实现类
 *
 */
@Service
public class BasProductIncomeImpl implements IBasProductIncomeService {

	@Autowired
	IBasProductIncomeRepository iBasProductIncomeRepository;
	@Override
	public Page<BasProductIncome> getBasProductIncome(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasProductIncomeRepository.findAll(request);
	}

}