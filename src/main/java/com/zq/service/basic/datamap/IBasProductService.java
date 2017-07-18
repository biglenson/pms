package com.zq.service.basic.datamap;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.datamap.BasProduct;

/**
 *
 * BasProduct 表数据服务层接口
 *
 */
public interface IBasProductService{

	Page<BasProduct> getBasProduct(Integer page, int pageSize);


}