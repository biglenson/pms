package com.zq.service.Impl.basic.capex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.capex.IBasCAPEXRequirmentRepository;
import com.zq.service.basic.capex.IBasCAPEXRequirmentService;

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