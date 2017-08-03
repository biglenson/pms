package com.zq.service.Impl.system;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.system.ISysStandardtimeRepository;
import com.zq.service.system.ISysStandardtimeService;

/**
 *
 * SysStandardtime 表数据服务层接口实现类
 *
 */
@Service
public class SysStandardtimeServiceImpl implements ISysStandardtimeService {


	private static Logger logger = Logger.getLogger(SysStandardtimeServiceImpl.class);
    @Autowired
    private ISysStandardtimeRepository iSysStandardtimeRepository;

	
}