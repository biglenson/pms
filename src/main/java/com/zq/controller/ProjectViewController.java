package com.zq.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zq.commons.result.HighChartData;
import com.zq.commons.utils.CMCCConstant;
import com.zq.commons.utils.TypeUtils;
import com.zq.entity.basic.capex.BasCAPEXAmountPool;
import com.zq.entity.basic.capex.BasCAPEXExpendplan;
import com.zq.entity.basic.capex.BasCAPEXInvestPlan;
import com.zq.entity.basic.capex.BasCAPEXProject;
import com.zq.entity.basic.capex.BasCAPEXTotalInvestplan;
import com.zq.entity.basic.capex.BasCAPEXTransferplan;
import com.zq.service.basic.capex.IBasCAPEXAmountPoolService;
import com.zq.service.basic.capex.IBasCAPEXExpendplanService;
import com.zq.service.basic.capex.IBasCAPEXInvestPlanService;
import com.zq.service.basic.capex.IBasCAPEXProjectService;
import com.zq.service.basic.capex.IBasCAPEXTotalInvestplanService;
import com.zq.service.basic.capex.IBasCAPEXTransferplanService;


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
	
	@Autowired
	private IBasCAPEXInvestPlanService iBasCAPEXInvestPlanService;
	
	@Autowired
	private IBasCAPEXAmountPoolService iBasCAPEXAmountPoolService;
	
	@Autowired
	private IBasCAPEXTransferplanService iBasCAPEXTransferplanService;
	
	@Autowired
	private IBasCAPEXTotalInvestplanService iBasCAPEXTotalInvestplanService;
	
	@Autowired
	private IBasCAPEXExpendplanService iBasCAPEXExpendplanService;
	
	private static Logger logger = Logger.getLogger(ProjectViewController.class);  
	/**
	* @Title: projectsummary
	* @Description: TODO(项目总览)
	* @author BigCoin
	* @date 2017年7月5日 下午4:22:50
	* @param @param request
	* @param @return 设定文件
	* @return String 返回类型
	* @throws
	*/
	@RequestMapping(value = "projectsummary", method = RequestMethod.POST)
    public String projectSummary(HttpServletRequest request) {		
		int index=TypeUtils.getIntFromString(request.getParameter("index"));
		String year=request.getParameter("year");
		Date dataUpdateDate = null;
		if(index==0){
			double allValue=0d;
			double yearValue=0d;
			List<BasCAPEXProject> projectList=iBasCAPEXProjectService.getBasCAPEXProjectByYear(year);
			for(BasCAPEXProject capexproj:projectList){
				if(dataUpdateDate == null){
					dataUpdateDate = capexproj.getModifyTime();
				}
				if(dataUpdateDate != null && capexproj.getModifyTime() != null && dataUpdateDate.before(capexproj.getModifyTime())){
					dataUpdateDate = capexproj.getModifyTime();
				}
				BasCAPEXInvestPlan plan = iBasCAPEXInvestPlanService.getBasCAPEXInvestPlanByYearAndBasCAPEXProject(year,capexproj.getProjCode());
				String attribute="";
				if(plan != null){
					attribute = "新建";  //后期根据BasCAPEXInvestPlan中attribute去代码表中查出具体值
				}
				if("新建".equals(attribute)){
					allValue+=TypeUtils.string2Double(capexproj.getProjTotalInvest());
					yearValue+=TypeUtils.string2Double(capexproj.getProjSetupAmount());
				}
			}
			request.setAttribute(CMCCConstant.LASUPDATE, TypeUtils.getRelativeTime(dataUpdateDate));
			request.setAttribute("allValue", allValue);
			request.setAttribute("yearValue", yearValue);
			
		}else if(index==1){			
			List<BasCAPEXAmountPool> capexAmountPoolList=iBasCAPEXAmountPoolService.getAllCAPEXAmountPoolByYear(year);
			double allValue=0d;  //自主资金池总金额
			double projectValue=0d;//立项金额：当年新建项目中，投资计划项目集名称为“自主安排”的项目的“立项批复金额”进行累加
			double yuZhuanValue=0d;//
			for(BasCAPEXAmountPool capexpool:capexAmountPoolList){
				if(dataUpdateDate == null){
					dataUpdateDate = capexpool.getModifyTime();
				}
				if(dataUpdateDate != null && capexpool.getModifyTime() != null && dataUpdateDate.before(capexpool.getModifyTime())){
					dataUpdateDate = capexpool.getModifyTime();
				}
				allValue+=TypeUtils.string2Double(capexpool.getInitialAmount());
			}
			List<BasCAPEXProject> projectList=iBasCAPEXProjectService.getBasCAPEXProjectByYear(year);
			for(BasCAPEXProject capexproj:projectList){
				if(dataUpdateDate == null){
					dataUpdateDate = capexproj.getModifyTime();
				}
				if(dataUpdateDate != null && capexproj.getModifyTime() != null && dataUpdateDate.before(capexproj.getModifyTime())){
					dataUpdateDate = capexproj.getModifyTime();
				}
				BasCAPEXInvestPlan plan = iBasCAPEXInvestPlanService.getBasCAPEXInvestPlanByYearAndBasCAPEXProject(year,capexproj.getProjCode());
				if(plan==null){
					continue;
				}
				String attribute="";
				if(plan != null){
					attribute = "新建";  //后期根据BasCAPEXInvestPlan中attribute去代码表中查出具体值
				}
				if("新建".equals(attribute)){
					projectValue+=TypeUtils.string2Double(capexproj.getProjSetupAmount());
					yuZhuanValue+=TypeUtils.string2Double(capexproj.getPreoccupyAmount())- TypeUtils.string2Double(capexproj.getProjSetupAmount());
				}
			}
			double leftValue=allValue-projectValue-yuZhuanValue;
			request.setAttribute(CMCCConstant.LASUPDATE, TypeUtils.getRelativeTime(dataUpdateDate));
			request.setAttribute("leftValue", leftValue);
			request.setAttribute("projectValue", projectValue);
			request.setAttribute("yuZhuanValue", yuZhuanValue);
			request.setAttribute("allValue", allValue);
			
		}else if(index==2){			
			List<BasCAPEXProject> projectList=iBasCAPEXProjectService.getBasCAPEXProjectByYear(year);
			int newValue=0;
			int xuValue=0;
			int allValue=0;
			Map<String,HighChartData> dataMap=new HashMap();
			HighChartData other=null;
			List<HighChartData> dataList=new ArrayList();	
			for(BasCAPEXProject capexproj:projectList){
				if(dataUpdateDate == null){
					dataUpdateDate = capexproj.getModifyTime();
				}
				if(dataUpdateDate != null && capexproj.getModifyTime() != null && dataUpdateDate.before(capexproj.getModifyTime())){
					dataUpdateDate = capexproj.getModifyTime();
				}

				BasCAPEXInvestPlan plan = iBasCAPEXInvestPlanService.getBasCAPEXInvestPlanByYearAndBasCAPEXProject(year,capexproj.getProjCode());
				
				String attribute="";
				if(plan != null){
					attribute = "新建";  //后期根据BasCAPEXInvestPlan中attribute去代码表中查出具体值
				}
				if("新建".equals(attribute)){
					newValue++;
				}else if("续建".equals(attribute)){
					xuValue++;
				}
				allValue++;
				
				String zhuanYe=plan!=null?"其他":"";
				if(zhuanYe.equals("")){
					zhuanYe="其他";
				}
				HighChartData data=dataMap.get(zhuanYe);		
				if(data==null){
					data=new HighChartData();
					data.setName(zhuanYe);
					data.setId(zhuanYe);
					dataMap.put(zhuanYe, data);
					dataList.add(data);
				}
				if("其他".equals(zhuanYe)){
					other=data;
				}
				data.addY(1d);
			}
			if(other!=null){
				dataList.remove(other);
				dataList.add(dataList.size(),other);
			}
			request.setAttribute("allValue", allValue);
			request.setAttribute("xuValue", xuValue);
			request.setAttribute("newValue", newValue);
			request.setAttribute("dataList", dataList);

		}else if(index==3){
			List<BasCAPEXExpendplan> capexExpendplanList=iBasCAPEXExpendplanService.getAllCAPEXExpendplanByYear(year);
			List<BasCAPEXTransferplan> capexTransferplanList=iBasCAPEXTransferplanService.getAllBasCAPEXTransferplanByYear(year);
			double kaizhiTotal=0d;
			double kaizhiActual=0d;
			for(BasCAPEXExpendplan capexExpPlan:capexExpendplanList){
				if(dataUpdateDate == null){
					dataUpdateDate = capexExpPlan.getModifyTime();
				}
				if(dataUpdateDate != null && capexExpPlan.getModifyTime() != null && dataUpdateDate.before(capexExpPlan.getModifyTime())){
					dataUpdateDate = capexExpPlan.getModifyTime();
				}
				kaizhiActual+=iBasCAPEXExpendplanService.getActualByYearAndCAPEXProjCode(year,capexExpPlan.getProjCode());
			}		
			double zhuanZiTotal=0d;
			double zhuanZiActual=0d;
			for(BasCAPEXTransferplan capexTransferplan:capexTransferplanList){

				if(dataUpdateDate == null){
					dataUpdateDate = capexTransferplan.getModifyTime();
				}
				if(dataUpdateDate != null && capexTransferplan.getModifyTime() != null && dataUpdateDate.before(capexTransferplan.getModifyTime())){
					dataUpdateDate = capexTransferplan.getModifyTime();
				}
				zhuanZiActual+=iBasCAPEXTransferplanService.getActualByYearAndCAPEXProjCode(year,capexTransferplan.getProjCode());
			}		
			List<BasCAPEXTotalInvestplan> totalTouzi = iBasCAPEXTotalInvestplanService.getAllCAPEXTotalInvestplanByYear(year);
			if(totalTouzi != null){
				for(BasCAPEXTotalInvestplan zonge : totalTouzi){
					if(dataUpdateDate == null){
						dataUpdateDate = zonge.getModifyTime();
					}
					if(dataUpdateDate != null && zonge.getModifyTime() != null && dataUpdateDate.before(zonge.getModifyTime())){
						dataUpdateDate = zonge.getModifyTime();
					}
					kaizhiTotal += TypeUtils.string2Double(zonge.getAnnualCapexPlan());
					zhuanZiTotal += TypeUtils.string2Double(zonge.getAnnualCapexPlan());
				}
			}
			request.setAttribute("kaizhiTotal", kaizhiTotal);
			request.setAttribute("kaizhiActual", kaizhiActual);
			request.setAttribute("zhuanZiTotal", zhuanZiTotal);
			request.setAttribute("zhuanZiActual", zhuanZiActual);			
		}
		request.setAttribute("index", index);
		return CMCCConstant.ProjectSummary;
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
		Date dataUpdateDate = null;
		int index=TypeUtils.getIntFromString(request.getParameter("index"));
		String year=request.getParameter("year");
		double kaizhiTotal = 0d;
		double zhuanZiTotal = 0d;
		List<BasCAPEXTotalInvestplan> totalTouzi = iBasCAPEXTotalInvestplanService.getAllCAPEXTotalInvestplanByYear(year);
		if(totalTouzi != null){
			for(BasCAPEXTotalInvestplan total : totalTouzi){
				if(dataUpdateDate == null){
					dataUpdateDate = total.getModifyTime();
				}
				if(dataUpdateDate != null && total.getModifyTime() != null && dataUpdateDate.before(total.getModifyTime())){
					dataUpdateDate = total.getModifyTime();
				}
				kaizhiTotal += TypeUtils.string2Double(total.getAnnualCapexPlan());
				zhuanZiTotal += TypeUtils.string2Double(total.getAnnualTransferPlan());
			}
		}
		if(index==0){//投资计划
			ZongheAction action=new ZongheAction();
			action.touziDetailCapex(user, request);
		}else if(index==1){ //开支计划
			Calendar cal=Calendar.getInstance();
			int currentYear=cal.get(Calendar.YEAR);
			int month=cal.get(Calendar.MONTH);
//			System.out.println("year="+year+"month="+month);
			PageInfo pageInfo=new PageInfo();
			Properties ps=new Properties();
			pageInfo.setConditions(ps);
			ps.put("year", year);
			cm.getKaiZhiPlanPageInfo(user, pageInfo);
			List<CMCCKaiZhiPlan> list=pageInfo.getItems();
			Double[] plan=new Double[12];
//			Double allPlan=0d;
			Double[] actual=new Double[12];
			for(int i=0,j=plan.length;i<j;i++){
				plan[i]=0d;
				actual[i]=0d;
			}
			Double allActual=0d;
			Double monthPlan=0d;
			Double monthActual=0d;
			String[] planFields=CMCCKaiZhiPlan.PLAN_STOREFIELD;
			String[] actualFields=CMCCKaiZhiPlan.ACTUAL_STOREFIELD;
			for(CMCCKaiZhiPlan c:list){
				if(dataUpdateDate == null){
					dataUpdateDate = c.getLastUpdateTime();
				}
				if(dataUpdateDate != null && c.getLastUpdateTime() != null && dataUpdateDate.before(c.getLastUpdateTime())){
					dataUpdateDate = c.getLastUpdateTime();
				}
				int c_year=c.getYear();
				for(int i=0;i<12;i++){
					double tempPlan=TypeUtils.getNotNullDoubleValue(user, c, planFields[i]);
					double tempActual=TypeUtils.getNotNullDoubleValue(user, c, actualFields[i]);
//					allPlan+=tempPlan;
					allActual+=tempActual;
					Double p1=plan[i];
					
					p1+=tempPlan;
					plan[i]=p1;
					Double p2=actual[i];
					p2+=tempActual;
					actual[i]=p2;
					if(c_year<currentYear||(c_year==year&&i<=month)){
						monthPlan+=tempPlan;
						monthActual+=tempActual;
					}
				}
				
			}
			for(int i=plan.length-1;i>0;i--){
				for(int j=i-1;j>=0;j--){
					plan[i]+=plan[j];
				}
			}
			
			for(int i=actual.length-1;i>0;i--){
				for(int j=i-1;j>=0;j--){
					actual[i]+=actual[j];
				}
			}
			double wan=10000;
			for(int i=0,j=plan.length;i<j;i++){
				plan[i]/=wan;
			}
			
			for(int i=0,j=actual.length;i<j;i++){
				actual[i]/=wan;
			}
			monthPlan/=wan;
			monthActual/=wan;
			kaizhiTotal/=wan;
			allActual/=wan;
			request.setAttribute("plan", plan);
			request.setAttribute("actual", actual);
			request.setAttribute("monthPlan", monthPlan);
			request.setAttribute("monthActual", monthActual);
			request.setAttribute("allPlan", kaizhiTotal);
			request.setAttribute("allActual", allActual);
			request.setAttribute("year", year);	
		}else if(index==2){//转资计划
			Calendar cal=Calendar.getInstance();
			int currentYear=cal.get(Calendar.YEAR);
			int month=cal.get(Calendar.MONTH);
//			System.out.println("year="+year+"month="+month);
			PageInfo pageInfo=new PageInfo();
			Properties ps=new Properties();
			pageInfo.setConditions(ps);
			ps.put("year", year);
			cm.getZhuanZiPlanPageInfo(user, pageInfo);
			List<CMCCZhuanZiPlan> list=pageInfo.getItems();
			Double[] plan=new Double[12];
//			Double allPlan=0d;
			Double[] actual=new Double[12];
			for(int i=0,j=plan.length;i<j;i++){
				plan[i]=0d;
				actual[i]=0d;
			}
			Double allActual=0d;
			Double monthPlan=0d;
			Double monthActual=0d;
			String[] planFields=CMCCZhuanZiPlan.PLAN_STOREFIELD;
			String[] actualFields=CMCCZhuanZiPlan.ACTUAL_STOREFIELD;
			for(CMCCZhuanZiPlan c:list){
				if(dataUpdateDate == null){
					dataUpdateDate = c.getLastUpdateTime();
				}
				if(dataUpdateDate != null && c.getLastUpdateTime() != null && dataUpdateDate.before(c.getLastUpdateTime())){
					dataUpdateDate = c.getLastUpdateTime();
				}
				int c_year=c.getYear();
				for(int i=0;i<12;i++){
					double tempPlan=TypeUtils.getNotNullDoubleValue(user, c, planFields[i]);
					double tempActual=TypeUtils.getNotNullDoubleValue(user, c, actualFields[i]);
//					allPlan+=tempPlan;
					allActual+=tempActual;
					Double p1=plan[i];
					p1+=tempPlan;
					plan[i]=p1;
					Double p2=actual[i];
					p2+=tempActual;
					actual[i]=p2;
					if(c_year<currentYear||(c_year==year&&i<=month)){
						monthPlan+=tempPlan;
						monthActual+=tempActual;
					}
				}
			}
			for(int i=plan.length-1;i>0;i--){
				for(int j=i-1;j>=0;j--){
					plan[i]+=plan[j];
				}
			}
			
			for(int i=actual.length-1;i>0;i--){
				for(int j=i-1;j>=0;j--){
					actual[i]+=actual[j];
				}
			}
			double wan=10000;
			for(int i=0,j=plan.length;i<j;i++){
				plan[i]/=wan;
			}
			
			for(int i=0,j=actual.length;i<j;i++){
				actual[i]/=wan;
			}
			monthPlan/=wan;
			monthActual/=wan;
			zhuanZiTotal/=wan;
			allActual/=wan;
			request.setAttribute("plan", plan);
			request.setAttribute("actual", actual);
			request.setAttribute("monthPlan", monthPlan);
			request.setAttribute("monthActual", monthActual);
			request.setAttribute("allPlan", zhuanZiTotal);
			request.setAttribute("allActual", allActual);
			request.setAttribute("year", year);
		}
		request.setAttribute(CMCCConstant.LASUPDATE, CMCCAction.getDataModifiedTimeStr(dataUpdateDate));
		request.setAttribute("index", index);
		return CMCCConstant.PlanResult;
	}
}
