package com.zq.vo.basic.datamap;

/**
 * 预算科目
 */

public class BasBudgetSubjectVO {

	private int id;
	
	private Integer companyId;
	
	private java.sql.Timestamp createTime;
	
	private String creator;
	
	private java.sql.Timestamp modifyTime;
	
	private String lastReviser;
		
	private String bugdetSubjectCode;
	
	private String bugdetName;
	
	private String supBugdetSubjectCode;
		
	private Integer relevantDept;
	
	private Integer expenseType;
	
	private Integer isEstablish;
	
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
