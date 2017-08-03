package com.zq.service.Impl.basic.purchase;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.commons.utils.CMCCConstant;
import com.zq.commons.utils.TypeUtils;
import com.zq.dao.basic.purchase.IBasSecondBillRepository;
import com.zq.entity.basic.purchase.BasSecondBill;
import com.zq.service.basic.purchase.IBasSecondBillService;
import com.zq.service.system.ISysDicService;

/**
 *
 * BasSecondBill 表数据服务层接口实现类
 *
 */
@Service
public class BasSecondBillImpl implements IBasSecondBillService {

    @Autowired
    private IBasSecondBillRepository iBasSecondBillRepository;
    
    @Autowired
    private ISysDicService iSysDicService;

	@Override
	public Page<BasSecondBill> getBasSecondBill(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasSecondBillRepository.findAll(request);
	}
	public List<BasSecondBill> getSecondBillByYear(String year) {		
		return iBasSecondBillRepository.findByYear(year);
	}
	@Override
	public HttpServletRequest getTotalMoneyFromBasSecondBill(HttpServletRequest request) {
		Date dataUpdateDate = null;
		Map<String,Double> secondBillMoney=new HashMap<String, Double>();
		Double capexMoney=0d;
		Double opexMoney=0d;
		int capexSCount=0;
		int opexSCount=0;
		String year = request.getParameter("year");
		List<BasSecondBill> secondBillList = this.getSecondBillByYear(year);
		for(int i=0,j=secondBillList.size();i<j;i++){
			BasSecondBill secondBill = secondBillList.get(i);
			if(dataUpdateDate == null){
				dataUpdateDate = secondBill.getModifyTime();
			}else if(secondBill.getModifyTime()!=null && dataUpdateDate.before(secondBill.getModifyTime())){
				dataUpdateDate = secondBill.getModifyTime();
			}
			int type=secondBill.getExpenditureType();
			if(type==1){//capex
				capexMoney+=TypeUtils.string2Double(secondBill.getContractInTax());
				capexSCount++;
			}else if(type==2){//opex
				opexMoney+=TypeUtils.string2Double(secondBill.getContractInTax());
				opexSCount++;
			}
		}
		secondBillMoney.put("capexMoney", capexMoney);
		secondBillMoney.put("opexMoney", opexMoney);
		request.setAttribute(CMCCConstant.LASUPDATE, TypeUtils.getRelativeTime(dataUpdateDate));
		request.setAttribute("capexSCount",capexSCount);
		request.setAttribute("opexSCount",opexSCount);
		request.setAttribute("secondBillMoney",secondBillMoney);
		return request;
	}
	@Override
	public HttpServletRequest getPKindFromSecondBill(HttpServletRequest request, Map<String, Double> categoryMoney,
			Map<String, Integer> categoryProject) {
		Date dataUpdateDate = null;
		String year = request.getParameter("year");
		List<BasSecondBill> secondBills = this.getSecondBillByYear(year);
		for(int i=0,j=secondBills.size();i<j;i++){
			BasSecondBill secondBill = secondBills.get(i);			
			int isFrame = secondBill.getContractFrameStatus();
			int isRebulidProject = secondBill.getProjResetuprStatus();
			String pinleiName = iSysDicService.getNameByClasscodeAndCode("purchasing_category",secondBill.getCategory());
			if(dataUpdateDate == null){
				dataUpdateDate = secondBill.getModifyTime();
			}else if(secondBill.getModifyTime()!=null && dataUpdateDate.before(secondBill.getModifyTime())){
				dataUpdateDate = secondBill.getModifyTime();
			}
			if(isFrame==1){
				//计算金额
				Double money = categoryMoney.get(pinleiName)==null?0:categoryMoney.get(pinleiName) + TypeUtils.string2Double(secondBill.getContractInTax());
				categoryMoney.put(pinleiName, money);
			}
			if(isRebulidProject==1){
				//计算项目的个数
				Integer count = categoryProject.get(pinleiName)==null?0:categoryProject.get(pinleiName) + 1;
				categoryProject.put(pinleiName, count);
			}
		}
		request.setAttribute(CMCCConstant.LASUPDATE, TypeUtils.getRelativeTime(dataUpdateDate));
		request.setAttribute("categoryMoney",categoryMoney);
		request.setAttribute("categoryProject",categoryProject);
		return request;
	}
	@Override
	public HttpServletRequest getPMethodFromSecondBill(HttpServletRequest request, Map<String, Double> zhichuMoney,
			Map<String, Integer> zhichuProject) {
		Date dataUpdateDate = null;
		String year = request.getParameter("year");
		List<BasSecondBill> secondBills = this.getSecondBillByYear(year);
		Set<String> secondBillNames = new HashSet();
		for(int i=0,j=secondBills.size();i<j;i++){
			BasSecondBill secondBill = secondBills.get(i);
			int isRebulidProject = secondBill.getProjResetuprStatus();
			String methodName = iSysDicService.getNameByClasscodeAndCode("purchasing_method",secondBill.getPurchasingMethod());
			if(year != secondBill.getYear() || isRebulidProject==1){
				continue;
			}
			if(dataUpdateDate == null){
				dataUpdateDate = secondBill.getModifyTime();
			}else if(secondBill.getModifyTime()!=null && dataUpdateDate.before(secondBill.getModifyTime())){
				dataUpdateDate = secondBill.getModifyTime();
			}
			Double money = zhichuMoney.get(methodName)==null?0:zhichuMoney.get(methodName) + TypeUtils.string2Double(secondBill.getContractInTax());
			zhichuMoney.put(methodName, money);
			boolean flag = secondBillNames.add(secondBill.getProjName());
			if(flag){
				Integer count = zhichuProject.get(methodName)==null?0:zhichuProject.get(methodName) + 1;
				zhichuProject.put(methodName, count);
			}
			
		}
		request.setAttribute(CMCCConstant.LASUPDATE, TypeUtils.getRelativeTime(dataUpdateDate));
		request.setAttribute("zhichuMoney",zhichuMoney);
		request.setAttribute("zhichuProject",zhichuProject);
		return request;
	}
	@Override
	public HttpServletRequest getCostSavingFromSecondBill(HttpServletRequest request) {
		Date dataUpdateDate = null;
		String year = request.getParameter("year");
		Double totalMoney = 0d;
		Double capexPlanMoney = 0d;
		Double opexPlanMoney = 0d;
		Double capexActualMoney = 0d;
		Double opexActualMoney = 0d;
		List<BasSecondBill> secondBills = this.getSecondBillByYear(year);
		for(int i=0,j=secondBills.size();i<j;i++){
			BasSecondBill secondBill = secondBills.get(i);
			String jueceLevelName = iSysDicService.getNameByClasscodeAndCode("confirm_level",secondBill.getPlanDecisioner());
			int type = secondBill.getExpenditureType();
			if(year != secondBill.getYear() || "".equals(jueceLevelName)){
				continue;
			}
			if(dataUpdateDate == null){
				dataUpdateDate = secondBill.getModifyTime();
			}else if(secondBill.getModifyTime()!=null && dataUpdateDate.before(secondBill.getModifyTime())){
				dataUpdateDate = secondBill.getModifyTime();
			}
			if(type==1){//capex
				capexPlanMoney += TypeUtils.string2Double(secondBill.getPlanDecisionAmount());
				capexActualMoney += TypeUtils.string2Double(secondBill.getPurchaseResConfirmAmount());
			}else if(type==2){//opex
				opexPlanMoney += TypeUtils.string2Double(secondBill.getPlanDecisionAmount());
				opexActualMoney += TypeUtils.string2Double(secondBill.getPurchaseResConfirmAmount());
			}
		}
		totalMoney = capexPlanMoney + opexPlanMoney - capexActualMoney - opexActualMoney;
		request.setAttribute(CMCCConstant.LASUPDATE, TypeUtils.getRelativeTime(dataUpdateDate));
		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("capexPlanMoney", capexPlanMoney);
		request.setAttribute("opexPlanMoney", opexPlanMoney);
		request.setAttribute("capexActualMoney", capexActualMoney);
		request.setAttribute("opexActualMoney", opexActualMoney);
		return request;
	}
	
	
	
	/* (非
	Javadoc)
	* <p>Title: getOpenMoneyInfoFromSecondBill</p>
	* <p>Description: 和项目数公用一个方法</p>
	* @param request
	* @return
	* @see com.zq.service.basic.purchase.IBasSecondBillService#getOpenMoneyInfoFromSecondBill(javax.servlet.http.HttpServletRequest)
	*/
	@Override
	public HttpServletRequest getOpenMoneyInfoFromSecondBill(HttpServletRequest request) {
		Date dataUpdateDate = null;
		Map<String,List> allOpenData = new HashMap();
		List dataList = new ArrayList();
		dataList.add(0d);
		dataList.add(0);
		List dataList1 = new ArrayList();
		dataList1.add(0d);
		dataList1.add(0);
		allOpenData.put("公开类", dataList);
		allOpenData.put("非公开类", dataList1);
		String year = request.getParameter("year");
		List<BasSecondBill> secondBills = this.getSecondBillByYear(year);
		for(int i=0,j=secondBills.size();i<j;i++){
			BasSecondBill secondBill = secondBills.get(i);
			String isRebulid = iSysDicService.getNameByClasscodeAndCode("yesno_code",secondBill.getProjResetuprStatus());
			String isPublishNotice = iSysDicService.getNameByClasscodeAndCode("yesno_code",secondBill.getSssNoticeStatus());
			String caigouMethod = iSysDicService.getNameByClasscodeAndCode("purchasing_method",secondBill.getPurchasingMethod());
			if(year != secondBill.getYear() || "是".equals(isRebulid)){
				continue;
			}
			if(dataUpdateDate == null){
				dataUpdateDate = secondBill.getModifyTime();
			}else if(secondBill.getModifyTime()!=null && dataUpdateDate.before(secondBill.getModifyTime())){
				dataUpdateDate = secondBill.getModifyTime();
			}
			if("单一来源谈判".equals(caigouMethod)){
				if("是".equals(isPublishNotice)){
					List openData = allOpenData.get("公开类");
					Double money = (Double) openData.get(0) + TypeUtils.string2Double(secondBill.getPurchaseResConfirmAmount());
					Integer count = (Integer) openData.get(1) + 1;
					openData.add(0, money);
					openData.add(1, count);
					allOpenData.put("公开类", openData);
				}else if("否".equals(isPublishNotice)){
					List openData = allOpenData.get("非公开类");
					Double money = (Double) openData.get(0) + TypeUtils.string2Double(secondBill.getPurchaseResConfirmAmount());
					Integer count = (Integer) openData.get(1) + 1;
					openData.add(0, money);
					openData.add(1, count);
					allOpenData.put("非公开类", openData);
				}
			}else if("公开招标".equals(caigouMethod) || "公开比选".equals(caigouMethod) || "公开询价".equals(caigouMethod)){
				List openData = allOpenData.get("公开类");
				Double money = (Double) openData.get(0) + TypeUtils.string2Double(secondBill.getPurchaseResConfirmAmount());
				Integer count = (Integer) openData.get(1) + 1;
				openData.add(0, money);
				openData.add(1, count);
				allOpenData.put("公开类", openData);
			}else if("邀请招标".equals(caigouMethod) || "邀请比选".equals(caigouMethod) || "邀请询价".equals(caigouMethod) || "竞争性谈判".equals(caigouMethod)){
				List openData = allOpenData.get("非公开类");
				Double money = (Double) openData.get(0) + TypeUtils.string2Double(secondBill.getPurchaseResConfirmAmount());
				Integer count = (Integer) openData.get(1) + 1;
				openData.add(0, money);
				openData.add(1, count);
				allOpenData.put("非公开类", openData);
			}
		}
		request.setAttribute(CMCCConstant.LASUPDATE, TypeUtils.getRelativeTime(dataUpdateDate));
		request.setAttribute("allOpenData", allOpenData); 
		return request;
	}
	@Override
	public HttpServletRequest getFinishInTimeFromSecondBill(HttpServletRequest request) {
		Date dataUpdateDate = null;
		String year=request.getParameter("year");
		int index=TypeUtils.getIntFromString(request.getParameter("index"));
		List<BasSecondBill> secondBillList=this.getSecondBillByYear(year);
		Map<String,Integer> startTimesMap = (Map<String,Integer>)request.getAttribute("startTimesMap");
		Map<String,Integer> finishTimesNormalMap = (Map<String,Integer>)request.getAttribute("finishTimesNormalMap");
		Map<String,Integer> finishTimesImportantMap = (Map<String,Integer>)request.getAttribute("finishTimesImportantMap");
		int startCount = 0;
		int delayStartCount = 0;
		Double totalDelatStartDays = 0d;
		int finishCount = 0;
		int delayFinishCount = 0;
		Double totalDelayFinishDays = 0d;
		for(BasSecondBill secondbill:secondBillList){
			if(dataUpdateDate == null){
				dataUpdateDate = secondbill.getModifyTime();
			}else if(secondbill.getModifyTime()!=null && dataUpdateDate.before(secondbill.getModifyTime())){
				dataUpdateDate = secondbill.getModifyTime();
			}
			String isSingle = iSysDicService.getNameByClasscodeAndCode("purchasing_method",secondbill.getPurchasingMethod());
			String caigouJuece = iSysDicService.getNameByClasscodeAndCode("confirm_level",secondbill.getPlanDecisioner());
			if("单一来源".equals(isSingle)||"单一来源谈判".equals(isSingle) ){
				if(index == 0){
					startCount += 1;
				}else if(index == 1){
					finishCount += 1;
				}
			}else{
				Date compareDate = new Date("2016/07/01");
				if(secondbill.getReqCollectTime() == null || secondbill.getReqCollectTime().getTime() < compareDate.getTime()){
					continue;
				}
				long demandTime = secondbill.getReqCollectTime().getTime();
				if(index == 0){
					//根据采购方式和决策层级取到启动标准时限
					int standardTime = 0;//取得标准时限
					if(isSingle.contains("招标")){
						standardTime = startTimesMap.get("招标");
					}else if(isSingle.contains("比选")){
						standardTime = startTimesMap.get("比选");
					}else if(isSingle.contains("询价")){
						standardTime = startTimesMap.get("询价");
					}else if(isSingle.contains("竞争性谈判")){
						standardTime = startTimesMap.get("竞争性谈判");
					}
					if(secondbill.getPlanDecisionTime() == null){
						continue;
					}
					long jueceTime = secondbill.getPlanDecisionTime().getTime();
					Long betweenDays = (jueceTime-demandTime)/(1000*3600*24);
					int actualTime = betweenDays.intValue();
					if(actualTime < standardTime){
						startCount += 1;
					}else{
						totalDelatStartDays += actualTime-standardTime;
						delayStartCount += 1;
					}
				}else if(index == 1){
					//根据采购方式和决策层级取到完成标准时限
					int standardTime = 0;//制造的标准时限
					Map<String,Integer> tempMap = finishTimesNormalMap;
					if(caigouJuece.contains("总经理")){
						//重大
						tempMap = finishTimesImportantMap;
					}
					if(isSingle.contains("招标")){
						standardTime = tempMap.get("招标");
					}else if(isSingle.contains("比选")){
						standardTime = tempMap.get("比选");
					}else if(isSingle.contains("询价")){
						standardTime = tempMap.get("询价");
					}else if(isSingle.contains("竞争性谈判")){
						standardTime = tempMap.get("竞争性谈判");
					}
					if(secondbill.getPaperReviseTime() == null){
						continue;
					}
					long contractTime = secondbill.getPaperReviseTime().getTime();
					Long betweenDays = (contractTime-demandTime)/(1000*3600*24);
					int actualTime = betweenDays.intValue();
					if(actualTime < standardTime){
						finishCount += 1;
					}else{
						totalDelayFinishDays += actualTime-standardTime;
						delayFinishCount += 1;
					}
				}
			}
		}
		request.setAttribute(CMCCConstant.LASUPDATE, TypeUtils.getRelativeTime(dataUpdateDate));
		request.setAttribute("finishAllCount", finishCount+delayFinishCount);
		request.setAttribute("finishCount", finishCount);
		request.setAttribute("delayFinishCount", delayFinishCount);
		request.setAttribute("totalDelayFinishDays", totalDelayFinishDays);
		request.setAttribute("startCount",startCount);
		request.setAttribute("delayStartCount",delayStartCount);
		request.setAttribute("finishCount",finishCount);
		request.setAttribute("delayFinishCount",delayFinishCount);
		return request;
	}	
    
   

}