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
 * OPEX每月成本统计
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="sta_opex_coststa_month")
public class StaOpexCoststaMonth implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月21日 上午8:22:40 
	*/
	private static final long serialVersionUID = 3771576094297030160L;

	public StaOpexCoststaMonth() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="STAOPEXCOSTSTAMONTH_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="STAOPEXCOSTSTAMONTH_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="company_id", nullable=true, length=10)	
	private Integer companyId;
	
	@Column(name="year", nullable=true, length=10)	
	private Integer year;
	
	@Column(name="month", nullable=true, length=10)	
	private Integer month;
	
	@Column(name="opex_id", nullable=true, length=10)	
	private Integer opexId;
	
	@Column(name="cost", nullable=true, precision=20, scale=3)	
	private java.math.BigDecimal cost;
	
	@Column(name="opex_name", nullable=true, length=255)	
	private String opexName;
	
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
	 * OPEX项ID bas_opex_project中budsys_proj_code
	 */
	public void setOpexId(int value) {
		setOpexId(new Integer(value));
	}
	
	/**
	 * OPEX项ID bas_opex_project中budsys_proj_code
	 */
	public void setOpexId(Integer value) {
		this.opexId = value;
	}
	
	/**
	 * OPEX项ID bas_opex_project中budsys_proj_code
	 */
	public Integer getOpexId() {
		return opexId;
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
	 * OPEX项名称
	 */
	public void setOpexName(String value) {
		this.opexName = value;
	}
	
	/**
	 * OPEX项名称
	 */
	public String getOpexName() {
		return opexName;
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
