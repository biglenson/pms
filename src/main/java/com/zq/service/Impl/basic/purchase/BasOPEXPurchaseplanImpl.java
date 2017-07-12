package com.zq.service.Impl.basic.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.purchase.IBasOPEXPurchaseplanRepository;
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
    
   

}