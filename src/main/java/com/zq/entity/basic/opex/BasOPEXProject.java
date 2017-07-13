package com.zq.entity.basic.opex;
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
 * OPEX项
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="bas_opex_project")
public class BasOPEXProject implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月12日 上午9:50:25 
	*/
	private static final long serialVersionUID = -239693861172972548L;

	public BasOPEXProject() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BAS_OPEX_PROJECT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BAS_OPEX_PROJECT_ID_GENERATOR", strategy="native")	
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
	
	@Column(name="budget_proj_code", nullable=true, length=50)	
	private String budgetProjCode;
	
	@Column(name="req_code", nullable=true, length=50)	
	private String reqCode;
	
	@Column(name="proj_code", nullable=true, length=50)	
	private String projCode;
	
	@Column(name="proj_name", nullable=true, length=255)	
	private String projName;
	
	@Column(name="bel_proj", nullable=true, length=50)	
	private String belProj;
	
	@Column(name="proj_type", nullable=true, length=10)	
	private Integer projType;
	
	@Column(name="budsys_proj_code", nullable=true, length=50)	
	private String budsysProjCode;
	
	@Column(name="year", nullable=true, length=50)	
	private String year;
	
	@Column(name="proj_setup_time", nullable=true)	
	private java.sql.Timestamp projSetupTime;
	
	@Column(name="proj_decision_time", nullable=true)	
	private java.sql.Timestamp projDecisionTime;
	
	@Column(name="proj_decision_way", nullable=true, length=50)	
	private String projDecisionWay;
	
	@Column(name="proj_decision_base", nullable=true, length=50)	
	private String projDecisionBase;
	
	@Column(name="proj_decision_status", nullable=true, length=50)	
	private Integer projDecisionStatus;
	
	@Column(name="proj_setup_amount", nullable=true, length=50)	
	private String projSetupAmount;
	
	@Column(name="reimbursement_amount", nullable=true, length=50)	
	private String reimbursementAmount;
	
	@Column(name="recorded_amount", nullable=true, length=50)	
	private String recordedAmount;
	
	@Column(name="jan_plan", nullable=true, length=50)	
	private String janPlan;
	
	@Column(name="feb_plan", nullable=true, length=50)	
	private String febPlan;
	
	@Column(name="mar_plan", nullable=true, length=50)	
	private String marPlan;
	
	@Column(name="apr_plan", nullable=true, length=50)	
	private String aprPlan;
	
	@Column(name="may_plan", nullable=true, length=50)	
	private String mayPlan;
	
	@Column(name="jun_plan", nullable=true, length=50)	
	private String junPlan;
	
	@Column(name="jul_plan", nullable=true, length=50)	
	private String julPlan;
	
	@Column(name="aug_plan", nullable=true, length=50)	
	private String augPlan;
	
	@Column(name="sep_plan", nullable=true, length=50)	
	private String sepPlan;
	
	@Column(name="oct_plan", nullable=true, length=50)	
	private String octPlan;
	
	@Column(name="nov_plan", nullable=true, length=50)	
	private String novPlan;
	
	@Column(name="dec_plan", nullable=true, length=50)	
	private String decPlan;
	
	@Column(name="jan_actual", nullable=true, length=50)	
	private String jan_actual;
	
	@Column(name="feb_actual", nullable=true, length=50)	
	private String feb_actual;
	
	@Column(name="mar_actual", nullable=true, length=50)	
	private String mar_actual;
	
	@Column(name="apr_actual", nullable=true, length=50)	
	private String apr_actual;
	
	@Column(name="may_actual", nullable=true, length=50)	
	private String may_actual;
	
	@Column(name="jun_actual", nullable=true, length=50)	
	private String jun_actual;
	
	@Column(name="jul_actual", nullable=true, length=50)	
	private String jul_actual;
	
	@Column(name="aug_actual", nullable=true, length=50)	
	private String aug_actual;
	
	@Column(name="sept_actual", nullable=true, length=50)	
	private String sept_actual;
	
	@Column(name="oct_actual", nullable=true, length=50)	
	private String oct_actual;
	
	@Column(name="nov_actual", nullable=true, length=50)	
	private String nov_actual;
	
	@Column(name="dec_actual", nullable=true, length=50)	
	private String dec_actual;
	
	@Column(name="description", nullable=true)	
	private String description;
	
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
