package com.zq.service.basic.capex;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;

import com.zq.commons.result.PageInfo;
import com.zq.entity.basic.capex.BasCAPEXProject;
import com.zq.vo.basic.capex.BasCAPEXProjectVO;

/**
 *
 * BasCapexProject 表数据服务层接口
 *
 */
public interface IBasCAPEXProjectService{

	List<BasCAPEXProject> getALLCAPEXProject();

	BasCAPEXProject getCAPEXProject();

	List<BasCAPEXProject> getBasCAPEXProjectByYear(String year);

	public int getCurrentPhase(BasCAPEXProject capexProject) throws Exception;

	Page<BasCAPEXProject> getBasCAPEXProject(Integer page, int pageSize);

	/**
	* @Title: getBasCAPEXInvestPlanUsage
	* @Description: TODO(获取投资计划使用进度)
	* @author BigCoin
	* @date 2017年7月20日 下午4:49:37
	* @param @param year
	* @param @param request
	* @param @return 设定文件
	* @return HttpServletRequest 返回类型
	* @throws
	*/
	HttpServletRequest getBasCAPEXInvestPlanUsage(String year, HttpServletRequest request);

	HttpServletRequest getCAPEXProjectAsPage(PageInfo pageInfo, HttpServletRequest request);

	List<BasCAPEXProjectVO> getBasCAPEXProjectVOList(List<BasCAPEXProject> content);
}