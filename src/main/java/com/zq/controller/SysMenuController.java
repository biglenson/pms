package com.zq.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zq.commons.utils.CMCCConstant;


/** 
* @ClassName: SysMenuController 
* @Description: TODO(系统菜单) 
* @author shujukuss 
* @date 2017年6月18日 下午7:06:02 
*  
*/
@Controller
@RequestMapping("/")
public class SysMenuController extends BaseController{
	
	private static Logger logger = Logger.getLogger(SysMenuController.class);
	
	/** 
	* @Title: comprehensiveView 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @author shujukuss 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "comprehensiveview")
	public String comprehensiveView() {
		return CMCCConstant.CVDashBoard;
	}
	/** 
	* @Title: financialView 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @author shujukuss 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "financialview")
	public String financialView() {
		return CMCCConstant.FVDashBoard;
	}
	/** 
	* @Title: multiAnalysis 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @author shujukuss 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "multianalysis")
	public String multiAnalysis() {
		return CMCCConstant.MADashBoard;
	}
	/** 
	* @Title: projectView 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @author shujukuss 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "projectview")
	public String projectView() {
		return CMCCConstant.PJVDashBoard;
	}
	/** 
	* @Title: purchaseView 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @author shujukuss 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "purchaseview")
	public String purchaseView() {
		return CMCCConstant.PCVDashBoard;
	}
	
	/** 
	* @Title: dataManager 
	* @Description: TODO(数据管理页面) 
	* @author shujukuss 
	* @date 2017年6月29日 上午11:11:28 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "datamanager")
	public String dataManager() {
		return "redirect:/capex/bascapexinvestplan";
	}
	
	/** 
	* @Title: capex 
	* @Description: TODO(CAPEX管理页面) 
	* @author shujukuss 
	* @date 2017年6月29日 上午11:11:28 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "capex")
	public String capex() {
		return "redirect:/capex/bascapexinvestplan";
	}
	
	/** 
	* @Title: opex 
	* @Description: TODO(OPEX管理页面) 
	* @author shujukuss 
	* @date 2017年6月29日 上午11:11:28 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "opex")
	public String opex() {
		return "redirect:/opex/basopexbudgetpool";
	}
	
	/** 
	* @Title: purchase 
	* @Description: TODO(采购管理页面) 
	* @author shujukuss 
	* @date 2017年6月29日 上午11:11:28 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "purchase")
	public String purchase() {
		return "redirect:/purchase/basfirstbill";
	}
	
	/** 
	* @Title: systemManager 
	* @Description: TODO(系统管理页面) 
	* @author shujukuss 
	* @date 2017年6月29日 上午11:11:28 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "systemmanager")
	public String systemManager() {
		return "redirect:/systemmanager/monitor";
	}
	
	/** 
	* @Title: sysConfig 
	* @Description: TODO(系统配置界面) 
	* @author shujukuss 
	* @date 2017年7月10日 上午9:44:29 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "systemconfig")
	public String sysConfig() {
		return "redirect:/systemconfig/syscode";
	}
	
	/** 
	* @Title: resourceManager 
	* @Description: TODO(权限管理界面) 
	* @author shujukuss 
	* @date 2017年7月10日 上午9:44:33 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "resourcemanager")
	public String resourceManager() {
		return "redirect:/resourcemanager/department";
	}
	
}
