package com.zq.vo.basic.datamap;

/**
 * 产品
 */

public class BasProductVO {
	
	private int id;
		
	private Integer companyId;
	
	private java.sql.Timestamp createTime;
	
	private String creator;
	
	private java.sql.Timestamp modifyTime;
	
	private String lastReviser;
	
	private String productCode;
	
	private String productName;
	
	private Integer productType;
	
	private Integer productClass;
	
	private Integer department;
	
	private Integer isView;
	
	private java.sql.Timestamp expireTime;
	
	private String description;
	
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
	 * 产品编号 
	 */
	public void setProductCode(String value) {
		this.productCode = value;
	}
	
	/**
	 * 产品编号 
	 */
	public String getProductCode() {
		return productCode;
	}
	
	/**
	 * 产品名称 
	 */
	public void setProductName(String value) {
		this.productName = value;
	}
	
	/**
	 * 产品名称 
	 */
	public String getProductName() {
		return productName;
	}
	
	/**
	 * 类型 代码表：产品类型
	 */
	public void setProductType(int value) {
		setProductType(new Integer(value));
	}
	
	/**
	 * 类型 代码表：产品类型
	 */
	public void setProductType(Integer value) {
		this.productType = value;
	}
	
	/**
	 * 类型 代码表：产品类型
	 */
	public Integer getProductType() {
		return productType;
	}
	
	/**
	 * 分类 代码表：产品分类代码表
	 */
	public void setProductClass(int value) {
		setProductClass(new Integer(value));
	}
	
	/**
	 * 分类 代码表：产品分类代码表
	 */
	public void setProductClass(Integer value) {
		this.productClass = value;
	}
	
	/**
	 * 分类 代码表：产品分类代码表
	 */
	public Integer getProductClass() {
		return productClass;
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
	 * 是否在报表显示 代码表：是否代码表
	 */
	public void setIsView(int value) {
		setIsView(new Integer(value));
	}
	
	/**
	 * 是否在报表显示 代码表：是否代码表
	 */
	public void setIsView(Integer value) {
		this.isView = value;
	}
	
	/**
	 * 是否在报表显示 代码表：是否代码表
	 */
	public Integer getIsView() {
		return isView;
	}
	
	/**
	 * 失效时间 
	 */
	public void setExpireTime(java.sql.Timestamp value) {
		this.expireTime = value;
	}
	
	/**
	 * 失效时间 
	 */
	public java.sql.Timestamp getExpireTime() {
		return expireTime;
	}
	
	/**
	 * 描述 
	 */
	public void setDescription(String value) {
		this.description = value;
	}
	
	/**
	 * 描述 
	 */
	public String getDescription() {
		return description;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
