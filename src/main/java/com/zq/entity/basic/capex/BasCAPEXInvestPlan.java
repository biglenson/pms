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
	private Integer company_id;
	
	@Column(name="create_time", nullable=true)	
	private java.sql.Timestamp create_time;
	
	@Column(name="creator", nullable=true, length=50)	
	private String creator;
	
	@Column(name="modify_time", nullable=true)	
	private java.sql.Timestamp modify_time;
	
	@Column(name="last_reviser", nullable=true, length=50)	
	private String last_reviser;
	
	@Column(name="invest_plan_code", nullable=true, length=255)	
	private String invest_plan_code;
	
	@Column(name="year", nullable=true, length=50)	
	private String year;
	
	@Column(name="version", nullable=true, length=10)	
	private Integer version;
	
	@Column(name="first_domain", nullable=true, length=10)	
	private Integer first_domain;
	
	@Column(name="secend_domain", nullable=true, length=255)	
	private String secend_domain;
	
	@Column(name="third_domain", nullable=true, length=255)	
	private String third_domain;
	
	@Column(name="fourth_domain", nullable=true, length=255)	
	private String fourth_domain;
	
	@Column(name="attribute", nullable=true, length=10)	
	private Integer attribute;
	
	@Column(name="proj_name", nullable=true, length=255)	
	private String proj_name;
	
	@Column(name="proj_code", nullable=true, length=50)	
	private String proj_code;
	
	@Column(name="department", nullable=true, length=1)	
	private Integer department;
	
	@Column(name="total_invest", nullable=true, length=50)	
	private String total_invest;
	
	@Column(name="annual_capex", nullable=true, length=50)	
	private String annual_capex;
	
	@Column(name="last_finish_capex", nullable=true, length=50)	
	private String last_finish_capex;
	
	@Column(name="transfer_capex", nullable=true, length=50)	
	private String transfer_capex;
	
	@Column(name="construct_content", nullable=true, length=255)	
	private String construct_content;
	
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
	public void setCompany_id(int value) {
		setCompany_id(new Integer(value));
	}
	
	/**
	 * 公司id
	 */
	public void setCompany_id(Integer value) {
		this.company_id = value;
	}
	
	/**
	 * 公司id
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
	public void setModify_time(java.sql.Timestamp value) {
		this.modify_time = value;
	}
	
	/**
	 * 最后修改时间
	 */
	public java.sql.Timestamp getModify_time() {
		return modify_time;
	}
	
	/**
	 * 修改人
	 */
	public void setLast_reviser(String value) {
		this.last_reviser = value;
	}
	
	/**
	 * 修改人
	 */
	public String getLast_reviser() {
		return last_reviser;
	}
	
	/**
	 * 投资计划编号
	 */
	public void setInvest_plan_code(String value) {
		this.invest_plan_code = value;
	}
	
	/**
	 * 投资计划编号
	 */
	public String getInvest_plan_code() {
		return invest_plan_code;
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
	public void setFirst_domain(int value) {
		setFirst_domain(new Integer(value));
	}
	
	/**
	 * 一级专业 代码表：投资专业代码表
	 */
	public void setFirst_domain(Integer value) {
		this.first_domain = value;
	}
	
	/**
	 * 一级专业 代码表：投资专业代码表
	 */
	public Integer getFirst_domain() {
		return first_domain;
	}
	
	/**
	 * 二级专业
	 */
	public void setSecend_domain(String value) {
		this.secend_domain = value;
	}
	
	/**
	 * 二级专业
	 */
	public String getSecend_domain() {
		return secend_domain;
	}
	
	/**
	 * 三级专业
	 */
	public void setThird_domain(String value) {
		this.third_domain = value;
	}
	
	/**
	 * 三级专业
	 */
	public String getThird_domain() {
		return third_domain;
	}
	
	/**
	 * 四级专业
	 */
	public void setFourth_domain(String value) {
		this.fourth_domain = value;
	}
	
	/**
	 * 四级专业
	 */
	public String getFourth_domain() {
		return fourth_domain;
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
	public void setProj_name(String value) {
		this.proj_name = value;
	}
	
	/**
	 * 投资项目集/项目名称
	 */
	public String getProj_name() {
		return proj_name;
	}
	
	/**
	 * 投资项目集/项目编码
	 */
	public void setProj_code(String value) {
		this.proj_code = value;
	}
	
	/**
	 * 投资项目集/项目编码
	 */
	public String getProj_code() {
		return proj_code;
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
	public void setTotal_invest(String value) {
		this.total_invest = value;
	}
	
	/**
	 * 项目集总投资(元)
	 */
	public String getTotal_invest() {
		return total_invest;
	}
	
	/**
	 * 项目集当年资本开支计划(元)
	 */
	public void setAnnual_capex(String value) {
		this.annual_capex = value;
	}
	
	/**
	 * 项目集当年资本开支计划(元)
	 */
	public String getAnnual_capex() {
		return annual_capex;
	}
	
	/**
	 * 上年累计已完成资本开支(元)
	 */
	public void setLast_finish_capex(String value) {
		this.last_finish_capex = value;
	}
	
	/**
	 * 上年累计已完成资本开支(元)
	 */
	public String getLast_finish_capex() {
		return last_finish_capex;
	}
	
	/**
	 * 项目集结转资本开支(元)
	 */
	public void setTransfer_capex(String value) {
		this.transfer_capex = value;
	}
	
	/**
	 * 项目集结转资本开支(元)
	 */
	public String getTransfer_capex() {
		return transfer_capex;
	}
	
	/**
	 * 项目主要建设内容 
	 */
	public void setConstruct_content(String value) {
		this.construct_content = value;
	}
	
	/**
	 * 项目主要建设内容 
	 */
	public String getConstruct_content() {
		return construct_content;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
