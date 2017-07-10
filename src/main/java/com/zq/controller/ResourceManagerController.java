package com.zq.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zq.commons.utils.CMCCConstant;


/** 
* @ClassName: ResourceManagerController 
* @Description: TODO(权限管理视图) 
* @author shujukuss 
* @date 2017年6月18日 下午7:05:04 
*  
*/
@Controller
@RequestMapping("/resourcemanager/")
public class ResourceManagerController extends BaseController{
	
	private static Logger logger = Logger.getLogger(ResourceManagerController.class);	
	
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
		
		request = setLeftMenu(request,"/resourcemanager/department");
		return CMCCConstant.Department;	
	}
	
	/** 
	* @Title: user 
	* @Description: TODO(用户) 
	* @author shujukuss 
	* @date 2017年7月10日 上午9:39:52 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "user")
    public String user(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/resourcemanager/user");
		return CMCCConstant.User;	
	}
	
	/** 
	* @Title: role 
	* @Description: TODO(角色) 
	* @author shujukuss 
	* @date 2017年7月10日 上午9:39:56 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "role")
    public String role(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/resourcemanager/role");
		return CMCCConstant.Role;	
	}
	
	/** 
	* @Title: resource 
	* @Description: TODO(权限) 
	* @author shujukuss 
	* @date 2017年7月10日 上午9:40:00 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "resource")
    public String resource(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/resourcemanager/resource");
		return CMCCConstant.Resource;	
	}
}
