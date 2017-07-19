package com.zq.service.basic.opex;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.opex.BasOPEXProject;

/**
 *
 * BasOPEXProject 表数据服务层接口
 *
 */
public interface IBasOPEXProjectService{

	Page<BasOPEXProject> getBasOPEXProject(Integer page, int pageSize);


}