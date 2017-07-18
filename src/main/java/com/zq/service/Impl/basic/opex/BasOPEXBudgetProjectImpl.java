package com.zq.service.Impl.basic.opex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.opex.IBasOPEXBudgetProjectRepository;
import com.zq.entity.basic.opex.BasOPEXBudgetProject;
import com.zq.service.basic.opex.IBasOPEXBudgetProjectService;

/**
 *
 * BasOPEXBudgetProject 表数据服务层接口实现类
 *
 */
@Service
public class BasOPEXBudgetProjectImpl implements IBasOPEXBudgetProjectService {

    @Autowired
    private IBasOPEXBudgetProjectRepository iBasOPEXBudgetProjectRepository;

	@Override
	public Page<BasOPEXBudgetProject> getBasOPEXBudgetProject(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasOPEXBudgetProjectRepository.findAll(request);
	}
    
   

}