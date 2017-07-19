package com.zq.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Hierarchy;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zq.commons.utils.CMCCConstant;
import com.zq.commons.utils.TypeUtils;
import com.zq.entity.basic.capex.BasCAPEXInvestPlan;
import com.zq.entity.basic.capex.BasCAPEXProject;
import com.zq.entity.basic.purchase.BasFirstBill;
import com.zq.entity.basic.purchase.BasSecondBill;
import com.zq.service.basic.capex.IBasCAPEXInvestPlanService;
import com.zq.service.basic.capex.IBasCAPEXProjectService;
import com.zq.service.basic.purchase.IBasFirstBillService;
import com.zq.service.basic.purchase.IBasSecondBillService;

/**
 * @ClassName: ComprehensiveViewController
 * @Description: TODO(综合视图)
 * @author shujukuss
 * @date 2017年6月18日 下午7:01:05
 * 
 */
@Controller
@RequestMapping("/comprehensiveview/")
public class ComprehensiveViewController extends BaseController {

	@Autowired
	private IBasCAPEXProjectService iBasCAPEXProjectService;

	@Autowired
	private IBasCAPEXInvestPlanService iBasCAPEXInvestPlanService;

	@Autowired
	private IBasFirstBillService iBasFirstBillService;

	@Autowired
	private IBasSecondBillService iBasSecondBillService;

	private static Logger logger = Logger.getLogger(ComprehensiveViewController.class);

	/**
	 * @throws Exception @Title: capexPhaseStatus @Description:
	 * TODO(capex阶段进度) @author BigCoin @date 2017年7月10日 下午3:31:07 @param @param
	 * request @param @return 设定文件 @return String 返回类型 @throws
	 */
	@RequestMapping(value = "capexphasestatus", method = RequestMethod.POST)
	public String capexPhaseStatus(HttpServletRequest request) throws Exception {
		String year = request.getParameter("year");
		Date dataUpdateDate = null;
		List<BasCAPEXProject> capexList = iBasCAPEXProjectService.getBasCAPEXProjectByYear(year);
		// TypeUtils.prepareForFormList(user, list, request);
		String[] phaseName = { "需求", "立项/可研", "采购", "设计", "工程实施", "试运行", "竣工投产" };
		double[] moneyDouble = { 0d, 0d, 0d, 0d, 0d };
		int[] allCount = new int[phaseName.length];
		int[] newCount = new int[phaseName.length];
		int totalCount = 0;
		int newTotalCount = 0;
		Set<Integer> projectIDSet = new HashSet<Integer>();
		Set<String> projectCodeSet = new HashSet<String>();
		for (BasCAPEXProject capexProject : capexList) {
			if (dataUpdateDate == null) {
				dataUpdateDate = capexProject.getModifyTime();
			}
			if (dataUpdateDate != null && capexProject.getModifyTime() != null
					&& dataUpdateDate.before(capexProject.getModifyTime())) {
				dataUpdateDate = capexProject.getModifyTime();
			}
			projectCodeSet.add(capexProject.getProjCode());
			projectIDSet.add(capexProject.getId());
			moneyDouble[0] += TypeUtils.string2Double(capexProject.getProjTotalInvest());// 项目总投资
			moneyDouble[2] += TypeUtils.string2Double(capexProject.getProjSetupAmount());// 立项决策金额
			moneyDouble[4] += TypeUtils.string2Double(capexProject.getDesignApprovalAmount());// 设计批复金额
			int phaseIndex = iBasCAPEXProjectService.getCurrentPhase(capexProject);
			totalCount++;
			allCount[phaseIndex]++;
			// System.out.println("property=="+property);
			BasCAPEXInvestPlan plan = iBasCAPEXInvestPlanService.getBasCAPEXInvestPlanByYearAndBasCAPEXProject(year,
					capexProject.getProjCode());
			String shuxing = "";
			if (plan != null) {
				shuxing = "新建"; // 后期根据BasCAPEXInvestPlan中attribute去代码表中查出具体值
			}
			if ("新建".equalsIgnoreCase(shuxing)) {
				newCount[phaseIndex]++;
				newTotalCount++;
			}
		}

		// ps.clear();
		// ps.put("capexProjectCodeArray", projectCodeSet);
		// 一级集采台账
		Set<Integer> firstContractIDSet = new HashSet<Integer>();
		List<BasFirstBill> firstBillList = projectIDSet.size() > 0 ? iBasFirstBillService.getFirstBillByYear(year)
				: java.util.Collections.EMPTY_LIST;
		double contractValue = 0d;
		for (BasFirstBill firstBill : firstBillList) {
			if (dataUpdateDate == null) {
				dataUpdateDate = firstBill.getLastUpdateTime();
			}
			if (dataUpdateDate != null && firstBill.getLastUpdateTime() != null
					&& dataUpdateDate.before(firstBill.getLastUpdateTime())) {
				dataUpdateDate = firstBill.getLastUpdateTime();
			}
			String projectCode = TypeUtils.nullToString(firstBill.getProjCode());
			if (projectCodeSet.contains(projectCode)) {
				double val = TypeUtils.string2Double(firstBill.getContractNoTax());
				contractValue += val;
			}
		}
		// 二级集采台账
		// ps.clear();
		// ps.put("capexProjectCodeArray", projectCodeSet);
		List<BasSecondBill> secondBillList = projectIDSet.size() > 0 ? iBasSecondBillService.getSecondBillByYear(year)
				: java.util.Collections.EMPTY_LIST;
		;
		for (BasSecondBill secondBill : secondBillList) {
			if (dataUpdateDate == null) {
				dataUpdateDate = secondBill.getModifyTime();
			}
			if (dataUpdateDate != null && secondBill.getModifyTime() != null
					&& dataUpdateDate.before(secondBill.getModifyTime())) {
				dataUpdateDate = secondBill.getModifyTime();
			}
			String projectCode = TypeUtils.nullToString(secondBill.getProjCode()).trim();
			if (projectCodeSet.contains(projectCode)) {
				double val = TypeUtils.string2Double(secondBill.getContractNoTax());
				contractValue += val;
			}
		}
		moneyDouble[3] = contractValue;
		request.setAttribute(CMCCConstant.LASUPDATE, TypeUtils.getRelativeTime(dataUpdateDate));
		request.setAttribute("moneyDouble", moneyDouble);
		// ps.put("year", year);
		request.setAttribute("newTotalCount", newTotalCount);
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("newCount", newCount);
		request.setAttribute("allCount", allCount);
		request.setAttribute("phaseName", phaseName);
		return CMCCConstant.CAPEXPhaseStatus;
	}

	@RequestMapping(value = "capexinvestdetail", method = RequestMethod.POST)
	public String capexInvestDetail(HttpServletRequest request) throws Exception {

		Date dataUpdateDate = null;
		String year = request.getParameter("year");
		if (year.equals("0")) {
			year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
		}
		Hierarchy tree = ComponentFactory.getProfileManager().getObsHierarchy(user.getCompanyID());
		tree.setComparator(RoleComparator.SequenceComparator);
		Role root = (Role) tree.getObject(Role.ROOT_DEPARTMENT_ID);
		List<Hierarchyable> roleList = tree.getDirectChildren(root);
		request.setAttribute("roleList", roleList);
		request.setAttribute("index", 0);
		double capexValue = 0;
		double shiYongValue = 0;
		Map<Integer, Double> capexValueMap = new HashMap<Integer, Double>();
		Map<Integer, Double> shiYongValueMap = new HashMap<Integer, Double>();

		List<BasCAPEXProject> projectList = cm.getCmProjectPageInfo(user, pageInfo).getItems();
		TypeUtils.prepareForFormList(user, projectList, request);

		for (BasCAPEXProject project : projectList) {
			if (dataUpdateDate == null) {
				dataUpdateDate = project.getModifyTime();
			}
			if (dataUpdateDate != null && project.getModifyTime() != null
					&& dataUpdateDate.before(project.getModifyTime())) {
				dataUpdateDate = project.getModifyTime();
			}
			CMCCTouziPlan plan = project.getYearTouziPlan(year);
			String shuxing = "";
			if (plan != null) {
				shuxing = TypeUtils.resoveFieldAsString(user, plan, "enum04", request);
			}
			if ("新建".equalsIgnoreCase(shuxing.trim())) {
				double tempCapexValue = TypeUtils.getNotNullDoubleValue(user, p, "num09");
				double tempShiYongValue = TypeUtils.getNotNullDoubleValue(user, p, "num01");
				capexValue += tempCapexValue;
				shiYongValue += tempShiYongValue;

				Role tempRole = (Role) TypeUtils.resoveFieldAsObject(user, p, "str25.sys01", request);
				if (tempRole != null) {
					Double roleCapexValue = capexValueMap.get(tempRole.getId());
					if (roleCapexValue == null) {
						roleCapexValue = 0d;
					}
					roleCapexValue += tempCapexValue;
					capexValueMap.put(tempRole.getId(), roleCapexValue);

					Double roleShiYongValue = shiYongValueMap.get(tempRole.getId());
					if (roleShiYongValue == null) {
						roleShiYongValue = 0d;
					}
					roleShiYongValue += tempShiYongValue;
					shiYongValueMap.put(tempRole.getId(), roleShiYongValue);
				}
			}
		}
		request.setAttribute("capexValueMap", capexValueMap);
		request.setAttribute("shiYongValueMap", shiYongValueMap);
		request.setAttribute("capexValue", capexValue);
		request.setAttribute("shiYongValue", shiYongValue);

		double ziJinValue = 0;
		double ziJinShiYongValue = 0;

		List<CMCCZiJinPool> poolList = cm.getZiJinPoolPageInfo(user, pageInfo).getItems();
		for (CMCCZiJinPool c : poolList) {
			if (dataUpdateDate == null) {
				dataUpdateDate = c.getLastUpdateTime();
			}
			if (dataUpdateDate != null && c.getLastUpdateTime() != null
					&& dataUpdateDate.before(c.getLastUpdateTime())) {
				dataUpdateDate = c.getLastUpdateTime();
			}
			ziJinValue += TypeUtils.getNotNullDoubleValue(user, c, "num02");
			ziJinShiYongValue += TypeUtils.getNotNullDoubleValue(user, c, "num03");
		}
		ziJinShiYongValue = ziJinValue - ziJinShiYongValue;
		request.setAttribute("ziJinValue", ziJinValue);
		request.setAttribute("ziJinShiYongValue", ziJinShiYongValue);
		request.setAttribute(CMCCConstant.LASUPDATE, TypeUtils.getRelativeTime(dataUpdateDate));
		return CMCCConstant.PlanResult;
	}
}
