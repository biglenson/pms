package com.zq.service.Impl.basic.datamap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zq.dao.basic.datamap.IBasBudgetSubjectRepository;
import com.zq.entity.basic.datamap.BasBudgetSubject;
import com.zq.service.basic.datamap.IBasBudgetSubjectService;
import com.zq.vo.basic.datamap.BasBudgetSubjectVO;

/**
 *
 * BasBudgetSubject 表数据服务层接口实现类
 *
 */
@Service
public class BasBudgetSubjectImpl implements IBasBudgetSubjectService {

	@Autowired
	IBasBudgetSubjectRepository iBasBudgetSubjectRepository;
	@Override
	public Page<BasBudgetSubject> getBasBudgetSubject(Integer pageNumber, int pageSize) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, null);
		return iBasBudgetSubjectRepository.findAll(request);
	}
	@Override
	public List<BasBudgetSubjectVO> getBasBudgetSubjectVOList(List<BasBudgetSubject> content) {
		List<BasBudgetSubjectVO> voList = new ArrayList<>();		
		for(BasBudgetSubject po:content){
			BasBudgetSubjectVO vo = new BasBudgetSubjectVO();
			BeanUtils.copyProperties(po, vo);		
			if(po.getSupBugdetSubjectCode()!=null){
				BasBudgetSubject budg = iBasBudgetSubjectRepository.findById(Integer.parseInt(po.getSupBugdetSubjectCode()));
				String supBugdetSubjectCode = budg.getBugdetSubjectCode();
				String supBugdetSubjectName = budg.getBugdetName();
				if(supBugdetSubjectCode==null||supBugdetSubjectCode.equals("")){
					vo.setSupBugdetSubjectCode("未录入编码");
				}else{
					vo.setSupBugdetSubjectCode(supBugdetSubjectCode);
				}
				if(supBugdetSubjectName==null||supBugdetSubjectName.equals("")){
					vo.setSupBugdetSubjectName("未录入名称");
				}else{
					vo.setSupBugdetSubjectName(supBugdetSubjectName);
				}	
			}			
			voList.add(vo);
		}
		return voList;
	}

}