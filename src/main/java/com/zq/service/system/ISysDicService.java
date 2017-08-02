package com.zq.service.system;


/**
 *
 * SysDic 表数据服务层接口
 *
 */
public interface ISysDicService{

	String getNameByClasscodeAndCode(String classcode, Integer code);

}