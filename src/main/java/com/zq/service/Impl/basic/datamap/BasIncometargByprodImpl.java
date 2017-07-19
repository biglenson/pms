package com.zq.service.Impl.basic.datamap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.datamap.IBasIncometargByprodRepository;
import com.zq.entity.basic.datamap.BasIncometargByprod;
import com.zq.service.basic.datamap.IBasIncometargByprodService;

/**
 *
 * BasIncometargByprod 表数据服务层接口实现类
 *
 */
@Service
public class BasIncometargByprodImpl implements IBasIncometargByprodService {
	@Autowired
	IBasIncometargByprodRepository iBasIncometargByprodRepository;
	@Override
	public Page<BasIncometargByprod> getBasIncometargByprod(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasIncometargByprodRepository.findAll(request);
	}

}