
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
import com.zq.entity.basic.purchase.BasFirstBill;
import com.zq.entity.basic.purchase.BasFrameContract;
import com.zq.entity.basic.purchase.BasOPEXPurchaseplan;
import com.zq.entity.basic.purchase.BasOtherContract;
import com.zq.entity.basic.purchase.BasSecondBill;
import com.zq.service.basic.purchase.IBasFirstBillService;
import com.zq.service.basic.purchase.IBasFrameContractService;
import com.zq.service.basic.purchase.IBasOPEXPurchaseplanService;
import com.zq.service.basic.purchase.IBasOtherContractService;
import com.zq.service.basic.purchase.IBasSecondBillService;


/** 
* @ClassName: PurchaseManagerController 
* @Description: TODO(采购数据管理视图) 
* @author shujukuss 
* @date 2017年6月18日 下午7:05:04 
*  
*/
@Controller
@RequestMapping("/purchase/")
public class PurchaseManagerController extends BaseController{
	@Autowired
	private IBasFirstBillService iBasFirstBillService;
	@Autowired
	private IBasSecondBillService iBasSecondBillService;
	@Autowired
	private IBasFrameContractService iBasFrameContractService;
	@Autowired
	private IBasOtherContractService iBasOtherContractService;
	@Autowired
	private IBasOPEXPurchaseplanService iBasOPEXPurchaseplanService;
	
	private static Logger logger = Logger.getLogger(PurchaseManagerController.class);  
	
	/** 
	* @Title: BasFirstBill 
	* @Description: TODO(一级集采台账) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:41:34 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basfirstbill")
    public String basFirstBill(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
	    int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasFirstBill> pageData = iBasFirstBillService.getBasFirstBill(page, pageSize);	        
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
		request = setForm(request, "BasFirstBill");
		request = setLeftMenu(request,"/purchase/basfirstbill");
		request.setAttribute("action", "/purchase/basfirstbill");
		request.setAttribute("pageInfo", pageInfo);
		return CMCCConstant.BasFirstBill;	
	}
	/** 
	* @Title: BaspurchaseAmountPool 
	* @Description: TODO(二级集采台账) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:42:17 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "bassecondbill")
    public String basSecondBill(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
	    int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasSecondBill> pageData = iBasSecondBillService.getBasSecondBill(page, pageSize);	        
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
		request = setForm(request, "BasSecondBill");
		request = setLeftMenu(request,"/purchase/bassecondbill");
		request.setAttribute("action", "/purchase/bassecondbill");
		request.setAttribute("pageInfo", pageInfo);
		return CMCCConstant.BasSecondBill;	
	}

	/** 
	* @Title: BasFrameContract 
	* @Description: TODO(框架合同台账) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:42:40 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basframecontract")
    public String basFrameContract(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
	    int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasFrameContract> pageData = iBasFrameContractService.getBasFrameContract(page, pageSize);	        
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
		request = setForm(request, "BasFrameContract");
		request = setLeftMenu(request,"/purchase/basframecontract");
		request.setAttribute("action", "/purchase/basframecontract");
		request.setAttribute("pageInfo", pageInfo);
		return CMCCConstant.BasFrameContract;	
	}
	/** 
	* @Title: BasOtherContract 
	* @Description: TODO(其他合同台账) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:04:59 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basothercontract")
    public String basOtherContract(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
	    int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasOtherContract> pageData = iBasOtherContractService.getBasOtherContract(page, pageSize);	        
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
		request = setForm(request, "BasOtherContract");
		request = setLeftMenu(request,"/purchase/basothercontract");
		request.setAttribute("action", "/purchase/basothercontract");
		request.setAttribute("pageInfo", pageInfo);
		return CMCCConstant.BasOtherContract;	
	}

	/** 
	* @Title: BasOPEXPurchaseplan 
	* @Description: TODO(OPEX采购计划) 
	* @author shujukuss 
	* @date 2017年7月11日 下午5:00:07 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basopexpurchaseplan")
    public String basOPEXPurchaseplan(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
	    int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasOPEXPurchaseplan> pageData = iBasOPEXPurchaseplanService.getBasOPEXPurchaseplan(page, pageSize);	        
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
		request = setForm(request, "BasOPEXPurchaseplan");
		request = setLeftMenu(request,"/purchase/basopexpurchaseplan");
		request.setAttribute("action", "/purchase/basopexpurchaseplan");
		request.setAttribute("pageInfo", pageInfo);
		return CMCCConstant.BasOPEXPurchaseplan;	
	}
	
}
