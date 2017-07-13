package com.zq.service.basic.capex;

import java.util.List;

import com.zq.entity.basic.capex.BasCAPEXExpendplan;

/**
 *
 * BasCapexExpendplan 表数据服务层接口
 *
 */
public interface IBasCAPEXExpendplanService{

	List<BasCAPEXExpendplan> getAllCAPEXExpendplanByYear(int year);

	double getActualByYearAndCAPEXProjCode(int year, String proj_code);



}