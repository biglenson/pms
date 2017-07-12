package com.zq.service.Impl.basic.capex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.capex.IBasCAPEXTransferplanRepository;
import com.zq.service.basic.capex.IBasCAPEXTransferplanService;

/**
 *
 * BasCAPEXTransferplan 表数据服务层接口实现类
 *
 */
@Service
public class BasCAPEXTransferplanImpl implements IBasCAPEXTransferplanService {

    @Autowired
    private IBasCAPEXTransferplanRepository iBasCAPEXTransferplanRepository;
    
   

}