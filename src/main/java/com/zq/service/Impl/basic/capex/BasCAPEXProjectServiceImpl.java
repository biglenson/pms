package com.zq.service.Impl.basic.capex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	public List<BasCAPEXProject> getBasCAPEXProjectByYear(String year) {
		
		return iBasCAPEXProjectRepository.findByProjStartYear(year);
	}

	@Override
	public Page<BasCAPEXProject> getBasCAPEXProject(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasCAPEXProjectRepository.findAll(request);
	}   

}