
package com.zq.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zq.commons.utils.CMCCConstant;


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
    public String basFirstBill(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/purchase/basfirstbill");
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
    public String basSecondBill(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/purchase/bassecondbill");
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
    public String basFrameContract(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/purchase/basframecontract");
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
    public String basOtherContract(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/purchase/basothercontract");
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
    public String basOPEXPurchaseplan(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/purchase/basopexpurchaseplan");
		return CMCCConstant.BasOPEXPurchaseplan;	
	}
	
}
