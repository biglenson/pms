package com.zq.service.basic.capex;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.capex.BasCAPEXProjInvestplan;

/**
 *
 * BasCapexProjInvestplan 表数据服务层接口
 *
 */
public interface IBasCAPEXProjInvestplanService{

	Page<BasCAPEXProjInvestplan> getBasCAPEXProjInvestplan(Integer page, int pageSize);

	BasCAPEXProjInvestplan getBasCAPEXProjInvestplanByProjCode(String projCode);


}