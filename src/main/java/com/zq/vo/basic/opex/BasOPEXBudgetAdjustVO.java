package com.zq.vo.basic.opex;

/**
 * OPEX部门间预算调剂
 */

public class BasOPEXBudgetAdjustVO{

	private int id;
	
	private Integer companyId;
	
	private java.sql.Timestamp createTime;
	
	private String creator;
	
	private java.sql.Timestamp modifyTime;
	
	private String lastReviser;
	
	private Integer outDept;
	
	private Integer inDept;
	
	private String outOpexProj;
	
	private String inOpexProj;
	
	private String adjustAmount;
	
	private java.sql.Timestamp adjustTime;
	
	private String outBudgetedAmount;
	
	private String inBudgetedAmount;
		
	private String outBudgetAccount;
	
	private String inBudgetAccount;
	
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
		this.outBudgetedAmount = value;
	}
	
	/**
	 * 调出项目调整后预算金额（元） 
	 */
	public String getOutBudgetedAmount() {
		return outBudgetedAmount;
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
