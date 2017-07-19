package com.zq.service.basic.datamap;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.datamap.BasIncometargBydept;

/**
 *
 * BasIncometargBydept 表数据服务层接口
 *
 */
public interface IBasIncometargBydeptService{

	Page<BasIncometargBydept> getBasIncometargBydept(Integer page, int pageSize);


}