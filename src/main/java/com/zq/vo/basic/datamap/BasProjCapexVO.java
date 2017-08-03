package com.zq.vo.basic.datamap;
/**
 * 产品与CAPEX分摊
 */

public class BasProjCapexVO {
	
	private int id;
	
	private Integer companyId;
	
	private java.sql.Timestamp createTime;
	
	private String creator;
	
	private java.sql.Timestamp modifyTime;
	
	private String lastReviser;
	
	private String productCode;
	
	private String productName;
	
	private String projectCode;
	
	private String projName;
	
	private String allocationRatio;
	
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
	 * 全流程项目编号 bas_capex_project中proj_code
	 */
	public void setProjectCode(String value) {
		this.projectCode = value;
	}
	
	/**
	 * 全流程项目编号 bas_capex_project中proj_code
	 */
	public String getProjectCode() {
		return projectCode;
	}
	
	/**
	 * 分摊比例
	 */
	public void setAllocationRatio(String value) {
		this.allocationRatio = value;
	}
	
	/**
	 * 分摊比例
	 */
	public String getAllocationRatio() {
		return allocationRatio;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}

	/**
	 * 产品名称
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * 产品名称
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * 项目名称
	 */
	public String getProjName() {
		return projName;
	}
	/**
	 * 项目名称
	 */
	public void setProjName(String projName) {
		this.projName = projName;
	}
	
}
