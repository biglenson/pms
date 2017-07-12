package com.zq.service.Impl.basic.capex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.capex.IBasCAPEXAmountPoolRepository;
import com.zq.service.basic.capex.IBasCAPEXAmountPoolService;

/**
 *
 * BasCAPEXAmountPool 表数据服务层接口实现类
 *
 */
@Service
public class BasCAPEXAmountPoolImpl implements IBasCAPEXAmountPoolService {

    @Autowired
    private IBasCAPEXAmountPoolRepository iBasCAPEXAmountPoolRepository;
    
   

}