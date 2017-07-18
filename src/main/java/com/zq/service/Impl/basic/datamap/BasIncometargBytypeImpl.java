package com.zq.service.Impl.basic.datamap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.datamap.IBasIncometargBytypeRepository;
import com.zq.entity.basic.datamap.BasIncometargBytype;
import com.zq.service.basic.datamap.IBasIncometargBytypeService;

/**
 *
 * BasIncometargBytype 表数据服务层接口实现类
 *
 */
@Service
public class BasIncometargBytypeImpl implements IBasIncometargBytypeService {

	@Autowired
	IBasIncometargBytypeRepository iBasIncometargBytypeRepository;
	@Override
	public Page<BasIncometargBytype> getBasIncometargBytype(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasIncometargBytypeRepository.findAll(request);
	}

}