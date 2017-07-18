package com.zq.service.Impl.basic.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.purchase.IBasOPEXPurchaseplanRepository;
import com.zq.entity.basic.purchase.BasOPEXPurchaseplan;
import com.zq.service.basic.purchase.IBasOPEXPurchaseplanService;

/**
 *
 * BasOPEXPurchaseplan 表数据服务层接口实现类
 *
 */
@Service
public class BasOPEXPurchaseplanImpl implements IBasOPEXPurchaseplanService {

    @Autowired
    private IBasOPEXPurchaseplanRepository iBasOPEXPurchaseplanRepository;

	@Override
	public Page<BasOPEXPurchaseplan> getBasOPEXPurchaseplan(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasOPEXPurchaseplanRepository.findAll(request);
	}
    
   

}