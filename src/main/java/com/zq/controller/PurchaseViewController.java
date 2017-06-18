package com.zq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zq.Util.CMCCConstant;


/** 
* @ClassName: PurchaseViewController 
* @Description: TODO(采购视图) 
* @author shujukuss 
* @date 2017年6月18日 下午7:05:47 
*  
*/
@Controller
@RequestMapping("/")
public class PurchaseViewController {
	/** 
	* @Title: purchaseView 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @author shujukuss 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "purchaseview", method = RequestMethod.GET)
	public String purchaseView() {
		return CMCCConstant.PCVDashBoard;
	}
}
