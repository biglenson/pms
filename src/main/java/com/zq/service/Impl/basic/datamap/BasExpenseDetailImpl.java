package com.zq.service.Impl.basic.datamap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.datamap.IBasExpenseDetailRepository;
import com.zq.dao.basic.datamap.IBasProductRepository;
import com.zq.entity.basic.datamap.BasExpenseDetail;
import com.zq.entity.basic.datamap.BasProduct;
import com.zq.service.basic.datamap.IBasExpenseDetailService;
import com.zq.vo.basic.datamap.BasExpenseDetailVO;

/**
 *
 * BasExpenseDetail 表数据服务层接口实现类
 *
 */
@Service
public class BasExpenseDetailImpl implements IBasExpenseDetailService {

	@Autowired
	IBasExpenseDetailRepository iBasExpenseDetailRepository;
	@Autowired
	IBasProductRepository iBasProductRepository;
	@Override
	public Page<BasExpenseDetail> getBasExpenseDetail(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasExpenseDetailRepository.findAll(request);
	}
	@Override
	public List<BasExpenseDetailVO> getBasExpenseDetailVOList(List<BasExpenseDetail> content) {
		List<BasExpenseDetailVO> voList = new ArrayList<>();		
		for(BasExpenseDetail po:content){
			BasExpenseDetailVO vo = new BasExpenseDetailVO();
			BeanUtils.copyProperties(po, vo);		
			if(po.getProdCode()!=null){
				if(po.getProdCode()!=""){
					BasProduct prod = iBasProductRepository.findById(Integer.parseInt(po.getProdCode()));
					String prodCode = prod.getProductCode();
					String prodName = prod.getProductName();		
					if(prodCode==null||prodCode.equals("")){
						vo.setProdCode("未录入编码");
					}else{
						vo.setProdCode(prodCode);
					}
					if(prodName==null||prodName.equals("")){
						vo.setProdName("未录入名称");
					}else{
						vo.setProdName(prodName);
					}	
				}				
			}			
			voList.add(vo);
		}
		return voList;
	}

}