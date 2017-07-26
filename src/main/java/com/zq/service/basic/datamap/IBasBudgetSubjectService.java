package com.zq.service.basic.datamap;

import java.util.List;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.datamap.BasBudgetSubject;
import com.zq.vo.basic.datamap.BasBudgetSubjectVO;

/**
 *
 * BasBudgetSubject 表数据服务层接口
 *
 */
public interface IBasBudgetSubjectService{

	Page<BasBudgetSubject> getBasBudgetSubject(Integer page, int pageSize);

	List<BasBudgetSubjectVO> getBasBudgetSubjectVOList(List<BasBudgetSubject> content);


}