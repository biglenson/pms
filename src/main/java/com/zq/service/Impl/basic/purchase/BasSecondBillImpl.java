package com.zq.service.Impl.basic.purchase;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			String pinleiName = iSysDicService.getNameByClassAndCode("purchasing_category",secondBill.getCategory());
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
    
   

}