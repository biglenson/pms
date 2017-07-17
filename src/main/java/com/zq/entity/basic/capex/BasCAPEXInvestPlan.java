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
 * CAPEX投资计划
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="bas_capex_invest_plan")
public class BasCAPEXInvestPlan implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月11日 下午4:14:21 
	*/
	private static final long serialVersionUID = 8540146770262315353L;

	public BasCAPEXInvestPlan() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BAS_CAPEX_INVEST_PLAN_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BAS_CAPEX_INVEST_PLAN_ID_GENERATOR", strategy="native")	
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
	
	@Column(name="invest_plan_code", nullable=true, length=255)	
	private String investPlanCode;
	
	@Column(name="year", nullable=true, length=50)	
	private String year;
	
	@Column(name="version", nullable=true, length=10)	
	private Integer version;
	
	@Column(name="first_domain", nullable=true, length=10)	
	private Integer firstDomain;
	
	@Column(name="secend_domain", nullable=true, length=255)	
	private String secendDomain;
	
	@Column(name="third_domain", nullable=true, length=255)	
	private String thirdDomain;
	
	@Column(name="fourth_domain", nullable=true, length=255)	
	private String fourthDomain;
	
	@Column(name="attribute", nullable=true, length=10)	
	private Integer attribute;
	
	@Column(name="proj_name", nullable=true, length=255)	
	private String projName;
	
	@Column(name="proj_code", nullable=true, length=50)	
	private String projCode;
	
	@Column(name="department", nullable=true, length=1)	
	private Integer department;
	
	@Column(name="total_invest", nullable=true, length=50)	
	private String totalInvest;
	
	@Column(name="annual_capex", nullable=true, length=50)	
	private String annualCapex;
	
	@Column(name="last_finish_capex", nullable=true, length=50)	
	private String lastFinishCapex;
	
	@Column(name="transfer_capex", nullable=true, length=50)	
	private String transferCapex;
	
	@Column(name="construct_content", nullable=true, length=255)	
	private String constructContent;
	
	/**
	 * id
	 */
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
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
	public void setFirstDomain(int value) {
		setFirstDomain(new Integer(value));
	}
	
	/**
	 * 一级专业 代码表：投资专业代码表
	 */
	public void setFirstDomain(Integer value) {
		this.firstDomain = value;
	}
	
	/**
	 * 一级专业 代码表：投资专业代码表
	 */
	public Integer getFirstDomain() {
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
	public void setAttribute(int value) {
		setAttribute(new Integer(value));
	}
	
	/**
	 * 属性 代码表：属性
	 */
	public void setAttribute(Integer value) {
		this.attribute = value;
	}
	
	/**
	 * 属性 代码表：属性
	 */
	public Integer getAttribute() {
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
