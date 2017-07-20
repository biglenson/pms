package com.zq.service.Impl.basic.opex;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.opex.IBasOPEXManhourRepository;
import com.zq.dao.basic.opex.IBasOPEXProjectRepository;
import com.zq.entity.basic.opex.BasOPEXManhour;
import com.zq.entity.basic.opex.BasOPEXProject;
import com.zq.service.basic.opex.IBasOPEXManhourService;
import com.zq.vo.basic.opex.BasOPEXManhourVO;

/**
 *
 * BasOPEXManhour 表数据服务层接口实现类
 *
 */
@Service
public class BasOPEXManhourImpl implements IBasOPEXManhourService {

    @Autowired
    private IBasOPEXManhourRepository iBasOPEXManhourRepository;
    @Autowired
    private IBasOPEXProjectRepository iBasOPEXProjectRepository;

	@Override
	public Page<BasOPEXManhour> getBasOPEXManhour(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasOPEXManhourRepository.findAll(request);
	}

	@Override
	public List<BasOPEXManhourVO> getBasOPEXManhourVOList(List<BasOPEXManhour> list) {
		List<BasOPEXManhourVO> voList = new ArrayList<>();		
		for(BasOPEXManhour po:list){
			BasOPEXManhourVO vo = new BasOPEXManhourVO();
			BeanUtils.copyProperties(po, vo);			
			BasOPEXProject proj = iBasOPEXProjectRepository.findById(Integer.parseInt(po.getOpexProjCode()));
			String projName = proj.getProjName();
			String projCode = proj.getProjCode();
			if(projName==null||projName.equals("")){
				vo.setOpexProjName("未录入名称");
			}else{
				vo.setOpexProjName(projName);
			}
			if(projCode==null||projCode.equals("")){
				vo.setOpexProjCode("未录入编码");
			}else{
				vo.setOpexProjCode(projCode);
			}
			voList.add(vo);
		}
		return voList;
	}
    
   

}