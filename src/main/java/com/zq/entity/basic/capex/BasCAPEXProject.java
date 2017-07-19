package com.zq.entity.basic.capex;
/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
import java.io.Serializable;
import javax.persistence.*;
/**
 * CAPEX项
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="bas_capex_project")
public class BasCAPEXProject implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月11日 下午3:46:04 
	*/
	private static final long serialVersionUID = -1866831144342940435L;

	public BasCAPEXProject() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BAS_CAPEX_PROJECT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BAS_CAPEX_PROJECT_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="company_id", nullable=true, length=10)	
	private Integer companyId;
	
	@Column(name="create_time", nullable=true)	
	private java.sql.Timestamp createTime;
	
	@Column(name="creator", nullable=true, length=50)	
	private String creator;
	
	@Column(name="modify_time", nullable=true)	
	private java.sql.Timestamp modifyTime;
	
	@Column(name="last_reviser", nullable=true, length=50)	
	private String lastReviser;
	
	@Column(name="pms_proj_code", nullable=true, length=255)	
	private String pmsProjCode;
	
	@Column(name="req_code", nullable=true, length=255)	
	private String reqCode;
	
	@Column(name="proj_name", nullable=true, length=255)	
	private String projName;
	
	@Column(name="proj_code", nullable=true, length=255)	
	private String projCode;
	
	@Column(name="proj_type", nullable=true, length=10)	
	private Integer projType;
	
	@Column(name="proj_start_year", nullable=true, length=255)	
	private String projStartYear;
	
	@Column(name="belong_proj", nullable=true, length=255)	
	private String belongProj;
	
	@Column(name="proj_status", nullable=true, length=10)	
	private Integer projStatus;
	
	@Column(name="proj_total_invest", nullable=true, length=50)	
	private String projTotalInvest;
	
	@Column(name="anual_capex_plan", nullable=true, length=50)	
	private String anualCapexPlan;
	
	@Column(name="anual_truncap_plan", nullable=true, length=50)	
	private String anualTruncapPlan;
	
	@Column(name="plan_setup_time", nullable=true)	
	private java.sql.Timestamp planSetupTime;
	
	@Column(name="plan_approval_time", nullable=true)	
	private java.sql.Timestamp planApprovalTime;
	
	@Column(name="plan_construct_time", nullable=true)	
	private java.sql.Timestamp planConstructTime;
	
	@Column(name="plan_online_time", nullable=true)	
	private java.sql.Timestamp planOnlineTime;
	
	@Column(name="pinit_approval_time", nullable=true)	
	private java.sql.Timestamp pinitApprovalTime;
	
	@Column(name="pfinal_approval_time", nullable=true)	
	private java.sql.Timestamp pfinalApprovalTime;
	
	@Column(name="plan_pm", nullable=true, length=255)	
	private String planPm;
	
	@Column(name="purchase_pm", nullable=true, length=255)	
	private String purchasePm;
	
	@Column(name="proj_pm_dept", nullable=true, length=255)	
	private String projPmDept;
	
	@Column(name="construct_pm", nullable=true, length=255)	
	private String constructPm;
	
	@Column(name="preoccupy_amount", nullable=true, length=50)	
	private String preoccupyAmount;
	
	@Column(name="proj_setup_mode", nullable=true, length=10)	
	private Integer projSetupMode;
	
	@Column(name="proj_setup_state", nullable=true, length=10)	
	private Integer projSetupState;
	
	@Column(name="proj_setup_time", nullable=true)	
	private java.sql.Timestamp projSetupTime;
	
	@Column(name="proj_setup_amount", nullable=true, length=50)	
	private String projSetupAmount;
	
	@Column(name="decision_basis", nullable=true, length=255)	
	private String decisionBasis;
	
	@Column(name="available_approval_time", nullable=true)	
	private java.sql.Timestamp availableApprovalTime;
	
	@Column(name="available_approval_amount", nullable=true, length=50)	
	private String availableApprovalAmount;
	
	@Column(name="design_approval_time", nullable=true)	
	private java.sql.Timestamp designApprovalTime;
	
	@Column(name="design_approval_amount", nullable=true, length=50)	
	private String designApprovalAmount;
	
	@Column(name="final_account", nullable=true, length=50)	
	private String finalAccount;
	
	@Column(name="construct_time", nullable=true)	
	private java.sql.Timestamp constructTime;
	
	@Column(name="online_time", nullable=true)	
	private java.sql.Timestamp onlineTime;
	
	@Column(name="initApprovalTime", nullable=true)	
	private java.sql.Timestamp initApprovalTime;
	
	@Column(name="final_approval_time", nullable=true)	
	private java.sql.Timestamp finalApprovalTime;
	
	@Column(name="arrival_time", nullable=true)	
	private java.sql.Timestamp arrivalTime;
	
	@Column(name="capex_plan_status", nullable=true, length=10)	
	private Integer capexPlanStatus;
	
	@Column(name="truncap_plan_status", nullable=true, length=10)	
	private Integer truncapPlanStatus;

	@Column(name="req_freeze_time", nullable=true)	
	private java.sql.Timestamp reqFreezeTime;
	
	@Column(name="paper_contract_time", nullable=true)	
	private java.sql.Timestamp paperContractTime;
	/**
	 * ID
	 */
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
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
	
}
