package com.zq.vo.basic.capex;

public class BasCAPEXTransferplanVO {

	private int id;
		
	private Integer companyId;
	
	private java.sql.Timestamp createTime;
	
	private String creator;
	
	private java.sql.Timestamp modifyTime;
	
	private String lastReviser;
	
	private String projCode;
	
	private String projName;
	
	private String currentTransferAmount;
	
	private String totalTransferAmount;
	
	private String year;
	
	private String janPlan;
	
	private String febPlan;
	
	private String marPlan;
	
	private String aprPlan;
	
	private String mayPlan;
	
	private String junPlan;
	
	private String julPlan;
	
	private String augPlan;
		
	private String sepPlan;
	
	private String octPlan;
		
	private String novPlan;
		
	private String decPlan;
	
	private String janActual;
		
	private String febActual;
	
	private String marActual;
	
	private String aprActual;
		
	private String mayActual;
		
	private String junActual;
		
	private String julActual;
		
	private String augActual;
		
	private String sepActual;
	
	private String octActual;
		
	private String novActual;
		
	private String decActual;
	
	/**
	 * ID
	 */
	public int getId() {
		return id;
	}	
	
	/**
	 * id
	 */
	public void setId(int id) {
		this.id = id;
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
	
	public void setProjCode(String value) {
		this.projCode = value;
	}
	
	public String getProjCode() {
		return projCode;
	}
	
	/**
	 * 当年转资完成金额（元） 
	 */
	public void setCurrentTransferAmount(String value) {
		this.currentTransferAmount = value;
	}
	
	/**
	 * 当年转资完成金额（元） 
	 */
	public String getCurrentTransferAmount() {
		return currentTransferAmount;
	}
	
	/**
	 * 累计转资完成金额（元） 
	 */
	public void setTotalTransferAmount(String value) {
		this.totalTransferAmount = value;
	}
	
	/**
	 * 累计转资完成金额（元） 
	 */
	public String getTotalTransferAmount() {
		return totalTransferAmount;
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
	public void setJan_plan(String value) {
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
	/**
	 * 项目名称 
	 */
	public String getProjName() {
		return projName;
	}
	/**
	 * 项目名称
	 */
	public void setProjName(String projName) {
		this.projName = projName;
	}
	
}
