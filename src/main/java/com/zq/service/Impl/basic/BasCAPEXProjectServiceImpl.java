package com.zq.service.Impl.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.IBasCAPEXProjectRepository;
import com.zq.service.basic.IBasCAPEXProjectService;

/**
 *
 * BasCAPEXProject 表数据服务层接口实现类
 *
 */
@Service
public class BasCAPEXProjectServiceImpl implements IBasCAPEXProjectService {

    @Autowired
    private IBasCAPEXProjectRepository iBasCAPEXProjectRepository;
    
   

}