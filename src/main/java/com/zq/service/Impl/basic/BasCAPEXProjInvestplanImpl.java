package com.zq.service.Impl.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.IBasCAPEXProjInvestplanRepository;
import com.zq.service.basic.IBasCAPEXProjInvestplanService;

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