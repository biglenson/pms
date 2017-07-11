package com.zq.service.Impl.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.IBasCAPEXInvestPlanRepository;
import com.zq.service.basic.IBasCAPEXInvestPlanService;

/**
 *
 * BasCAPEXInvestPlan 表数据服务层接口实现类
 *
 */
@Service
public class BasCAPEXInvestPlanImpl implements IBasCAPEXInvestPlanService {

    @Autowired
    private IBasCAPEXInvestPlanRepository iBasCAPEXInvestPlanRepository;
    
   

}