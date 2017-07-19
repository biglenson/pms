package com.zq.service.Impl.basic.datamap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.datamap.IBasBudgetSubjectRepository;
import com.zq.entity.basic.datamap.BasBudgetSubject;
import com.zq.service.basic.datamap.IBasBudgetSubjectService;

/**
 *
 * BasBudgetSubject 表数据服务层接口实现类
 *
 */
@Service
public class BasBudgetSubjectImpl implements IBasBudgetSubjectService {

	@Autowired
	IBasBudgetSubjectRepository iBasBudgetSubjectRepository;
	@Override
	public Page<BasBudgetSubject> getBasBudgetSubject(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasBudgetSubjectRepository.findAll(request);
	}

}