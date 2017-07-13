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
	private Integer companyId;
	
	@Column(name="create_time", nullable=true)	
	private java.sql.Timestamp createTime;
	
	@Column(name="creator", nullable=true, length=50)	
	private String creator;
	
	@Column(name="modify_time", nullable=true)	
	private java.sql.Timestamp modifyTime;
	
	@Column(name="last_reviser", nullable=true, length=50)	
	private String lastReviser;
	
	@Column(name="out_dept", nullable=true, length=10)	
	private Integer outDept;
	
	@Column(name="in_dept", nullable=true, length=10)	
	private Integer inDept;
	
	@Column(name="out_opex_proj", nullable=true, length=50)	
	private String outOpexProj;
	
	@Column(name="in_opex_proj", nullable=true, length=50)	
	private String inOpexProj;
	
	@Column(name="adjust_amount", nullable=true, length=50)	
	private String adjustAmount;
	
	@Column(name="adjustTime", nullable=true)	
	private java.sql.Timestamp adjustTime;
	
	@Column(name="out_budgeted_amount", nullable=true, length=50)	
	private String outBudgetedAmount;
	
	@Column(name="in_budgeted_amount", nullable=true, length=50)	
	private String inBudgetedAmount;
	
	@Column(name="out_budget_account", nullable=true, length=50)	
	private String outBudgetAccount;
	
	@Column(name="in_budget_account", nullable=true, length=50)	
	private String inBudgetAccount;
	
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
	 * 调出部门 
	 */
	public void setOut_dept(int value) {
		setOut_dept(new Integer(value));
	}
	
	/**
	 * 调出部门 
	 */
	public void setOutDept(Integer value) {
		this.outDept = value;
	}
	
	/**
	 * 调出部门 
	 */
	public Integer getOutDept() {
		return outDept;
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
	public void setInDept(Integer value) {
		this.inDept = value;
	}
	
	/**
	 * 调入部门 
	 */
	public Integer getInDept() {
		return inDept;
	}
	
	/**
	 * 调出OPEX项目 bas_opex_project中budsys_proj_code
	 */
	public void setOutOpexProj(String value) {
		this.outOpexProj = value;
	}
	
	/**
	 * 调出OPEX项目 bas_opex_project中budsys_proj_code
	 */
	public String getOutOpexProj() {
		return outOpexProj;
	}
	
	/**
	 * 调入OPEX项目 bas_opex_project中budsys_proj_code
	 */
	public void setInOpexProj(String value) {
		this.inOpexProj = value;
	}
	
	/**
	 * 调入OPEX项目 bas_opex_project中budsys_proj_code
	 */
	public String getInOpexProj() {
		return inOpexProj;
	}
	
	/**
	 * 调整金额（元） 
	 */
	public void setAdjustAmount(String value) {
		this.adjustAmount = value;
	}
	
	/**
	 * 调整金额（元） 
	 */
	public String getAdjustAmount() {
		return adjustAmount;
	}
	
	/**
	 * 调整时间 
	 */
	public void setAdjustTime(java.sql.Timestamp value) {
		this.adjustTime = value;
	}
	
	/**
	 * 调整时间 
	 */
	public java.sql.Timestamp getAdjustTime() {
		return adjustTime;
	}
	
	/**
	 * 调出项目调整后预算金额（元） 
	 */
	public void setOutBudgetedAmount(String value) {
		this.outBudgetAccount = value;
	}
	
	/**
	 * 调出项目调整后预算金额（元） 
	 */
	public String getOutBudgetedAmount() {
		return outBudgetAccount;
	}
	
	/**
	 * 调入项目调整后预算金额（元） 
	 */
	public void setInBudgetedAmount(String value) {
		this.inBudgetedAmount = value;
	}
	
	/**
	 * 调入项目调整后预算金额（元） 
	 */
	public String getInBudgetedAmount() {
		return inBudgetedAmount;
	}
	
	/**
	 * 调出预算科目 bas_budget_account中bugdet_account _code
	 */
	public void setOutBudgetAccount(String value) {
		this.outBudgetAccount = value;
	}
	
	/**
	 * 调出预算科目 bas_budget_account中bugdet_account _code
	 */
	public String getOutBudgetAccount() {
		return outBudgetAccount;
	}
	
	/**
	 * 调入预算科目 bas_budget_account中bugdet_account _code
	 */
	public void setInBudgetAccount(String value) {
		this.inBudgetAccount = value;
	}
	
	/**
	 * 调入预算科目 bas_budget_account中bugdet_account _code
	 */
	public String getInBudgetAccount() {
		return inBudgetAccount;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
