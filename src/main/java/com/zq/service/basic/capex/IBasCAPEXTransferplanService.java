package com.zq.service.basic.capex;

import java.util.List;

import com.zq.entity.basic.capex.BasCAPEXTransferplan;

/**
 *
 * BasCapexTransferplan 表数据服务层接口
 *
 */
public interface IBasCAPEXTransferplanService{

	List<BasCAPEXTransferplan> getAllBasCAPEXTransferplanByYear(int year);

	double getActualByYearAndCAPEXProjCode(int year, String proj_code);


}