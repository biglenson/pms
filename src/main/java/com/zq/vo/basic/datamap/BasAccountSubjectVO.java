package com.zq.vo.basic.datamap;

import java.io.Serializable;
import javax.persistence.*;
/**
 * 会计科目
 */

public class BasAccountSubjectVO {
	
	private int id;
	
	private Integer companyId;
	
	private java.sql.Timestamp createTime;
	
	private String creator;
	
	private java.sql.Timestamp modifyTime;
	
	private String lastReviser;
		
	private String expenseCategory;
	
	private String expenseCategoryName;
	
	private String expenseSubjectCode;
	
	private String expenseSubjectName;
	
	private String budgetSubject;
	
	private Integer expenseType;
	
	/**
	 * ID
	 */
	public int getId() {
		return id;
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
