package com.zq.service.Impl.basic.datamap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.datamap.IBasProjCapexRepository;
import com.zq.entity.basic.datamap.BasProjCapex;
import com.zq.service.basic.datamap.IBasProjCapexService;

/**
 *
 * BasProjCapex 表数据服务层接口实现类
 *
 */
@Service
public class BasProjCapexImpl implements IBasProjCapexService {

	@Autowired
	IBasProjCapexRepository iBasProjCapexRepository;
	@Override
	public Page<BasProjCapex> getBasProjCapex(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasProjCapexRepository.findAll(request);
	}

}