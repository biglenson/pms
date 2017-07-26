package com.zq.service.basic.datamap;

import java.util.List;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.datamap.BasAssetDetail;
import com.zq.vo.basic.datamap.BasAssetDetailVO;

/**
 *
 * BasAssetDetail 表数据服务层接口
 *
 */
public interface IBasAssetDetailService{

	Page<BasAssetDetail> getBasAssetDetail(Integer page, int pageSize);

	List<BasAssetDetailVO> getBasAssetDetailVOList(List<BasAssetDetail> content);


}