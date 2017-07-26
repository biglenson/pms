package com.zq.service.basic.capex;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;

import com.zq.entity.basic.capex.BasCAPEXAmountPool;

/**
 *
 * BasCapexAmountPool 表数据服务层接口
 *
 */
public interface IBasCAPEXAmountPoolService{

	List<BasCAPEXAmountPool> getAllCAPEXAmountPoolByYear(String year);

	Page<BasCAPEXAmountPool> getBasCAPEXAmountPool(Integer page, int pageSize);

	/**
	* @Title: getBasCAPEXAmountPoolUsage
	* @Description: TODO(获取自主资金池使用进度)
	* @author BigCoin
	* @date 2017年7月20日 下午4:50:11
	* @param @param year
	* @param @param request
	* @param @return 设定文件
	* @return HttpServletRequest 返回类型
	* @throws
	*/
	HttpServletRequest getBasCAPEXAmountPoolUsage(String year, HttpServletRequest request);


}