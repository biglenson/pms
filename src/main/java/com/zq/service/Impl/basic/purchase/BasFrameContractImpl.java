package com.zq.service.Impl.basic.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.purchase.IBasFrameContractRepository;
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
    
   

}