package com.zq.service.basic.purchase;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.purchase.BasFrameContract;

/**
 *
 * BasFrameContract 表数据服务层接口
 *
 */
public interface IBasFrameContractService{

	Page<BasFrameContract> getBasFrameContract(Integer page, int pageSize);

	HttpServletRequest getTotalMoneyFromBasFrame(HttpServletRequest request);


}