package com.zq.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zq.commons.utils.CMCCConstant;


/** 
* @ClassName: PurchaseViewController 
* @Description: TODO(采购视图) 
* @author shujukuss 
* @date 2017年6月18日 下午7:05:47 
*  
*/
@Controller
@RequestMapping("/purchaseview/")
public class PurchaseViewController extends BaseController{
	
	private static Logger logger = Logger.getLogger(PurchaseViewController.class);  

	/** 
	* @Title: totalMoneyInfo 
	* @Description: TODO(采购金额) 
	* @author shujukuss 
	* @date 2017年7月5日 下午4:00:21 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "totalMoneyInfo",method =RequestMethod.POST)
	public String totalMoneyInfo(HttpServletRequest request){
		
		return CMCCConstant.TotalMoneyInfo;		
	}
	
	/** 
	* @Title: totalProjectInfo 
	* @Description: TODO(采购项目数) 
	* @author shujukuss 
	* @date 2017年7月5日 下午4:00:24 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "totalProjectInfo",method =RequestMethod.POST)
	public String totalProjectInfo(HttpServletRequest request){
		
		return CMCCConstant.TotalProjectInfo;		
	}
}
