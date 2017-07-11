package com.zq.entity.basic;
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
	private Integer company_id;
	
	@Column(name="create_time", nullable=true)	
	private java.sql.Timestamp create_time;
	
	@Column(name="creator", nullable=true, length=50)	
	private String creator;
	
	@Column(name="modify_time", nullable=true)	
	private java.sql.Timestamp modify_time;
	
	@Column(name="last_reviser", nullable=true, length=50)	
	private String last_reviser;
	
	@Column(name="year", nullable=true, length=50)	
	private String year;
	
	@Column(name="initial_amount", nullable=true, length=50)	
	private String initial_amount;
	
	@Column(name="preoccupy_amount", nullable=true, length=50)	
	private String preoccupy_amount;
	
	@Column(name="now_invest_amount", nullable=true, length=50)	
	private String now_invest_amount;
	
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
	public void setCompany_id(int value) {
		setCompany_id(new Integer(value));
	}
	
	/**
	 * 公司ID
	 */
	public void setCompany_id(Integer value) {
		this.company_id = value;
	}
	
	/**
	 * 公司ID
	 */
	public Integer getCompany_id() {
		return company_id;
	}
	
	/**
	 * 创建时间
	 */
	public void setCreate_time(java.sql.Timestamp value) {
		this.create_time = value;
	}
	
	/**
	 * 创建时间
	 */
	public java.sql.Timestamp getCreate_time() {
		return create_time;
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
	public void setModify_time(java.sql.Timestamp value) {
		this.modify_time = value;
	}
	
	/**
	 * 最后修改时间
	 */
	public java.sql.Timestamp getModify_time() {
		return modify_time;
	}
	
	/**
	 * 修改人
	 */
	public void setLast_reviser(String value) {
		this.last_reviser = value;
	}
	
	/**
	 * 修改人
	 */
	public String getLast_reviser() {
		return last_reviser;
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
	public void setInitial_amount(String value) {
		this.initial_amount = value;
	}
	
	/**
	 * 初始金额
	 */
	public String getInitial_amount() {
		return initial_amount;
	}
	
	/**
	 * 预占金额
	 */
	public void setPreoccupy_amount(String value) {
		this.preoccupy_amount = value;
	}
	
	/**
	 * 预占金额
	 */
	public String getPreoccupy_amount() {
		return preoccupy_amount;
	}
	
	/**
	 * 目前可用投资金额
	 */
	public void setNow_invest_amount(String value) {
		this.now_invest_amount = value;
	}
	
	/**
	 * 目前可用投资金额
	 */
	public String getNow_invest_amount() {
		return now_invest_amount;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
