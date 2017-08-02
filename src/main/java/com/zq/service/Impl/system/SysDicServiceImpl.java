package com.zq.service.Impl.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.system.ISysDicRepository;
import com.zq.service.system.ISysDicService;

/**
 *
 * SysDic 表数据服务层接口实现类
 *
 */
@Service
public class SysDicServiceImpl implements ISysDicService {

    @Autowired
    private ISysDicRepository iSysDicRepository;



}