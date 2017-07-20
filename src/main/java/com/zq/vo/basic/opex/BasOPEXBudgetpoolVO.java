package com.zq.vo.basic.opex;

public class BasOPEXBudgetpoolVO {
	
	private int id;
	
	private Integer companyId;
	
	private java.sql.Timestamp createTime;
	
	private String creator;
	
	private java.sql.Timestamp modifyTime;
	
	private String lastReviser;
		
	private String dynabudplInitAmount;
	
	private String availDynabudplAmount;
	
	private String year;
	
	/**
	 * ID
	 */
	public int getId() {
		return id;
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
	 * 动态预算池初始金额（元）
	 */
	public void setDynabudplInitAmount(String value) {
		this.dynabudplInitAmount = value;
	}
	
	/**
	 * 动态预算池初始金额（元）
	 */
	public String getDynabudplInitAmount() {
		return dynabudplInitAmount;
	}
	
	/**
	 * 可用动态预算池总金额（元）
	 */
	public void setAvailDynabudplAmount(String value) {
		this.availDynabudplAmount = value;
	}
	
	/**
	 * 可用动态预算池总金额（元）
	 */
	public String getAvailDynabudplAmount() {
		return availDynabudplAmount;
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
