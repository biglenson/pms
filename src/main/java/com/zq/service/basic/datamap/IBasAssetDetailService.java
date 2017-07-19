package com.zq.service.basic.datamap;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.datamap.BasAssetDetail;

/**
 *
 * BasAssetDetail 表数据服务层接口
 *
 */
public interface IBasAssetDetailService{

	Page<BasAssetDetail> getBasAssetDetail(Integer page, int pageSize);


}