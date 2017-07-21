package com.zq.service.Impl.basic.datamap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.capex.IBasCAPEXProjectRepository;
import com.zq.dao.basic.datamap.IBasAssetDetailRepository;
import com.zq.entity.basic.capex.BasCAPEXProject;
import com.zq.entity.basic.datamap.BasAssetDetail;
import com.zq.service.basic.datamap.IBasAssetDetailService;
import com.zq.vo.basic.datamap.BasAssetDetailVO;

/**
 *
 * BasAssetDetail 表数据服务层接口实现类
 *
 */
@Service
public class BasAssetDetailImpl implements IBasAssetDetailService {

	@Autowired
	IBasAssetDetailRepository iBasAssetDetailRepository;
	@Autowired
	IBasCAPEXProjectRepository iBasCAPEXProjectRepository;
	@Override
	public Page<BasAssetDetail> getBasAssetDetail(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasAssetDetailRepository.findAll(request);
	}
	@Override
	public List<BasAssetDetailVO> getBasAssetDetailVOList(List<BasAssetDetail> content) {
		List<BasAssetDetailVO> voList = new ArrayList<>();		
		for(BasAssetDetail po:content){
			BasAssetDetailVO vo = new BasAssetDetailVO();
			BeanUtils.copyProperties(po, vo);		
			if(po.getProjCode()!=null){
				if(po.getProjCode()!=""){
					BasCAPEXProject proj = iBasCAPEXProjectRepository.findById(Integer.parseInt(po.getProjCode()));
					String projCode = proj.getProjCode();
					String projName = proj.getProjName();	
					if(projCode==null||projCode.equals("")){
						vo.setProjCode("未录入编码");
					}else{
						vo.setProjCode(projCode);
					}
					if(projName==null||projName.equals("")){
						vo.setProjName("未录入名称");
					}else{
						vo.setProjName(projName);
					}	
				}				
			}			
			voList.add(vo);
		}
		return voList;
	}

}