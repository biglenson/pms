package com.zq.service.basic.opex;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.opex.BasOPEXRequirment;

/**
 *
 * BasOPEXRequirment 表数据服务层接口
 *
 */
public interface IBasOPEXRequirmentService{

	Page<BasOPEXRequirment> getBasOPEXRequirment(Integer page, int pageSize);


}