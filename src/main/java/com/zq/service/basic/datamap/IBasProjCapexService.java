package com.zq.service.basic.datamap;

import java.util.List;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.datamap.BasProjCapex;
import com.zq.vo.basic.datamap.BasProjCapexVO;

/**
 *
 * BasProjCapex 表数据服务层接口
 *
 */
public interface IBasProjCapexService{

	Page<BasProjCapex> getBasProjCapex(Integer page, int pageSize);

	List<BasProjCapexVO> getBasProjCapexVOList(List<BasProjCapex> content);


}