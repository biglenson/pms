package com.zq.entity.basic.datamap;
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
 * 收入目标-按部门
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="bas_incometarg_bydept")
public class BasIncometargBydept implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月16日 下午11:12:02 
	*/
	private static final long serialVersionUID = 1L;

	public BasIncometargBydept() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BASINCOMETARGBYDEPT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASINCOMETARGBYDEPT_ID_GENERATOR", strategy="native")	
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
	
	@Column(name="dept_code", nullable=true, length=10)	
	private Integer deptCode;
	
	@Column(name="annual_goal", nullable=true, length=50)	
	private String annualGoal;
	
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
	public void setYear(String value) {
		this.year = value;
	}
	
	/**
	 * 年度
	 */
	public String getYear() {
		return year;
	}
	
	/**
	 * 部门编号
	 */
	public void setDeptCode(int value) {
		setDeptCode(new Integer(value));
	}
	
	/**
	 * 部门编号
	 */
	public void setDeptCode(Integer value) {
		this.deptCode = value;
	}
	
	/**
	 * 部门编号
	 */
	public Integer getDeptCode() {
		return deptCode;
	}
	
	/**
	 * 全年目标
	 */
	public void setAnnualGoal(String value) {
		this.annualGoal = value;
	}
	
	/**
	 * 全年目标
	 */
	public String getAnnualGoal() {
		return annualGoal;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
