package com.zq.controller;

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
* @ClassName: ComprehensiveViewController 
* @Description: TODO(综合视图) 
* @author shujukuss 
* @date 2017年6月18日 下午7:01:05 
*  
*/
@Controller
@RequestMapping("/comprehensiveview/")
public class ComprehensiveViewController extends BaseController{
	
	@Autowired
	private IBasCAPEXProjectService iBasCAPEXProjectService;
	
	private static Logger logger = Logger.getLogger(ComprehensiveViewController.class);  

	/**
			* @Title: capexPhaseStatus
			* @Description: TODO(capex阶段进度)
			* @author BigCoin
			* @date 2017年7月10日 下午3:31:07
			* @param @param request
			* @param @return 设定文件
			* @return String 返回类型
			* @throws
			*/
	@RequestMapping(value = "capexphasestatus", method = RequestMethod.POST)
    public String capexPhaseStatus(HttpServletRequest request) {		
		int[] allCount = {10,20,30,40};
		int[] newCount = {10,20,30,40};
		int totalCount = 10;
		int newTotalCount = 20;
		BasCAPEXProject CAPEXProject = iBasCAPEXProjectService.getCAPEXProject();
		Integer index=3;
		request.setAttribute("allCount", allCount);
		request.setAttribute("newCount", newCount);
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("newTotalCount", newTotalCount);	
		return CMCCConstant.CAPEXPhaseStatus;
	}
}
