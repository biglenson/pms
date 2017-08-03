package com.zq.vo.basic.datamap;

public class BasIncomeByprodVO {

	private int id;
		
	private Integer companyId;
	
	private java.sql.Timestamp createTime;
	
	private String creator;
	
	private java.sql.Timestamp modifyTime;
		
	private String lastReviser;
		
	private String productCode;
	
	private String customerCode;
	
	private String itemsetCode;
		
	private Integer incomeType;
	
	private String amount;
	
	private java.sql.Timestamp date;
	
	private Integer industry;
	
	private Integer department;
	
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
	 * 产品编号 bas_product中product_code
	 */
	public void setProductCode(String value) {
		this.productCode = value;
	}
	
	/**
	 * 产品编号 bas_product中product_code
	 */
	public String getProductCode() {
		return productCode;
	}
	
	/**
	 * 客户编号 bas_customer中customer_code
	 */
	public void setCustomerCode(String value) {
		this.customerCode = value;
	}
	
	/**
	 * 客户编号 bas_customer中customer_code
	 */
	public String getCustomerCode() {
		return customerCode;
	}
	
	/**
	 * 项目集编号 bas_ itemset中itemset_code
	 */
	public void setItemsetCode(String value) {
		this.itemsetCode = value;
	}
	
	/**
	 * 项目集编号 bas_ itemset中itemset_code
	 */
	public String getItemsetCode() {
		return itemsetCode;
	}
	
	/**
	 * 收入类型 代码表：收入类型 
	 */
	public void setIncomeType(int value) {
		setIncomeType(new Integer(value));
	}
	
	/**
	 * 收入类型 代码表：收入类型 
	 */
	public void setIncomeType(Integer value) {
		this.incomeType = value;
	}
	
	/**
	 * 收入类型 代码表：收入类型 
	 */
	public Integer getIncomeType() {
		return incomeType;
	}
	
	/**
	 * 金额 
	 */
	public void setAmount(String value) {
		this.amount = value;
	}
	
	/**
	 * 金额 
	 */
	public String getAmount() {
		return amount;
	}
	
	/**
	 * 日期 
	 */
	public void setDate(java.sql.Timestamp value) {
		this.date = value;
	}
	
	/**
	 * 日期 
	 */
	public java.sql.Timestamp getDate() {
		return date;
	}
	
	/**
	 * 行业 代码表：行业代码表
	 */
	public void setIndustry(int value) {
		setIndustry(new Integer(value));
	}
	
	/**
	 * 行业 代码表：行业代码表
	 */
	public void setIndustry(Integer value) {
		this.industry = value;
	}
	
	/**
	 * 行业 代码表：行业代码表
	 */
	public Integer getIndustry() {
		return industry;
	}
	
	/**
	 * 部门 
	 */
	public void setDepartment(int value) {
		setDepartment(new Integer(value));
	}
	
	/**
	 * 部门 
	 */
	public void setDepartment(Integer value) {
		this.department = value;
	}
	
	/**
	 * 部门 
	 */
	public Integer getDepartment() {
		return department;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
