package com.zq.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.zq.commons.utils.CMCCConstant;
import com.zq.entity.basic.BasCAPEXProject;
import com.zq.service.basic.IBasCAPEXProjectService;


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
	
	@Autowired
	private IBasCAPEXProjectService iBasCAPEXProjectService;
	
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
		double kaizhiTotal = 1000;
		double kaizhiActual = 2000;
		double zhuanZiTotal = 500;
		double zhuanZiActual = 100;
		double projectValue = 50;
		double yuZhuanValue = 100;
		double leftValue = 100;
		Integer index=1;
		request.setAttribute("allValue", allValue);
		request.setAttribute("yearValue", yearValue);
		request.setAttribute("kaizhiTotal", kaizhiTotal);
		request.setAttribute("kaizhiActual", kaizhiActual);
		request.setAttribute("zhuanZiTotal", zhuanZiTotal);
		request.setAttribute("zhuanZiActual", zhuanZiActual);
		request.setAttribute("projectValue", projectValue);
		request.setAttribute("yuZhuanValue", yuZhuanValue);	
		request.setAttribute("leftValue", leftValue);	
		request.setAttribute("index", index);	
		return CMCCConstant.InvestmentSchedule;
	}
    
	/**
	* @Title: planResult
	* @Description: TODO(项目计划标签)
	* @author BigCoin
	* @date 2017年7月10日 下午4:40:07
	* @param @param request
	* @param @return 设定文件
	* @return String 返回类型
	* @throws
	*/
	@RequestMapping(value = "planresult", method = RequestMethod.POST)
    public String planResult(HttpServletRequest request) {		
		Integer index = 1;
		List<BasCAPEXProject> project = iBasCAPEXProjectService.getALLCAPEXProject();		
		request.setAttribute("project", project);
		request.setAttribute("index", index);	
		return CMCCConstant.PlanResult;
	}
}
