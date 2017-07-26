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
 * 项目按类型成本统计
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="sta_proj_coststa_type")
public class StaProjCoststaType implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月21日 上午8:23:57 
	*/
	private static final long serialVersionUID = 796880258651744976L;

	public StaProjCoststaType() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="STAPROJCOSTSTATYPE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="STAPROJCOSTSTATYPE_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="company_id", nullable=true, length=10)	
	private Integer companyId;
	
	@Column(name="year", nullable=true, length=10)	
	private Integer year;
	
	@Column(name="month", nullable=true, length=10)	
	private Integer month;
	
	@Column(name="proj_code", nullable=true, length=10)	
	private Integer projCode;
	
	@Column(name="type_id", nullable=true, length=20)	
	private Integer typeId;
	
	@Column(name="cost", nullable=true, precision=20, scale=3)	
	private java.math.BigDecimal cost;
	
	@Column(name="proj_name", nullable=true, length=255)	
	private String projName;
	
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
	 * 项目ID bas_itemset中itemset_code
	 */
	public void setProjCode(int value) {
		setProjCode(new Integer(value));
	}
	
	/**
	 * 项目ID bas_itemset中itemset_code
	 */
	public void setProjCode(Integer value) {
		this.projCode = value;
	}
	
	/**
	 * 项目ID bas_itemset中itemset_code
	 */
	public Integer getProjCode() {
		return projCode;
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
	 * 成本
	 */
	public void setCost(java.math.BigDecimal value) {
		this.cost = value;
	}
	
	/**
	 * 成本
	 */
	public java.math.BigDecimal getCost() {
		return cost;
	}
	
	/**
	 * 项目名称
	 */
	public void setProjName(String value) {
		this.projName = value;
	}
	
	/**
	 * 项目名称
	 */
	public String getProjName() {
		return projName;
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
