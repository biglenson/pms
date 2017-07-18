package com.zq.service.basic.datamap;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.datamap.BasItemProdCust;

/**
 *
 * BasItemProdCust 表数据服务层接口
 *
 */
public interface IBasItemProdCustService{

	Page<BasItemProdCust> getBasItemProdCust(Integer page, int pageSize);


}