package com.zq.service.system;

import java.util.List;

import com.zq.entity.system.SysDic;

/**
 *
 * SysDic 表数据服务层接口
 *
 */
public interface ISysDicService{

	List<SysDic> getAllSysDicListByClass(String string);
	
	String getNameByClasscodeAndCode(String classcode, Integer code);

}