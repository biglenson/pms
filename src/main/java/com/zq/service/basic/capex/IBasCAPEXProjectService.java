package com.zq.service.basic.capex;

import java.util.List;

import com.zq.entity.basic.capex.BasCAPEXProject;

/**
 *
 * BasCapexProject 表数据服务层接口
 *
 */
public interface IBasCAPEXProjectService{

	List<BasCAPEXProject> getALLCAPEXProject();

	BasCAPEXProject getCAPEXProject();
}