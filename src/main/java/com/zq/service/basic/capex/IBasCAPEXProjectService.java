package com.zq.service.basic.capex;

import java.util.List;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.capex.BasCAPEXProject;

/**
 *
 * BasCapexProject 表数据服务层接口
 *
 */
public interface IBasCAPEXProjectService{

	List<BasCAPEXProject> getALLCAPEXProject();

	BasCAPEXProject getCAPEXProject();

	List<BasCAPEXProject> getBasCAPEXProjectByYear(String year);

	Page<BasCAPEXProject> getBasCAPEXProject(Integer page, int pageSize);
}