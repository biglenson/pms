
package com.zq.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zq.commons.utils.CMCCConstant;


/** 
* @ClassName: DataMapManagerController 
* @Description: TODO(数据映射管理视图) 
* @author shujukuss 
* @date 2017年6月18日 下午7:05:04 
*  
*/
@Controller
@RequestMapping("/datamap/")
public class DataMapManagerController extends BaseController{
	
	private static Logger logger = Logger.getLogger(DataMapManagerController.class);  
	
	/** 
	* @Title: basCustomer 
	* @Description: TODO(一级集采台账) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:41:34 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "bascustomer")
    public String basCustomer(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/datamap/bascustomer");
		return CMCCConstant.BasCustomer;	
	}
	/** 
	* @Title: basdatamapAmountPool 
	* @Description: TODO(项目) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:42:17 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basitemset")
    public String basItemset(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/datamap/basitemset");
		return CMCCConstant.BasItemset;	
	}

	/** 
	* @Title: basProduct 
	* @Description: TODO(产品) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:42:40 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basproduct")
    public String basProduct(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/datamap/basproduct");
		return CMCCConstant.BasProduct;	
	}
	/** 
	* @Title: basItemProdCust 
	* @Description: TODO(项目与产品客户关系) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:04:59 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basitemprodcust")
    public String basItemProdCust(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/datamap/basitemprodcust");
		return CMCCConstant.BasItemProdCust;	
	}

	/** 
	* @Title: basProjCapex 
	* @Description: TODO(产品与CAPEX分摊) 
	* @author shujukuss 
	* @date 2017年7月11日 下午5:00:07 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basprojcapex")
    public String basProjCapex(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/datamap/basprojcapex");
		return CMCCConstant.BasProjCapex;	
	}
	
	/** 
	* @Title: basProductIncome 
	* @Description: TODO(产品直销收入) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:42:53 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basproductincome")
    public String basProductIncome(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/datamap/basproductincome");
		return CMCCConstant.BasProductIncome;	
	}
	
	/** 
	* @Title: basIncomeByprod 
	* @Description: TODO(收入按产品分摊) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:43:10 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basincomebyprod")
    public String basIncomeByprod(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/datamap/basincomebyprod");
		return CMCCConstant.BasIncomeByprod;	
	}
	
	/** 
	* @Title: basIncometargBytype 
	* @Description: TODO(收入目标/类型) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:43:30 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basincometargbytype")
    public String basIncometargBytype(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/datamap/basincometargbytype");
		return CMCCConstant.BasIncometargBytype;	
	}
	/** 
	* @Title: basIncometargByprod 
	* @Description: TODO(收入目标/经分产品) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:43:30 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basincometargbyprod")
    public String basIncometargByprod(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/datamap/basincometargbyprod");
		return CMCCConstant.BasIncometargByprod;	
	}
	/** 
	* @Title: basIncometargBydept 
	* @Description: TODO(收入目标/部门) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:43:30 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basincometargbydept")
    public String basIncometargBydept(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/datamap/basincometargbydept");
		return CMCCConstant.BasIncometargBydept;	
	}
	/** 
	* @Title: basBudgetSubject 
	* @Description: TODO(预算科目) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:41:34 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basbudgetsubject")
    public String basBudgetSubject(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/datamap/basbudgetsubject");
		return CMCCConstant.BasBudgetSubject;	
	}
	/** 
	* @Title: basAccountSubject 
	* @Description: TODO(会计科目) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:42:17 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basaccountsubject")
    public String basAccountSubject(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/datamap/basaccountsubject");
		return CMCCConstant.BasAccountSubject;	
	}

	/** 
	* @Title: basAssetDetail 
	* @Description: TODO(费用明细) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:42:40 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basassetdetail")
    public String basAssetDetail(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/datamap/basassetdetail");
		return CMCCConstant.BasAssetDetail;	
	}
	/** 
	* @Title: basExpenseDetail 
	* @Description: TODO(资产明细) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:04:59 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basexpensedetail")
    public String basExpenseDetail(HttpServletRequest request) {
		
		request = setLeftMenu(request,"/datamap/basexpensedetail");
		return CMCCConstant.BasExpenseDetail;	
	}
	
}
