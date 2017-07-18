package com.zq.service.basic.datamap;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.datamap.BasIncomeByprod;

/**
 *
 * BasIncomeByprod 表数据服务层接口
 *
 */
public interface IBasIncomeByprodService{

	Page<BasIncomeByprod> getBasIncomeByprod(Integer page, int pageSize);


}