package com.zq.service.Impl.basic.opex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.opex.IBasOPEXProjectRepository;
import com.zq.service.basic.opex.IBasOPEXProjectService;

/**
 *
 * BasOPEXProject 表数据服务层接口实现类
 *
 */
@Service
public class BasOPEXProjectImpl implements IBasOPEXProjectService {

    @Autowired
    private IBasOPEXProjectRepository iBasOPEXProjectRepository;
    
   

}