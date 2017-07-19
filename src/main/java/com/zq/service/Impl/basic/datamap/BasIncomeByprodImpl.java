package com.zq.service.Impl.basic.datamap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.datamap.IBasIncomeByprodRepository;
import com.zq.entity.basic.datamap.BasIncomeByprod;
import com.zq.service.basic.datamap.IBasIncomeByprodService;

/**
 *
 * BasIncomeByprod 表数据服务层接口实现类
 *
 */
@Service
public class BasIncomeByprodImpl implements IBasIncomeByprodService {

	@Autowired
	IBasIncomeByprodRepository iBasIncomeByprodRepository;
	@Override
	public Page<BasIncomeByprod> getBasIncomeByprod(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasIncomeByprodRepository.findAll(request);
	}

}