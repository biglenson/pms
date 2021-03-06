package com.zq.service.Impl.basic.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.purchase.IBasOtherContractRepository;
import com.zq.entity.basic.purchase.BasOtherContract;
import com.zq.service.basic.purchase.IBasOtherContractService;

/**
 *
 * BasOtherContract 表数据服务层接口实现类
 *
 */
@Service
public class BasOtherContractImpl implements IBasOtherContractService {

    @Autowired
    private IBasOtherContractRepository iBasOtherContractRepository;

	@Override
	public Page<BasOtherContract> getBasOtherContract(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasOtherContractRepository.findAll(request);
	}
    
   

}