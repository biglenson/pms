package com.zq.service.system;

import java.util.List;

import com.zq.entity.system.SysForm;

/**
 *
 * SysLog 表数据服务层接口
 *
 */
public interface ISysFormService{

	List<SysForm> findByForm(String form);


}