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
import com.zq.dao.basic.purchase.IBasFrameContractRepository;
import com.zq.entity.basic.purchase.BasFrameContract;
import com.zq.service.basic.purchase.IBasFrameContractService;
import com.zq.service.system.ISysDicService;

/**
 *
 * BasFrameContract 表数据服务层接口实现类
 *
 */
@Service
public class BasFrameContractImpl implements IBasFrameContractService {

    @Autowired
    private IBasFrameContractRepository iBasFrameContractRepository;
    
    @Autowired
    private ISysDicService iSysDicService;

	@Override
	public Page<BasFrameContract> getBasFrameContract(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasFrameContractRepository.findAll(request);
	}

	@Override
	public HttpServletRequest getTotalMoneyFromBasFrame(HttpServletRequest request) {
		Date dataUpdateDate = null;
		String year = request.getParameter("year");
		Map<String,Double> capexMoney=new HashMap();
		Double cMoney=0d;
		Map<String,Double> opexMoney=new HashMap();
		Double oMoney=0d;
		List<BasFrameContract> frameContractList = this.getAllframeContractList(year);
		for(int i=0,j=frameContractList.size();i<j;i++){
			BasFrameContract frameContract = frameContractList.get(i);
			if(TypeUtils.getIntFromString(frameContract.getYear())<=0){
				continue;
			}
			int isJicai = frameContract.getPurchasingWay();
			if(year != frameContract.getYear() || isJicai==1){
				continue;
			}
			if(dataUpdateDate == null){
				dataUpdateDate = frameContract.getModifyTime();
			}else if(frameContract.getModifyTime()!=null && dataUpdateDate.before(frameContract.getModifyTime())){
				dataUpdateDate = frameContract.getModifyTime();
			}
			int type=frameContract.getExpenditureType();
			if(type==0){//capex
				cMoney+=TypeUtils.string2Double(frameContract.getContractInTax());
			}else if(type==1){//opex
				oMoney+=TypeUtils.string2Double(frameContract.getContractInTax());
			}
		}
		return request;
	}

	private List<BasFrameContract> getAllframeContractList(String year) {
		
		return iBasFrameContractRepository.findByYear(year);
	}

	@Override
	public HttpServletRequest getPKindFromFrameContract(HttpServletRequest request, Map<String, Double> categoryMoney,
			Map<String, Integer> categoryProject) {
		Date dataUpdateDate = null;
		String year = request.getParameter("year");
		List<BasFrameContract> frameContracts = this.getAllframeContractList(year);
		for(int i=0,j=frameContracts.size();i<j;i++){
			BasFrameContract frameContract = frameContracts.get(i);
			int isJicai = frameContract.getPurchasingWay();
			String pinleiName = iSysDicService.getNameByClasscodeAndCode("purchasing_category",frameContract.getFrameCategories());
			if(year != frameContract.getYear() || isJicai==10){
				continue;
			}
			if(dataUpdateDate == null){
				dataUpdateDate = frameContract.getModifyTime();
			}else if(frameContract.getModifyTime()!=null && dataUpdateDate.before(frameContract.getModifyTime())){
				dataUpdateDate = frameContract.getModifyTime();
			}
			Double money = categoryMoney.get(pinleiName)==null?0:categoryMoney.get(pinleiName) + TypeUtils.string2Double(frameContract.getContractInTax());
			categoryMoney.put(pinleiName, money);
		}
		request.setAttribute(CMCCConstant.LASUPDATE, TypeUtils.getRelativeTime(dataUpdateDate));
		request.setAttribute("categoryMoney",categoryMoney);
		return request;
	}
    
   

}