
package com.zq.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zq.commons.result.PageInfo;
import com.zq.commons.utils.CMCCConstant;
import com.zq.entity.basic.datamap.BasAccountSubject;
import com.zq.entity.basic.datamap.BasAssetDetail;
import com.zq.entity.basic.datamap.BasBudgetSubject;
import com.zq.entity.basic.datamap.BasCustomer;
import com.zq.entity.basic.datamap.BasExpenseDetail;
import com.zq.entity.basic.datamap.BasIncomeByprod;
import com.zq.entity.basic.datamap.BasIncometargBydept;
import com.zq.entity.basic.datamap.BasIncometargByprod;
import com.zq.entity.basic.datamap.BasIncometargBytype;
import com.zq.entity.basic.datamap.BasItemProdCust;
import com.zq.entity.basic.datamap.BasItemset;
import com.zq.entity.basic.datamap.BasProduct;
import com.zq.entity.basic.datamap.BasProductIncome;
import com.zq.entity.basic.datamap.BasProjCapex;
import com.zq.entity.basic.purchase.BasFirstBill;
import com.zq.service.basic.datamap.IBasAccountSubjectService;
import com.zq.service.basic.datamap.IBasAssetDetailService;
import com.zq.service.basic.datamap.IBasBudgetSubjectService;
import com.zq.service.basic.datamap.IBasCustomerService;
import com.zq.service.basic.datamap.IBasExpenseDetailService;
import com.zq.service.basic.datamap.IBasIncomeByprodService;
import com.zq.service.basic.datamap.IBasIncometargBydeptService;
import com.zq.service.basic.datamap.IBasIncometargByprodService;
import com.zq.service.basic.datamap.IBasIncometargBytypeService;
import com.zq.service.basic.datamap.IBasItemProdCustService;
import com.zq.service.basic.datamap.IBasItemsetService;
import com.zq.service.basic.datamap.IBasProductIncomeService;
import com.zq.service.basic.datamap.IBasProductService;
import com.zq.service.basic.datamap.IBasProjCapexService;
import com.zq.service.basic.purchase.IBasFirstBillService;


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
	@Autowired
	private IBasCustomerService iBasCustomerService;
	@Autowired
	private IBasItemsetService iBasItemsetService;
	@Autowired
	private IBasProductService iBasProductService;
	@Autowired
	private IBasItemProdCustService iBasItemProdCustService;
	@Autowired
	private IBasProjCapexService iBasProjCapexService;
	@Autowired
	private IBasProductIncomeService iBasProductIncomeService;
	@Autowired
	private IBasIncomeByprodService iBasIncomeByprodService;
	@Autowired
	private IBasIncometargBytypeService iBasIncometargBytypeService;
	@Autowired
	private IBasIncometargByprodService iBasIncometargByprodService;
	@Autowired
	private IBasIncometargBydeptService iBasIncometargBydeptService;
	@Autowired
	private IBasBudgetSubjectService iBasBudgetSubjectService;
	@Autowired
	private IBasAccountSubjectService iBasAccountSubjectService;
	@Autowired
	private IBasAssetDetailService iBasAssetDetailService;
	@Autowired
	private IBasExpenseDetailService iBasExpenseDetailService;
	private static Logger logger = Logger.getLogger(DataMapManagerController.class);  
	
	/** 
	* @Title: basCustomer 
	* @Description: TODO(客户) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:41:34 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "bascustomer")
    public String basCustomer(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
	    int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasCustomer> pageData = iBasCustomerService.getBasCustomer(page, pageSize);	        
        request.setAttribute("pageData", pageData.getContent());
        logger.info("总记录数"+pageData.getTotalElements());  
        logger.info("当前第几页"+pageData.getNumber()+1);  
        logger.info("总页数"+pageData.getTotalPages());  
        logger.info("当前页面的List"+pageData.getContent());  
        logger.info("当前页面的记录数"+pageData.getNumberOfElements());
        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotalRows((int)pageData.getTotalElements());
        pageInfo.setPageCount(pageData.getTotalPages());
        pageInfo.setPageSize(pageData.getNumberOfElements());
        pageInfo.setCurrentPage(page);
		request = setForm(request, "BasCustomer");
		request = setLeftMenu(request,"/datamap/bascustomer");
		request.setAttribute("action", "/datamap/bascustomer");
		request = setLeftMenu(request,"/datamap/bascustomer");
		return CMCCConstant.BasCustomer;	
	}
	/** 
	* @Title: basItemset 
	* @Description: TODO(项目) 
	* @author shujukuss 
	* @date 2017年7月11日 下午4:42:17 
	* @param @param request
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/
	@RequestMapping(value = "basitemset")
    public String basItemset(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
	    int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasItemset> pageData = iBasItemsetService.getBasItemset(page, pageSize);	        
        request.setAttribute("pageData", pageData.getContent());
        logger.info("总记录数"+pageData.getTotalElements());  
        logger.info("当前第几页"+pageData.getNumber()+1);  
        logger.info("总页数"+pageData.getTotalPages());  
        logger.info("当前页面的List"+pageData.getContent());  
        logger.info("当前页面的记录数"+pageData.getNumberOfElements());
        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotalRows((int)pageData.getTotalElements());
        pageInfo.setPageCount(pageData.getTotalPages());
        pageInfo.setPageSize(pageData.getNumberOfElements());
        pageInfo.setCurrentPage(page);
		request = setForm(request, "BasItemset");
		request = setLeftMenu(request,"/datamap/basitemset");
		request.setAttribute("action", "/datamap/basitemset");
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
    public String basProduct(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
	    int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasProduct> pageData = iBasProductService.getBasProduct(page, pageSize);	        
        request.setAttribute("pageData", pageData.getContent());
        logger.info("总记录数"+pageData.getTotalElements());  
        logger.info("当前第几页"+pageData.getNumber()+1);  
        logger.info("总页数"+pageData.getTotalPages());  
        logger.info("当前页面的List"+pageData.getContent());  
        logger.info("当前页面的记录数"+pageData.getNumberOfElements());
        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotalRows((int)pageData.getTotalElements());
        pageInfo.setPageCount(pageData.getTotalPages());
        pageInfo.setPageSize(pageData.getNumberOfElements());
        pageInfo.setCurrentPage(page);
		request = setForm(request, "BasProduct");
		request = setLeftMenu(request,"/datamap/basproduct");
		request.setAttribute("action", "/datamap/basproduct");
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
    public String basItemProdCust(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
	    int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasItemProdCust> pageData = iBasItemProdCustService.getBasItemProdCust(page, pageSize);	        
        request.setAttribute("pageData", pageData.getContent());
        logger.info("总记录数"+pageData.getTotalElements());  
        logger.info("当前第几页"+pageData.getNumber()+1);  
        logger.info("总页数"+pageData.getTotalPages());  
        logger.info("当前页面的List"+pageData.getContent());  
        logger.info("当前页面的记录数"+pageData.getNumberOfElements());
        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotalRows((int)pageData.getTotalElements());
        pageInfo.setPageCount(pageData.getTotalPages());
        pageInfo.setPageSize(pageData.getNumberOfElements());
        pageInfo.setCurrentPage(page);
		request = setForm(request, "BasItemProdCust");
		request = setLeftMenu(request,"/datamap/basitemprodcust");
		request.setAttribute("action", "/datamap/basitemprodcust");
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
    public String basProjCapex(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
	    int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasProjCapex> pageData = iBasProjCapexService.getBasProjCapex(page, pageSize);	        
        request.setAttribute("pageData", pageData.getContent());
        logger.info("总记录数"+pageData.getTotalElements());  
        logger.info("当前第几页"+pageData.getNumber()+1);  
        logger.info("总页数"+pageData.getTotalPages());  
        logger.info("当前页面的List"+pageData.getContent());  
        logger.info("当前页面的记录数"+pageData.getNumberOfElements());
        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotalRows((int)pageData.getTotalElements());
        pageInfo.setPageCount(pageData.getTotalPages());
        pageInfo.setPageSize(pageData.getNumberOfElements());
        pageInfo.setCurrentPage(page);
		request = setForm(request, "BasProjCapex");
		request = setLeftMenu(request,"/datamap/basprojcapex");
		request.setAttribute("action", "/datamap/basprojcapex");
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
    public String basProductIncome(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
	    int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasProductIncome> pageData = iBasProductIncomeService.getBasProductIncome(page, pageSize);	        
        request.setAttribute("pageData", pageData.getContent());
        logger.info("总记录数"+pageData.getTotalElements());  
        logger.info("当前第几页"+pageData.getNumber()+1);  
        logger.info("总页数"+pageData.getTotalPages());  
        logger.info("当前页面的List"+pageData.getContent());  
        logger.info("当前页面的记录数"+pageData.getNumberOfElements());
        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotalRows((int)pageData.getTotalElements());
        pageInfo.setPageCount(pageData.getTotalPages());
        pageInfo.setPageSize(pageData.getNumberOfElements());
        pageInfo.setCurrentPage(page);
		request = setForm(request, "BasProductIncome");
		request = setLeftMenu(request,"/datamap/basproductincome");
		request.setAttribute("action", "/datamap/basproductincome");
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
    public String basIncomeByprod(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
	    int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasIncomeByprod> pageData = iBasIncomeByprodService.getBasIncomeByprod(page, pageSize);	        
        request.setAttribute("pageData", pageData.getContent());
        logger.info("总记录数"+pageData.getTotalElements());  
        logger.info("当前第几页"+pageData.getNumber()+1);  
        logger.info("总页数"+pageData.getTotalPages());  
        logger.info("当前页面的List"+pageData.getContent());  
        logger.info("当前页面的记录数"+pageData.getNumberOfElements());
        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotalRows((int)pageData.getTotalElements());
        pageInfo.setPageCount(pageData.getTotalPages());
        pageInfo.setPageSize(pageData.getNumberOfElements());
        pageInfo.setCurrentPage(page);
		request = setForm(request, "BasIncomeByprod");
		request = setLeftMenu(request,"/datamap/basincomebyprod");
		request.setAttribute("action", "/datamap/basincomebyprod");
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
    public String basIncometargBytype(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
	    int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasIncometargBytype> pageData = iBasIncometargBytypeService.getBasIncometargBytype(page, pageSize);	        
        request.setAttribute("pageData", pageData.getContent());
        logger.info("总记录数"+pageData.getTotalElements());  
        logger.info("当前第几页"+pageData.getNumber()+1);  
        logger.info("总页数"+pageData.getTotalPages());  
        logger.info("当前页面的List"+pageData.getContent());  
        logger.info("当前页面的记录数"+pageData.getNumberOfElements());
        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotalRows((int)pageData.getTotalElements());
        pageInfo.setPageCount(pageData.getTotalPages());
        pageInfo.setPageSize(pageData.getNumberOfElements());
        pageInfo.setCurrentPage(page);
		request = setForm(request, "BasIncometargBytype");
		request = setLeftMenu(request,"/datamap/basincometargbytype");
		request.setAttribute("action", "/datamap/basincometargbytype");
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
    public String basIncometargByprod(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
	    int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasIncometargByprod> pageData = iBasIncometargByprodService.getBasIncometargByprod(page, pageSize);	        
        request.setAttribute("pageData", pageData.getContent());
        logger.info("总记录数"+pageData.getTotalElements());  
        logger.info("当前第几页"+pageData.getNumber()+1);  
        logger.info("总页数"+pageData.getTotalPages());  
        logger.info("当前页面的List"+pageData.getContent());  
        logger.info("当前页面的记录数"+pageData.getNumberOfElements());
        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotalRows((int)pageData.getTotalElements());
        pageInfo.setPageCount(pageData.getTotalPages());
        pageInfo.setPageSize(pageData.getNumberOfElements());
        pageInfo.setCurrentPage(page);
		request = setForm(request, "BasIncometargByprod");
		request = setLeftMenu(request,"/datamap/basincometargbyprod");
		request.setAttribute("action", "/datamap/basincometargbyprod");
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
    public String basIncometargBydept(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
	    int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasIncometargBydept> pageData = iBasIncometargBydeptService.getBasIncometargBydept(page, pageSize);	        
        request.setAttribute("pageData", pageData.getContent());
        logger.info("总记录数"+pageData.getTotalElements());  
        logger.info("当前第几页"+pageData.getNumber()+1);  
        logger.info("总页数"+pageData.getTotalPages());  
        logger.info("当前页面的List"+pageData.getContent());  
        logger.info("当前页面的记录数"+pageData.getNumberOfElements());
        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotalRows((int)pageData.getTotalElements());
        pageInfo.setPageCount(pageData.getTotalPages());
        pageInfo.setPageSize(pageData.getNumberOfElements());
        pageInfo.setCurrentPage(page);
		request = setForm(request, "BasIncometargBydept");
		request = setLeftMenu(request,"/datamap/basincometargbydept");
		request.setAttribute("action", "/datamap/basincometargbydept");
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
    public String basBudgetSubject(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
	    int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasBudgetSubject> pageData = iBasBudgetSubjectService.getBasBudgetSubject(page, pageSize);	        
        request.setAttribute("pageData", pageData.getContent());
        logger.info("总记录数"+pageData.getTotalElements());  
        logger.info("当前第几页"+pageData.getNumber()+1);  
        logger.info("总页数"+pageData.getTotalPages());  
        logger.info("当前页面的List"+pageData.getContent());  
        logger.info("当前页面的记录数"+pageData.getNumberOfElements());
        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotalRows((int)pageData.getTotalElements());
        pageInfo.setPageCount(pageData.getTotalPages());
        pageInfo.setPageSize(pageData.getNumberOfElements());
        pageInfo.setCurrentPage(page);
		request = setForm(request, "BasBudgetSubject");
		request = setLeftMenu(request,"/datamap/basbudgetsubject");
		request.setAttribute("action", "/datamap/basbudgetsubject");
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
    public String basAccountSubject(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
	    int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasAccountSubject> pageData = iBasAccountSubjectService.getBasAccountSubject(page, pageSize);	        
        request.setAttribute("pageData", pageData.getContent());
        logger.info("总记录数"+pageData.getTotalElements());  
        logger.info("当前第几页"+pageData.getNumber()+1);  
        logger.info("总页数"+pageData.getTotalPages());  
        logger.info("当前页面的List"+pageData.getContent());  
        logger.info("当前页面的记录数"+pageData.getNumberOfElements());
        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotalRows((int)pageData.getTotalElements());
        pageInfo.setPageCount(pageData.getTotalPages());
        pageInfo.setPageSize(pageData.getNumberOfElements());
        pageInfo.setCurrentPage(page);
		request = setForm(request, "BasAccountSubject");
		request = setLeftMenu(request,"/datamap/basaccountsubject");
		request.setAttribute("action", "/datamap/basaccountsubject");
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
    public String basAssetDetail(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
	    int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasAssetDetail> pageData = iBasAssetDetailService.getBasAssetDetail(page, pageSize);	        
        request.setAttribute("pageData", pageData.getContent());
        logger.info("总记录数"+pageData.getTotalElements());  
        logger.info("当前第几页"+pageData.getNumber()+1);  
        logger.info("总页数"+pageData.getTotalPages());  
        logger.info("当前页面的List"+pageData.getContent());  
        logger.info("当前页面的记录数"+pageData.getNumberOfElements());
        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotalRows((int)pageData.getTotalElements());
        pageInfo.setPageCount(pageData.getTotalPages());
        pageInfo.setPageSize(pageData.getNumberOfElements());
        pageInfo.setCurrentPage(page);
		request = setForm(request, "BasAssetDetail");
		request = setLeftMenu(request,"/datamap/basassetdetail");
		request.setAttribute("action", "/datamap/basassetdetail");
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
    public String basExpenseDetail(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") Integer page) {
	    int pageSize = CMCCConstant.PAGE_SIZE;
        Page<BasExpenseDetail> pageData = iBasExpenseDetailService.getBasExpenseDetail(page, pageSize);	        
        request.setAttribute("pageData", pageData.getContent());
        logger.info("总记录数"+pageData.getTotalElements());  
        logger.info("当前第几页"+pageData.getNumber()+1);  
        logger.info("总页数"+pageData.getTotalPages());  
        logger.info("当前页面的List"+pageData.getContent());  
        logger.info("当前页面的记录数"+pageData.getNumberOfElements());
        PageInfo pageInfo = new PageInfo();
        pageInfo.setTotalRows((int)pageData.getTotalElements());
        pageInfo.setPageCount(pageData.getTotalPages());
        pageInfo.setPageSize(pageData.getNumberOfElements());
        pageInfo.setCurrentPage(page);
		request = setForm(request, "BasExpenseDetail");
		request = setLeftMenu(request,"/datamap/basexpensedetail");
		request.setAttribute("action", "/datamap/basexpensedetail");
		request = setLeftMenu(request,"/datamap/basexpensedetail");
		return CMCCConstant.BasExpenseDetail;	
	}
	
}
