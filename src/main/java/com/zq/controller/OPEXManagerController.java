
package com.zq.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zq.commons.utils.CMCCConstant;


/** 
* @ClassName: OPEXManagerController 
* @Description: TODO(OPEX数据管理视图) 
* @author shujukuss 
* @date 2017年6月18日 下午7:05:04 
*  
*/
@Controller
@RequestMapping("/opex/")
public class OPEXManagerController extends BaseController{
	
	private static Logger logger = Logger.getLogger(OPEXManagerController.class);  
	
	/** 
	* @Title: BasOPEXBudgetpool 
	* @Description: TODO(OPEX动态预算池) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:41:34 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basopexbudgetpool")
    public String basOPEXBudgetpool(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/opex/basopexbudgetpool");
		return CMCCConstant.BasOPEXBudgetpool;	
	}
	/** 
	* @Title: BasOpexBudgetpoolDetail 
	* @Description: TODO(OPEX动态预算池明细) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:42:17 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basopexbudgetpooldetail")
    public String basOpexBudgetpoolDetail(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/opex/basopexbudgetpooldetail");
		return CMCCConstant.BasOpexBudgetpoolDetail;	
	}

	/** 
	* @Title: BasOPEXBudgetAdjust 
	* @Description: TODO(OPEX部门间预算调剂) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:42:40 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basopexbudgetadjust")
    public String BasOPEXBudgetAdjust(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/opex/basopexbudgetadjust");
		return CMCCConstant.BasOPEXBudgetAdjust;	
	}
	/** 
	* @Title: BasOPEXBudgetProject 
	* @Description: TODO(OPEX预算项目) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:04:59 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basopexbudgetproject")
    public String basOPEXBudgetProject(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/opex/basopexbudgetproject");
		return CMCCConstant.BasOPEXBudgetProject;	
	}

	/** 
	* @Title: BasOPEXRequirment 
	* @Description: TODO(OPEX需求) 
	* @author shujukuss 
	* @date 2017年7月11日 下午5:00:07 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basopexrequirment")
    public String basOPEXRequirment(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/opex/basopexrequirment");
		return CMCCConstant.BasOPEXRequirment;	
	}
	/** 
	* @Title: BasOPEXProject 
	* @Description: TODO(OPEX项) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:42:53 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basopexproject")
    public String basOPEXProject(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/opex/basopexproject");
		return CMCCConstant.BasOPEXProject;	
	}
	
	/** 
	* @Title: BasOPEXManhour 
	* @Description: TODO(OPEX工时管理) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:43:10 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basopexmanhour")
    public String basOPEXManhour(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/opex/basopexmanhour");
		return CMCCConstant.BasOPEXManhour;	
	}

}
