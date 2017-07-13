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
 * 投资计划总额信息管理
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="bas_capex_total_investplan")
public class BasCAPEXTotalInvestplan implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月11日 下午4:16:08 
	*/
	private static final long serialVersionUID = 9012239417501473241L;

	public BasCAPEXTotalInvestplan() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BAS_CAPEX_TOTAL_INVESTPLAN_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BAS_CAPEX_TOTAL_INVESTPLAN_ID_GENERATOR", strategy="native")	
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
	
	@Column(name="annual", nullable=true, length=10)	
	private Integer annual;
	
	@Column(name="version", nullable=true, length=10)	
	private Integer version;
	
	@Column(name="annual_capex_plan", nullable=true, length=50)	
	private String annualCapexPlan;
	
	@Column(name="annual_transfer_plan", nullable=true, length=50)	
	private String annualTransferPlan;
	
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
	 * 年度
	 */
	public void setAnnual(int value) {
		setAnnual(new Integer(value));
	}
	
	/**
	 * 年度
	 */
	public void setAnnual(Integer value) {
		this.annual = value;
	}
	
	/**
	 * 年度
	 */
	public Integer getAnnual() {
		return annual;
	}
	
	/**
	 * 版本 1-年初；2-年
	 */
	public void setVersion(int value) {
		setVersion(new Integer(value));
	}
	
	/**
	 * 版本 1-年初；2-年
	 */
	public void setVersion(Integer value) {
		this.version = value;
	}
	
	/**
	 * 版本 1-年初；2-年
	 */
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 年度资本开支计划
	 */
	public void setAnnualCapexPlan(String value) {
		this.annualCapexPlan = value;
	}
	
	/**
	 * 年度资本开支计划
	 */
	public String getAnnualCapexPlan() {
		return annualCapexPlan;
	}
	
	/**
	 * 年度转资额计划
	 */
	public void setAnnualTransferPlan(String value) {
		this.annualTransferPlan = value;
	}
	
	/**
	 * 年度转资额计划
	 */
	public String getAnnualTransferPlan() {
		return annualTransferPlan;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
