package com.zq.entity.basic.capex;
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
 * CAPEX自主资金池
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="bas_capex_amount_pool")
public class BasCAPEXAmountPool implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月11日 下午4:13:18 
	*/
	private static final long serialVersionUID = -5240322963614638075L;

	public BasCAPEXAmountPool() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BAS_CAPEX_AMOUNT_POOL_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BAS_CAPEX_AMOUNT_POOL_ID_GENERATOR", strategy="native")	
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
	
	@Column(name="year", nullable=true, length=50)	
	private String year;
	
	@Column(name="initial_amount", nullable=true, length=50)	
	private String initialAmount;
	
	@Column(name="preoccupy_amount", nullable=true, length=50)	
	private String preoccupyAmount;
	
	@Column(name="now_invest_amount", nullable=true, length=50)	
	private String nowinvestAmount;
	
	/**
	 * id
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
	 * 年份
	 */
	public void setYear(String value) {
		this.year = value;
	}
	
	/**
	 * 年份
	 */
	public String getYear() {
		return year;
	}
	
	/**
	 * 初始金额
	 */
	public void setInitialAmount(String value) {
		this.initialAmount = value;
	}
	
	/**
	 * 初始金额
	 */
	public String getInitialAmount() {
		return initialAmount;
	}
	
	/**
	 * 预占金额
	 */
	public void setPreoccupyAmount(String value) {
		this.preoccupyAmount = value;
	}
	
	/**
	 * 预占金额
	 */
	public String getPreoccupyAmount() {
		return preoccupyAmount;
	}
	
	/**
	 * 目前可用投资金额
	 */
	public void setNowinvestAmount(String value) {
		this.nowinvestAmount = value;
	}
	
	/**
	 * 目前可用投资金额
	 */
	public String getNowinvestAmount() {
		return nowinvestAmount;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
