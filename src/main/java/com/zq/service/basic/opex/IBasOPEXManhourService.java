package com.zq.service.basic.opex;

import java.util.List;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.opex.BasOPEXManhour;
import com.zq.vo.basic.opex.BasOPEXManhourVO;

/**
 *
 * BasOPEXManhour 表数据服务层接口
 *
 */
public interface IBasOPEXManhourService{

	Page<BasOPEXManhour> getBasOPEXManhour(Integer page, int pageSize);

	List<BasOPEXManhourVO> getBasOPEXManhourVOList(List<BasOPEXManhour> content);


}