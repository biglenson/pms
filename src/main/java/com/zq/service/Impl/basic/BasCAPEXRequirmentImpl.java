package com.zq.service.Impl.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.IBasCAPEXRequirmentRepository;
import com.zq.service.basic.IBasCAPEXRequirmentService;

/**
 *
 * BasCAPEXRequirment 表数据服务层接口实现类
 *
 */
@Service
public class BasCAPEXRequirmentImpl implements IBasCAPEXRequirmentService {

    @Autowired
    private IBasCAPEXRequirmentRepository iBasCAPEXRequirmentRepository;
    
   

}