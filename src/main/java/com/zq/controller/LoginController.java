package com.zq.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.zq.Util.CMCCConstant;
import com.zq.entity.SysMenu;
import com.zq.service.SysMenuService;


/** 
* @ClassName: LoginController 
* @Description: TODO(登陆) 
* @author shujukuss 
* @date 2017年6月18日 下午7:01:35 
*  
*/
@Controller
public class LoginController {
	
	private static Logger logger = Logger.getLogger(LoginController.class);  
	
	@Autowired
	SysMenuService sysMenuService;	

	/** 
	* @Title: index 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @author shujukuss 
	* @param @param model
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {

		List<SysMenu> sysMenu = sysMenuService.getAllSysMenu();
		model.addAttribute("topMenu", sysMenu);
		logger.info(sysMenu.get(0).getName());
		return CMCCConstant.CVDashBoard;
	}

}
