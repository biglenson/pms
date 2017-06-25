package com.zq.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.zq.entity.SysMenu;


/** 
* @ClassName: SysMenuRepository 
* @Description: TODO(系统菜单Dao) 
* @author shujukuss 
* @date 2017年6月18日 下午7:06:30z 
*  
*/

public interface ISysMenuRepository extends JpaRepository<SysMenu, Long> {	

}
