package com.zq.service.Impl.basic.opex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.opex.IBasOPEXManhourRepository;
import com.zq.service.basic.opex.IBasOPEXManhourService;

/**
 *
 * BasOPEXManhour 表数据服务层接口实现类
 *
 */
@Service
public class BasOPEXManhourImpl implements IBasOPEXManhourService {

    @Autowired
    private IBasOPEXManhourRepository iBasOPEXManhourRepository;
    
   

}