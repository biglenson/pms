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
import com.zq.dao.basic.purchase.IBasFirstBillRepository;
import com.zq.entity.basic.purchase.BasFirstBill;
import com.zq.service.basic.purchase.IBasFirstBillService;

/**
 *
 * BasFirstBill 表数据服务层接口实现类
 *
 */
@Service
public class BasFirstBillImpl implements IBasFirstBillService {

    @Autowired
    private IBasFirstBillRepository iBasFirstBillRepository;

	@Override
	public Page<BasFirstBill> getBasFirstBill(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasFirstBillRepository.findAll(request);
	}
	public List getFirstBillByYear(String year) {		
		return iBasFirstBillRepository.findByYear(year);
	}
	@Override
	public HttpServletRequest getTotalMoneyFromBasFirstBill(HttpServletRequest request) {
		Date dataUpdateDate = null;
		Map<String,Double> firstBillMoney=new HashMap();
		Double capexMoney=0d;
		Double opexMoney=0d;
		int capexFCount=0;
		int opexFCount=0;
		String year = request.getParameter("year");
		List<BasFirstBill> firstBillList = this.getFirstBillByYear(year);
		for(int i=0,j=firstBillList.size();i<j;i++){
			BasFirstBill firstBill = firstBillList.get(i);
			if(dataUpdateDate == null){
				dataUpdateDate = firstBill.getModifyTime();
			}else if(firstBill.getModifyTime()!=null && dataUpdateDate.before(firstBill.getModifyTime())){
				dataUpdateDate = firstBill.getModifyTime();
			}
			int type=firstBill.getExpenditureType();
			if(type==1){//capex
				capexMoney+=TypeUtils.string2Double(firstBill.getContractInTax());
				capexFCount++;
			}else if(type==2){//opex
				opexMoney+=TypeUtils.string2Double(firstBill.getContractInTax());
				opexFCount++;
			}
		}
		firstBillMoney.put("capexMoney", capexMoney);
		firstBillMoney.put("opexMoney", opexMoney);	
		request.setAttribute(CMCCConstant.LASUPDATE, TypeUtils.getRelativeTime(dataUpdateDate));
		request.setAttribute("capexFCount",capexFCount);
		request.setAttribute("opexFCount",opexFCount);
		request.setAttribute("firstBillMoney",firstBillMoney);
		return request;
	}
}