package com.zq.service.basic.opex;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.opex.BasOPEXBudgetProject;

/**
 *
 * BasOPEXBudgetProject 表数据服务层接口
 *
 */
public interface IBasOPEXBudgetProjectService{

	Page<BasOPEXBudgetProject> getBasOPEXBudgetProject(Integer page, int pageSize);


}