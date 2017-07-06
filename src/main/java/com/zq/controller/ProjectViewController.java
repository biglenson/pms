package com.zq.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zq.commons.utils.CMCCConstant;


/** 
* @ClassName: ProjectViewController 
* @Description: TODO(工程视图) 
* @author shujukuss 
* @date 2017年6月18日 下午7:05:04 
*  
*/
@Controller
@RequestMapping("/projectview/")
public class ProjectViewController extends BaseController{
	
	private static Logger logger = Logger.getLogger(ProjectViewController.class);  
	/**
			* @Title: investmentSchedule
			* @Description: TODO(投资使用进度)
			* @author BigCoin
			* @date 2017年7月5日 下午4:22:50
			* @param @param request
			* @param @return 设定文件
			* @return String 返回类型
			* @throws
			*/
	@RequestMapping(value = "investmentSchedule", method = RequestMethod.POST)
    public String investmentSchedule(HttpServletRequest request) {		
		double allValue = 1024;
		double yearValue = 3306;
		Integer index=2;
		request.setAttribute("allValue", allValue);
		request.setAttribute("yearValue", yearValue);
		request.setAttribute("index", index);	
		return CMCCConstant.InvestmentSchedule;
	}
}
