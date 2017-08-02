package com.zq.vo.basic.capex;
/**
 * CAPEX投资计划
 */
public class BasCAPEXInvestPlanVO{

	private int id;
		
	private Integer companyId;
	
	private java.sql.Timestamp createTime;
	
	private String creator;
	
	private java.sql.Timestamp modifyTime;
	
	private String lastReviser;
	
	private String investPlanCode;
	
	private String year;
	
	private Integer version;
	
	private String firstDomain;
		
	private String secendDomain;
	
	private String thirdDomain;
		
	private String fourthDomain;
	
	private String attribute;
	
	private String projName;
	
	private String projCode;
	
	private Integer department;
		
	private String totalInvest;
	
	private String annualCapex;
	
	private String lastFinishCapex;
		
	private String transferCapex;
		
	private String constructContent;
	
	/**
	 * id
	 */
	public int getId() {
		return id;
	}
	/**
	 * 公司id
	 */
	public void setCompanyId(int value) {
		setCompanyId(new Integer(value));
	}
	
	/**
	 * 公司id
	 */
	public void setCompanyId(Integer value) {
		this.companyId = value;
	}
	
	/**
	 * 公司id
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
	 * 版本 1-年中；2-年
	 */
	public void setVersion(int value) {
		setVersion(new Integer(value));
	}
	
	/**
	 * 版本 1-年中；2-年
	 */
	public void setVersion(Integer value) {
		this.version = value;
	}
	
	/**
	 * 版本 1-年中；2-年
	 */
	public Integer getVersion() {
		return version;
	}
	
	/**
	 * 一级专业 代码表：投资专业代码表
	 */
	public void setFirstDomain(String value) {
		this.firstDomain = value;
	}
	
	/**
	 * 一级专业 代码表：投资专业代码表
	 */
	public String getFirstDomain() {
		return firstDomain;
	}
	
	/**
	 * 二级专业
	 */
	public void setSecendDomain(String value) {
		this.secendDomain = value;
	}
	
	/**
	 * 二级专业
	 */
	public String getSecendDomain() {
		return secendDomain;
	}
	
	/**
	 * 三级专业
	 */
	public void setThirdDomain(String value) {
		this.thirdDomain = value;
	}
	
	/**
	 * 三级专业
	 */
	public String getThirdDomain() {
		return thirdDomain;
	}
	
	/**
	 * 四级专业
	 */
	public void setFourthDomain(String value) {
		this.fourthDomain = value;
	}
	
	/**
	 * 四级专业
	 */
	public String getFourthDomain() {
		return fourthDomain;
	}

	
	/**
	 * 属性 代码表：属性
	 */
	public void setAttribute(String value) {
		this.attribute = value;
	}
	
	/**
	 * 属性 代码表：属性
	 */
	public String getAttribute() {
		return attribute;
	}
	
	/**
	 * 投资项目集/项目名称
	 */
	public void setProjName(String value) {
		this.projName = value;
	}
	
	/**
	 * 投资项目集/项目名称
	 */
	public String getProjName() {
		return projName;
	}
	
	/**
	 * 投资项目集/项目编码
	 */
	public void setProjCode(String value) {
		this.projCode = value;
	}
	
	/**
	 * 投资项目集/项目编码
	 */
	public String getProjCode() {
		return projCode;
	}
	
	/**
	 * 部门
	 */
	public void setDepartment(int value) {
		setDepartment(new Integer(value));
	}
	
	/**
	 * 部门
	 */
	public void setDepartment(Integer value) {
		this.department = value;
	}
	
	/**
	 * 部门
	 */
	public Integer getDepartment() {
		return department;
	}
	
	/**
	 * 项目集总投资(元)
	 */
	public void setTotalInvest(String value) {
		this.totalInvest = value;
	}
	
	/**
	 * 项目集总投资(元)
	 */
	public String getTotalInvest() {
		return totalInvest;
	}
	
	/**
	 * 项目集当年资本开支计划(元)
	 */
	public void setAnnualCapex(String value) {
		this.annualCapex = value;
	}
	
	/**
	 * 项目集当年资本开支计划(元)
	 */
	public String getAnnualCapex() {
		return annualCapex;
	}
	
	/**
	 * 上年累计已完成资本开支(元)
	 */
	public void setLastFinishCapex(String value) {
		this.lastFinishCapex = value;
	}
	
	/**
	 * 上年累计已完成资本开支(元)
	 */
	public String getLastFinishCapex() {
		return lastFinishCapex;
	}
	
	/**
	 * 项目集结转资本开支(元)
	 */
	public void setTransferCapex(String value) {
		this.transferCapex = value;
	}
	
	/**
	 * 项目集结转资本开支(元)
	 */
	public String getTransferCapex() {
		return transferCapex;
	}
	
	/**
	 * 项目主要建设内容 
	 */
	public void setConstructContent(String value) {
		this.constructContent = value;
	}
	
	/**
	 * 项目主要建设内容 
	 */
	public String getConstructContent() {
		return constructContent;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
