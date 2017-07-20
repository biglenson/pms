package com.zq.vo.basic.opex;

public class BasOpexBudgetpoolDetailVO {
	
	private int id;
	
	private Integer companyId;
	
	private java.sql.Timestamp createTime;
	
	private String creator;
	
	private java.sql.Timestamp modifyTime;
	
	private String lastReviser;
	
	private Integer businessDept;
	
	private String adjustAmount;
		
	private String budgetAccount;
	
	private java.sql.Timestamp adjustDate;
	
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
	 * 预算科目 bas_budget_account中bugdet_account _code
	 */
	public void setBudgetAccount(String value) {
		this.budgetAccount = value;
	}
	
	/**
	 * 预算科目 bas_budget_account中bugdet_account _code
	 */
	public String getBudgetAccount() {
		return budgetAccount;
	}
	
	/**
	 * 调整日期 
	 */
	public void setAdjustDate(java.sql.Timestamp value) {
		this.adjustDate = value;
	}
	
	/**
	 * 调整日期 
	 */
	public java.sql.Timestamp getAdjustDate() {
		return adjustDate;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
