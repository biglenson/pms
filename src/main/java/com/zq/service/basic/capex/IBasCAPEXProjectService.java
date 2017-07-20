package com.zq.service.basic.capex;

import java.util.List;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.capex.BasCAPEXProject;
import com.zq.vo.basic.capex.BasCAPEXProjectVO;

/**
 *
 * BasCapexProject 表数据服务层接口
 *
 */
public interface IBasCAPEXProjectService{

	List<BasCAPEXProject> getALLCAPEXProject();

	BasCAPEXProject getCAPEXProject();

	List<BasCAPEXProject> getBasCAPEXProjectByYear(String year);

	public int getCurrentPhase(BasCAPEXProject capexProject) throws Exception;

	Page<BasCAPEXProject> getBasCAPEXProject(Integer page, int pageSize);

	List<BasCAPEXProjectVO> getBasCAPEXProjectVOList(List<BasCAPEXProject> content);
}