package com.zq.service.Impl.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.system.ISysFormRepository;
import com.zq.entity.system.SysForm;
import com.zq.service.system.ISysFormService;


/**
 *
 * SysForm 表数据服务层接口实现类
 *
 */
@Service
public class SysFormServiceImpl  implements ISysFormService {
	@Autowired
	ISysFormRepository iSysFormRepository;

	@Override
	public List<SysForm> findByForm(String form) {
		return iSysFormRepository.findByForm(form);
	}
    
}