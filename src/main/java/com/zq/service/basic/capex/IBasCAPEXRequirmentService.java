package com.zq.service.basic.capex;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.capex.BasCAPEXRequirment;

/**
 *
 * BasCapexRequirment 表数据服务层接口
 *
 */
public interface IBasCAPEXRequirmentService{

	Page<BasCAPEXRequirment> getBasCAPEXRequirment(Integer page, int pageSize);


}