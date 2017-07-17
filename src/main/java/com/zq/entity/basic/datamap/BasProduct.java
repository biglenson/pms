package com.zq.entity.basic.datamap;
/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
import java.io.Serializable;
import javax.persistence.*;
/**
 * 产品
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="bas_product")
public class BasProduct implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月16日 下午11:13:29 
	*/
	private static final long serialVersionUID = 8353431644407878906L;

	public BasProduct() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BASPRODUCT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASPRODUCT_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="company_id", nullable=true, length=10)	
	private Integer companyId;
	
	@Column(name="create_time", nullable=true)	
	private java.sql.Timestamp createTime;
	
	@Column(name="creator", nullable=true, length=50)	
	private String creator;
	
	@Column(name="modify_time", nullable=true)	
	private java.sql.Timestamp modifyTime;
	
	@Column(name="last_reviser", nullable=true, length=50)	
	private String lastReviser;
	
	@Column(name="product_code", nullable=true, length=50)	
	private String productCode;
	
	@Column(name="product_name", nullable=true, length=50)	
	private String productName;
	
	@Column(name="product_type", nullable=true, length=10)	
	private Integer productType;
	
	@Column(name="product_class", nullable=true, length=10)	
	private Integer productClass;
	
	@Column(name="department", nullable=true, length=10)	
	private Integer department;
	
	@Column(name="is_view", nullable=true, length=10)	
	private Integer isView;
	
	@Column(name="expire_time", nullable=true)	
	private java.sql.Timestamp expireTime;
	
	@Column(name="description", nullable=true)	
	private String description;
	
	/**
	 * ID
	 */
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
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
