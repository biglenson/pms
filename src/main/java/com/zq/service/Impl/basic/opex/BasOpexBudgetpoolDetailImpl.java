package com.zq.service.Impl.basic.opex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.opex.IBasOpexBudgetpoolDetailRepository;
import com.zq.service.basic.opex.IBasOpexBudgetpoolDetailService;

/**
 *
 * BasOpexBudgetpoolDetail 表数据服务层接口实现类
 *
 */
@Service
public class BasOpexBudgetpoolDetailImpl implements IBasOpexBudgetpoolDetailService {

    @Autowired
    private IBasOpexBudgetpoolDetailRepository iBasOpexBudgetpoolDetailRepository;
    
   

}