package com.zq.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zq.commons.utils.CMCCConstant;
import com.zq.entity.FeCapexselffundspool;


/** 
* @ClassName: SystemManagerController 
* @Description: TODO(数据管理视图) 
* @author shujukuss 
* @date 2017年6月18日 下午7:05:04 
*  
*/
@Controller
@RequestMapping("/capex/")
public class DataManagerController extends BaseController{
	
	private static Logger logger = Logger.getLogger(DataManagerController.class);  
	
	/** 
	* @Title: capexSelfFundsPool 
	* @Description: TODO(CAPEX自主资金池) 
	* @author shujukuss 
	* @date 2017年7月2日 下午10:01:55 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "capexSelfFundsPool", method = RequestMethod.POST)
	public String capexSelfFundsPool(Model model){
		List<String> titlelist = new ArrayList();
		titlelist.add("年份");
		titlelist.add("目前可用投资金额（元）");
		titlelist.add("初始金额（元）");
		model.addAttribute("titlelist", titlelist); 
		List<FeCapexselffundspool> recordlist = new ArrayList();
		FeCapexselffundspool feCapexselffundspool = new FeCapexselffundspool();	
		feCapexselffundspool.setYear("1996");
		feCapexselffundspool.setInitfunds("48.5");
		feCapexselffundspool.setAvifunds("12.574");
		recordlist.add(feCapexselffundspool);
		model.addAttribute("recordlist", recordlist); 
		return CMCCConstant.dataManager;
	}

}
