package com.zq.service.Impl.basic.opex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.opex.IBasOPEXManhourRepository;
import com.zq.entity.basic.opex.BasOPEXManhour;
import com.zq.service.basic.opex.IBasOPEXManhourService;

/**
 *
 * BasOPEXManhour 表数据服务层接口实现类
 *
 */
@Service
public class BasOPEXManhourImpl implements IBasOPEXManhourService {

    @Autowired
    private IBasOPEXManhourRepository iBasOPEXManhourRepository;

	@Override
	public Page<BasOPEXManhour> getBasOPEXManhour(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasOPEXManhourRepository.findAll(request);
	}
    
   

}