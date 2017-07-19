package com.zq.service.Impl.basic.datamap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.datamap.IBasItemsetRepository;
import com.zq.entity.basic.datamap.BasItemset;
import com.zq.service.basic.datamap.IBasItemsetService;

/**
 *
 * BasItemset 表数据服务层接口实现类
 *
 */
@Service
public class BasItemsetImpl implements IBasItemsetService {

	@Autowired
	IBasItemsetRepository iBasItemsetRepository;
	@Override
	public Page<BasItemset> getBasItemset(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasItemsetRepository.findAll(request);
	}

}