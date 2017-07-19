package com.zq.service.basic.datamap;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.datamap.BasCustomer;

/**
 *
 * BasCustomer 表数据服务层接口
 *
 */
public interface IBasCustomerService{

	Page<BasCustomer> getBasCustomer(Integer page, int pageSize);


}