package com.zq.vo.basic.datamap;

/**
 * 收入目标-按产品
 */

public class BasIncometargByprodVO{
	
	private int id;
	
	private Integer companyId;
	
	private java.sql.Timestamp createTime;
		
	private String creator;
		
	private java.sql.Timestamp modifyTime;
		
	private String lastReviser;
	
	private String year;
	
	private String productCode;
	
	private String annualGoal;
	
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
	 * 年度
	 */
	public void setYear(String value) {
		this.year = value;
	}
	
	/**
	 * 年度
	 */
	public String getYear() {
		return year;
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
	 * 全年目标
	 */
	public void setAnnualGoal(String value) {
		this.annualGoal = value;
	}
	
	/**
	 * 全年目标
	 */
	public String getAnnualGoal() {
		return annualGoal;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
