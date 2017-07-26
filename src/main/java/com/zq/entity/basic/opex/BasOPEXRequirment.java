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
 * OPEX需求
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="bas_opex_requirment")
public class BasOPEXRequirment implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月12日 上午9:51:32 
	*/
	private static final long serialVersionUID = 1606788312558463302L;

	public BasOPEXRequirment() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BAS_OPEX_REQUIRMENT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BAS_OPEX_REQUIRMENT_ID_GENERATOR", strategy="native")	
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
	
	@Column(name="req_code", nullable=true, length=50)	
	private String reqCode;
	
	@Column(name="req_name", nullable=true, length=50)	
	private String reqName;
	
	@Column(name="audit_state", nullable=true, length=10)	
	private Integer auditState;
	
	@Column(name="business_dep", nullable=true, length=10)	
	private Integer businessDep;
	
	@Column(name="budget_proj_code", nullable=true, length=50)	
	private String budgetProjCode;
	
	@Column(name="req_confirm_time", nullable=true)	
	private java.sql.Timestamp reqConfirmTime;
	
	@Column(name="year", nullable=true, length=50)	
	private String year;
	
	@Column(name="req_declare_amount", nullable=true, length=50)	
	private String reqDeclareAmount;
	
	@Column(name="fund_source", nullable=true, length=10)	
	private Integer fundSource;
	
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
	 * 需求名称 
	 */
	public void setReqName(String value) {
		this.reqName = value;
	}
	
	/**
	 * 需求名称 
	 */
	public String getReqName() {
		return reqName;
	}
	
	/**
	 * 审批状态 
	 */
	public void setAuditState(int value) {
		setAuditState(new Integer(value));
	}
	
	/**
	 * 审批状态 
	 */
	public void setAuditState(Integer value) {
		this.auditState = value;
	}
	
	/**
	 * 审批状态 
	 */
	public Integer getAuditState() {
		return auditState;
	}
	
	/**
	 * 业务部门 
	 */
	public void setBusinessDep(int value) {
		setBusinessDep(new Integer(value));
	}
	
	/**
	 * 业务部门 
	 */
	public void setBusinessDep(Integer value) {
		this.businessDep = value;
	}
	
	/**
	 * 业务部门 
	 */
	public Integer getBusinessDep() {
		return businessDep;
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
	 * 需求确认时间 
	 */
	public void setReqConfirmTime(java.sql.Timestamp value) {
		this.reqConfirmTime = value;
	}
	
	/**
	 * 需求确认时间 
	 */
	public java.sql.Timestamp getReqConfirmTime() {
		return reqConfirmTime;
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
	 * 需求申报金额（元） 
	 */
	public void setReqDeclareAmount(String value) {
		this.reqDeclareAmount = value;
	}
	
	/**
	 * 需求申报金额（元） 
	 */
	public String getReqDeclareAmount() {
		return reqDeclareAmount;
	}
	
	/**
	 * 资金来源  代码表：OPEX预算来源代码表
	 */
	public void setFundSource(int value) {
		setFundSource(new Integer(value));
	}
	
	/**
	 * 资金来源  代码表：OPEX预算来源代码表
	 */
	public void setFundSource(Integer value) {
		this.fundSource = value;
	}
	
	/**
	 * 资金来源  代码表：OPEX预算来源代码表
	 */
	public Integer getFundSource() {
		return fundSource;
	}
	
	/**
	 * 描述 
	 */
	public void setDescription(String value) {
		this.description = value;
	}
	
	/**
	 * 描述 
	 */
	public String getDescription() {
		return description;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
