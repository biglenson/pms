package com.zq.service.basic.capex;

import java.util.List;

import org.springframework.data.domain.Page;

import com.zq.commons.result.PageInfo;
import com.zq.entity.basic.capex.BasCAPEXTransferplan;
import com.zq.vo.basic.capex.BasCAPEXTransferplanVO;

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

	Page<BasCAPEXTransferplan> getCAPEXTransferplanByPageAndYear(int currentPage, int pageSize, String year);


	List<BasCAPEXTransferplanVO> getBasCAPEXTransferplanVOList(List<BasCAPEXTransferplan> content);


}