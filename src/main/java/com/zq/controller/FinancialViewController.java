package com.zq.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zq.commons.utils.CMCCConstant;

/** 
* @ClassName: FinancialViewController 
* @Description: TODO(财务视图) 
* @author shujukuss 
* @date 2017年6月18日 下午7:01:20 
*  
*/
@Controller
@RequestMapping("/financialview/")
public class FinancialViewController extends BaseController{
	
	private static Logger logger = Logger.getLogger(FinancialViewController.class);  
		
	/** 
	* @Title: realIncome 
	* @Description: TODO(本年分公司真实收入) 
	* @author shujukuss 
	* @date 2017年7月5日 上午10:04:46 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "realIncome", method = RequestMethod.POST)
    public String realIncome(HttpServletRequest request) {		
		double totalPlanValue = 1024;
		double totalActualValue = 3306;
		Map<Integer,Double> typeShouruMap = new HashMap<Integer, Double>();
		typeShouruMap.put(1, 12.25);
		typeShouruMap.put(2, 15.75);
		Map<Integer,String> categoryNames  = new HashMap<Integer, String>();
		categoryNames.put(1, "和教育");
		categoryNames.put(2, "移动云");
		request.setAttribute("totalPlanValue", totalPlanValue);
		request.setAttribute("totalActualValue", totalActualValue);
		request.setAttribute("typeShouruMap", typeShouruMap);
		request.setAttribute("categoryNames", categoryNames);		
		return CMCCConstant.realIncome;
	}
}
