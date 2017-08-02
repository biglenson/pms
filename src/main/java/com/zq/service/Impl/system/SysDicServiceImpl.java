package com.zq.service.Impl.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.system.ISysDicRepository;
import com.zq.entity.system.SysDic;
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

	@Override
	public List<SysDic> getAllSysDicListByClass(String string) {
		
		return iSysDicRepository.findByClasscode(string);
	}

	public String getNameByClasscodeAndCode(String classcode, Integer code) {
		return iSysDicRepository.findByClasscodeAndCode(classcode, code).getName();
	}

}