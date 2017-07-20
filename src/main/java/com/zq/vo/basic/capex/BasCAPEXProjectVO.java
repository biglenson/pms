package com.zq.vo.basic.capex;

/**
 * CAPEX项
 */

public class BasCAPEXProjectVO {
	
	private int id;
	
	private Integer companyId;
	
	private java.sql.Timestamp createTime;
	
	private String creator;
	
	private java.sql.Timestamp modifyTime;
		
	private String lastReviser;
		
	private String pmsProjCode;
	
	private String reqCode;
	
	private String reqName;
	
	private String reqDept;
	
	private String projName;
	
	private String projCode;
	
	private Integer projType;
	
	private String projStartYear;
	
	private String belongProj;
	
	private Integer projStatus;
	
	private String projTotalInvest;
	
	private String anualCapexPlan;
		
	private String anualTruncapPlan;
	
	private java.sql.Timestamp planSetupTime;
	
	private java.sql.Timestamp planApprovalTime;
	
	private java.sql.Timestamp planConstructTime;
	
	private java.sql.Timestamp planOnlineTime;
		
	private java.sql.Timestamp pinitApprovalTime;
	
	private java.sql.Timestamp pfinalApprovalTime;
	
	private String planPm;
		
	private String purchasePm;
	
	private String projPmDept;
	
	private String constructPm;
		
	private String preoccupyAmount;
	
	private Integer projSetupMode;
		
	private Integer projSetupState;
	
	private java.sql.Timestamp projSetupTime;
	
	private String projSetupAmount;
	
	private String decisionBasis;
	
	private java.sql.Timestamp availableApprovalTime;
	
	private String availableApprovalAmount;
	
	private java.sql.Timestamp designApprovalTime;
		
	private String designApprovalAmount;
	
	private String finalAccount;
	
	private java.sql.Timestamp constructTime;
	
	private java.sql.Timestamp onlineTime;
	
	private java.sql.Timestamp initApprovalTime;
	
	private java.sql.Timestamp finalApprovalTime;
	
	private java.sql.Timestamp arrivalTime;
	
	private Integer capexPlanStatus;
		
	private Integer truncapPlanStatus;

	private java.sql.Timestamp reqFreezeTime;
	
	private java.sql.Timestamp paperContractTime;
	
	private String investPlanProjName;
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
	public void setCompanyId(Integer value) {
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
	 * 全流程项目编号 
	 */
	public void setPmsProjCode(String value) {
		this.pmsProjCode = value;
	}
	
	/**
	 * 全流程项目编号 
	 */
	public String getPmsProjCode() {
		return pmsProjCode;
	}
	
	/**
	 * 需求编号 
	 */
	public void setReqCode(String value) {
		this.reqCode = value;
	}
	
	/**
	 * 需求编号 
	 */
	public String getReqCode() {
		return reqCode;
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
	 * 项目编码 
	 */
	public void setProjCode(String value) {
		this.projCode = value;
	}
	
	/**
	 * 项目编码 
	 */
	public String getProjCode() {
		return projCode;
	}
	
	/**
	 * 项目类型  代码表：capex项目类型代码表
	 */
	public void setProjType(int value) {
		setProjType(new Integer(value));
	}
	
	/**
	 * 项目类型  代码表：capex项目类型代码表
	 */
	public void setProjType(Integer value) {
		this.projType = value;
	}
	
	/**
	 * 项目类型  代码表：capex项目类型代码表
	 */
	public Integer getProjType() {
		return projType;
	}
	
	/**
	 * 项目起始年份 
	 */
	public void setProjStartYear(String value) {
		this.projStartYear = value;
	}
	
	/**
	 * 项目起始年份 
	 */
	public String getProjStartYear() {
		return projStartYear;
	}
	
	/**
	 * 所属项目/产品 
	 */
	public void setBelongProj(String value) {
		this.belongProj = value;
	}
	
	/**
	 * 所属项目/产品 
	 */
	public String getBelongProj() {
		return belongProj;
	}
	
	/**
	 * 当前工程状态 代码表：CAPEX当前工程状态代码 
	 */
	public void setProjStatus(int value) {
		setProjStatus(new Integer(value));
	}
	
	/**
	 * 当前工程状态 代码表：CAPEX当前工程状态代码 
	 */
	public void setProjStatus(Integer value) {
		this.projStatus = value;
	}
	
	/**
	 * 当前工程状态 代码表：CAPEX当前工程状态代码 
	 */
	public Integer getProjStatus() {
		return projStatus;
	}
	
	/**
	 * 项目总投资（元） 
	 */
	public void setProjTotalInvest(String value) {
		this.projTotalInvest = value;
	}
	
	/**
	 * 项目总投资（元） 
	 */
	public String getProjTotalInvest() {
		return projTotalInvest;
	}
	
	/**
	 * 当年资本开支计划（元） 
	 */
	public void setAnualCapexPlan(String value) {
		this.anualCapexPlan = value;
	}
	
	/**
	 * 当年资本开支计划（元） 
	 */
	public String getAnualCapexPlan() {
		return anualCapexPlan;
	}
	
	/**
	 * 当年转资计划（元） 
	 */
	public void setAnualTruncapPlan(String value) {
		this.anualTruncapPlan = value;
	}
	
	/**
	 * 当年转资计划（元） 
	 */
	public String getAnualTruncapPlan() {
		return anualTruncapPlan;
	}
	
	/**
	 * 计划立项时间 
	 */
	public void setPlanSetupTime(java.sql.Timestamp value) {
		this.planSetupTime = value;
	}
	
	/**
	 * 计划立项时间 
	 */
	public java.sql.Timestamp getPlanSetupTime() {
		return planSetupTime;
	}
	
	/**
	 * 计划设计批复时间 
	 */
	public void setPlanApprovalTime(java.sql.Timestamp value) {
		this.planApprovalTime = value;
	}
	
	/**
	 * 计划设计批复时间 
	 */
	public java.sql.Timestamp getPlanApprovalTime() {
		return planApprovalTime;
	}
	
	/**
	 * 计划开工时间 
	 */
	public void setPlanConstructTime(java.sql.Timestamp value) {
		this.planConstructTime = value;
	}
	
	/**
	 * 计划开工时间 
	 */
	public java.sql.Timestamp getPlanConstructTime() {
		return planConstructTime;
	}
	
	/**
	 * 计划上线运行时间 
	 */
	public void setPlanOnlineTime(java.sql.Timestamp value) {
		this.planOnlineTime = value;
	}
	
	/**
	 * 计划上线运行时间 
	 */
	public java.sql.Timestamp getPlanOnlineTime() {
		return planOnlineTime;
	}
	
	/**
	 * 计划初验批复时间 
	 */
	public void setPinitApprovalTime(java.sql.Timestamp value) {
		this.pinitApprovalTime = value;
	}
	
	/**
	 * 计划初验批复时间 
	 */
	public java.sql.Timestamp getPinitApprovalTime() {
		return pinitApprovalTime;
	}
	
	/**
	 * 计划终验批复时间 
	 */
	public void setPfinalApprovalTime(java.sql.Timestamp value) {
		this.pfinalApprovalTime = value;
	}
	
	/**
	 * 计划终验批复时间 
	 */
	public java.sql.Timestamp getPfinalApprovalTime() {
		return pfinalApprovalTime;
	}
	
	/**
	 * 计划项目经理 
	 */
	public void setPlanPm(String value) {
		this.planPm = value;
	}
	
	/**
	 * 计划项目经理 
	 */
	public String getPlanPm() {
		return planPm;
	}
	
	/**
	 * 采购项目经理 
	 */
	public void setPurchasePm(String value) {
		this.purchasePm = value;
	}
	
	/**
	 * 采购项目经理 
	 */
	public String getPurchasePm() {
		return purchasePm;
	}
	
	/**
	 * 工程管理部门 
	 */
	public void setProjPmDept(String value) {
		this.projPmDept = value;
	}
	
	/**
	 * 工程管理部门 
	 */
	public String getProjPmDept() {
		return projPmDept;
	}
	
	/**
	 * 工建项目经理 
	 */
	public void setConstructPm(String value) {
		this.constructPm = value;
	}
	
	/**
	 * 工建项目经理 
	 */
	public String getConstructPm() {
		return constructPm;
	}
	
	/**
	 * 预占金额 
	 */
	public void setPreoccupyAmount(String value) {
		this.preoccupyAmount = value;
	}
	
	/**
	 * 预占金额 
	 */
	public String getPreoccupyAmount() {
		return preoccupyAmount;
	}
	
	/**
	 * 立项决策方式  1-会议；2-呈批
	 */
	public void setProjSetupMode(int value) {
		setProjSetupMode(new Integer(value));
	}
	
	/**
	 * 立项决策方式  1-会议；2-呈批
	 */
	public void setProjSetupMode(Integer value) {
		this.projSetupMode = value;
	}
	
	/**
	 * 立项决策方式  1-会议；2-呈批
	 */
	public Integer getProjSetupMode() {
		return projSetupMode;
	}
	
	/**
	 * 立项决策状态  1-通过；2-有条件通过；3-未通过
	 */
	public void setProjSetupState(int value) {
		setProjSetupState(new Integer(value));
	}
	
	/**
	 * 立项决策状态  1-通过；2-有条件通过；3-未通过
	 */
	public void setProjSetupState(Integer value) {
		this.projSetupState = value;
	}
	
	/**
	 * 立项决策状态  1-通过；2-有条件通过；3-未通过
	 */
	public Integer getProjSetupState() {
		return projSetupState;
	}
	
	/**
	 * 立项决策时间 
	 */
	public void setProjSetupTime(java.sql.Timestamp value) {
		this.projSetupTime = value;
	}
	
	/**
	 * 立项决策时间 
	 */
	public java.sql.Timestamp getProjSetupTime() {
		return projSetupTime;
	}
	
	/**
	 * 立项决策金额（元） 
	 */
	public void setProjSetupAmount(String value) {
		this.projSetupAmount = value;
	}
	
	/**
	 * 立项决策金额（元） 
	 */
	public String getProjSetupAmount() {
		return projSetupAmount;
	}
	
	/**
	 * 决策依据 
	 */
	public void setDecisionBasis(String value) {
		this.decisionBasis = value;
	}
	
	/**
	 * 决策依据 
	 */
	public String getDecisionBasis() {
		return decisionBasis;
	}
	
	/**
	 * 可研批复时间 
	 */
	public void setAvailableApprovalTime(java.sql.Timestamp value) {
		this.availableApprovalTime = value;
	}
	
	/**
	 * 可研批复时间 
	 */
	public java.sql.Timestamp getAvailableApprovalTime() {
		return availableApprovalTime;
	}
	
	/**
	 * 可研批复金额（元） 
	 */
	public void setAvailableApprovalAmount(String value) {
		this.availableApprovalAmount = value;
	}
	
	/**
	 * 可研批复金额（元） 
	 */
	public String getAvailableApprovalAmount() {
		return availableApprovalAmount;
	}
	
	/**
	 * 设计批复时间 
	 */
	public void setDesignApprovalTime(java.sql.Timestamp value) {
		this.designApprovalTime = value;
	}
	
	/**
	 * 设计批复时间 
	 */
	public java.sql.Timestamp getDesignApprovalTime() {
		return designApprovalTime;
	}
	
	/**
	 * 项目设计批复金额（元） 
	 */
	public void setDesignApprovalAmount(String value) {
		this.designApprovalAmount = value;
	}
	
	/**
	 * 项目设计批复金额（元） 
	 */
	public String getDesignApprovalAmount() {
		return designApprovalAmount;
	}
	
	/**
	 * 已完成决算项目的决算金额（元） 
	 */
	public void setFinalAccount(String value) {
		this.finalAccount = value;
	}
	
	/**
	 * 已完成决算项目的决算金额（元） 
	 */
	public String getFinalAccount() {
		return finalAccount;
	}
	
	/**
	 * 开工时间 
	 */
	public void setConstructTime(java.sql.Timestamp value) {
		this.constructTime = value;
	}
	
	/**
	 * 开工时间 
	 */
	public java.sql.Timestamp getConstructTime() {
		return constructTime;
	}
	
	/**
	 * 上线时间 
	 */
	public void setOnlineTime(java.sql.Timestamp value) {
		this.onlineTime = value;
	}
	
	/**
	 * 上线时间 
	 */
	public java.sql.Timestamp getOnlineTime() {
		return onlineTime;
	}
	
	/**
	 * 初验批复时间 
	 */
	public void setInitApprovalTime(java.sql.Timestamp value) {
		this.initApprovalTime = value;
	}
	
	/**
	 * 初验批复时间 
	 */
	public java.sql.Timestamp getInitApprovalTime() {
		return initApprovalTime;
	}
	
	/**
	 * 终验批复时间 
	 */
	public void setFinalApprovalTime(java.sql.Timestamp value) {
		this.finalApprovalTime = value;
	}
	
	/**
	 * 终验批复时间 
	 */
	public java.sql.Timestamp getFinalApprovalTime() {
		return finalApprovalTime;
	}
	
	/**
	 * 到货接收时间 
	 */
	public void setArrivalTime(java.sql.Timestamp value) {
		this.arrivalTime = value;
	}
	
	/**
	 * 到货接收时间 
	 */
	public java.sql.Timestamp getArrivalTime() {
		return arrivalTime;
	}
	
	/**
	 * 开支计划是否已完成 
	 */
	public void setCapexPlanStatus(int value) {
		setCapexPlanStatus(new Integer(value));
	}
	
	/**
	 * 开支计划是否已完成 
	 */
	public void setCapexPlanStatus(Integer value) {
		this.capexPlanStatus = value;
	}
	
	/**
	 * 开支计划是否已完成 
	 */
	public Integer getCapexPlanStatus() {
		return capexPlanStatus;
	}
	
	/**
	 * 转资计划是否已完成 
	 */
	public void setTruncapPlanStatus(int value) {
		setTruncapPlanStatus(new Integer(value));
	}
	
	/**
	 * 转资计划是否已完成 
	 */
	public void setTruncapPlanStatus(Integer value) {
		this.truncapPlanStatus = value;
	}
	
	/**
	 * 转资计划是否已完成 
	 */
	public Integer getTruncapPlanStatus() {
		return truncapPlanStatus;
	}
	/**
	 * 需求冻结时间date20
	 */
	public java.sql.Timestamp getReqFreezeTime() {
		return reqFreezeTime;
	}

	public void setReqFreezeTime(java.sql.Timestamp reqFreezeTime) {
		this.reqFreezeTime = reqFreezeTime;
	}
	/**
	 * 纸制合同签订时间date21
	 */
	public java.sql.Timestamp getPaperContractTime() {
		return paperContractTime;
	}

	public void setPaperContractTime(java.sql.Timestamp paperContractTime) {
		this.paperContractTime = paperContractTime;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	/**
	 * 需求名称
	 */
	public String getReqName() {
		return reqName;
	}
	/**
	 * 需求名称
	 */
	public void setReqName(String reqName) {
		this.reqName = reqName;
	}
	
	/**
	 * 需求部门
	 */
	public String getReqDept() {
		return reqDept;
	}
	
	/**
	 * 需求部门
	 */
	public void setReqDept(String reqDept) {
		this.reqDept = reqDept;
	}
	/**
	 * 投资项目集/项目名称
	 */
	public String getInvestPlanProjName() {
		return investPlanProjName;
	}
	/**
	 * 投资项目集/项目名称
	 */
	public void setInvestPlanProjName(String investPlanProjName) {
		this.investPlanProjName = investPlanProjName;
	}
	
}
