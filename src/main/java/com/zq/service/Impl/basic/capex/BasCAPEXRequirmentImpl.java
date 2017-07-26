package com.zq.service.Impl.basic.capex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.capex.IBasCAPEXRequirmentRepository;
import com.zq.entity.basic.capex.BasCAPEXRequirment;
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

	@Override
	public Page<BasCAPEXRequirment> getBasCAPEXRequirment(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasCAPEXRequirmentRepository.findAll(request);
	}
    
   

}