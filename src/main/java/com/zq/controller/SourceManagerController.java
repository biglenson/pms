package com.zq.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zq.commons.utils.CMCCConstant;


/** 
* @ClassName: SourceManagerController 
* @Description: TODO(权限管理视图) 
* @author shujukuss 
* @date 2017年6月18日 下午7:05:04 
*  
*/
@Controller
@RequestMapping("/sourcemanager/")
public class SourceManagerController extends BaseController{
	
	private static Logger logger = Logger.getLogger(SourceManagerController.class);	
	
	/** 
	* @Title: department 
	* @Description: TODO(部门) 
	* @author shujukuss 
	* @date 2017年7月9日 下午2:57:57 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "department")
    public String department(HttpServletRequest request) {
		return CMCCConstant.Department;	
	}
}
