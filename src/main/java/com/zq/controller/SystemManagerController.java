package com.zq.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zq.commons.utils.CMCCConstant;


/** 
* @ClassName: SystemManagerController 
* @Description: TODO(系统管理视图) 
* @author shujukuss 
* @date 2017年6月18日 下午7:05:04 
*  
*/
@Controller
@RequestMapping("/systemmanager/")
public class SystemManagerController extends BaseController{
	
	private static Logger logger = Logger.getLogger(SystemManagerController.class);  
	
	/** 
	* @Title: sysmonitor 
	* @Description: TODO(系统监控) 
	* @author shujukuss 
	* @date 2017年7月9日 下午2:56:49 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "monitor")
    public String monitor(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/systemmanager/monitor");
		return CMCCConstant.Monitor;	
	}
	
	/** 
	* @Title: backup 
	* @Description: TODO(数据备份) 
	* @author shujukuss 
	* @date 2017年7月9日 下午9:42:24 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "backup")
    public String backup(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/systemmanager/backup");
		return CMCCConstant.Backup;	
	}
	
	/** 
	* @Title: timer 
	* @Description: TODO(定时程序) 
	* @author shujukuss 
	* @date 2017年7月9日 下午9:42:46 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "timer")
    public String timer(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/systemmanager/timer");
		return CMCCConstant.Timer;	
	}
	
	/** 
	* @Title: log 
	* @Description: TODO(系统日志) 
	* @author shujukuss 
	* @date 2017年7月9日 下午9:42:59 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "log")
    public String log(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/systemmanager/log");
		return CMCCConstant.Log;	
	}
	
	/** 
	* @Title: unlockuser 
	* @Description: TODO(解锁用户) 
	* @author shujukuss 
	* @date 2017年7月9日 下午9:43:09 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "unlockuser")
    public String unlockuser(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/systemmanager/unlockuser");
		return CMCCConstant.UnlockUser;	
	}
}
