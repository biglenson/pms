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
 * OPEX预算项目
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="bas_opex_budget_project")
public class BasOPEXBudgetProject implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月12日 上午9:48:50 
	*/
	private static final long serialVersionUID = 7750127843550586000L;

	public BasOPEXBudgetProject() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BAS_OPEX_BUDGET_PROJECT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BAS_OPEX_BUDGET_PROJECT_ID_GENERATOR", strategy="native")	
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
	
	@Column(name="budget_code", nullable=true, length=50)	
	private String budget_code;
	
	@Column(name="budget_account", nullable=true, length=50)	
	private String budget_account;
	
	@Column(name="budget_proj_code", nullable=true, length=50)	
	private String budget_proj_code;
	
	@Column(name="budget_proj_name", nullable=true, length=255)	
	private String budget_proj_name;
	
	@Column(name="proj_budget_amount", nullable=true, length=50)	
	private String proj_budget_amount;
	
	@Column(name="proj_expectfinish_amount", nullable=true, length=50)	
	private String proj_expectfinish_amount;
	
	@Column(name="proj_finished_amount", nullable=true, length=50)	
	private String proj_finished_amount;
	
	@Column(name="year", nullable=true, length=50)	
	private String year;
	
	@Column(name="business_dept", nullable=true, length=10)	
	private Integer business_dept;
	
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
	 * 预算编号
	 */
	public void setBudget_code(String value) {
		this.budget_code = value;
	}
	
	/**
	 * 预算编号
	 */
	public String getBudget_code() {
		return budget_code;
	}
	
	/**
	 * 预算科目bas_budget_account中bugdet_account _code
	 */
	public void setBudget_account(String value) {
		this.budget_account = value;
	}
	
	/**
	 * 预算科目bas_budget_account中bugdet_account _code
	 */
	public String getBudget_account() {
		return budget_account;
	}
	
	/**
	 * 预算项目编号 
	 */
	public void setBudget_proj_code(String value) {
		this.budget_proj_code = value;
	}
	
	/**
	 * 预算项目编号 
	 */
	public String getBudget_proj_code() {
		return budget_proj_code;
	}
	
	/**
	 * 预算项目名称 
	 */
	public void setBudget_proj_name(String value) {
		this.budget_proj_name = value;
	}
	
	/**
	 * 预算项目名称 
	 */
	public String getBudget_proj_name() {
		return budget_proj_name;
	}
	
	/**
	 * 项目预算金额（元） 
	 */
	public void setProj_budget_amount(String value) {
		this.proj_budget_amount = value;
	}
	
	/**
	 * 项目预算金额（元） 
	 */
	public String getProj_budget_amount() {
		return proj_budget_amount;
	}
	
	/**
	 * 项目预计完成值（元） 
	 */
	public void setProj_expectfinish_amount(String value) {
		this.proj_expectfinish_amount = value;
	}
	
	/**
	 * 项目预计完成值（元） 
	 */
	public String getProj_expectfinish_amount() {
		return proj_expectfinish_amount;
	}
	
	/**
	 * 项目完成额度（元） 
	 */
	public void setProj_finished_amount(String value) {
		this.proj_finished_amount = value;
	}
	
	/**
	 * 项目完成额度（元） 
	 */
	public String getProj_finished_amount() {
		return proj_finished_amount;
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
	 * 业务部门 
	 */
	public void setBusiness_dept(int value) {
		setBusiness_dept(new Integer(value));
	}
	
	/**
	 * 业务部门 
	 */
	public void setBusiness_dept(Integer value) {
		this.business_dept = value;
	}
	
	/**
	 * 业务部门 
	 */
	public Integer getBusiness_dept() {
		return business_dept;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
