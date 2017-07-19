package com.zq.service.Impl.basic.datamap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.datamap.IBasProductRepository;
import com.zq.entity.basic.datamap.BasProduct;
import com.zq.service.basic.datamap.IBasProductService;

/**
 *
 * BasProduct 表数据服务层接口实现类
 *
 */
@Service
public class BasProductImpl implements IBasProductService {

	@Autowired
	IBasProductRepository iBasProductRepository;
	@Override
	public Page<BasProduct> getBasProduct(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasProductRepository.findAll(request);
	}

}