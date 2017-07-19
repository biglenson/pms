package com.zq.service.basic.datamap;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.datamap.BasBudgetSubject;

/**
 *
 * BasBudgetSubject 表数据服务层接口
 *
 */
public interface IBasBudgetSubjectService{

	Page<BasBudgetSubject> getBasBudgetSubject(Integer page, int pageSize);


}