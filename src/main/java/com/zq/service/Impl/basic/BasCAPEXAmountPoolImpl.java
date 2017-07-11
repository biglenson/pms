package com.zq.service.Impl.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.IBasCAPEXAmountPoolRepository;
import com.zq.service.basic.IBasCAPEXAmountPoolService;

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