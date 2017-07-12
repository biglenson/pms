package com.zq.service.Impl.basic.opex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.opex.IBasOPEXBudgetpoolRepository;
import com.zq.service.basic.opex.IBasOPEXBudgetpoolService;

/**
 *
 * BasOPEXBudgetpool 表数据服务层接口实现类
 *
 */
@Service
public class BasOPEXBudgetpoolImpl implements IBasOPEXBudgetpoolService {

    @Autowired
    private IBasOPEXBudgetpoolRepository iBasOPEXBudgetpoolRepository;
    
   

}