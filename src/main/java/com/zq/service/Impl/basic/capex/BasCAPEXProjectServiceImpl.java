package com.zq.service.Impl.basic.capex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.capex.IBasCAPEXProjectRepository;
import com.zq.entity.basic.capex.BasCAPEXProject;
import com.zq.service.basic.capex.IBasCAPEXProjectService;

/**
 *
 * BasCAPEXProject 表数据服务层接口实现类
 *
 */
@Service
public class BasCAPEXProjectServiceImpl implements IBasCAPEXProjectService {

    @Autowired
    private IBasCAPEXProjectRepository iBasCAPEXProjectRepository;

	@Override
	public List<BasCAPEXProject> getALLCAPEXProject() {
		
		return iBasCAPEXProjectRepository.findAll();
	}

	@Override
	public BasCAPEXProject getCAPEXProject() {
		
		return null;
	}

	@Override
	public List<BasCAPEXProject> getAllCAPEXProjectByYear(int year) {
		
		return iBasCAPEXProjectRepository.findByYear(year);
	}


    
	
   

}