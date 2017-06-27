package com.zq.controller.REST;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zq.commons.utils.CMCCConstant;

/** 
* @ClassName: ComprehensiveViewController 
* @Description: TODO(综合视图) 
* @author shujukuss 
* @date 2017年6月18日 下午7:01:05 
*  
*/
@Controller
@RequestMapping("/")
public class ComprehensiveViewController {
	
	private static Logger logger = Logger.getLogger(ComprehensiveViewController.class);  
	/** 
	* @Title: comprehensiveView 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @author shujukuss 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "comprehensiveview", method = RequestMethod.GET)
	public String comprehensiveView() {
		return CMCCConstant.CVDashBoard;
	}
}
