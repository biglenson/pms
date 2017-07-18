package com.zq.service.basic.datamap;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.datamap.BasAccountSubject;

/**
 *
 * BasAccountSubject 表数据服务层接口
 *
 */
public interface IBasAccountSubjectService{

	Page<BasAccountSubject> getBasAccountSubject(Integer page, int pageSize);


}