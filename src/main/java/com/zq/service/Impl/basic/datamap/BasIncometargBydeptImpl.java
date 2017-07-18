package com.zq.service.Impl.basic.datamap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.datamap.IBasIncometargBydeptRepository;
import com.zq.entity.basic.datamap.BasIncometargBydept;
import com.zq.service.basic.datamap.IBasIncometargBydeptService;

/**
 *
 * BasIncometargBydept 表数据服务层接口实现类
 *
 */
@Service
public class BasIncometargBydeptImpl implements IBasIncometargBydeptService {

	@Autowired
	IBasIncometargBydeptRepository iBasIncometargBydeptRepository;
	@Override
	public Page<BasIncometargBydept> getBasIncometargBydept(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasIncometargBydeptRepository.findAll(request);
	}

}