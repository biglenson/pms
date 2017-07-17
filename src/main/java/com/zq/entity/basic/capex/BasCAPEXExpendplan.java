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
 * CAPEX资本开支计划
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="bas_capex_expendplan")
public class BasCAPEXExpendplan implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月11日 下午4:13:50 
	*/
	private static final long serialVersionUID = -5504474080513082819L;

	public BasCAPEXExpendplan() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BAS_CAPEX_EXPENDPLAN_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BAS_CAPEX_EXPENDPLAN_ID_GENERATOR", strategy="native")	
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
	
	@Column(name="proj_code", nullable=true, length=255)	
	private String projCode;
	
	@Column(name="current_capex_amount", nullable=true, length=50)	
	private String currentCapexAmount;
	
	@Column(name="total_capex_amount", nullable=true, length=50)	
	private String totalCapexAmount;
	
	@Column(name="year", nullable=true, length=50)	
	private String year;
	
	@Column(name="jan_plan", nullable=true, length=50)	
	private String janPlan;
	
	@Column(name="feb_plan", nullable=true, length=50)	
	private String febPlan;
	
	@Column(name="mar_plan", nullable=true, length=50)	
	private String marPlan;
	
	@Column(name="apr_plan", nullable=true, length=50)	
	private String aprPlan;
	
	@Column(name="may_plan", nullable=true, length=50)	
	private String mayPlan;
	
	@Column(name="jun_plan", nullable=true, length=50)	
	private String junPlan;
	
	@Column(name="jul_plan", nullable=true, length=50)	
	private String julPlan;
	
	@Column(name="aug_plan", nullable=true, length=50)	
	private String augPlan;
	
	@Column(name="sep_plan", nullable=true, length=50)	
	private String sepPlan;
	
	@Column(name="oct_plan", nullable=true, length=50)	
	private String octPlan;
	
	@Column(name="nov_plan", nullable=true, length=50)	
	private String novPlan;
	
	@Column(name="dec_plan", nullable=true, length=50)	
	private String decPlan;
	
	@Column(name="jan_actual", nullable=true, length=50)	
	private String janActual;
	
	@Column(name="feb_actual", nullable=true, length=50)	
	private String febActual;
	
	@Column(name="mar_actual", nullable=true, length=50)	
	private String marActual;
	
	@Column(name="apr_actual", nullable=true, length=50)	
	private String aprActual;
	
	@Column(name="may_actual", nullable=true, length=50)	
	private String mayActual;
	
	@Column(name="jun_actual", nullable=true, length=50)	
	private String junActual;
	
	@Column(name="jul_actual", nullable=true, length=50)	
	private String julActual;
	
	@Column(name="aug_actual", nullable=true, length=50)	
	private String augActual;
	
	@Column(name="sep_actual", nullable=true, length=50)	
	private String sepActual;
	
	@Column(name="oct_actual", nullable=true, length=50)	
	private String octActual;
	
	@Column(name="nov_actual", nullable=true, length=50)	
	private String novActual;
	
	@Column(name="dec_actual", nullable=true, length=50)	
	private String decActual;
	
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
	 * 项目编码
	 */
	public String getProjCode() {
		return projCode;
	}

	public void setProjCode(String projCode) {
		this.projCode = projCode;
	}
	
	/**
	 * 当年资本开支完成金额（元） 
	 */
	public void setCurrentCapexAmount(String value) {
		this.currentCapexAmount = value;
	}
	
	/**
	 * 当年资本开支完成金额（元） 
	 */
	public String getCurrentCapexAmount() {
		return currentCapexAmount;
	}
	
	/**
	 * 累计资本开支完成金额（元） 
	 */
	public void setTotalCapexAmount(String value) {
		this.totalCapexAmount = value;
	}
	
	/**
	 * 累计资本开支完成金额（元） 
	 */
	public String getTotalCapexAmount() {
		return totalCapexAmount;
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
	 * 1月计划（元） 
	 */
	public void setJanPlan(String value) {
		this.janPlan = value;
	}
	
	/**
	 * 1月计划（元） 
	 */
	public String getJanPlan() {
		return janPlan;
	}
	
	/**
	 * 2月计划（元） 
	 */
	public void setFebPlan(String value) {
		this.febPlan = value;
	}
	
	/**
	 * 2月计划（元） 
	 */
	public String getFebPlan() {
		return febPlan;
	}
	
	/**
	 * 3月计划（元） 
	 */
	public void setMarPlan(String value) {
		this.marPlan = value;
	}
	
	/**
	 * 3月计划（元） 
	 */
	public String getMarPlan() {
		return marPlan;
	}
	
	/**
	 * 4月计划（元） 
	 */
	public void setAprPlan(String value) {
		this.aprPlan = value;
	}
	
	/**
	 * 4月计划（元） 
	 */
	public String getAprPlan() {
		return aprPlan;
	}
	
	/**
	 * 5月计划（元） 
	 */
	public void setMayPlan(String value) {
		this.mayPlan = value;
	}
	
	/**
	 * 5月计划（元） 
	 */
	public String getMayPlan() {
		return mayPlan;
	}
	
	/**
	 * 6月计划（元） 
	 */
	public void setJunPlan(String value) {
		this.junPlan = value;
	}
	
	/**
	 * 6月计划（元） 
	 */
	public String getJunPlan() {
		return junPlan;
	}
	
	/**
	 * 7月计划（元） 
	 */
	public void setJulPlan(String value) {
		this.julPlan = value;
	}
	
	/**
	 * 7月计划（元） 
	 */
	public String getJulPlan() {
		return julPlan;
	}
	
	/**
	 * 8月计划（元） 
	 */
	public void setAugPlan(String value) {
		this.augPlan = value;
	}
	
	/**
	 * 8月计划（元） 
	 */
	public String getAugPlan() {
		return augPlan;
	}
	
	/**
	 * 9月计划（元） 
	 */
	public void setSepPlan(String value) {
		this.sepPlan = value;
	}
	
	/**
	 * 9月计划（元） 
	 */
	public String getSepPlan() {
		return sepPlan;
	}
	
	/**
	 * 10月计划（元） 
	 */
	public void setOctPlan(String value) {
		this.octPlan = value;
	}
	
	/**
	 * 10月计划（元） 
	 */
	public String getOctPlan() {
		return octPlan;
	}
	
	/**
	 * 11月计划（元） 
	 */
	public void setNovPlan(String value) {
		this.novPlan = value;
	}
	
	/**
	 * 11月计划（元） 
	 */
	public String getNovPlan() {
		return novPlan;
	}
	
	/**
	 * 12月计划（元） 
	 */
	public void setDecPlan(String value) {
		this.decPlan = value;
	}
	
	/**
	 * 12月计划（元） 
	 */
	public String getDecPlan() {
		return decPlan;
	}
	
	/**
	 * 1月实际（元） 
	 */
	public void setJanActual(String value) {
		this.janActual = value;
	}
	
	/**
	 * 1月实际（元） 
	 */
	public String getJanActual() {
		return janActual;
	}
	
	/**
	 * 2月实际（元） 
	 */
	public void setFebActual(String value) {
		this.febActual = value;
	}
	
	/**
	 * 2月实际（元） 
	 */
	public String getFebActual() {
		return febActual;
	}
	
	/**
	 * 3月实际（元） 
	 */
	public void setMarActual(String value) {
		this.marActual = value;
	}
	
	/**
	 * 3月实际（元） 
	 */
	public String getMarActual() {
		return marActual;
	}
	
	/**
	 * 4月实际（元） 
	 */
	public void setAprActual(String value) {
		this.aprActual = value;
	}
	
	/**
	 * 4月实际（元） 
	 */
	public String getAprActual() {
		return aprActual;
	}
	
	/**
	 * 5月实际（元） 
	 */
	public void setMayActual(String value) {
		this.mayActual = value;
	}
	
	/**
	 * 5月实际（元） 
	 */
	public String getMayActual() {
		return mayActual;
	}
	
	/**
	 * 6月实际（元） 
	 */
	public void setJunActual(String value) {
		this.junActual = value;
	}
	
	/**
	 * 6月实际（元） 
	 */
	public String getJunActual() {
		return junActual;
	}
	
	/**
	 * 7月实际（元） 
	 */
	public void setJulActual(String value) {
		this.julActual = value;
	}
	
	/**
	 * 7月实际（元） 
	 */
	public String getJulActual() {
		return julActual;
	}
	
	/**
	 * 8月实际（元） 
	 */
	public void setAugActual(String value) {
		this.augActual = value;
	}
	
	/**
	 * 8月实际（元） 
	 */
	public String getAugActual() {
		return augActual;
	}
	
	/**
	 * 9月实际（元） 
	 */
	public void setSepActual(String value) {
		this.sepActual = value;
	}
	
	/**
	 * 9月实际（元） 
	 */
	public String getSepActual() {
		return sepActual;
	}
	
	/**
	 * 10月实际（元） 
	 */
	public void setOctActual(String value) {
		this.octActual = value;
	}
	
	/**
	 * 10月实际（元） 
	 */
	public String getOctActual() {
		return octActual;
	}
	
	/**
	 * 11月实际（元） 
	 */
	public void setNovActual(String value) {
		this.novActual = value;
	}
	
	/**
	 * 11月实际（元） 
	 */
	public String getNovActual() {
		return novActual;
	}
	
	/**
	 * 12月实际（元） 
	 */
	public void setDecActual(String value) {
		this.decActual = value;
	}
	
	/**
	 * 12月实际（元） 
	 */
	public String getDecActual() {
		return decActual;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
