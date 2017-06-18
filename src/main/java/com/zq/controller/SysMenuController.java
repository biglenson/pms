package com.zq.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zq.Util.CMCCConstant;


/** 
* @ClassName: SysMenuController 
* @Description: TODO(系统菜单) 
* @author shujukuss 
* @date 2017年6月18日 下午7:06:02 
*  
*/
@Controller
@RequestMapping("/")
public class SysMenuController {
	
	private static Logger logger = Logger.getLogger(SysMenuController.class);  
	/** 
	* @Title: generalGRUDForm 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @author shujukuss 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "generalGRUDform", method = RequestMethod.GET)
	public String generalGRUDForm() {
		return CMCCConstant.GeneralGRUDForm;
	}
}
