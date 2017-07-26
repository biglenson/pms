package com.zq.vo.basic.datamap;

/**
 * 项目与产品客户关系
 */

public class BasItemProdCustVO {
	
	private int id;
		
	private Integer companyId;
	
	private java.sql.Timestamp createTime;
	
	private String creator;
	
	private java.sql.Timestamp modifyTime;
		
	private String lastReviser;
	
	private String itemsetCode;
	
	private String customerCode;
	
	private String productCode;
	
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
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
