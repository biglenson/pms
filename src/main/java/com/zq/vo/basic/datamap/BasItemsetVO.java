package com.zq.vo.basic.datamap;

/**
 * 项目
 */

public class BasItemsetVO {
	
	private int id;
		
	private Integer companyId;
	
	private java.sql.Timestamp createTime;
	
	private String creator;
	
	private java.sql.Timestamp modifyTime;
	
	private String lastReviser;
	
	private String itemsetCode;
	
	private String itemsetName;
		
	private Integer department;
	
	private Integer itemsetType;
	
	private java.sql.Timestamp startTime;
	
	private java.sql.Timestamp endTime;
	
	private Integer isView;
	
	private String productId;
	
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
	 * 项目集编号 
	 */
	public void setItemsetCode(String value) {
		this.itemsetCode = value;
	}
	
	/**
	 * 项目集编号 
	 */
	public String getItemsetCode() {
		return itemsetCode;
	}
	
	/**
	 * 项目集名称 
	 */
	public void setItemsetName(String value) {
		this.itemsetName = value;
	}
	
	/**
	 * 项目集名称 
	 */
	public String getItemsetName() {
		return itemsetName;
	}
	
	/**
	 * 所属部门 
	 */
	public void setDepartment(int value) {
		setDepartment(new Integer(value));
	}
	
	/**
	 * 所属部门 
	 */
	public void setDepartment(Integer value) {
		this.department = value;
	}
	
	/**
	 * 所属部门 
	 */
	public Integer getDepartment() {
		return department;
	}
	
	/**
	 * 类型 代码表：项目集分类代码表
	 */
	public void setItemsetType(int value) {
		setItemsetType(new Integer(value));
	}
	
	/**
	 * 类型 代码表：项目集分类代码表
	 */
	public void setItemsetType(Integer value) {
		this.itemsetType = value;
	}
	
	/**
	 * 类型 代码表：项目集分类代码表
	 */
	public Integer getItemsetType() {
		return itemsetType;
	}
	
	/**
	 * 预计开始时间 
	 */
	public void setStartTime(java.sql.Timestamp value) {
		this.startTime = value;
	}
	
	/**
	 * 预计开始时间 
	 */
	public java.sql.Timestamp getStartTime() {
		return startTime;
	}
	
	/**
	 * 预计终止时间 
	 */
	public void setEndTime(java.sql.Timestamp value) {
		this.endTime = value;
	}
	
	/**
	 * 预计终止时间 
	 */
	public java.sql.Timestamp getEndTime() {
		return endTime;
	}
	
	/**
	 * 是否在报表中展示 代码表：是否代码表
	 */
	public void setIsView(int value) {
		setIsView(new Integer(value));
	}
	
	/**
	 * 是否在报表中展示 代码表：是否代码表
	 */
	public void setIsView(Integer value) {
		this.isView = value;
	}
	
	/**
	 * 是否在报表中展示 代码表：是否代码表
	 */
	public Integer getIsView() {
		return isView;
	}
	
	/**
	 * 所属产品 bas_product中product_code
	 */
	public void setProductId(String value) {
		this.productId = value;
	}
	
	/**
	 * 所属产品 bas_product中product_code
	 */
	public String getProductId() {
		return productId;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
