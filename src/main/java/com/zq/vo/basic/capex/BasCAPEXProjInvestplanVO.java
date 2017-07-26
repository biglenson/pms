package com.zq.vo.basic.capex;

/**
 * CAPEX项与投资计划
 */

public class BasCAPEXProjInvestplanVO{

	private int id;
	
	private Integer companyId;
	
	private java.sql.Timestamp createTime;
	
	private String creator;
	
	private java.sql.Timestamp modifyTime;
		
	private String lastReviser;
		
	private String projCode;
	
	private String projName;
	
	private String investPlanCode;
	
	private String investPlanProjName;
	
	private String year;
	
	private String firstDomain;
	
	private String attribute;
	
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
	 * CAPEX项目编号
	 */
	public void setProjCode(String value) {
		this.projCode = value;
	}
	/**
	 * CAPEX项目编号
	 */
	public String getProjCode() {
		return projCode;
	}
	/**
	 * 投资计划编号
	 */
	public void setInvestPlanCode(String value) {
		this.investPlanCode = value;
	}
	/**
	 * 投资计划编号
	 */
	public String getInvestPlanCode() {
		return investPlanCode;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	/**
	 * CAPEX项目名称
	 */
	public String getProjName() {
		return projName;
	}
	/**
	 * CAPEX项目名称
	 */
	public void setProjName(String projName) {
		this.projName = projName;
	}
	/**
	 * 投资项目集/项目名称
	 */
	public String getInvestPlanProjName() {
		return investPlanProjName;
	}
	/**
	 *投资项目集/项目名称
	 */
	public void setInvestPlanProjName(String investPlanProjName) {
		this.investPlanProjName = investPlanProjName;
	}
	/**
	 * 年份
	 */
	public String getYear() {
		return year;
	}
	/**
	 * 年份
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * 专业
	 */
	public String getFirstDomain() {
		return firstDomain;
	}
	/**
	 * 专业
	 */
	public void setFirstDomain(String firstDomain) {
		this.firstDomain = firstDomain;
	}
	/**
	 * 属性
	 */
	public String getAttribute() {
		return attribute;
	}	
	/**
	 * 属性
	 */
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	
}
