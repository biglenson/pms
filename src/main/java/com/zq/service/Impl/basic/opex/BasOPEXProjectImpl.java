package com.zq.service.Impl.basic.opex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.opex.IBasOPEXProjectRepository;
import com.zq.entity.basic.opex.BasOPEXProject;
import com.zq.service.basic.opex.IBasOPEXProjectService;

/**
 *
 * BasOPEXProject 表数据服务层接口实现类
 *
 */
@Service
public class BasOPEXProjectImpl implements IBasOPEXProjectService {

    @Autowired
    private IBasOPEXProjectRepository iBasOPEXProjectRepository;

	@Override
	public Page<BasOPEXProject> getBasOPEXProject(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasOPEXProjectRepository.findAll(request);
	}
    
   

}