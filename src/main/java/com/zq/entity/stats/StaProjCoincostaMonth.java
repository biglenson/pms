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
 * 项目每月成本收入统计
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="sta_proj_coincosta_month")
public class StaProjCoincostaMonth implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月21日 上午8:23:42 
	*/
	private static final long serialVersionUID = -7989325885392389919L;

	public StaProjCoincostaMonth() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="STAPROJCOINCOSTAMONTH_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="STAPROJCOINCOSTAMONTH_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="company_id", nullable=true, length=10)	
	private Integer companyId;
	
	@Column(name="year", nullable=true, length=10)	
	private Integer year;
	
	@Column(name="month", nullable=true, length=10)	
	private Integer month;
	
	@Column(name="proj_code", nullable=true, length=10)	
	private Integer projCode;
	
	@Column(name="opexcost", nullable=true, precision=20, scale=3)	
	private java.math.BigDecimal opexcost;
	
	@Column(name="capexcost", nullable=true, precision=20, scale=3)	
	private java.math.BigDecimal capexcost;
	
	@Column(name="invest_amount", nullable=true, precision=20, scale=3)	
	private java.math.BigDecimal investAmount;
	
	@Column(name="transfer_amount", nullable=true, precision=20, scale=3)	
	private java.math.BigDecimal transferAmount;
	
	@Column(name="income", nullable=true, precision=20, scale=3)	
	private java.math.BigDecimal income;
	
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
	 * OPEX成本
	 */
	public void setOpexcost(java.math.BigDecimal value) {
		this.opexcost = value;
	}
	
	/**
	 * OPEX成本
	 */
	public java.math.BigDecimal getOpexcost() {
		return opexcost;
	}
	
	/**
	 * CAPEX成本 CAPEX折旧
	 */
	public void setCapexcost(java.math.BigDecimal value) {
		this.capexcost = value;
	}
	
	/**
	 * CAPEX成本 CAPEX折旧
	 */
	public java.math.BigDecimal getCapexcost() {
		return capexcost;
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
