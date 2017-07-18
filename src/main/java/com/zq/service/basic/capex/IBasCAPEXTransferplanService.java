package com.zq.service.basic.capex;

import java.util.List;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.capex.BasCAPEXTransferplan;

/**
 *
 * BasCapexTransferplan 表数据服务层接口
 *
 */
public interface IBasCAPEXTransferplanService{

	List<BasCAPEXTransferplan> getAllBasCAPEXTransferplanByYear(String year);

	double getActualByYearAndCAPEXProjCode(String year, String proj_code);

	List<BasCAPEXTransferplan> getAllBasCAPEXTransferplan();

	Page<BasCAPEXTransferplan> getBasCAPEXTransferplan(Integer page, int pageSize);


}