package com.zq.service.basic.purchase;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.purchase.BasOtherContract;

/**
 *
 * BasOtherContract 表数据服务层接口
 *
 */
public interface IBasOtherContractService{

	Page<BasOtherContract> getBasOtherContract(Integer page, int pageSize);


}