package com.zq.service.Impl.basic.datamap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.datamap.IBasItemProdCustRepository;
import com.zq.entity.basic.datamap.BasItemProdCust;
import com.zq.service.basic.datamap.IBasItemProdCustService;

/**
 *
 * BasItemProdCust 表数据服务层接口实现类
 *
 */
@Service
public class BasItemProdCustImpl implements IBasItemProdCustService {

	@Autowired
	IBasItemProdCustRepository iBasItemProdCustRepository;
	@Override
	public Page<BasItemProdCust> getBasItemProdCust(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasItemProdCustRepository.findAll(request);
	}

}