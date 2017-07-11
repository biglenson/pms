package com.zq.entity.basic;
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
	private Integer company_id;
	
	@Column(name="create_time", nullable=true)	
	private java.sql.Timestamp create_time;
	
	@Column(name="creator", nullable=true, length=50)	
	private String creator;
	
	@Column(name="modify_time", nullable=true)	
	private java.sql.Timestamp modify_time;
	
	@Column(name="last_reviser", nullable=true, length=50)	
	private String last_reviser;
	
	@Column(name="invest_plan_code", nullable=true, length=255)	
	private String invest_plan_code;
	
	@Column(name="req_code", nullable=true, length=255)	
	private String req_code;
	
	@Column(name="req_name", nullable=true, length=255)	
	private String req_name;
	
	@Column(name="req_department", nullable=true, length=255)	
	private String req_department;
	
	@Column(name="plan_req_submit_time", nullable=true)	
	private java.sql.Timestamp plan_req_submit_time;
	
	@Column(name="req_submit_time", nullable=true)	
	private java.sql.Timestamp req_submit_time;
	
	@Column(name="req_submit_status", nullable=true, length=10)	
	private Integer req_submit_status;
	
	@Column(name="req_audit_status", nullable=true, length=10)	
	private Integer req_audit_status;
	
	@Column(name="req_confirm_time", nullable=true)	
	private java.sql.Timestamp req_confirm_time;
	
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
	public void setCompany_id(int value) {
		setCompany_id(new Integer(value));
	}
	
	/**
	 * 公司ID
	 */
	public void setCompany_id(Integer value) {
		this.company_id = value;
	}
	
	/**
	 * 公司ID
	 */
	public Integer getCompany_id() {
		return company_id;
	}
	
	/**
	 * 创建时间
	 */
	public void setCreate_time(java.sql.Timestamp value) {
		this.create_time = value;
	}
	
	/**
	 * 创建时间
	 */
	public java.sql.Timestamp getCreate_time() {
		return create_time;
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
	public void setModify_time(java.sql.Timestamp value) {
		this.modify_time = value;
	}
	
	/**
	 * 最后修改时间
	 */
	public java.sql.Timestamp getModify_time() {
		return modify_time;
	}
	
	/**
	 * 修改人
	 */
	public void setLast_reviser(String value) {
		this.last_reviser = value;
	}
	
	/**
	 * 修改人
	 */
	public String getLast_reviser() {
		return last_reviser;
	}
	
	public void setInvest_plan_code(String value) {
		this.invest_plan_code = value;
	}
	
	public String getInvest_plan_code() {
		return invest_plan_code;
	}
	
	/**
	 * 需求编号 
	 */
	public void setReq_code(String value) {
		this.req_code = value;
	}
	
	/**
	 * 需求编号 
	 */
	public String getReq_code() {
		return req_code;
	}
	
	/**
	 * 需求名称 
	 */
	public void setReq_name(String value) {
		this.req_name = value;
	}
	
	/**
	 * 需求名称 
	 */
	public String getReq_name() {
		return req_name;
	}
	
	/**
	 * 需求部门 
	 */
	public void setReq_department(String value) {
		this.req_department = value;
	}
	
	/**
	 * 需求部门 
	 */
	public String getReq_department() {
		return req_department;
	}
	
	/**
	 * 计划需求提交时间 
	 */
	public void setPlan_req_submit_time(java.sql.Timestamp value) {
		this.plan_req_submit_time = value;
	}
	
	/**
	 * 计划需求提交时间 
	 */
	public java.sql.Timestamp getPlan_req_submit_time() {
		return plan_req_submit_time;
	}
	
	/**
	 * 需求提交时间 
	 */
	public void setReq_submit_time(java.sql.Timestamp value) {
		this.req_submit_time = value;
	}
	
	/**
	 * 需求提交时间 
	 */
	public java.sql.Timestamp getReq_submit_time() {
		return req_submit_time;
	}
	
	/**
	 * 需求是否已提交 代码表：是否代
	 */
	public void setReq_submit_status(int value) {
		setReq_submit_status(new Integer(value));
	}
	
	/**
	 * 需求是否已提交 代码表：是否代
	 */
	public void setReq_submit_status(Integer value) {
		this.req_submit_status = value;
	}
	
	/**
	 * 需求是否已提交 代码表：是否代
	 */
	public Integer getReq_submit_status() {
		return req_submit_status;
	}
	
	/**
	 * 需求审核状态 1-通过；2-不
	 */
	public void setReq_audit_status(int value) {
		setReq_audit_status(new Integer(value));
	}
	
	/**
	 * 需求审核状态 1-通过；2-不
	 */
	public void setReq_audit_status(Integer value) {
		this.req_audit_status = value;
	}
	
	/**
	 * 需求审核状态 1-通过；2-不
	 */
	public Integer getReq_audit_status() {
		return req_audit_status;
	}
	
	/**
	 * 需求确认时间 
	 */
	public void setReq_confirm_time(java.sql.Timestamp value) {
		this.req_confirm_time = value;
	}
	
	/**
	 * 需求确认时间 
	 */
	public java.sql.Timestamp getReq_confirm_time() {
		return req_confirm_time;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
