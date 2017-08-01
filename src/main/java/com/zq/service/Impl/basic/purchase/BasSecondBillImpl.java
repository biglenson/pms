package com.zq.service.Impl.basic.purchase;

import java.util.ArrayList;
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
import com.zq.entity.basic.purchase.BasFirstBill;
import com.zq.entity.basic.purchase.BasSecondBill;
import com.zq.service.basic.purchase.IBasSecondBillService;

/**
 *
 * BasSecondBill 表数据服务层接口实现类
 *
 */
@Service
public class BasSecondBillImpl implements IBasSecondBillService {

    @Autowired
    private IBasSecondBillRepository iBasSecondBillRepository;

	@Override
	public Page<BasSecondBill> getBasSecondBill(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasSecondBillRepository.findAll(request);
	}
	public List getSecondBillByYear(String year) {		
		return iBasSecondBillRepository.findByYear(year);
	}
	@Override
	public HttpServletRequest getTotalMoneyFromBasSecondBill(HttpServletRequest request) {
		Date dataUpdateDate = null;
		Map<String,Double> secondBillMoney=new HashMap();
		Double capexMoney=0d;
		Double opexMoney=0d;
		int capexSCount=0;
		int opexSCount=0;
		String year = request.getParameter("year");
		List<BasFirstBill> secondBillList = this.getSecondBillByYear(year);
		for(int i=0,j=secondBillList.size();i<j;i++){
			BasFirstBill secondBill = secondBillList.get(i);
			if(dataUpdateDate == null){
				dataUpdateDate = secondBill.getLastUpdateTime();
			}else if(secondBill.getLastUpdateTime()!=null && dataUpdateDate.before(secondBill.getLastUpdateTime())){
				dataUpdateDate = secondBill.getLastUpdateTime();
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
    
   

}