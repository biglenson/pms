package com.zq.service.Impl.basic.datamap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.capex.IBasCAPEXProjectRepository;
import com.zq.dao.basic.datamap.IBasProductRepository;
import com.zq.dao.basic.datamap.IBasProjCapexRepository;
import com.zq.entity.basic.capex.BasCAPEXProject;
import com.zq.entity.basic.datamap.BasProduct;
import com.zq.entity.basic.datamap.BasProjCapex;
import com.zq.service.basic.datamap.IBasProjCapexService;
import com.zq.vo.basic.datamap.BasProjCapexVO;

/**
 *
 * BasProjCapex 表数据服务层接口实现类
 *
 */
@Service
public class BasProjCapexImpl implements IBasProjCapexService {

	@Autowired
	IBasProjCapexRepository iBasProjCapexRepository;
	@Autowired
	IBasProductRepository iBasProductRepository;
	@Autowired
	IBasCAPEXProjectRepository iBasCAPEXProjectRepository;
	@Override
	public Page<BasProjCapex> getBasProjCapex(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasProjCapexRepository.findAll(request);
	}
	@Override
	public List<BasProjCapexVO> getBasProjCapexVOList(List<BasProjCapex> content) {
		List<BasProjCapexVO> voList = new ArrayList<>();		
		for(BasProjCapex po:content){
			BasProjCapexVO vo = new BasProjCapexVO();
			BeanUtils.copyProperties(po, vo);			
			BasProduct prod = iBasProductRepository.findById(Integer.parseInt(po.getProductCode()));
			BasCAPEXProject proj = iBasCAPEXProjectRepository.findById(Integer.parseInt(po.getProjectCode()));
			String prodCode = prod.getProductCode();
			String prodName = prod.getProductName();			
			String projCode = proj.getProjCode();
			String projName = proj.getProjName();			
			if(prodCode==null||prodCode.equals("")){
				vo.setProductCode("未录入编码");
			}else{
				vo.setProductCode(prodCode);
			}
			if(prodName==null||prodName.equals("")){
				vo.setProductName("未录入名称");
			}else{
				vo.setProductName(prodName);
			}	
			if(projCode==null||projCode.equals("")){
				vo.setProjectCode("未录入编码");
			}else{
				vo.setProjectCode(projCode);
			}
			if(projName==null||projName.equals("")){
				vo.setProjName("未录入名称");
			}else{
				vo.setProjName(projName);
			}
			voList.add(vo);
		}
		return voList;
	}

}