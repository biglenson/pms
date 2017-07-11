package com.zq.service.Impl.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.IBasCAPEXExpendplanRepository;
import com.zq.service.basic.IBasCAPEXExpendplanService;

/**
 *
 * BasCAPEXExpendplan 表数据服务层接口实现类
 *
 */
@Service
public class BasCAPEXExpendplanImpl implements IBasCAPEXExpendplanService {

    @Autowired
    private IBasCAPEXExpendplanRepository iBasCAPEXExpendplanRepository;
    
   

}