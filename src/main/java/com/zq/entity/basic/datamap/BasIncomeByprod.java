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
 * 收入按产品分摊
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="bas_income_byprod")
public class BasIncomeByprod implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月16日 下午11:11:46 
	*/
	private static final long serialVersionUID = 3067667532144038346L;

	public BasIncomeByprod() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BASINCOMEBYPROD_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASINCOMEBYPROD_ID_GENERATOR", strategy="native")	
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
	
	@Column(name="customer_code", nullable=true, length=50)	
	private String customerCode;
	
	@Column(name="itemset_code", nullable=true, length=50)	
	private String itemsetCode;
	
	@Column(name="income_type", nullable=true, length=10)	
	private Integer incomeType;
	
	@Column(name="amount", nullable=true, length=50)	
	private String amount;
	
	@Column(name="date", nullable=true)	
	private java.sql.Timestamp date;
	
	@Column(name="industry", nullable=true, length=10)	
	private Integer industry;
	
	@Column(name="department", nullable=true, length=10)	
	private Integer department;
	
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
