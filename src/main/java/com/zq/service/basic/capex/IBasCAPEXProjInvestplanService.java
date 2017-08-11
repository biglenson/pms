package com.zq.service.basic.capex;

import java.util.List;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.capex.BasCAPEXProjInvestplan;
import com.zq.vo.basic.capex.BasCAPEXProjInvestplanVO;

/**
 *
 * BasCapexProjInvestplan 表数据服务层接口
 *
 */
public interface IBasCAPEXProjInvestplanService{

	Page<BasCAPEXProjInvestplan> getBasCAPEXProjInvestplan(Integer page, int pageSize);


	BasCAPEXProjInvestplan getBasCAPEXProjInvestplanByProjCode(String projCode);


	List<BasCAPEXProjInvestplanVO> getBasCAPEXProjInvestplanVOList(List<BasCAPEXProjInvestplan> content);
}