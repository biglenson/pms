package com.zq.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zq.entity.SysMenu;

/** 
* @ClassName: SysMenuService 
* @Description: TODO(系统菜单服务接口) 
* @author shujukuss 
* @date 2017年6月18日 下午7:07:08 
*  
*/
public interface SysMenuService {

	/** 
	* @Title: getAllSysMenu 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @author shujukuss 
	* @param @return    设定文件 
	* @return List<SysMenu>    返回类型 
	* @throws 
	*/
	public List<SysMenu> getAllSysMenu();	

}
