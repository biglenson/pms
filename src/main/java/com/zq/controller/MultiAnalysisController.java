package com.zq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zq.Util.CMCCConstant;


/** 
* @ClassName: MultiAnalysisController 
* @Description: TODO(报表) 
* @author shujukuss 
* @date 2017年6月18日 下午7:04:45 
*  
*/
@Controller
@RequestMapping("/")
public class MultiAnalysisController {
	/** 
	* @Title: multiAnalysis 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @author shujukuss 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "multianalysis", method = RequestMethod.GET)
	public String multiAnalysis() {
		return CMCCConstant.MADashBoard;
	}
}
