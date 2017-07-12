package com.zq.service.Impl.basic.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.purchase.IBasOtherContractRepository;
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
    
   

}