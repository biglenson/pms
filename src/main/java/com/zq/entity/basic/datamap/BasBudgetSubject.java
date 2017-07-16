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
 * 预算科目
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="bas_budget_subject")
public class BasBudgetSubject implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月16日 下午11:10:26 
	*/
	private static final long serialVersionUID = 4279888483872035232L;

	public BasBudgetSubject() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BASBUDGETSUBJECT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASBUDGETSUBJECT_ID_GENERATOR", strategy="native")	
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
	
	@Column(name="bugdet_subject_code", nullable=true, length=50)	
	private String bugdetSubjectCode;
	
	@Column(name="bugdet_name", nullable=true, length=10)	
	private String bugdetName;
	
	@Column(name="sup_bugdet_subject_code", nullable=true, length=50)	
	private String supBugdetSubjectCode;
	
	@Column(name="relevant_dept", nullable=true, length=10)	
	private Integer relevantDept;
	
	@Column(name="expense_type", nullable=true, length=10)	
	private Integer expenseType;
	
	@Column(name="is_establish", nullable=true, length=10)	
	private Integer isEstablish;
	
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
	 * 预算科目编号 
	 */
	public void setBugdetSubjectCode(String value) {
		this.bugdetSubjectCode = value;
	}
	
	/**
	 * 预算科目编号 
	 */
	public String getBugdetSubjectCode() {
		return bugdetSubjectCode;
	}
	
	/**
	 * 预算科目名称 
	 */
	public void setBugdetName(String value) {
		this.bugdetName = value;
	}
	
	/**
	 * 预算科目名称 
	 */
	public String getBugdetName() {
		return bugdetName;
	}
	
	/**
	 * 上级预算科目编号 
	 */
	public void setSupBugdetSubjectCode(String value) {
		this.supBugdetSubjectCode = value;
	}
	
	/**
	 * 上级预算科目编号 
	 */
	public String getSupBugdetSubjectCode() {
		return supBugdetSubjectCode;
	}
	
	/**
	 * 归口部门 
	 */
	public void setRelevantDept(int value) {
		setRelevantDept(new Integer(value));
	}
	
	/**
	 * 归口部门 
	 */
	public void setRelevantDept(Integer value) {
		this.relevantDept = value;
	}
	
	/**
	 * 归口部门 
	 */
	public Integer getRelevantDept() {
		return relevantDept;
	}
	
	/**
	 * 成本费用类型 代码表：成本费用类型大类代码表
	 */
	public void setExpenseType(int value) {
		setExpenseType(new Integer(value));
	}
	
	/**
	 * 成本费用类型 代码表：成本费用类型大类代码表
	 */
	public void setExpenseType(Integer value) {
		this.expenseType = value;
	}
	
	/**
	 * 成本费用类型 代码表：成本费用类型大类代码表
	 */
	public Integer getExpenseType() {
		return expenseType;
	}
	
	/**
	 * 是否立项 代码表：是否代码表
	 */
	public void setIsEstablish(int value) {
		setIsEstablish(new Integer(value));
	}
	
	/**
	 * 是否立项 代码表：是否代码表
	 */
	public void setIsEstablish(Integer value) {
		this.isEstablish = value;
	}
	
	/**
	 * 是否立项 代码表：是否代码表
	 */
	public Integer getIsEstablish() {
		return isEstablish;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
