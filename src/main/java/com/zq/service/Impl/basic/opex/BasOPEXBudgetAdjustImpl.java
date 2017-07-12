package com.zq.service.Impl.basic.opex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.opex.IBasOPEXBudgetAdjustRepository;
import com.zq.service.basic.opex.IBasOPEXBudgetAdjustService;

/**
 *
 * BasOPEXBudgetAdjust 表数据服务层接口实现类
 *
 */
@Service
public class BasOPEXBudgetAdjustImpl implements IBasOPEXBudgetAdjustService {

    @Autowired
    private IBasOPEXBudgetAdjustRepository iBasOPEXBudgetAdjustRepository;
    
   

}