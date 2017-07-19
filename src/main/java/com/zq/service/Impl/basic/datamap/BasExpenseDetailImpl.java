package com.zq.service.Impl.basic.datamap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.datamap.IBasExpenseDetailRepository;
import com.zq.entity.basic.datamap.BasExpenseDetail;
import com.zq.service.basic.datamap.IBasExpenseDetailService;

/**
 *
 * BasExpenseDetail 表数据服务层接口实现类
 *
 */
@Service
public class BasExpenseDetailImpl implements IBasExpenseDetailService {

	@Autowired
	IBasExpenseDetailRepository iBasExpenseDetailRepository;
	@Override
	public Page<BasExpenseDetail> getBasExpenseDetail(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasExpenseDetailRepository.findAll(request);
	}

}