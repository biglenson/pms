package com.zq.service.Impl.basic.capex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.capex.IBasCAPEXTotalInvestplanRepository;
import com.zq.service.basic.capex.IBasCAPEXTotalInvestplanService;

/**
 *
 * BasCAPEXTotalInvestplan 表数据服务层接口实现类
 *
 */
@Service
public class BasCAPEXTotalInvestplanImpl implements IBasCAPEXTotalInvestplanService {

    @Autowired
    private IBasCAPEXTotalInvestplanRepository iBasCAPEXTotalInvestplanRepository;
    
   

}