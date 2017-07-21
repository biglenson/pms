package com.zq.service.basic.datamap;

import java.util.List;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.datamap.BasExpenseDetail;
import com.zq.vo.basic.datamap.BasExpenseDetailVO;

/**
 *
 * BasExpenseDetail 表数据服务层接口
 *
 */
public interface IBasExpenseDetailService{

	Page<BasExpenseDetail> getBasExpenseDetail(Integer page, int pageSize);

	List<BasExpenseDetailVO> getBasExpenseDetailVOList(List<BasExpenseDetail> content);


}