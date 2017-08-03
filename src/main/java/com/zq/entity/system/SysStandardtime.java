package com.zq.entity.system;

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
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="sys_standardtime")
public class SysStandardtime implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年8月3日 下午4:28:00 
	*/
	private static final long serialVersionUID = -2346265268133109527L;

	public SysStandardtime() {
	}
	
	@Column(name="id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="SYS_STANDARDTIME_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="SYS_STANDARDTIME_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="company_id", nullable=true, length=11)	
	private Integer companyId;
	
	@Column(name="create_time", nullable=true)	
	private java.sql.Timestamp createTime;
	
	@Column(name="creator", nullable=true, length=50)	
	private String creator;
	
	@Column(name="modify_time", nullable=true)	
	private java.sql.Timestamp modifyTime;
	
	@Column(name="last_reviser", nullable=true, length=50)	
	private String lastReviser;
	
	@Column(name="code", nullable=true, length=50)	
	private String code;
	
	@Column(name="category", nullable=true, length=11)	
	private Integer category;
	
	@Column(name="status", nullable=true, length=11)	
	private Integer status;
	
	@Column(name="comfirm_level", nullable=true, length=20)	
	private Integer comfirmLevel;
	
	@Column(name="purchasing_type", nullable=true, length=20)	
	private Integer purchasingType;
	
	@Column(name="purchasing_method", nullable=true, length=20)	
	private Integer purchasingMethod;
	
	@Column(name="standard_startup_timit", nullable=true, length=20)	
	private String standardStartupTimit;
	
	@Column(name="standard_completion_timit", nullable=true, length=20)	
	private String standardCompletionTimit;
	
	private void setId(int value) {
		this.id = value;
	}
	
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
	 * 修改时间
	 */
	public void setModifyTime(java.sql.Timestamp value) {
		this.modifyTime = value;
	}
	
	/**
	 * 修改时间
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
	
	public void setCode(String value) {
		this.code = value;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCategory(int value) {
		setCategory(new Integer(value));
	}
	
	public void setCategory(Integer value) {
		this.category = value;
	}
	
	public Integer getCategory() {
		return category;
	}
	
	/**
	 * 状态
	 */
	public void setStatus(int value) {
		setStatus(new Integer(value));
	}
	
	/**
	 * 状态
	 */
	public void setStatus(Integer value) {
		this.status = value;
	}
	
	/**
	 * 状态
	 */
	public Integer getStatus() {
		return status;
	}
	
	/**
	 * 决策层级 代码表：决策层级代码表
	 */
	public void setComfirmLevel(int value) {
		setComfirmLevel(new Integer(value));
	}
	
	/**
	 * 决策层级 代码表：决策层级代码表
	 */
	public void setComfirmLevel(Integer value) {
		this.comfirmLevel = value;
	}
	
	/**
	 * 决策层级 代码表：决策层级代码表
	 */
	public Integer getComfirmLevel() {
		return comfirmLevel;
	}
	
	/**
	 * 采购类型 代码表：采购类型代码表
	 */
	public void setPurchasingType(int value) {
		setPurchasingType(new Integer(value));
	}
	
	/**
	 * 采购类型 代码表：采购类型代码表
	 */
	public void setPurchasingType(Integer value) {
		this.purchasingType = value;
	}
	
	/**
	 * 采购类型 代码表：采购类型代码表
	 */
	public Integer getPurchasingType() {
		return purchasingType;
	}
	
	/**
	 * 采购方式 代码表：集采采购方式代码表
	 */
	public void setPurchasingMethod(int value) {
		setPurchasingMethod(new Integer(value));
	}
	
	/**
	 * 采购方式 代码表：集采采购方式代码表
	 */
	public void setPurchasingMethod(Integer value) {
		this.purchasingMethod = value;
	}
	
	/**
	 * 采购方式 代码表：集采采购方式代码表
	 */
	public Integer getPurchasingMethod() {
		return purchasingMethod;
	}
	
	/**
	 * 标准启动时限(天)
	 */
	public void setStandardStartupTimit(String value) {
		this.standardStartupTimit = value;
	}
	
	/**
	 * 标准启动时限(天)
	 */
	public String getStandardStartupTimit() {
		return standardStartupTimit;
	}
	
	/**
	 * 标准完成时限(天)
	 */
	public void setStandardCompletionTimit(String value) {
		this.standardCompletionTimit = value;
	}
	
	/**
	 * 标准完成时限(天)
	 */
	public String getStandardCompletionTimit() {
		return standardCompletionTimit;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
