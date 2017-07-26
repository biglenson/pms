package com.zq.service.basic.capex;

import java.util.List;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.capex.BasCAPEXExpendplan;
import com.zq.vo.basic.capex.BasCAPEXExpendplanVO;

/**
 *
 * BasCapexExpendplan 表数据服务层接口
 *
 */
public interface IBasCAPEXExpendplanService{

	List<BasCAPEXExpendplan> getAllCAPEXExpendplanByYear(String year);

	double getActualByYearAndCAPEXProjCode(String year, String projCode);

	List<BasCAPEXExpendplan> getAllCAPEXExpendplan();

	Page<BasCAPEXExpendplan> getBasCAPEXExpendplan(Integer page, int pageSize);

	List<BasCAPEXExpendplanVO> getBasCAPEXExpendplanVOList(List<BasCAPEXExpendplan> content);



}