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
	private Integer company_id;
	
	@Column(name="create_time", nullable=true)	
	private java.sql.Timestamp create_time;
	
	@Column(name="create_by", nullable=true, length=50)	
	private String create_by;
	
	@Column(name="last_update_time", nullable=true)	
	private java.sql.Timestamp last_update_time;
	
	@Column(name="last_update_by", nullable=true, length=50)	
	private String last_update_by;
	
	@Column(name="opex_proj_code", nullable=true, length=50)	
	private String opex_proj_code;
	
	@Column(name="junior_man_day", nullable=true, length=50)	
	private String junior_man_day;
	
	@Column(name="`middle _man_day`", nullable=true, length=50)	
	private String middle__man_day;
	
	@Column(name="senior_man_day", nullable=true, length=50)	
	private String senior_man_day;
	
	@Column(name="service_times", nullable=true, length=50)	
	private String service_times;
	
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
	public void setCreate_by(String value) {
		this.create_by = value;
	}
	
	/**
	 * 创建人
	 */
	public String getCreate_by() {
		return create_by;
	}
	
	/**
	 * 最后修改时间
	 */
	public void setLast_update_time(java.sql.Timestamp value) {
		this.last_update_time = value;
	}
	
	/**
	 * 最后修改时间
	 */
	public java.sql.Timestamp getLast_update_time() {
		return last_update_time;
	}
	
	/**
	 * 修改人
	 */
	public void setLast_update_by(String value) {
		this.last_update_by = value;
	}
	
	/**
	 * 修改人
	 */
	public String getLast_update_by() {
		return last_update_by;
	}
	
	/**
	 * OPEX项目编号 bas_opex_project中budget_sysproj_code
	 */
	public void setOpex_proj_code(String value) {
		this.opex_proj_code = value;
	}
	
	/**
	 * OPEX项目编号 bas_opex_project中budget_sysproj_code
	 */
	public String getOpex_proj_code() {
		return opex_proj_code;
	}
	
	/**
	 * 初级（人天） 
	 */
	public void setJunior_man_day(String value) {
		this.junior_man_day = value;
	}
	
	/**
	 * 初级（人天） 
	 */
	public String getJunior_man_day() {
		return junior_man_day;
	}
	
	/**
	 * 中级（人天） 
	 */
	public void setMiddle__man_day(String value) {
		this.middle__man_day = value;
	}
	
	/**
	 * 中级（人天） 
	 */
	public String getMiddle__man_day() {
		return middle__man_day;
	}
	
	/**
	 * 高级（人天） 
	 */
	public void setSenior_man_day(String value) {
		this.senior_man_day = value;
	}
	
	/**
	 * 高级（人天） 
	 */
	public String getSenior_man_day() {
		return senior_man_day;
	}
	
	/**
	 * 服务（次） 
	 */
	public void setService_times(String value) {
		this.service_times = value;
	}
	
	/**
	 * 服务（次） 
	 */
	public String getService_times() {
		return service_times;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
