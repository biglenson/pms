package com.zq.service.Impl.basic.capex;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.commons.utils.CMCCConstant;
import com.zq.commons.utils.TypeUtils;
import com.zq.dao.basic.capex.IBasCAPEXAmountPoolRepository;
import com.zq.entity.basic.capex.BasCAPEXAmountPool;
import com.zq.service.basic.capex.IBasCAPEXAmountPoolService;

/**
 *
 * BasCAPEXAmountPool 表数据服务层接口实现类
 *
 */
@Service
public class BasCAPEXAmountPoolImpl implements IBasCAPEXAmountPoolService {

    @Autowired
    private IBasCAPEXAmountPoolRepository iBasCAPEXAmountPoolRepository;

	@Override
	public List<BasCAPEXAmountPool> getAllCAPEXAmountPoolByYear(String year) {
		
		return iBasCAPEXAmountPoolRepository.findByYear(year);
	}

	@Override
	public Page<BasCAPEXAmountPool> getBasCAPEXAmountPool(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasCAPEXAmountPoolRepository.findAll(request);
	}

	
	@Override
	public HttpServletRequest getBasCAPEXAmountPoolUsage(String year, HttpServletRequest request) {
		double ziJinValue = 0d;
		double ziJinShiYongValue = 0d;
		Date dataUpdateDate = null;
		List<BasCAPEXAmountPool> poolList = this.getAllCAPEXAmountPoolByYear(year);
		for (BasCAPEXAmountPool pool : poolList) {
			if (dataUpdateDate == null) {
				dataUpdateDate = pool.getModifyTime();
			}
			if (dataUpdateDate != null && pool.getModifyTime() != null
					&& dataUpdateDate.before(pool.getModifyTime())) {
				dataUpdateDate = pool.getModifyTime();
			}
			ziJinValue += TypeUtils.string2Double(pool.getInitialAmount());
			ziJinShiYongValue += TypeUtils.string2Double(pool.getPreoccupyAmount());
		}
		ziJinShiYongValue = ziJinValue - ziJinShiYongValue;
		request.setAttribute("ziJinValue", ziJinValue);
		request.setAttribute("ziJinShiYongValue", ziJinShiYongValue);
		request.setAttribute(CMCCConstant.LASUPDATE, TypeUtils.getRelativeTime(dataUpdateDate));
		return request;
	}
    
   

}