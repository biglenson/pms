package com.zq.vo.basic.opex;

/**
 * OPEX需求
 */

public class BasOPEXRequirmentVO {
	
	private int id;
		
	private Integer companyId;
	
	private java.sql.Timestamp createTime;
		
	private String creator;
	
	private java.sql.Timestamp modifyTime;
	
	private String lastReviser;
		
	private String reqCode;
	
	private String reqName;
	
	private Integer auditState;
	
	private Integer businessDep;
	
	private String budgetProjCode;
	
	private java.sql.Timestamp reqConfirmTime;
	
	private String year;
	
	private String reqDeclareAmount;
	
	private Integer fundSource;
	
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
