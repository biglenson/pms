package com.zq.entity.stats;
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
 * 产品按类型收入统计
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="sta_prod_incomesta_type")
public class StaProdIncomestaType implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月21日 上午8:23:31 
	*/
	private static final long serialVersionUID = 3770651247576434536L;

	public StaProdIncomestaType() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="STAPRODINCOMESTATYPE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="STAPRODINCOMESTATYPE_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="company_id", nullable=true, length=10)	
	private Integer companyId;
	
	@Column(name="year", nullable=true, length=10)	
	private Integer year;
	
	@Column(name="month", nullable=true, length=10)	
	private Integer month;
	
	@Column(name="prod_id", nullable=true, length=10)	
	private Integer prodId;
	
	@Column(name="type_id", nullable=true, length=20)	
	private Integer typeId;
	
	@Column(name="income", nullable=true, precision=20, scale=3)	
	private java.math.BigDecimal income;
	
	@Column(name="prod_name", nullable=true, length=255)	
	private String prodName;
	
	@Column(name="type_name", nullable=true, length=255)	
	private String typeName;
	
	@Column(name="modify_time", nullable=true)	
	private java.sql.Timestamp modifyTime;
	
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
	 * 年
	 */
	public void setYear(int value) {
		setYear(new Integer(value));
	}
	
	/**
	 * 年
	 */
	public void setYear(Integer value) {
		this.year = value;
	}
	
	/**
	 * 年
	 */
	public Integer getYear() {
		return year;
	}
	
	/**
	 * 月
	 */
	public void setMonth(int value) {
		setMonth(new Integer(value));
	}
	
	/**
	 * 月
	 */
	public void setMonth(Integer value) {
		this.month = value;
	}
	
	/**
	 * 月
	 */
	public Integer getMonth() {
		return month;
	}
	
	/**
	 * 产品ID bas_product中product_code
	 */
	public void setProdId(int value) {
		setProdId(new Integer(value));
	}
	
	/**
	 * 产品ID bas_product中product_code
	 */
	public void setProdId(Integer value) {
		this.prodId = value;
	}
	
	/**
	 * 产品ID bas_product中product_code
	 */
	public Integer getProdId() {
		return prodId;
	}
	
	/**
	 * 类型ID 代码表：成本类别二级代码表
	 */
	public void setTypeId(int value) {
		setTypeId(new Integer(value));
	}
	
	/**
	 * 类型ID 代码表：成本类别二级代码表
	 */
	public void setTypeId(Integer value) {
		this.typeId = value;
	}
	
	/**
	 * 类型ID 代码表：成本类别二级代码表
	 */
	public Integer getTypeId() {
		return typeId;
	}
	
	/**
	 * 收入
	 */
	public void setIncome(java.math.BigDecimal value) {
		this.income = value;
	}
	
	/**
	 * 收入
	 */
	public java.math.BigDecimal getIncome() {
		return income;
	}
	
	/**
	 * 产品名称
	 */
	public void setProdName(String value) {
		this.prodName = value;
	}
	
	/**
	 * 产品名称
	 */
	public String getProdName() {
		return prodName;
	}
	
	/**
	 * 类型名称
	 */
	public void setTypeName(String value) {
		this.typeName = value;
	}
	
	/**
	 * 类型名称
	 */
	public String getTypeName() {
		return typeName;
	}
	
	/**
	 * 最后更新时间
	 */
	public void setModifyTime(java.sql.Timestamp value) {
		this.modifyTime = value;
	}
	
	/**
	 * 最后更新时间
	 */
	public java.sql.Timestamp getModifyTime() {
		return modifyTime;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
