package com.zq.service.Impl.basic.capex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
    
   

}