package com.zq.vo.basic.capex;
/**
 * CAPEX自主资金池VO
 */
public class BasCAPEXAmountPoolVO{

	private int id;
	
	private Integer companyId;
	
	private java.sql.Timestamp createTime;
	
	private String creator;
	
	private java.sql.Timestamp modifyTime;
	
	private String lastReviser;
	
	private String year;
	
	private String initialAmount;
	
	private String preoccupyAmount;
	
	private String nowinvestAmount;
	
	/**
	 * id
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
	public void setInitialAmount(String value) {
		this.initialAmount = value;
	}
	
	/**
	 * 初始金额
	 */
	public String getInitialAmount() {
		return initialAmount;
	}
	
	/**
	 * 预占金额
	 */
	public void setPreoccupyAmount(String value) {
		this.preoccupyAmount = value;
	}
	
	/**
	 * 预占金额
	 */
	public String getPreoccupyAmount() {
		return preoccupyAmount;
	}
	
	/**
	 * 目前可用投资金额
	 */
	public void setNowinvestAmount(String value) {
		this.nowinvestAmount = value;
	}
	
	/**
	 * 目前可用投资金额
	 */
	public String getNowinvestAmount() {
		return nowinvestAmount;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
