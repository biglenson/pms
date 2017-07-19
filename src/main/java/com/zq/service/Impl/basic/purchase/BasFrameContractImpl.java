package com.zq.service.Impl.basic.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.purchase.IBasFrameContractRepository;
import com.zq.entity.basic.purchase.BasFrameContract;
import com.zq.service.basic.purchase.IBasFrameContractService;

/**
 *
 * BasFrameContract 表数据服务层接口实现类
 *
 */
@Service
public class BasFrameContractImpl implements IBasFrameContractService {

    @Autowired
    private IBasFrameContractRepository iBasFrameContractRepository;

	@Override
	public Page<BasFrameContract> getBasFrameContract(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasFrameContractRepository.findAll(request);
	}
    
   

}