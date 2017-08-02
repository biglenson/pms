package com.zq.service.system;

import java.util.List;

import com.zq.entity.system.SysDic;

/**
 *
 * SysDic 表数据服务层接口
 *
 */
public interface ISysDicService{

	String getNameByClassAndCode(String string, Integer category);

	List<SysDic> getAllSysDicListByClass(String string);

}