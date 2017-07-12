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
 * OPEX动态预算池明细
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="bas_opex_budgetpool_detail")
public class BasOpexBudgetpoolDetail implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月12日 上午9:56:00 
	*/
	private static final long serialVersionUID = -1141521478360390581L;

	public BasOpexBudgetpoolDetail() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BAS_OPEX_BUDGETPOOL_DETAIL_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BAS_OPEX_BUDGETPOOL_DETAIL_ID_GENERATOR", strategy="native")	
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
	
	@Column(name="business_dept", nullable=true, length=10)	
	private Integer business_dept;
	
	@Column(name="adjust_amount", nullable=true, length=50)	
	private String adjust_amount;
	
	@Column(name="budget_account", nullable=true, length=50)	
	private String budget_account;
	
	@Column(name="adjust_date", nullable=true)	
	private java.sql.Timestamp adjust_date;
	
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
	
	/**
	 * 调整金额（元） 
	 */
	public void setAdjust_amount(String value) {
		this.adjust_amount = value;
	}
	
	/**
	 * 调整金额（元） 
	 */
	public String getAdjust_amount() {
		return adjust_amount;
	}
	
	/**
	 * 预算科目 bas_budget_account中bugdet_account _code
	 */
	public void setBudget_account(String value) {
		this.budget_account = value;
	}
	
	/**
	 * 预算科目 bas_budget_account中bugdet_account _code
	 */
	public String getBudget_account() {
		return budget_account;
	}
	
	/**
	 * 调整日期 
	 */
	public void setAdjust_date(java.sql.Timestamp value) {
		this.adjust_date = value;
	}
	
	/**
	 * 调整日期 
	 */
	public java.sql.Timestamp getAdjust_date() {
		return adjust_date;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
