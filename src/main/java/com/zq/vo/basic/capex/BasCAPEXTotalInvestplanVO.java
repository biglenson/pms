package com.zq.vo.basic.capex;

/**
 * 投资计划总额信息管理
 */

public class BasCAPEXTotalInvestplanVO {

	private int id;
	
	private Integer companyId;
		
	private java.sql.Timestamp createTime;
	
	private String creator;
	
	private java.sql.Timestamp modifyTime;
	
	private String lastReviser;
		
	private Integer annual;
		
	private Integer version;
		
	private String annualCapexPlan;
	
	private String annualTransferPlan;
	
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
