package com.zq.vo.basic.opex;

public class BasOPEXBudgetProjectVO {
	
	private int id;
	
	private Integer companyId;
	
	private java.sql.Timestamp createTime;
	
	private String creator;
	
	private java.sql.Timestamp modifyTime;
	
	private String lastReviser;
	
	private String budgetCode;
	
	private String budgetAccount;
	
	private String budgetProjCode;
	
	private String budgetProjName;
	
	private String projBudgetAmount;
	
	private String projExpectfinishAmount;
	
	private String projFinishedAmount;
	
	private String year;
	
	private Integer businessDept;
	
	/**
	 * ID
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * id
	 */
	public void setId(int id) {
		this.id = id;
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
