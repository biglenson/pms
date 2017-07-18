package com.zq.service.Impl.basic.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.purchase.IBasSecondBillRepository;
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
    
   

}