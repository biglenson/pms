package com.zq.service.Impl.basic.datamap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.datamap.IBasCustomerRepository;
import com.zq.entity.basic.datamap.BasCustomer;
import com.zq.service.basic.datamap.IBasCustomerService;

/**
 *
 * BasCustomer 表数据服务层接口实现类
 *
 */
@Service
public class BasCustomerImpl implements IBasCustomerService {

	@Autowired
	IBasCustomerRepository iBasCustomerRepository;
	@Override
	public Page<BasCustomer> getBasCustomer(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasCustomerRepository.findAll(request);
	}

}