package com.zq.service.Impl.basic.capex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.service.basic.capex.IBasCAPEXExpendplanService;

/**
 *
 * BasCAPEXExpendplan 表数据服务层接口实现类
 *
 */
@Service
public class BasCAPEXExpendplanImpl implements IBasCAPEXExpendplanService {

    @Autowired
    private IBasCAPEXExpendplanService iBasCAPEXExpendplanRepository;
    
   

}