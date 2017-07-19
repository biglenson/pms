package com.zq.service.basic.datamap;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.datamap.BasIncometargByprod;

/**
 *
 * BasIncometargByprod 表数据服务层接口
 *
 */
public interface IBasIncometargByprodService{

	Page<BasIncometargByprod> getBasIncometargByprod(Integer page, int pageSize);


}