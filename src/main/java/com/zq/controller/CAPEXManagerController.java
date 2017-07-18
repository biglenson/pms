
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
import com.zq.entity.basic.capex.BasCAPEXAmountPool;
import com.zq.entity.basic.capex.BasCAPEXExpendplan;
import com.zq.entity.basic.capex.BasCAPEXInvestPlan;
import com.zq.entity.basic.capex.BasCAPEXProjInvestplan;
import com.zq.entity.basic.capex.BasCAPEXProject;
import com.zq.entity.basic.capex.BasCAPEXRequirment;
import com.zq.entity.basic.capex.BasCAPEXTotalInvestplan;
import com.zq.entity.basic.capex.BasCAPEXTransferplan;
import com.zq.service.basic.capex.IBasCAPEXAmountPoolService;
import com.zq.service.basic.capex.IBasCAPEXExpendplanService;
import com.zq.service.basic.capex.IBasCAPEXInvestPlanService;
import com.zq.service.basic.capex.IBasCAPEXProjInvestplanService;
import com.zq.service.basic.capex.IBasCAPEXProjectService;
import com.zq.service.basic.capex.IBasCAPEXRequirmentService;
import com.zq.service.basic.capex.IBasCAPEXTotalInvestplanService;
import com.zq.service.basic.capex.IBasCAPEXTransferplanService;


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
	@Autowired
	private IBasCAPEXAmountPoolService iBasCAPEXAmountPoolService;
	@Autowired
	private IBasCAPEXRequirmentService iBasCAPEXRequirmentService;
	@Autowired
	private IBasCAPEXProjectService iBasCAPEXProjectService;
	@Autowired
	private IBasCAPEXProjInvestplanService iBasCAPEXProjInvestplanService;
	@Autowired
	private IBasCAPEXExpendplanService iBasCAPEXExpendplanService;
	@Autowired
	private IBasCAPEXTransferplanService iBasCAPEXTransferplanService;
	@Autowired
	private IBasCAPEXTotalInvestplanService iBasCAPEXTotalInvestplanService;
	
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
    public String basCAPEXAmountPool(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
        int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasCAPEXAmountPool> pageData = iBasCAPEXAmountPoolService.getBasCAPEXAmountPool(page, pageSize);	        
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
		request = setForm(request, "BasCAPEXAmountPool");
		request = setLeftMenu(request,"/capex/bascapexamountpool");
		request.setAttribute("action", "/capex/bascapexamountpool");
		request.setAttribute("pageInfo", pageInfo);
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
    public String basCAPEXRequirment(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
        int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasCAPEXRequirment> pageData = iBasCAPEXRequirmentService.getBasCAPEXRequirment(page, pageSize);	        
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
		request = setForm(request, "BasCAPEXRequirment");
		request = setLeftMenu(request,"/capex/bascapexrequirment");
		request.setAttribute("action", "/capex/bascapexrequirment");
		request.setAttribute("pageInfo", pageInfo);
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
    public String basCAPEXProject(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
        int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasCAPEXProject> pageData = iBasCAPEXProjectService.getBasCAPEXProject(page, pageSize);	        
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
		request = setForm(request, "BasCAPEXProject");
		request = setLeftMenu(request,"/capex/bascapexproject");
		request.setAttribute("action", "/capex/bascapexproject");
		request.setAttribute("pageInfo", pageInfo);
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
    public String basCAPEXProjInvestplan(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
        int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasCAPEXProjInvestplan> pageData = iBasCAPEXProjInvestplanService.getBasCAPEXProjInvestplan(page, pageSize);	        
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
		request = setForm(request, "BasCAPEXProjInvestplan");
		request = setLeftMenu(request,"/capex/bascapexinvestplan");
		request.setAttribute("action", "/capex/bascapexprojinvestplan");
		request.setAttribute("pageInfo", pageInfo);
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
    public String basCAPEXExpendplan(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
        int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasCAPEXExpendplan> pageData = iBasCAPEXExpendplanService.getBasCAPEXExpendplan(page, pageSize);	        
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
		request = setForm(request, "BasCAPEXExpendplan");
		request = setLeftMenu(request,"/capex/bascapexexpendplan");
		request.setAttribute("action", "/capex/bascapexexpendplan");
		request.setAttribute("pageInfo", pageInfo);
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
    public String basCAPEXTransferplan(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
        int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasCAPEXTransferplan> pageData = iBasCAPEXTransferplanService.getBasCAPEXTransferplan(page, pageSize);	        
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
		request = setForm(request, "BasCAPEXTransferplan");
		request = setLeftMenu(request,"/capex/bascapextransferplan");
		request.setAttribute("action", "/capex/bascapextransferplan");
		request.setAttribute("pageInfo", pageInfo);
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
    public String basCAPEXTotalInvestplan(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
        int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasCAPEXTotalInvestplan> pageData = iBasCAPEXTotalInvestplanService.getBasCAPEXTotalInvestplan(page, pageSize);	        
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
		request = setForm(request, "BasCAPEXTotalInvestplan");
		request = setLeftMenu(request,"/capex/bascapextotalinvestplan");
		request.setAttribute("action", "/capex/bascapextotalinvestplan");
		request.setAttribute("pageInfo", pageInfo);
		request = setLeftMenu(request,"/capex/bascapextotalinvestplan");
		return CMCCConstant.BasCAPEXTotalInvestplan;	
	}
}
