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
 * 项目
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="bas_itemset")
public class BasItemset implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月16日 下午11:13:21 
	*/
	private static final long serialVersionUID = 6761360174894728005L;

	public BasItemset() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BASITEMSET_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASITEMSET_ID_GENERATOR", strategy="native")	
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
	
	@Column(name="itemset_code", nullable=true, length=50)	
	private String itemsetCode;
	
	@Column(name="itemset_name", nullable=true, length=50)	
	private String itemsetName;
	
	@Column(name="department", nullable=true, length=10)	
	private Integer department;
	
	@Column(name="itemset_type", nullable=true, length=10)	
	private Integer itemsetType;
	
	@Column(name="start_time", nullable=true)	
	private java.sql.Timestamp startTime;
	
	@Column(name="end_time", nullable=true)	
	private java.sql.Timestamp endTime;
	
	@Column(name="is_view", nullable=true, length=10)	
	private Integer isView;
	
	@Column(name="product_id", nullable=true, length=50)	
	private String productId;
	
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
