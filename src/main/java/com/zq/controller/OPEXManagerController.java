
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
import com.zq.entity.basic.opex.BasOPEXBudgetProject;
import com.zq.entity.basic.opex.BasOPEXBudgetpool;
import com.zq.entity.basic.opex.BasOPEXManhour;
import com.zq.entity.basic.opex.BasOPEXProject;
import com.zq.entity.basic.opex.BasOPEXRequirment;
import com.zq.entity.basic.opex.BasOPEXBudgetAdjust;
import com.zq.entity.basic.opex.BasOpexBudgetpoolDetail;
import com.zq.service.basic.opex.IBasOPEXBudgetAdjustService;
import com.zq.service.basic.opex.IBasOPEXBudgetProjectService;
import com.zq.service.basic.opex.IBasOPEXBudgetpoolService;
import com.zq.service.basic.opex.IBasOPEXManhourService;
import com.zq.service.basic.opex.IBasOPEXProjectService;
import com.zq.service.basic.opex.IBasOPEXRequirmentService;
import com.zq.service.basic.opex.IBasOpexBudgetpoolDetailService;


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
	@Autowired
	private IBasOPEXBudgetpoolService iBasOPEXBudgetpoolService;
	@Autowired
	private IBasOpexBudgetpoolDetailService iBasOpexBudgetpoolDetailService;
	@Autowired
	private IBasOPEXBudgetAdjustService iBasOPEXBudgetAdjustService;
	@Autowired
	private IBasOPEXBudgetProjectService iBasOPEXBudgetProjectService;
	@Autowired
	private IBasOPEXRequirmentService iBasOPEXRequirmentService;
	@Autowired
	private IBasOPEXProjectService iBasOPEXProjectService;
	@Autowired
	private IBasOPEXManhourService iBasOPEXManhourService;
	
	private static Logger logger = Logger.getLogger(OPEXManagerController.class);  
	
	/** 
	* @Title: basOPEXBudgetpool 
	* @Description: TODO(OPEX动态预算池) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:41:34 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basopexbudgetpool")
    public String basOPEXBudgetpool(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
	    int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasOPEXBudgetpool> pageData = iBasOPEXBudgetpoolService.getBasOPEXBudgetpool(page, pageSize);	        
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
		request = setForm(request, "BasOPEXBudgetpool");
		request = setLeftMenu(request,"/opex/basopexbudgetpool");
		request.setAttribute("action", "/opex/basopexbudgetpool");
		request.setAttribute("pageInfo", pageInfo);
		return CMCCConstant.BasOPEXBudgetpool;	
	}
	/** 
	* @Title: basOpexBudgetpoolDetail 
	* @Description: TODO(OPEX动态预算池明细) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:42:17 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basopexbudgetpooldetail")
    public String basOpexBudgetpoolDetail(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
	    int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasOpexBudgetpoolDetail> pageData = iBasOpexBudgetpoolDetailService.getBasOpexBudgetpoolDetail(page, pageSize);	        
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
		request = setForm(request, "BasOpexBudgetpoolDetail");
		request = setLeftMenu(request,"/opex/basopexbudgetpooldetail");
		request.setAttribute("action", "/opex/basopexbudgetpooldetail");
		request.setAttribute("pageInfo", pageInfo);
		return CMCCConstant.BasOpexBudgetpoolDetail;	
	}

	/** 
	* @Title: basOPEXBudgetAdjust 
	* @Description: TODO(OPEX部门间预算调剂) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:42:40 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basopexbudgetadjust")
    public String BasOPEXBudgetAdjust(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
	    int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasOPEXBudgetAdjust> pageData = iBasOPEXBudgetAdjustService.getBasOPEXBudgetAdjust(page, pageSize);	        
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
		request = setForm(request, "BasOPEXBudgetAdjust");
		request = setLeftMenu(request,"/opex/basopexbudgetadjust");
		request.setAttribute("action", "/opex/basopexbudgetadjust");
		request.setAttribute("pageInfo", pageInfo);
		return CMCCConstant.BasOPEXBudgetAdjust;	
	}
	/** 
	* @Title: basOPEXBudgetProject 
	* @Description: TODO(OPEX预算项目) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:04:59 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basopexbudgetproject")
    public String basOPEXBudgetProject(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
	    int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasOPEXBudgetProject> pageData = iBasOPEXBudgetProjectService.getBasOPEXBudgetProject(page, pageSize);	        
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
		request = setForm(request, "BasOPEXBudgetProject");
		request = setLeftMenu(request,"/opex/basopexbudgetproject");
		request.setAttribute("action", "/opex/basopexbudgetproject");
		request.setAttribute("pageInfo", pageInfo);
		return CMCCConstant.BasOPEXBudgetProject;	
	}

	/** 
	* @Title: basOPEXRequirment 
	* @Description: TODO(OPEX需求) 
	* @author shujukuss 
	* @date 2017年7月11日 下午5:00:07 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basopexrequirment")
    public String basOPEXRequirment(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
	    int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasOPEXRequirment> pageData = iBasOPEXRequirmentService.getBasOPEXRequirment(page, pageSize);	        
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
		request = setForm(request, "BasOPEXRequirment");
		request = setLeftMenu(request,"/opex/basopexrequirment");
		request.setAttribute("action", "/opex/basopexrequirment");
		request.setAttribute("pageInfo", pageInfo);
		return CMCCConstant.BasOPEXRequirment;	
	}
	/** 
	* @Title: basOPEXProject 
	* @Description: TODO(OPEX项) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:42:53 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basopexproject")
    public String basOPEXProject(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
	    int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasOPEXProject> pageData = iBasOPEXProjectService.getBasOPEXProject(page, pageSize);	        
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
		request = setForm(request, "BasOPEXProject");
		request = setLeftMenu(request,"/opex/basopexproject");
		request.setAttribute("action", "/opex/basopexproject");
		request.setAttribute("pageInfo", pageInfo);
		return CMCCConstant.BasOPEXProject;	
	}
	
	/** 
	* @Title: basOPEXManhour 
	* @Description: TODO(OPEX工时管理) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:43:10 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basopexmanhour")
    public String basOPEXManhour(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
	    int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasOPEXManhour> pageData = iBasOPEXManhourService.getBasOPEXManhour(page, pageSize);	        
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
		request = setForm(request, "BasOPEXManhour");
		request = setLeftMenu(request,"/opex/basopexmanhour");
		request.setAttribute("action", "/opex/basopexmanhour");
		request.setAttribute("pageInfo", pageInfo);
		return CMCCConstant.BasOPEXManhour;	
	}

}
