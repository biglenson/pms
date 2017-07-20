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
 * OPEX工时管理
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="bas_opex_manhour")
public class BasOPEXManhour implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月12日 上午9:49:33 
	*/
	private static final long serialVersionUID = -2697550875297611913L;

	public BasOPEXManhour() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BAS_OPEX_MANHOUR_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BAS_OPEX_MANHOUR_ID_GENERATOR", strategy="native")	
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
	
	@Column(name="opex_proj_code", nullable=true, length=50)	
	private String opexProjCode;
	
	@Column(name="junior_man_day", nullable=true, length=50)	
	private String juniorManDay;
	
	@Column(name="middle_man_day", nullable=true, length=50)	
	private String middleManDay;
	
	@Column(name="senior_man_day", nullable=true, length=50)	
	private String seniorManDay;
	
	@Column(name="service_times", nullable=true, length=50)	
	private String serviceTimes;
	
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
	public void setCreateBy(String value) {
		this.creator = value;
	}
	
	/**
	 * 创建人
	 */
	public String getCreateBy() {
		return creator;
	}
	
	/**
	 * 最后修改时间
	 */
	public void setLastUpdateTime(java.sql.Timestamp value) {
		this.modifyTime = value;
	}
	
	/**
	 * 最后修改时间
	 */
	public java.sql.Timestamp getLastUpdateTime() {
		return modifyTime;
	}
	
	/**
	 * 修改人
	 */
	public void setLastUpdateBy(String value) {
		this.lastReviser = value;
	}
	
	/**
	 * 修改人
	 */
	public String getLastUpdateBy() {
		return lastReviser;
	}
	
	/**
	 * OPEX项目编号 bas_opex_project中budget_sysproj_code
	 */
	public void setOpexProjCode(String value) {
		this.opexProjCode = value;
	}
	
	/**
	 * OPEX项目编号 bas_opex_project中budget_sysproj_code
	 */
	public String getOpexProjCode() {
		return opexProjCode;
	}
	
	/**
	 * 初级（人天） 
	 */
	public void setJuniorManDay(String value) {
		this.juniorManDay = value;
	}
	
	/**
	 * 初级（人天） 
	 */
	public String getJuniorManDay() {
		return juniorManDay;
	}
	
	/**
	 * 中级（人天） 
	 */
	public void setMiddleManDay(String value) {
		this.middleManDay = value;
	}
	
	/**
	 * 中级（人天） 
	 */
	public String getMiddleManDay() {
		return middleManDay;
	}
	
	/**
	 * 高级（人天） 
	 */
	public void setSeniorManDay(String value) {
		this.seniorManDay = value;
	}
	
	/**
	 * 高级（人天） 
	 */
	public String getSeniorManDay() {
		return seniorManDay;
	}
	
	/**
	 * 服务（次） 
	 */
	public void setServiceTimes(String value) {
		this.serviceTimes = value;
	}
	
	/**
	 * 服务（次） 
	 */
	public String getServiceTimes() {
		return serviceTimes;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
