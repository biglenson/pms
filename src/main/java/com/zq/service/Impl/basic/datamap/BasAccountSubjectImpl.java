package com.zq.service.Impl.basic.datamap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.datamap.IBasAccountSubjectRepository;
import com.zq.dao.basic.datamap.IBasBudgetSubjectRepository;
import com.zq.entity.basic.datamap.BasAccountSubject;
import com.zq.entity.basic.datamap.BasBudgetSubject;
import com.zq.service.basic.datamap.IBasAccountSubjectService;
import com.zq.vo.basic.datamap.BasAccountSubjectVO;

/**
 *
 * BasAccountSubject 表数据服务层接口实现类
 *
 */
@Service
public class BasAccountSubjectImpl implements IBasAccountSubjectService {

	@Autowired
	IBasAccountSubjectRepository iBasAccountSubjectRepository;
	@Autowired
	IBasBudgetSubjectRepository iBasBudgetSubjectRepository;
	@Override
	public Page<BasAccountSubject> getBasAccountSubject(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasAccountSubjectRepository.findAll(request);
	}
	@Override
	public List<BasAccountSubjectVO> getBasAccountSubjectVOList(List<BasAccountSubject> content) {
		List<BasAccountSubjectVO> voList = new ArrayList<>();		
		for(BasAccountSubject po:content){
			BasAccountSubjectVO vo = new BasAccountSubjectVO();
			BeanUtils.copyProperties(po, vo);		
			if(po.getBudgetSubject()!=null){
				BasBudgetSubject budg = iBasBudgetSubjectRepository.findById(Integer.parseInt(po.getBudgetSubject()));
				String budgetSubject = budg.getBugdetSubjectCode();
				String bugdetName = budg.getBugdetName();		
				if(budgetSubject==null||budgetSubject.equals("")){
					vo.setBudgetSubject("未录入编码");
				}else{
					vo.setBudgetSubject(budgetSubject);
				}
				if(bugdetName==null||bugdetName.equals("")){
					vo.setBugdetName("未录入名称");
				}else{
					vo.setBugdetName(bugdetName);
				}	
			}			
			voList.add(vo);
		}
		return voList;
	}

}