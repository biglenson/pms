package com.zq.service.basic.datamap;

import java.util.List;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.datamap.BasAccountSubject;
import com.zq.vo.basic.datamap.BasAccountSubjectVO;

/**
 *
 * BasAccountSubject 表数据服务层接口
 *
 */
public interface IBasAccountSubjectService{

	Page<BasAccountSubject> getBasAccountSubject(Integer page, int pageSize);

	List<BasAccountSubjectVO> getBasAccountSubjectVOList(List<BasAccountSubject> content);


}