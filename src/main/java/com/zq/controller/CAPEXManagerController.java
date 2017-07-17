
package com.zq.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zq.commons.result.PageInfo;
import com.zq.commons.utils.CMCCConstant;
import com.zq.entity.basic.capex.BasCAPEXInvestPlan;
import com.zq.service.basic.capex.IBasCAPEXInvestPlanService;


/** 
* @ClassName: CAPEXManagerController 
* @Description: TODO(CAPEX数据管理视图) 
* @author shujukuss 
* @date 2017年6月18日 下午7:05:04 
*  
*/
@Controller
@RequestMapping("/capex/")
public class CAPEXManagerController extends BaseController{
	
	@Autowired
	private IBasCAPEXInvestPlanService iBasCAPEXInvestPlanService;
	
	private static Logger logger = Logger.getLogger(CAPEXManagerController.class);  
	
	/** 
	* @Title: basCAPEXInvestplan 
	* @Description: TODO(CAPEX投资计划) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:41:34 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "bascapexinvestplan")
    public String BasCAPEXInvestplan(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
        int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasCAPEXInvestPlan> pageData = iBasCAPEXInvestPlanService.getBasCAPEXInvestPlan(page, pageSize);	        
        request.setAttribute("pageData", pageData.getContent());
        logger.info("总记录数"+pageData.getTotalElements());  
        logger.info("当前第几页"+pageData.getNumber()+1);  
        logger.info("总页数"+pageData.getTotalPages());  
        logger.info("当前页面的List"+pageData.getContent());  
        logger.info("当前页面的记录数"+pageData.getNumberOfElements());
        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotalRows((int)pageData.getTotalElements());
        pageInfo.setPageCount(pageData.getTotalPages());
        pageInfo.setPageSize(pageData.getNumberOfElements());
        pageInfo.setCurrentPage(page);
		request = setForm(request, "BasCAPEXInvestPlan");
		request = setLeftMenu(request,"/capex/bascapexinvestplan");
		request.setAttribute("action", "/capex/bascapexinvestplan");
		request.setAttribute("pageInfo", pageInfo);
		return CMCCConstant.BasCAPEXInvestplan;	
	}
	@RequestMapping(value = "bascapexinvestplan/add")
    public String add(HttpServletRequest request) {

		return CMCCConstant.AddCAPEXInvestplan;	
	}
	/** 
	* @Title: basCAPEXAmountPool 
	* @Description: TODO(CAPEX自主资金池) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:42:17 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "bascapexamountpool")
    public String basCAPEXAmountPool(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/capex/bascapexamountpool");
		return CMCCConstant.BasCAPEXAmountPool;	
	}

	/** 
	* @Title: basCAPEXRequirment 
	* @Description: TODO(CAPEX需求) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:42:40 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "bascapexrequirment")
    public String basCAPEXRequirment(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/capex/bascapexrequirment");
		return CMCCConstant.BasCAPEXRequirment;	
	}
	/** 
	* @Title: basCAPEXProject 
	* @Description: TODO(CAPEX项) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:04:59 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "bascapexproject")
    public String basCAPEXProject(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/capex/bascapexproject");
		return CMCCConstant.BasCAPEXProject;	
	}

	/** 
	* @Title: basCAPEXProjInvestplan 
	* @Description: TODO(CAPEX项与投资计划) 
	* @author shujukuss 
	* @date 2017年7月11日 下午5:00:07 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "bascapexprojinvestplan")
    public String basCAPEXProjInvestplan(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/capex/bascapexprojinvestplan");
		return CMCCConstant.BasCAPEXProjInvestplan;	
	}
	/** 
	* @Title: basCAPEXExpendplan 
	* @Description: TODO(CAPEX资本开支计划) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:42:53 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "bascapexexpendplan")
    public String basCAPEXExpendplan(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/capex/bascapexexpendplan");
		return CMCCConstant.BasCAPEXExpendplan;	
	}
	
	/** 
	* @Title: basCAPEXTransferplan 
	* @Description: TODO(CAPEX转资计划) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:43:10 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "bascapextransferplan")
    public String basCAPEXTransferplan(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/capex/bascapextransferplan");
		return CMCCConstant.BasCAPEXTransferplan;	
	}
	
	/** 
	* @Title: basCAPEXTotalInvestplan 
	* @Description: TODO(投资计划总额信息管理) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:43:30 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "bascapextotalinvestplan")
    public String basCAPEXTotalInvestplan(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/capex/bascapextotalinvestplan");
		return CMCCConstant.BasCAPEXTotalInvestplan;	
	}
}
