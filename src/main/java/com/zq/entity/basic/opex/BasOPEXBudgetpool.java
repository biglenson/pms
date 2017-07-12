package com.zq.entity.basic.opex;
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
 * OPEX动态预算池
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="bas_opex_budgetpool")
public class BasOPEXBudgetpool implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月12日 上午9:49:13 
	*/
	private static final long serialVersionUID = 143225893113045376L;

	public BasOPEXBudgetpool() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BAS_OPEX_BUDGETPOOL_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BAS_OPEX_BUDGETPOOL_ID_GENERATOR", strategy="native")	
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
	
	@Column(name="dynabudpl_init_amount", nullable=true, length=50)	
	private String dynabudpl_init_amount;
	
	@Column(name="`avail_dynabudpl_ amount`", nullable=true, length=50)	
	private String avail_dynabudpl__amount;
	
	@Column(name="year", nullable=true, length=50)	
	private String year;
	
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
	 * 动态预算池初始金额（元）
	 */
	public void setDynabudpl_init_amount(String value) {
		this.dynabudpl_init_amount = value;
	}
	
	/**
	 * 动态预算池初始金额（元）
	 */
	public String getDynabudpl_init_amount() {
		return dynabudpl_init_amount;
	}
	
	/**
	 * 可用动态预算池总金额（元）
	 */
	public void setAvail_dynabudpl__amount(String value) {
		this.avail_dynabudpl__amount = value;
	}
	
	/**
	 * 可用动态预算池总金额（元）
	 */
	public String getAvail_dynabudpl__amount() {
		return avail_dynabudpl__amount;
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
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
