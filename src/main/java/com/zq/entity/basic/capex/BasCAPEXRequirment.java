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
 * CAPEX需求
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="bas_capex_requirment")
public class BasCAPEXRequirment implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月11日 下午4:15:47 
	*/
	private static final long serialVersionUID = 6022142226147269968L;

	public BasCAPEXRequirment() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BAS_CAPEX_REQUIRMENT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BAS_CAPEX_REQUIRMENT_ID_GENERATOR", strategy="native")	
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
	
	@Column(name="invest_plan_code", nullable=true, length=255)	
	private String investPlanCode;
	
	@Column(name="req_code", nullable=true, length=255)	
	private String reqCode;
	
	@Column(name="req_name", nullable=true, length=255)	
	private String reqName;
	
	@Column(name="req_dept", nullable=true, length=255)	
	private String reqDept;
	
	@Column(name="plan_req_submit_time", nullable=true)	
	private java.sql.Timestamp planReqSubmitTime;
	
	@Column(name="req_submit_time", nullable=true)	
	private java.sql.Timestamp reqSubmitTime;
	
	@Column(name="req_submit_status", nullable=true, length=10)	
	private Integer reqSubmitStatus;
	
	@Column(name="req_audit_status", nullable=true, length=10)	
	private Integer reqAuditStatus;
	
	@Column(name="req_confirm_time", nullable=true)	
	private java.sql.Timestamp reqConfirmTime;
	
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
	 * 需求是否已提交 代码表：是否代
	 */
	public void setReqSubmitStatus(int value) {
		setReqSubmitStatus(new Integer(value));
	}
	
	/**
	 * 需求是否已提交 代码表：是否代
	 */
	public void setReqSubmitStatus(Integer value) {
		this.reqSubmitStatus = value;
	}
	
	/**
	 * 需求是否已提交 代码表：是否代
	 */
	public Integer getReqSubmitStatus() {
		return reqSubmitStatus;
	}
	
	/**
	 * 需求审核状态 1-通过；2-不
	 */
	public void setReqAuditStatus(int value) {
		setReqAuditStatus(new Integer(value));
	}
	
	/**
	 * 需求审核状态 1-通过；2-不
	 */
	public void setReqAuditStatus(Integer value) {
		this.reqAuditStatus = value;
	}
	
	/**
	 * 需求审核状态 1-通过；2-不
	 */
	public Integer getReqAuditStatus() {
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
