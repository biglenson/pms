package com.zq.service.basic.datamap;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.datamap.BasProjCapex;

/**
 *
 * BasProjCapex 表数据服务层接口
 *
 */
public interface IBasProjCapexService{

	Page<BasProjCapex> getBasProjCapex(Integer page, int pageSize);


}