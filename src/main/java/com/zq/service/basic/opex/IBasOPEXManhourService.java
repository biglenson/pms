package com.zq.service.basic.opex;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.opex.BasOPEXManhour;

/**
 *
 * BasOPEXManhour 表数据服务层接口
 *
 */
public interface IBasOPEXManhourService{

	Page<BasOPEXManhour> getBasOPEXManhour(Integer page, int pageSize);


}