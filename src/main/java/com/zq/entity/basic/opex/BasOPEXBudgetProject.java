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
	private Integer companyId;
	
	@Column(name="create_time", nullable=true)	
	private java.sql.Timestamp createTime;
	
	@Column(name="creator", nullable=true, length=50)	
	private String creator;
	
	@Column(name="modify_time", nullable=true)	
	private java.sql.Timestamp modifyTime;
	
	@Column(name="last_reviser", nullable=true, length=50)	
	private String lastReviser;
	
	@Column(name="budget_code", nullable=true, length=50)	
	private String budgetCode;
	
	@Column(name="budget_account", nullable=true, length=50)	
	private String budgetAccount;
	
	@Column(name="budget_proj_code", nullable=true, length=50)	
	private String budgetProjCode;
	
	@Column(name="budget_proj_name", nullable=true, length=255)	
	private String budgetProjName;
	
	@Column(name="proj_budget_amount", nullable=true, length=50)	
	private String projBudgetAmount;
	
	@Column(name="proj_expectfinish_amount", nullable=true, length=50)	
	private String projExpectfinishAmount;
	
	@Column(name="proj_finished_amount", nullable=true, length=50)	
	private String projFinishedAmount;
	
	@Column(name="year", nullable=true, length=50)	
	private String year;
	
	@Column(name="business_dept", nullable=true, length=10)	
	private Integer businessDept;
	
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
	 * 预算编号
	 */
	public void setBudgetCode(String value) {
		this.budgetCode = value;
	}
	
	/**
	 * 预算编号
	 */
	public String getBudgetCode() {
		return budgetCode;
	}
	
	/**
	 * 预算科目bas_budget_account中bugdet_account _code
	 */
	public void setBudgetAccount(String value) {
		this.budgetAccount = value;
	}
	
	/**
	 * 预算科目bas_budget_account中bugdet_account _code
	 */
	public String getBudgetAccount() {
		return budgetAccount;
	}
	
	/**
	 * 预算项目编号 
	 */
	public void setBudgetProjCode(String value) {
		this.budgetProjCode = value;
	}
	
	/**
	 * 预算项目编号 
	 */
	public String getBudgetProjCode() {
		return budgetProjCode;
	}
	
	/**
	 * 预算项目名称 
	 */
	public void setBudgetProjName(String value) {
		this.budgetProjName = value;
	}
	
	/**
	 * 预算项目名称 
	 */
	public String getBudgetProjName() {
		return budgetProjName;
	}
	
	/**
	 * 项目预算金额（元） 
	 */
	public void setProjBudgetAmount(String value) {
		this.projBudgetAmount = value;
	}
	
	/**
	 * 项目预算金额（元） 
	 */
	public String getProjBudgetAmount() {
		return projBudgetAmount;
	}
	
	/**
	 * 项目预计完成值（元） 
	 */
	public void setProjExpectfinishAmount(String value) {
		this.projExpectfinishAmount = value;
	}
	
	/**
	 * 项目预计完成值（元） 
	 */
	public String getProjExpectfinishAmount() {
		return projExpectfinishAmount;
	}
	
	/**
	 * 项目完成额度（元） 
	 */
	public void setProjFinishedAmount(String value) {
		this.projFinishedAmount = value;
	}
	
	/**
	 * 项目完成额度（元） 
	 */
	public String getProjFinishedAmount() {
		return projFinishedAmount;
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
	public void setBusinessDept(Integer value) {
		this.businessDept = value;
	}
	
	/**
	 * 业务部门 
	 */
	public Integer getBusinessDept() {
		return businessDept;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
