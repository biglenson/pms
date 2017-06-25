package com.zq.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zq.dao.ISysMenuRepository;
import com.zq.entity.SysMenu;
import com.zq.service.SysMenuService;

/** 
* @ClassName: SysMenuServiceImpl 
* @Description: TODO(系统菜单实现) 
* @author shujukuss 
* @date 2017年6月18日 下午7:07:32 
*  
*/
@Service
public class SysMenuServiceImpl implements SysMenuService{
	@Autowired
	ISysMenuRepository iSysMenuRepository;
	
	/* (非 Javadoc) 
	* <p>Title: getAllSysMenu</p> 
	* <p>Description: </p> 
	* @return 
	* @see com.zq.service.SysMenuService#getAllSysMenu() 
	*/
	@Transactional
	public List<SysMenu> getAllSysMenu() {
		Sort sort = new Sort("seqno");
		return (List<SysMenu>) iSysMenuRepository.findAll(sort);
	}

}
