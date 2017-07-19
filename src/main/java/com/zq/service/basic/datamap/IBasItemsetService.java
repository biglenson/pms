package com.zq.service.basic.datamap;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.datamap.BasItemset;

/**
 *
 * BasItemset 表数据服务层接口
 *
 */
public interface IBasItemsetService{

	Page<BasItemset> getBasItemset(Integer page, int pageSize);


}