package com.zq.service.Impl.basic.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
    
   

}