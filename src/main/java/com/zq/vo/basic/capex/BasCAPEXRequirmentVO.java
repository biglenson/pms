package com.zq.vo.basic.capex;

/**
 * CAPEX需求
 */

public class BasCAPEXRequirmentVO {
	
	private int id;
	
	private Integer companyId;
	
	private java.sql.Timestamp createTime;
		
	private String creator;
	
	private java.sql.Timestamp modifyTime;
	
	private String lastReviser;
	
	private String investPlanCode;
	
	private String reqCode;
	
	private String reqName;
	
	private String reqDept;
	
	private java.sql.Timestamp planReqSubmitTime;
	
	private java.sql.Timestamp reqSubmitTime;
	
	private String reqSubmitStatus;
	
	private String reqAuditStatus;
	
	private java.sql.Timestamp reqConfirmTime;
	
	/**
	 * ID
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * id
	 */
	public void setId(int id) {
		this.id = id;
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
	
	public void setInvestPlanCode(String value) {
		this.investPlanCode = value;
	}
	
	public String getInvestPlanCode() {
		return investPlanCode;
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
	 * 需求部门 
	 */
	public void setReqDept(String value) {
		this.reqDept = value;
	}
	
	/**
	 * 需求部门 
	 */
	public String getReqDept() {
		return reqDept;
	}
	
	/**
	 * 计划需求提交时间 
	 */
	public void setPlanReqSubmitTime(java.sql.Timestamp value) {
		this.planReqSubmitTime = value;
	}
	
	/**
	 * 计划需求提交时间 
	 */
	public java.sql.Timestamp getPlanReqSubmitTime() {
		return planReqSubmitTime;
	}
	
	/**
	 * 需求提交时间 
	 */
	public void setReqSubmitTime(java.sql.Timestamp value) {
		this.reqSubmitTime = value;
	}
	
	/**
	 * 需求提交时间 
	 */
	public java.sql.Timestamp getReqSubmitTime() {
		return reqSubmitTime;
	}

	
	/**
	 * 需求是否已提交 代码表：是否代码表
	 */
	public void setReqSubmitStatus(String value) {
		this.reqSubmitStatus = value;
	}
	
	/**
	 * 需求是否已提交 代码表：是否代码表
	 */
	public String getReqSubmitStatus() {
		return reqSubmitStatus;
	}
		
	/**
	 * 需求审核状态 1-通过；2-不
	 */
	public void setReqAuditStatus(String value) {
		this.reqAuditStatus = value;
	}
	
	/**
	 * 需求审核状态 1-通过；2-不
	 */
	public String getReqAuditStatus() {
		return reqAuditStatus;
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
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
