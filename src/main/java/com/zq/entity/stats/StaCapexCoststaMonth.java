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
 * CAPEX每月成本统计
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="sta_capex_coststa_month")
public class StaCapexCoststaMonth implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月21日 上午8:19:44 
	*/
	private static final long serialVersionUID = -2571022711550444688L;

	public StaCapexCoststaMonth() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="STACAPEXCOSTSTAMONTH_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="STACAPEXCOSTSTAMONTH_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="company_id", nullable=true, length=10)	
	private Integer companyId;
	
	@Column(name="year", nullable=true, length=10)	
	private Integer year;
	
	@Column(name="month", nullable=true, length=10)	
	private Integer month;
	
	@Column(name="proj_id", nullable=true, length=50)	
	private String projId;
	
	@Column(name="cost", nullable=true, precision=20, scale=3)	
	private java.math.BigDecimal cost;
	
	@Column(name="invest_amount", nullable=true, precision=20, scale=3)	
	private java.math.BigDecimal investAmount;
	
	@Column(name="transfer_amount", nullable=true, precision=20, scale=3)	
	private java.math.BigDecimal transferAmount;
	
	@Column(name="proj_name", nullable=true, length=255)	
	private String projName;
	
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
	 * CAPEX项ID bas_capex_project中proj_code
	 */
	public void setProjId(String value) {
		this.projId = value;
	}
	
	/**
	 * CAPEX项ID bas_capex_project中proj_code
	 */
	public String getProjId() {
		return projId;
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
	 * 投资金额
	 */
	public void setInvestAmount(java.math.BigDecimal value) {
		this.investAmount = value;
	}
	
	/**
	 * 投资金额
	 */
	public java.math.BigDecimal getInvestAmount() {
		return investAmount;
	}
	
	/**
	 * 转资金额
	 */
	public void setTransferAmount(java.math.BigDecimal value) {
		this.transferAmount = value;
	}
	
	/**
	 * 转资金额
	 */
	public java.math.BigDecimal getTransferAmount() {
		return transferAmount;
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
