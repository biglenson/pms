package com.zq.service.Impl.basic.capex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.capex.IBasCAPEXProjInvestplanRepository;
import com.zq.service.basic.capex.IBasCAPEXProjInvestplanService;

/**
 *
 * BasCAPEXProjInvestplan 表数据服务层接口实现类
 *
 */
@Service
public class BasCAPEXProjInvestplanImpl implements IBasCAPEXProjInvestplanService {

    @Autowired
    private IBasCAPEXProjInvestplanRepository iBasCAPEXProjInvestplanRepository;
    
   

}