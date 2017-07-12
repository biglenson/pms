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
 * OPEX部门间预算调剂
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="bas_opex_budget_adjust")
public class BasOPEXBudgetAdjust implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月12日 上午9:44:44 
	*/
	private static final long serialVersionUID = -3754747985285642872L;

	public BasOPEXBudgetAdjust() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BAS_OPEX_BUDGET_ADJUST_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BAS_OPEX_BUDGET_ADJUST_ID_GENERATOR", strategy="native")	
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
	
	@Column(name="out_dept", nullable=true, length=10)	
	private Integer out_dept;
	
	@Column(name="in_dept", nullable=true, length=10)	
	private Integer in_dept;
	
	@Column(name="out_opex_proj", nullable=true, length=50)	
	private String out_opex_proj;
	
	@Column(name="in_opex_proj", nullable=true, length=50)	
	private String in_opex_proj;
	
	@Column(name="adjust_amount", nullable=true, length=50)	
	private String adjust_amount;
	
	@Column(name="adjust_time", nullable=true)	
	private java.sql.Timestamp adjust_time;
	
	@Column(name="out_budgeted_amount", nullable=true, length=50)	
	private String out_budgeted_amount;
	
	@Column(name="in_budgeted_amount", nullable=true, length=50)	
	private String in_budgeted_amount;
	
	@Column(name="out_budget_account", nullable=true, length=50)	
	private String out_budget_account;
	
	@Column(name="in_budget_account", nullable=true, length=50)	
	private String in_budget_account;
	
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
	 * 调出部门 
	 */
	public void setOut_dept(int value) {
		setOut_dept(new Integer(value));
	}
	
	/**
	 * 调出部门 
	 */
	public void setOut_dept(Integer value) {
		this.out_dept = value;
	}
	
	/**
	 * 调出部门 
	 */
	public Integer getOut_dept() {
		return out_dept;
	}
	
	/**
	 * 调入部门 
	 */
	public void setIn_dept(int value) {
		setIn_dept(new Integer(value));
	}
	
	/**
	 * 调入部门 
	 */
	public void setIn_dept(Integer value) {
		this.in_dept = value;
	}
	
	/**
	 * 调入部门 
	 */
	public Integer getIn_dept() {
		return in_dept;
	}
	
	/**
	 * 调出OPEX项目 bas_opex_project中budsys_proj_code
	 */
	public void setOut_opex_proj(String value) {
		this.out_opex_proj = value;
	}
	
	/**
	 * 调出OPEX项目 bas_opex_project中budsys_proj_code
	 */
	public String getOut_opex_proj() {
		return out_opex_proj;
	}
	
	/**
	 * 调入OPEX项目 bas_opex_project中budsys_proj_code
	 */
	public void setIn_opex_proj(String value) {
		this.in_opex_proj = value;
	}
	
	/**
	 * 调入OPEX项目 bas_opex_project中budsys_proj_code
	 */
	public String getIn_opex_proj() {
		return in_opex_proj;
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
	 * 调整时间 
	 */
	public void setAdjust_time(java.sql.Timestamp value) {
		this.adjust_time = value;
	}
	
	/**
	 * 调整时间 
	 */
	public java.sql.Timestamp getAdjust_time() {
		return adjust_time;
	}
	
	/**
	 * 调出项目调整后预算金额（元） 
	 */
	public void setOut_budgeted_amount(String value) {
		this.out_budgeted_amount = value;
	}
	
	/**
	 * 调出项目调整后预算金额（元） 
	 */
	public String getOut_budgeted_amount() {
		return out_budgeted_amount;
	}
	
	/**
	 * 调入项目调整后预算金额（元） 
	 */
	public void setIn_budgeted_amount(String value) {
		this.in_budgeted_amount = value;
	}
	
	/**
	 * 调入项目调整后预算金额（元） 
	 */
	public String getIn_budgeted_amount() {
		return in_budgeted_amount;
	}
	
	/**
	 * 调出预算科目 bas_budget_account中bugdet_account _code
	 */
	public void setOut_budget_account(String value) {
		this.out_budget_account = value;
	}
	
	/**
	 * 调出预算科目 bas_budget_account中bugdet_account _code
	 */
	public String getOut_budget_account() {
		return out_budget_account;
	}
	
	/**
	 * 调入预算科目 bas_budget_account中bugdet_account _code
	 */
	public void setIn_budget_account(String value) {
		this.in_budget_account = value;
	}
	
	/**
	 * 调入预算科目 bas_budget_account中bugdet_account _code
	 */
	public String getIn_budget_account() {
		return in_budget_account;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
