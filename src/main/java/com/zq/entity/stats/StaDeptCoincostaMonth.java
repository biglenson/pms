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
 * 部门每月成本收入统计
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="sta_dept_coincosta_month")
public class StaDeptCoincostaMonth implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月21日 上午8:20:42 
	*/
	private static final long serialVersionUID = 9168315255201008389L;

	public StaDeptCoincostaMonth() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="STADEPTCOINCOSTAMONTH_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="STADEPTCOINCOSTAMONTH_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="company_id", nullable=true, length=10)	
	private Integer companyId;
	
	@Column(name="year", nullable=true, length=10)	
	private Integer year;
	
	@Column(name="month", nullable=true, length=10)	
	private Integer month;
	
	@Column(name="dept_id", nullable=true, length=10)	
	private Integer deptId;
	
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
	
	@Column(name="dept_name", nullable=true, length=255)	
	private String deptName;
	
	@Column(name="seq", nullable=true, length=10)	
	private Integer seq;
	
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
	 * 部门ID
	 */
	public void setDeptId(int value) {
		setDeptId(new Integer(value));
	}
	
	/**
	 * 部门ID
	 */
	public void setDeptId(Integer value) {
		this.deptId = value;
	}
	
	/**
	 * 部门ID
	 */
	public Integer getDeptId() {
		return deptId;
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
	 * 部门名称
	 */
	public void setDeptName(String value) {
		this.deptName = value;
	}
	
	/**
	 * 部门名称
	 */
	public String getDeptName() {
		return deptName;
	}
	
	/**
	 * 序号 同部门序号，用于部门排序
	 */
	public void setSeq(int value) {
		setSeq(new Integer(value));
	}
	
	/**
	 * 序号 同部门序号，用于部门排序
	 */
	public void setSeq(Integer value) {
		this.seq = value;
	}
	
	/**
	 * 序号 同部门序号，用于部门排序
	 */
	public Integer getSeq() {
		return seq;
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
