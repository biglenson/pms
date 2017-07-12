package com.zq.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zq.commons.result.HighChartData;
import com.zq.commons.result.PageInfo;
import com.zq.commons.utils.CMCCConstant;
import com.zq.commons.utils.TypeUtils;
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
	@RequestMapping(value = "projectsummary", method = RequestMethod.POST)
    public String investmentSchedule(HttpServletRequest request) {
		
/*		User user=webMgr.getCurrentUser();
		CMCCManager cm=ComponentFactory.getCMCCManager();*/
		int index=TypeUtils.getIntFromString(request.getParameter("index"));
		int year=TypeUtils.getIntFromString(request.getParameter("year"));
		Date dataUpdateDate = null;
		if(index==0){
			PageInfo pageInfo=new PageInfo();
			Properties ps=new Properties();
			pageInfo.setConditions(ps);
			ps.put("year", year);
//			cm.getCmProjectPageInfo(user, pageInfo);
			double allValue=0d;
			double yearValue=0d;
			List<BasCAPEXProject> projectList=pageInfo.getItems();
			for(BasCAPEXProject c:projectList){
				if(dataUpdateDate == null){
					dataUpdateDate = c.getLastUpdateTime();
				}
				if(dataUpdateDate != null && c.getLastUpdateTime() != null && dataUpdateDate.before(c.getLastUpdateTime())){
					dataUpdateDate = c.getLastUpdateTime();
				}
				CMCCTouziPlan plan = c.getYearTouziPlan(year);
				String shuxing="";
				if(plan != null){
					shuxing = TypeUtils.resoveFieldAsString(user, plan, "enum04", request);
				}
				if("新建".equals(shuxing)){
					allValue+=TypeUtils.getNotNullDoubleValue(user, c, "num09");
					yearValue+=TypeUtils.getNotNullDoubleValue(user, c, "num01");
				}
			}
			//System.out.println("allValue==="+TypeUtils.formatWanMoney(allValue));
			//System.out.println("yearValue==="+TypeUtils.formatWanMoney(yearValue));
			request.setAttribute(CMCCConstant.LASUPDATE, CMCCAction.getDataModifiedTimeStr(dataUpdateDate));
			request.setAttribute("allValue", allValue);
			request.setAttribute("yearValue", yearValue);

		}else if(index==1){
			PageInfo pageInfo=new PageInfo();
			Properties ps=new Properties();
			pageInfo.setConditions(ps);
			ps.put("year", year);
//			cm.getZiJinPoolPageInfo(user, pageInfo);
			List<CMCCZiJinPool> ziJinList=pageInfo.getItems();
			double allValue=0;  //自主资金池总金额
			double projectValue=0d;//立项金额：当年新建项目中，投资计划项目集名称为“自主安排”的项目的“立项批复金额”进行累加
			double yuZhuanValue=0d;//
			for(CMCCZiJinPool p:ziJinList){
				if(dataUpdateDate == null){
					dataUpdateDate = p.getLastUpdateTime();
				}
				if(dataUpdateDate != null && p.getLastUpdateTime() != null && dataUpdateDate.before(p.getLastUpdateTime())){
					dataUpdateDate = p.getLastUpdateTime();
				}
				allValue+=TypeUtils.getNotNullDoubleValue(user, p, "num02");
			}
			ps.put("isZiJinPool", true);
			List<BasCAPEXProject> projectList=cm.getCmProjectPageInfo(user, pageInfo).getItems();
			TypeUtils.prepareForFormList(user, projectList, request);
			for(BasCAPEXProject p:projectList){
				if(dataUpdateDate == null){
					dataUpdateDate = p.getLastUpdateTime();
				}
				if(dataUpdateDate != null && p.getLastUpdateTime() != null && dataUpdateDate.before(p.getLastUpdateTime())){
					dataUpdateDate = p.getLastUpdateTime();
				}
				CMCCTouziPlan plan =p.getYearTouziPlan(year);
				if(plan==null){
					continue;
				}
				String shuxing="";
				if(plan != null){
					shuxing = TypeUtils.resoveFieldAsString(user, plan, "enum04", request);
				}
				if("新建".equals(shuxing)){
					projectValue+=TypeUtils.getNotNullDoubleValue(user, p, "num01");
					yuZhuanValue+=TypeUtils.getNotNullDoubleValue(user, p, "num08")- TypeUtils.getNotNullDoubleValue(user, p, "num01");
				}
			}
			double leftValue=allValue-projectValue-yuZhuanValue;
			request.setAttribute(CMCCConstant.LASUPDATE, CMCCAction.getDataModifiedTimeStr(dataUpdateDate));
			request.setAttribute("leftValue", leftValue);
			request.setAttribute("projectValue", projectValue);
			request.setAttribute("yuZhuanValue", yuZhuanValue);
			request.setAttribute("allValue", allValue);
		}else if(index==2){
			
			PageInfo pageInfo=new PageInfo();
			Properties ps=new Properties();
			pageInfo.setConditions(ps);
			ps.put("year", year);
			cm.getCmProjectPageInfo(user, pageInfo);
			List<BasCAPEXProject> projectList=pageInfo.getItems();
//			TypeUtils.prepareForFormList(user, projectList,"str32", request);
			int newValue=0;
			int xuValue=0;
			int allValue=0;
			Map<String,HighChartData> dataMap=new HashMap();
			HighChartData other=null;
			List<HighChartData> dataList=new ArrayList();
//			Map<Integer,TouziPlanAndCapex> touziAndCapexMap = new HashMap();
//			PageInfo touziAndCapexPage = new PageInfo();
//			List<TouziPlanAndCapex> touziAndCapexs = cm.getTouziPlanAndCapexPageInfo(user, touziAndCapexPage).getItems();
//			for(TouziPlanAndCapex touziAndCapex : touziAndCapexs){
//				touziAndCapexMap.put(TypeUtils.getIntFromString(touziAndCapex.getNum02()), touziAndCapex);
//			}
//			TypeUtils.prepareForFormList(user, touziAndCapexs, request);
		
			
			for(BasCAPEXProject p:projectList){
				if(dataUpdateDate == null){
					dataUpdateDate = p.getLastUpdateTime();
				}
				if(dataUpdateDate != null && p.getLastUpdateTime() != null && dataUpdateDate.before(p.getLastUpdateTime())){
					dataUpdateDate = p.getLastUpdateTime();
				}
//				System.out.println(p.getYear()+" year===="+year+" pID="+p.getID()+" code="+p.getCode());
//				TouziPlanAndCapex touziAndCapex = touziAndCapexMap.get(p.getId());
				CMCCTouziPlan plan = p.getYearTouziPlan(year);
				
				String shuxing="";
				if(plan != null){
					shuxing = TypeUtils.resoveFieldAsString(user, plan, "enum04", request);
				}
				if("新建".equals(shuxing)){
					newValue++;
				}else if("续建".equals(shuxing)){
					xuValue++;
				}
				allValue++;
				
				String zhuanYe=plan!=null?TypeUtils.resoveFieldAsString(user, plan, "enum01", request):"";
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
			//request.setAttribute(CMCCConstant.LASUPDATE, CMCCAction.getDataModifiedTimeStr(dataUpdateDate));
			request.setAttribute("allValue", allValue);
			request.setAttribute("xuValue", xuValue);
			request.setAttribute("newValue", newValue);
			request.setAttribute("dataList", dataList);

		}else if(index==3){
			PageInfo pageInfo=new PageInfo();
			Properties ps=new Properties();
			pageInfo.setConditions(ps);
			ps.put("year", year);
			List<CMCCKaiZhiPlan> list1=cm.getKaiZhiPlanPageInfo(user, pageInfo).getItems();
			List<CMCCZhuanZiPlan> list2=cm.getZhuanZiPlanPageInfo(user, pageInfo).getItems();
			double kaizhiTotal=0;
			double kaizhiActual=0;
			for(CMCCKaiZhiPlan c:list1){
//				kaizhiPlan+=c.getPlanValues(user);
				if(dataUpdateDate == null){
					dataUpdateDate = c.getLastUpdateTime();
				}
				if(dataUpdateDate != null && c.getLastUpdateTime() != null && dataUpdateDate.before(c.getLastUpdateTime())){
					dataUpdateDate = c.getLastUpdateTime();
				}
				kaizhiActual+=c.getActualValues(user);
			}
			
			double zhuanZiTotal=0;
			double zhuanZiActual=0;
			for(CMCCZhuanZiPlan c:list2){
//				zhuanZiPlan+=c.getPlanValues(user);
				if(dataUpdateDate == null){
					dataUpdateDate = c.getLastUpdateTime();
				}
				if(dataUpdateDate != null && c.getLastUpdateTime() != null && dataUpdateDate.before(c.getLastUpdateTime())){
					dataUpdateDate = c.getLastUpdateTime();
				}
				zhuanZiActual+=c.getActualValues(user);
			}
			
			PageInfo zongePage = new PageInfo();
			zongePage.getConditions().put("year", year);
			List<CMCCTouziZongE> totalTouzi = cm.getCMCCTouziZongEPageInfo(user, zongePage).getItems();
			if(totalTouzi != null){
				for(CMCCTouziZongE zonge : totalTouzi){
					if(dataUpdateDate == null){
						dataUpdateDate = zonge.getLastUpdateTime();
					}
					if(dataUpdateDate != null && zonge.getLastUpdateTime() != null && dataUpdateDate.before(zonge.getLastUpdateTime())){
						dataUpdateDate = zonge.getLastUpdateTime();
					}
					kaizhiTotal += TypeUtils.getNotNullDoubleValue(user, zonge, "num01");
					zhuanZiTotal += TypeUtils.getNotNullDoubleValue(user, zonge, "num02");
				}
			}
			//request.setAttribute(CMCCConstant.LASUPDATE, CMCCAction.getDataModifiedTimeStr(dataUpdateDate));
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
		Integer index = 1;
		List<BasCAPEXProject> project = iBasCAPEXProjectService.getALLCAPEXProject();		
		request.setAttribute("project", project);
		request.setAttribute("index", index);	
		return CMCCConstant.PlanResult;
	}
}
