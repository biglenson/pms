package com.zq.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
		return CMCCConstant.RealIncome;
	}
	
	/** 
	* @Title: currentCost 
	* @Description: TODO(本年成本) 
	* @author shujukuss 
	* @date 2017年7月5日 下午2:28:14 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "currentCost", method = RequestMethod.POST)
    public String currentCost(HttpServletRequest request) {				
		double totalPlanCostValue = 1024;
		double totalActualCostValue = 3306;
		Map<Integer,Double> kemuMoney = new HashMap<Integer, Double>();
		kemuMoney.put(1, 67.5);
		kemuMoney.put(2, 5.05);		
		Map<Integer,String> str  = new HashMap<Integer, String>();
		str.put(1, "和教育");
		str.put(2, "移动云");
		List<Map.Entry<Integer, String>> sortList = new ArrayList<>(str.entrySet());
		request.setAttribute("totalPlanCostValue", totalPlanCostValue);
		request.setAttribute("totalActualCostValue", totalActualCostValue);
		request.setAttribute("kemuMoney", kemuMoney);
		request.setAttribute("sortList", sortList);		
		return CMCCConstant.CurrentCost;
	}
	
	/** 
	* @Title: investmentBudget 
	* @Description: TODO(投资/预算总额) 
	* @author shujukuss 
	* @date 2017年7月5日 下午2:28:18 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "investmentBudget", method = RequestMethod.POST)
    public String investmentBudget(HttpServletRequest request) {	
		double capexMoney = 1024;
		double opexMoney = 3306;
		double percent = 37;
		request.setAttribute("capexMoney", capexMoney);
		request.setAttribute("opexMoney", opexMoney);
		request.setAttribute("percent", percent);	
		return CMCCConstant.InvestmentBudget;
	}
	
	/** 
	* @Title: expenditureTransfer 
	* @Description: TODO(开支、转资进度) 
	* @author shujukuss 
	* @date 2017年7月5日 下午2:28:22 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "expenditureTransfer", method = RequestMethod.POST)
    public String expenditureTransfer(HttpServletRequest request) {			
		double kaizhiTotal = 1024;
		double kaizhiActual = 3306;
		double opexPlan = 1024;
		double opexActual = 3306;
		double zhuanziTotal = 1024;
		double zhuanziActual = 3306;
		request.setAttribute("kaizhiTotal", kaizhiTotal);
		request.setAttribute("kaizhiActual", kaizhiActual);
		request.setAttribute("opexPlan", opexPlan);
		request.setAttribute("opexActual", opexActual);	
		request.setAttribute("zhuanziTotal", zhuanziTotal);
		request.setAttribute("zhuanziActual", zhuanziActual);
		return CMCCConstant.ExpenditureTransfer;
	}
}
