package com.zq.service.Impl.basic.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.purchase.IBasSecondBillRepository;
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
    
   

}