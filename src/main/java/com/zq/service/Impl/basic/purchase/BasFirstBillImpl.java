package com.zq.service.Impl.basic.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.purchase.IBasFirstBillRepository;
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
    
   

}