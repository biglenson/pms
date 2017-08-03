package com.zq.service.basic.capex;

import java.util.List;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.capex.BasCAPEXRequirment;
import com.zq.vo.basic.capex.BasCAPEXRequirmentVO;

/**
 *
 * BasCapexRequirment 表数据服务层接口
 *
 */
public interface IBasCAPEXRequirmentService{

	Page<BasCAPEXRequirment> getBasCAPEXRequirment(Integer page, int pageSize);

	List<BasCAPEXRequirmentVO> getBasCAPEXRequirmentVOList(List<BasCAPEXRequirment> content);


}