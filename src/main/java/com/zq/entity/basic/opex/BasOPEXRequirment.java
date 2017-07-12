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
	private Integer company_id;
	
	@Column(name="create_time", nullable=true)	
	private java.sql.Timestamp create_time;
	
	@Column(name="creator", nullable=true, length=50)	
	private String creator;
	
	@Column(name="modify_time", nullable=true)	
	private java.sql.Timestamp modify_time;
	
	@Column(name="last_reviser", nullable=true, length=50)	
	private String last_reviser;
	
	@Column(name="req_code", nullable=true, length=50)	
	private String req_code;
	
	@Column(name="req_name", nullable=true, length=50)	
	private String req_name;
	
	@Column(name="audit_state", nullable=true, length=10)	
	private Integer audit_state;
	
	@Column(name="business_dep", nullable=true, length=10)	
	private Integer business_dep;
	
	@Column(name="budget_proj_code", nullable=true, length=50)	
	private String budget_proj_code;
	
	@Column(name="req_confirm_time", nullable=true)	
	private java.sql.Timestamp req_confirm_time;
	
	@Column(name="year", nullable=true, length=50)	
	private String year;
	
	@Column(name="req_declare_amount", nullable=true, length=50)	
	private String req_declare_amount;
	
	@Column(name="fund_source", nullable=true, length=10)	
	private Integer fund_source;
	
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
	 * 审批状态 
	 */
	public void setAudit_state(int value) {
		setAudit_state(new Integer(value));
	}
	
	/**
	 * 审批状态 
	 */
	public void setAudit_state(Integer value) {
		this.audit_state = value;
	}
	
	/**
	 * 审批状态 
	 */
	public Integer getAudit_state() {
		return audit_state;
	}
	
	/**
	 * 业务部门 
	 */
	public void setBusiness_dep(int value) {
		setBusiness_dep(new Integer(value));
	}
	
	/**
	 * 业务部门 
	 */
	public void setBusiness_dep(Integer value) {
		this.business_dep = value;
	}
	
	/**
	 * 业务部门 
	 */
	public Integer getBusiness_dep() {
		return business_dep;
	}
	
	/**
	 * 预算项目编号 bas_opex_budget_project中budget_proj_code
	 */
	public void setBudget_proj_code(String value) {
		this.budget_proj_code = value;
	}
	
	/**
	 * 预算项目编号 bas_opex_budget_project中budget_proj_code
	 */
	public String getBudget_proj_code() {
		return budget_proj_code;
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
	public void setReq_declare_amount(String value) {
		this.req_declare_amount = value;
	}
	
	/**
	 * 需求申报金额（元） 
	 */
	public String getReq_declare_amount() {
		return req_declare_amount;
	}
	
	/**
	 * 资金来源  代码表：OPEX预算来源代码表
	 */
	public void setFund_source(int value) {
		setFund_source(new Integer(value));
	}
	
	/**
	 * 资金来源  代码表：OPEX预算来源代码表
	 */
	public void setFund_source(Integer value) {
		this.fund_source = value;
	}
	
	/**
	 * 资金来源  代码表：OPEX预算来源代码表
	 */
	public Integer getFund_source() {
		return fund_source;
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
