package com.zq.service.Impl.basic.capex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    
   

}