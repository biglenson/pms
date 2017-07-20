package com.zq.vo.basic.opex;

/**
 * OPEX工时管理
 */

public class BasOPEXManhourVO {
	
	private int id;
		
	private Integer companyId;
	
	private java.sql.Timestamp createTime;
	
	private String createBy;
	
	private java.sql.Timestamp lastUpdateTime;
		
	private String lastUpdateBy;
		
	private String opexProjCode;
	
	private String opexProjName;
		
	private String juniorManDay;
		
	private String middleManDay;
		
	private String seniorManDay;
	
	private String serviceTimes;
	
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
	public void setCreateBy(String value) {
		this.createBy = value;
	}
	
	/**
	 * 创建人
	 */
	public String getCreateBy() {
		return createBy;
	}
	
	/**
	 * 最后修改时间
	 */
	public void setLastUpdateTime(java.sql.Timestamp value) {
		this.lastUpdateTime = value;
	}
	
	/**
	 * 最后修改时间
	 */
	public java.sql.Timestamp getLastUpdateTime() {
		return lastUpdateTime;
	}
	
	/**
	 * 修改人
	 */
	public void setLastUpdateBy(String value) {
		this.lastUpdateBy = value;
	}
	
	/**
	 * 修改人
	 */
	public String getLastUpdateBy() {
		return lastUpdateBy;
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
	/**
	 * OPEX项目名称
	 */
	public String getOpexProjName() {
		return opexProjName;
	}
	/**
	 * OPEX项目名称） 
	 */
	public void setOpexProjName(String opexProjName) {
		this.opexProjName = opexProjName;
	}
	
}
