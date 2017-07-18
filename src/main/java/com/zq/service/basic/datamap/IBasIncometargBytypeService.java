package com.zq.service.basic.datamap;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.datamap.BasIncometargBytype;

/**
 *
 * BasIncometargBytype 表数据服务层接口
 *
 */
public interface IBasIncometargBytypeService{

	Page<BasIncometargBytype> getBasIncometargBytype(Integer page, int pageSize);


}