package com.zq.vo.basic.opex;
/**
 * OPEX项
 */

public class BasOPEXProjectVO {
	
	private int id;
		
	private Integer companyId;
	
	private java.sql.Timestamp createTime;
		
	private String creator;
	
	private java.sql.Timestamp modifyTime;
	
	private String lastReviser;
	
	private String budgetProjCode;
	
	private String reqCode;
	
	private String projCode;
		
	private String projName;
	
	private String belProj;
	
	private Integer projType;
		
	private String budsysProjCode;
	
	private String year;
	
	private java.sql.Timestamp projSetupTime;
	
	private java.sql.Timestamp projDecisionTime;
	
	private String projDecisionWay;
	
	private String projDecisionBase;
	
	private Integer projDecisionStatus;
	
	private String projSetupAmount;
	
	private String reimbursementAmount;
	
	private String recordedAmount;
	
	private String janPlan;
	
	private String febPlan;
	
	private String marPlan;
	
	private String aprPlan;
	
	private String mayPlan;
	
	private String junPlan;
	
	private String julPlan;
	
	private String augPlan;
	
	private String sepPlan;
		
	private String octPlan;
	
	private String novPlan;
	
	private String decPlan;
		
	private String jan_actual;
		
	private String feb_actual;
	
	private String mar_actual;
		
	private String apr_actual;
		
	private String may_actual;
		
	private String jun_actual;
		
	private String jul_actual;
		
	private String aug_actual;
		
	private String sept_actual;
	
	private String oct_actual;
		
	private String nov_actual;
	
	private String dec_actual;
	
	private String description;
	
	/**
	 * ID
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 公司ID
	 */
	public void setCompanyId(int value) {
		setCompanyId(new Integer(value));
	}
	
	/**
	 * 公司ID
	 */
	public void setCompanyid(Integer value) {
		this.companyId = value;
	}
	
	/**
	 * 公司ID
	 */
	public Integer getCompanyId() {
		return companyId;
	}
	
	/**
	 * 创建时间
	 */
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
	
	/**
	 * 创建时间
	 */
	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}
	
	/**
	 * 创建人
	 */
	public void setCreator(String value) {
		this.creator = value;
	}
	
	/**
	 * 创建人
	 */
	public String getCreator() {
		return creator;
	}
	
	/**
	 * 最后修改时间
	 */
	public void setModifyTime(java.sql.Timestamp value) {
		this.modifyTime = value;
	}
	
	/**
	 * 最后修改时间
	 */
	public java.sql.Timestamp getModifyTime() {
		return modifyTime;
	}
	
	/**
	 * 修改人
	 */
	public void setLastReviser(String value) {
		this.lastReviser = value;
	}
	
	/**
	 * 修改人
	 */
	public String getLastReviser() {
		return lastReviser;
	}
	
	/**
	 * 预算项目编号 bas_opex_budget_project中budget_proj_code
	 */
	public void setBudgetProjCode(String value) {
		this.budgetProjCode = value;
	}
	
	/**
	 * 预算项目编号 bas_opex_budget_project中budget_proj_code
	 */
	public String getBudgetProjCode() {
		return budgetProjCode;
	}
	
	/**
	 * 需求编号 bas_opex_requirment中req_code
	 */
	public void setReqCode(String value) {
		this.reqCode = value;
	}
	
	/**
	 * 需求编号 bas_opex_requirment中req_code
	 */
	public String getReqCode() {
		return reqCode;
	}
	
	/**
	 * 项目编号 
	 */
	public void setProjCode(String value) {
		this.projCode = value;
	}
	
	/**
	 * 项目编号 
	 */
	public String getProjCode() {
		return projCode;
	}
	
	/**
	 * 项目名称 
	 */
	public void setProjName(String value) {
		this.projName = value;
	}
	
	/**
	 * 项目名称 
	 */
	public String getProjName() {
		return projName;
	}
	
	/**
	 * 所属产品/项目 
	 */
	public void setBelProj(String value) {
		this.belProj = value;
	}
	
	/**
	 * 所属产品/项目 
	 */
	public String getBelProj() {
		return belProj;
	}
	
	/**
	 * 项目类型 代码表：OPEX项目类型代码表
	 */
	public void setProj_type(int value) {
		setProj_type(new Integer(value));
	}
	
	/**
	 * 项目类型 代码表：OPEX项目类型代码表
	 */
	public void setProjType(Integer value) {
		this.projType = value;
	}
	
	/**
	 * 项目类型 代码表：OPEX项目类型代码表
	 */
	public Integer getProjType() {
		return projType;
	}
	
	/**
	 * 预算系统项目编码 
	 */
	public void setBudsysProjCode(String value) {
		this.budsysProjCode = value;
	}
	
	/**
	 * 预算系统项目编码 
	 */
	public String getBudsysProjCode() {
		return budsysProjCode;
	}
	
	/**
	 * 年份 
	 */
	public void setYear(String value) {
		this.year = value;
	}
	
	/**
	 * 年份 
	 */
	public String getYear() {
		return year;
	}
	
	/**
	 * 计划立项时间 
	 */
	public void setProjSetupTime(java.sql.Timestamp value) {
		this.projSetupTime = value;
	}
	
	/**
	 * 计划立项时间 
	 */
	public java.sql.Timestamp getProjSetupTime() {
		return projSetupTime;
	}
	
	/**
	 * 立项决策时间 
	 */
	public void setProjDecisionTime(java.sql.Timestamp value) {
		this.projDecisionTime = value;
	}
	
	/**
	 * 立项决策时间 
	 */
	public java.sql.Timestamp getProjDecisionTime() {
		return projDecisionTime;
	}
	
	/**
	 * 立项决策方式 
	 */
	public void setProjDecisionWay(String value) {
		this.projDecisionWay = value;
	}
	
	/**
	 * 立项决策方式 
	 */
	public String getProjDecisionWay() {
		return projDecisionWay;
	}
	
	/**
	 * 立项决策依据 
	 */
	public void setProjDecisionBase(String value) {
		this.projDecisionBase = value;
	}
	
	/**
	 * 立项决策依据 
	 */
	public String getProjDecisionBase() {
		return projDecisionBase;
	}
	
	/**
	 * 立项决策状态  代码表：立项决策状态代码表
	 */
	public void setProj_decision_status(int value) {
		setProj_decision_status(new Integer(value));
	}
	
	/**
	 * 立项决策状态  代码表：立项决策状态代码表
	 */
	public void setProjDecisionStatus(Integer value) {
		this.projDecisionStatus = value;
	}
	
	/**
	 * 立项决策状态  代码表：立项决策状态代码表
	 */
	public Integer getProjDecisionStatus() {
		return projDecisionStatus;
	}
	
	/**
	 * 立项金额（元） 
	 */
	public void setProjSetupAmount(String value) {
		this.projSetupAmount = value;
	}
	
	/**
	 * 立项金额（元） 
	 */
	public String getProjSetupAmount() {
		return projSetupAmount;
	}
	
	/**
	 * 报账金额（元） 
	 */
	public void setReimbursementAmount(String value) {
		this.reimbursementAmount = value;
	}
	
	/**
	 * 报账金额（元） 
	 */
	public String getReimbursementAmount() {
		return reimbursementAmount;
	}
	
	/**
	 * 入账金额（元） 
	 */
	public void setRecordedAmount(String value) {
		this.recordedAmount = value;
	}
	
	/**
	 * 入账金额（元） 
	 */
	public String getRecordedAmount() {
		return recordedAmount;
	}
	
	/**
	 * 1月计划（元） 
	 */
	public void setJanPlan(String value) {
		this.janPlan = value;
	}
	
	/**
	 * 1月计划（元） 
	 */
	public String getJanPlan() {
		return janPlan;
	}
	
	/**
	 * 2月计划（元） 
	 */
	public void setFebPlan(String value) {
		this.febPlan = value;
	}
	
	/**
	 * 2月计划（元） 
	 */
	public String getFebPlan() {
		return febPlan;
	}
	
	/**
	 * 3月计划（元） 
	 */
	public void setMarPlan(String value) {
		this.marPlan = value;
	}
	
	/**
	 * 3月计划（元） 
	 */
	public String getMarPlan() {
		return marPlan;
	}
	
	/**
	 * 4月计划（元） 
	 */
	public void setAprPlan(String value) {
		this.aprPlan = value;
	}
	
	/**
	 * 4月计划（元） 
	 */
	public String getAprPlan() {
		return aprPlan;
	}
	
	/**
	 * 5月计划（元） 
	 */
	public void setMayPlan(String value) {
		this.mayPlan = value;
	}
	
	/**
	 * 5月计划（元） 
	 */
	public String getMayPlan() {
		return mayPlan;
	}
	
	/**
	 * 6月计划（元） 
	 */
	public void setJunPlan(String value) {
		this.junPlan = value;
	}
	
	/**
	 * 6月计划（元） 
	 */
	public String getJunPlan() {
		return junPlan;
	}
	
	/**
	 * 7月计划（元） 
	 */
	public void setJulPlan(String value) {
		this.julPlan = value;
	}
	
	/**
	 * 7月计划（元） 
	 */
	public String getJulPlan() {
		return julPlan;
	}
	
	/**
	 * 8月计划（元） 
	 */
	public void setAugPlan(String value) {
		this.augPlan = value;
	}
	
	/**
	 * 8月计划（元） 
	 */
	public String getAugPlan() {
		return augPlan;
	}
	
	/**
	 * 9月计划（元） 
	 */
	public void setSepPlan(String value) {
		this.sepPlan = value;
	}
	
	/**
	 * 9月计划（元） 
	 */
	public String getSepPlan() {
		return sepPlan;
	}
	
	/**
	 * 10月计划（元） 
	 */
	public void setOctPlan(String value) {
		this.octPlan = value;
	}
	
	/**
	 * 10月计划（元） 
	 */
	public String getOctPlan() {
		return octPlan;
	}
	
	/**
	 * 11月计划（元） 
	 */
	public void setNovPlan(String value) {
		this.novPlan = value;
	}
	
	/**
	 * 11月计划（元） 
	 */
	public String getNovPlan() {
		return novPlan;
	}
	
	/**
	 * 12月计划（元） 
	 */
	public void setDecPlan(String value) {
		this.decPlan = value;
	}
	
	/**
	 * 12月计划（元） 
	 */
	public String getDecPlan() {
		return decPlan;
	}
	
	/**
	 * 1月实际（元） 
	 */
	public void setJan_actual(String value) {
		this.jan_actual = value;
	}
	
	/**
	 * 1月实际（元） 
	 */
	public String getJan_actual() {
		return jan_actual;
	}
	
	/**
	 * 2月实际（元） 
	 */
	public void setFeb_actual(String value) {
		this.feb_actual = value;
	}
	
	/**
	 * 2月实际（元） 
	 */
	public String getFeb_actual() {
		return feb_actual;
	}
	
	/**
	 * 3月实际（元） 
	 */
	public void setMar_actual(String value) {
		this.mar_actual = value;
	}
	
	/**
	 * 3月实际（元） 
	 */
	public String getMar_actual() {
		return mar_actual;
	}
	
	/**
	 * 4月实际（元） 
	 */
	public void setApr_actual(String value) {
		this.apr_actual = value;
	}
	
	/**
	 * 4月实际（元） 
	 */
	public String getApr_actual() {
		return apr_actual;
	}
	
	/**
	 * 5月实际（元） 
	 */
	public void setMay_actual(String value) {
		this.may_actual = value;
	}
	
	/**
	 * 5月实际（元） 
	 */
	public String getMay_actual() {
		return may_actual;
	}
	
	/**
	 * 6月实际（元） 
	 */
	public void setJun_actual(String value) {
		this.jun_actual = value;
	}
	
	/**
	 * 6月实际（元） 
	 */
	public String getJun_actual() {
		return jun_actual;
	}
	
	/**
	 * 7月实际（元） 
	 */
	public void setJul_actual(String value) {
		this.jul_actual = value;
	}
	
	/**
	 * 7月实际（元） 
	 */
	public String getJul_actual() {
		return jul_actual;
	}
	
	/**
	 * 8月实际（元） 
	 */
	public void setAug_actual(String value) {
		this.aug_actual = value;
	}
	
	/**
	 * 8月实际（元） 
	 */
	public String getAug_actual() {
		return aug_actual;
	}
	
	/**
	 * 9月实际（元） 
	 */
	public void setSept_actual(String value) {
		this.sept_actual = value;
	}
	
	/**
	 * 9月实际（元） 
	 */
	public String getSept_actual() {
		return sept_actual;
	}
	
	/**
	 * 10月实际（元） 
	 */
	public void setOct_actual(String value) {
		this.oct_actual = value;
	}
	
	/**
	 * 10月实际（元） 
	 */
	public String getOct_actual() {
		return oct_actual;
	}
	
	/**
	 * 11月实际（元） 
	 */
	public void setNov_actual(String value) {
		this.nov_actual = value;
	}
	
	/**
	 * 11月实际（元） 
	 */
	public String getNov_actual() {
		return nov_actual;
	}
	
	/**
	 * 12月实际（元） 
	 */
	public void setDec_actual(String value) {
		this.dec_actual = value;
	}
	
	/**
	 * 12月实际（元） 
	 */
	public String getDec_actual() {
		return dec_actual;
	}
	
	/**
	 * 备注 
	 */
	public void setDescription(String value) {
		this.description = value;
	}
	
	/**
	 * 备注 
	 */
	public String getDescription() {
		return description;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
