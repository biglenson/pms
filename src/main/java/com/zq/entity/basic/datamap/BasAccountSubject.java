package com.zq.entity.basic.datamap;
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
 * 会计科目
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="bas_account_subject")
public class BasAccountSubject implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月16日 下午11:07:23 
	*/
	private static final long serialVersionUID = -7728217505554411609L;

	public BasAccountSubject() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BASACCOUNTSUBJECT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASACCOUNTSUBJECT_ID_GENERATOR", strategy="native")	
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
	
	@Column(name="expense_category", nullable=true, length=50)	
	private String expenseCategory;
	
	@Column(name="expense_category_name", nullable=true, length=50)	
	private String expenseCategoryName;
	
	@Column(name="expense_subject_code", nullable=true, length=50)	
	private String expenseSubjectCode;
	
	@Column(name="expense_subject_name", nullable=true, length=50)	
	private String expenseSubjectName;
	
	@Column(name="budget_subject", nullable=true, length=50)	
	private String budgetSubject;
	
	@Column(name="expense_type", nullable=true, length=10)	
	private Integer expenseType;
	
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
	 * 费用大类 
	 */
	public void setExpenseCategory(String value) {
		this.expenseCategory = value;
	}
	
	/**
	 * 费用大类 
	 */
	public String getExpenseCategory() {
		return expenseCategory;
	}
	
	/**
	 * 费用大类名称 
	 */
	public void setExpenseCategoryName(String value) {
		this.expenseCategoryName = value;
	}
	
	/**
	 * 费用大类名称 
	 */
	public String getExpenseCategoryName() {
		return expenseCategoryName;
	}
	
	/**
	 * 费用科目代码 
	 */
	public void setExpenseSubjectCode(String value) {
		this.expenseSubjectCode = value;
	}
	
	/**
	 * 费用科目代码 
	 */
	public String getExpenseSubjectCode() {
		return expenseSubjectCode;
	}
	
	/**
	 * 费用科目名称 
	 */
	public void setExpenseSubjectName(String value) {
		this.expenseSubjectName = value;
	}
	
	/**
	 * 费用科目名称 
	 */
	public String getExpenseSubjectName() {
		return expenseSubjectName;
	}
	
	/**
	 * 预算科目 
	 */
	public void setBudgetSubject(String value) {
		this.budgetSubject = value;
	}
	
	/**
	 * 预算科目 
	 */
	public String getBudgetSubject() {
		return budgetSubject;
	}
	
	/**
	 * 成本类型 代码表：成本类别二级代码表
	 */
	public void setExpenseType(int value) {
		setExpenseType(new Integer(value));
	}
	
	/**
	 * 成本类型 代码表：成本类别二级代码表
	 */
	public void setExpenseType(Integer value) {
		this.expenseType = value;
	}
	
	/**
	 * 成本类型 代码表：成本类别二级代码表
	 */
	public Integer getExpenseType() {
		return expenseType;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
