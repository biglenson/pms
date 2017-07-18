package com.zq.service.Impl.basic.datamap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.datamap.IBasAccountSubjectRepository;
import com.zq.entity.basic.datamap.BasAccountSubject;
import com.zq.service.basic.datamap.IBasAccountSubjectService;

/**
 *
 * BasAccountSubject 表数据服务层接口实现类
 *
 */
@Service
public class BasAccountSubjectImpl implements IBasAccountSubjectService {

	@Autowired
	IBasAccountSubjectRepository iBasAccountSubjectRepository;
	@Override
	public Page<BasAccountSubject> getBasAccountSubject(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasAccountSubjectRepository.findAll(request);
	}

}