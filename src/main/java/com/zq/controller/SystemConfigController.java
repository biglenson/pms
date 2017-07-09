package com.zq.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zq.commons.utils.CMCCConstant;


/** 
* @ClassName: SystemConfigController 
* @Description: TODO(系统配置视图) 
* @author shujukuss 
* @date 2017年6月18日 下午7:05:04 
*  
*/
@Controller
@RequestMapping("/systemconfig/")
public class SystemConfigController extends BaseController{
	
	private static Logger logger = Logger.getLogger(SystemConfigController.class);
	
	/** 
	* @Title: syscode 
	* @Description: TODO(系统代码表) 
	* @author shujukuss 
	* @date 2017年7月9日 下午2:57:43 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "syscode")
    public String syscode(HttpServletRequest request) {
		return CMCCConstant.SysCode;	
	}

}
