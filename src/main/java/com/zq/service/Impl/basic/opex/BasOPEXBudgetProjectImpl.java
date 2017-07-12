package com.zq.service.Impl.basic.opex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.opex.IBasOPEXBudgetProjectRepository;
import com.zq.service.basic.opex.IBasOPEXBudgetProjectService;

/**
 *
 * BasOPEXBudgetProject 表数据服务层接口实现类
 *
 */
@Service
public class BasOPEXBudgetProjectImpl implements IBasOPEXBudgetProjectService {

    @Autowired
    private IBasOPEXBudgetProjectRepository iBasOPEXBudgetProjectRepository;
    
   

}