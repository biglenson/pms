package com.zq.entity.basic;
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
 * CAPEX项
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="bas_capex_project")
public class BasCAPEXProject implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月11日 下午3:46:04 
	*/
	private static final long serialVersionUID = -1866831144342940435L;

	public BasCAPEXProject() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BAS_CAPEX_PROJECT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BAS_CAPEX_PROJECT_ID_GENERATOR", strategy="native")	
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
	
	@Column(name="pms_proj_code", nullable=true, length=255)	
	private String pms_proj_code;
	
	@Column(name="req_code", nullable=true, length=255)	
	private String req_code;
	
	@Column(name="proj_name", nullable=true, length=255)	
	private String proj_name;
	
	@Column(name="proj_code", nullable=true, length=255)	
	private String proj_code;
	
	@Column(name="proj_type", nullable=true, length=10)	
	private Integer proj_type;
	
	@Column(name="proj_start_year", nullable=true, length=255)	
	private String proj_start_year;
	
	@Column(name="belong_proj", nullable=true, length=255)	
	private String belong_proj;
	
	@Column(name="proj_status", nullable=true, length=10)	
	private Integer proj_status;
	
	@Column(name="proj_total_invest", nullable=true, length=50)	
	private String proj_total_invest;
	
	@Column(name="anual_capex_plan", nullable=true, length=50)	
	private String anual_capex_plan;
	
	@Column(name="anual_truncap_plan", nullable=true, length=50)	
	private String anual_truncap_plan;
	
	@Column(name="plan_setup_time", nullable=true)	
	private java.sql.Timestamp plan_setup_time;
	
	@Column(name="plan_approval_time", nullable=true)	
	private java.sql.Timestamp plan_approval_time;
	
	@Column(name="plan_construct_time", nullable=true)	
	private java.sql.Timestamp plan_construct_time;
	
	@Column(name="plan_online_time", nullable=true)	
	private java.sql.Timestamp plan_online_time;
	
	@Column(name="pinit_approval_time", nullable=true)	
	private java.sql.Timestamp pinit_approval_time;
	
	@Column(name="pfinal_approval_time", nullable=true)	
	private java.sql.Timestamp pfinal_approval_time;
	
	@Column(name="plan_pm", nullable=true, length=255)	
	private String plan_pm;
	
	@Column(name="purchase_pm", nullable=true, length=255)	
	private String purchase_pm;
	
	@Column(name="proj_pm_dept", nullable=true, length=255)	
	private String proj_pm_dept;
	
	@Column(name="construct_pm", nullable=true, length=255)	
	private String construct_pm;
	
	@Column(name="preoccupy_amount", nullable=true, length=50)	
	private String preoccupy_amount;
	
	@Column(name="proj_setup_mode", nullable=true, length=10)	
	private Integer proj_setup_mode;
	
	@Column(name="`proj_setup _state`", nullable=true, length=10)	
	private Integer proj_setup__state;
	
	@Column(name="`proj_setup _time`", nullable=true)	
	private java.sql.Timestamp proj_setup__time;
	
	@Column(name="`proj_setup _amount`", nullable=true, length=50)	
	private String proj_setup__amount;
	
	@Column(name="decision_basis", nullable=true, length=255)	
	private String decision_basis;
	
	@Column(name="available_approval_time", nullable=true)	
	private java.sql.Timestamp available_approval_time;
	
	@Column(name="available_approval_amount", nullable=true, length=50)	
	private String available_approval_amount;
	
	@Column(name="design_approval_time", nullable=true)	
	private java.sql.Timestamp design_approval_time;
	
	@Column(name="design_approval_amount", nullable=true, length=50)	
	private String design_approval_amount;
	
	@Column(name="final_account", nullable=true, length=50)	
	private String final_account;
	
	@Column(name="construct_time", nullable=true)	
	private java.sql.Timestamp construct_time;
	
	@Column(name="online_time", nullable=true)	
	private java.sql.Timestamp online_time;
	
	@Column(name="init_approval_time", nullable=true)	
	private java.sql.Timestamp init_approval_time;
	
	@Column(name="final_approval_time", nullable=true)	
	private java.sql.Timestamp final_approval_time;
	
	@Column(name="arrival_time", nullable=true)	
	private java.sql.Timestamp arrival_time;
	
	@Column(name="capex_plan_status", nullable=true, length=10)	
	private Integer capex_plan_status;
	
	@Column(name="truncap_plan_status", nullable=true, length=10)	
	private Integer truncap_plan_status;
	
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
	public void setCompany_id(int value) {
		setCompany_id(new Integer(value));
	}
	
	/**
	 * 公司ID
	 */
	public void setCompany_id(Integer value) {
		this.company_id = value;
	}
	
	/**
	 * 公司ID
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
	 * 全流程项目编号 
	 */
	public void setPms_proj_code(String value) {
		this.pms_proj_code = value;
	}
	
	/**
	 * 全流程项目编号 
	 */
	public String getPms_proj_code() {
		return pms_proj_code;
	}
	
	/**
	 * 需求编号 
	 */
	public void setReq_code(String value) {
		this.req_code = value;
	}
	
	/**
	 * 需求编号 
	 */
	public String getReq_code() {
		return req_code;
	}
	
	/**
	 * 项目名称 
	 */
	public void setProj_name(String value) {
		this.proj_name = value;
	}
	
	/**
	 * 项目名称 
	 */
	public String getProj_name() {
		return proj_name;
	}
	
	/**
	 * 项目编码 
	 */
	public void setProj_code(String value) {
		this.proj_code = value;
	}
	
	/**
	 * 项目编码 
	 */
	public String getProj_code() {
		return proj_code;
	}
	
	/**
	 * 项目类型  代码表：capex项目类型代码表
	 */
	public void setProj_type(int value) {
		setProj_type(new Integer(value));
	}
	
	/**
	 * 项目类型  代码表：capex项目类型代码表
	 */
	public void setProj_type(Integer value) {
		this.proj_type = value;
	}
	
	/**
	 * 项目类型  代码表：capex项目类型代码表
	 */
	public Integer getProj_type() {
		return proj_type;
	}
	
	/**
	 * 项目起始年份 
	 */
	public void setProj_start_year(String value) {
		this.proj_start_year = value;
	}
	
	/**
	 * 项目起始年份 
	 */
	public String getProj_start_year() {
		return proj_start_year;
	}
	
	/**
	 * 所属项目/产品 
	 */
	public void setBelong_proj(String value) {
		this.belong_proj = value;
	}
	
	/**
	 * 所属项目/产品 
	 */
	public String getBelong_proj() {
		return belong_proj;
	}
	
	/**
	 * 当前工程状态 代码表：CAPEX当前工程状态代码 
	 */
	public void setProj_status(int value) {
		setProj_status(new Integer(value));
	}
	
	/**
	 * 当前工程状态 代码表：CAPEX当前工程状态代码 
	 */
	public void setProj_status(Integer value) {
		this.proj_status = value;
	}
	
	/**
	 * 当前工程状态 代码表：CAPEX当前工程状态代码 
	 */
	public Integer getProj_status() {
		return proj_status;
	}
	
	/**
	 * 项目总投资（元） 
	 */
	public void setProj_total_invest(String value) {
		this.proj_total_invest = value;
	}
	
	/**
	 * 项目总投资（元） 
	 */
	public String getProj_total_invest() {
		return proj_total_invest;
	}
	
	/**
	 * 当年资本开支计划（元） 
	 */
	public void setAnual_capex_plan(String value) {
		this.anual_capex_plan = value;
	}
	
	/**
	 * 当年资本开支计划（元） 
	 */
	public String getAnual_capex_plan() {
		return anual_capex_plan;
	}
	
	/**
	 * 当年转资计划（元） 
	 */
	public void setAnual_truncap_plan(String value) {
		this.anual_truncap_plan = value;
	}
	
	/**
	 * 当年转资计划（元） 
	 */
	public String getAnual_truncap_plan() {
		return anual_truncap_plan;
	}
	
	/**
	 * 计划立项时间 
	 */
	public void setPlan_setup_time(java.sql.Timestamp value) {
		this.plan_setup_time = value;
	}
	
	/**
	 * 计划立项时间 
	 */
	public java.sql.Timestamp getPlan_setup_time() {
		return plan_setup_time;
	}
	
	/**
	 * 计划设计批复时间 
	 */
	public void setPlan_approval_time(java.sql.Timestamp value) {
		this.plan_approval_time = value;
	}
	
	/**
	 * 计划设计批复时间 
	 */
	public java.sql.Timestamp getPlan_approval_time() {
		return plan_approval_time;
	}
	
	/**
	 * 计划开工时间 
	 */
	public void setPlan_construct_time(java.sql.Timestamp value) {
		this.plan_construct_time = value;
	}
	
	/**
	 * 计划开工时间 
	 */
	public java.sql.Timestamp getPlan_construct_time() {
		return plan_construct_time;
	}
	
	/**
	 * 计划上线运行时间 
	 */
	public void setPlan_online_time(java.sql.Timestamp value) {
		this.plan_online_time = value;
	}
	
	/**
	 * 计划上线运行时间 
	 */
	public java.sql.Timestamp getPlan_online_time() {
		return plan_online_time;
	}
	
	/**
	 * 计划初验批复时间 
	 */
	public void setPinit_approval_time(java.sql.Timestamp value) {
		this.pinit_approval_time = value;
	}
	
	/**
	 * 计划初验批复时间 
	 */
	public java.sql.Timestamp getPinit_approval_time() {
		return pinit_approval_time;
	}
	
	/**
	 * 计划终验批复时间 
	 */
	public void setPfinal_approval_time(java.sql.Timestamp value) {
		this.pfinal_approval_time = value;
	}
	
	/**
	 * 计划终验批复时间 
	 */
	public java.sql.Timestamp getPfinal_approval_time() {
		return pfinal_approval_time;
	}
	
	/**
	 * 计划项目经理 
	 */
	public void setPlan_pm(String value) {
		this.plan_pm = value;
	}
	
	/**
	 * 计划项目经理 
	 */
	public String getPlan_pm() {
		return plan_pm;
	}
	
	/**
	 * 采购项目经理 
	 */
	public void setPurchase_pm(String value) {
		this.purchase_pm = value;
	}
	
	/**
	 * 采购项目经理 
	 */
	public String getPurchase_pm() {
		return purchase_pm;
	}
	
	/**
	 * 工程管理部门 
	 */
	public void setProj_pm_dept(String value) {
		this.proj_pm_dept = value;
	}
	
	/**
	 * 工程管理部门 
	 */
	public String getProj_pm_dept() {
		return proj_pm_dept;
	}
	
	/**
	 * 工建项目经理 
	 */
	public void setConstruct_pm(String value) {
		this.construct_pm = value;
	}
	
	/**
	 * 工建项目经理 
	 */
	public String getConstruct_pm() {
		return construct_pm;
	}
	
	/**
	 * 预占金额 
	 */
	public void setPreoccupy_amount(String value) {
		this.preoccupy_amount = value;
	}
	
	/**
	 * 预占金额 
	 */
	public String getPreoccupy_amount() {
		return preoccupy_amount;
	}
	
	/**
	 * 立项决策方式  1-会议；2-呈批
	 */
	public void setProj_setup_mode(int value) {
		setProj_setup_mode(new Integer(value));
	}
	
	/**
	 * 立项决策方式  1-会议；2-呈批
	 */
	public void setProj_setup_mode(Integer value) {
		this.proj_setup_mode = value;
	}
	
	/**
	 * 立项决策方式  1-会议；2-呈批
	 */
	public Integer getProj_setup_mode() {
		return proj_setup_mode;
	}
	
	/**
	 * 立项决策状态  1-通过；2-有条件通过；3-未通过
	 */
	public void setProj_setup__state(int value) {
		setProj_setup__state(new Integer(value));
	}
	
	/**
	 * 立项决策状态  1-通过；2-有条件通过；3-未通过
	 */
	public void setProj_setup__state(Integer value) {
		this.proj_setup__state = value;
	}
	
	/**
	 * 立项决策状态  1-通过；2-有条件通过；3-未通过
	 */
	public Integer getProj_setup__state() {
		return proj_setup__state;
	}
	
	/**
	 * 立项决策时间 
	 */
	public void setProj_setup__time(java.sql.Timestamp value) {
		this.proj_setup__time = value;
	}
	
	/**
	 * 立项决策时间 
	 */
	public java.sql.Timestamp getProj_setup__time() {
		return proj_setup__time;
	}
	
	/**
	 * 立项决策金额（元） 
	 */
	public void setProj_setup__amount(String value) {
		this.proj_setup__amount = value;
	}
	
	/**
	 * 立项决策金额（元） 
	 */
	public String getProj_setup__amount() {
		return proj_setup__amount;
	}
	
	/**
	 * 决策依据 
	 */
	public void setDecision_basis(String value) {
		this.decision_basis = value;
	}
	
	/**
	 * 决策依据 
	 */
	public String getDecision_basis() {
		return decision_basis;
	}
	
	/**
	 * 可研批复时间 
	 */
	public void setAvailable_approval_time(java.sql.Timestamp value) {
		this.available_approval_time = value;
	}
	
	/**
	 * 可研批复时间 
	 */
	public java.sql.Timestamp getAvailable_approval_time() {
		return available_approval_time;
	}
	
	/**
	 * 可研批复金额（元） 
	 */
	public void setAvailable_approval_amount(String value) {
		this.available_approval_amount = value;
	}
	
	/**
	 * 可研批复金额（元） 
	 */
	public String getAvailable_approval_amount() {
		return available_approval_amount;
	}
	
	/**
	 * 设计批复时间 
	 */
	public void setDesign_approval_time(java.sql.Timestamp value) {
		this.design_approval_time = value;
	}
	
	/**
	 * 设计批复时间 
	 */
	public java.sql.Timestamp getDesign_approval_time() {
		return design_approval_time;
	}
	
	/**
	 * 项目设计批复金额（元） 
	 */
	public void setDesign_approval_amount(String value) {
		this.design_approval_amount = value;
	}
	
	/**
	 * 项目设计批复金额（元） 
	 */
	public String getDesign_approval_amount() {
		return design_approval_amount;
	}
	
	/**
	 * 已完成决算项目的决算金额（元） 
	 */
	public void setFinal_account(String value) {
		this.final_account = value;
	}
	
	/**
	 * 已完成决算项目的决算金额（元） 
	 */
	public String getFinal_account() {
		return final_account;
	}
	
	/**
	 * 开工时间 
	 */
	public void setConstruct_time(java.sql.Timestamp value) {
		this.construct_time = value;
	}
	
	/**
	 * 开工时间 
	 */
	public java.sql.Timestamp getConstruct_time() {
		return construct_time;
	}
	
	/**
	 * 上线时间 
	 */
	public void setOnline_time(java.sql.Timestamp value) {
		this.online_time = value;
	}
	
	/**
	 * 上线时间 
	 */
	public java.sql.Timestamp getOnline_time() {
		return online_time;
	}
	
	/**
	 * 初验批复时间 
	 */
	public void setInit_approval_time(java.sql.Timestamp value) {
		this.init_approval_time = value;
	}
	
	/**
	 * 初验批复时间 
	 */
	public java.sql.Timestamp getInit_approval_time() {
		return init_approval_time;
	}
	
	/**
	 * 终验批复时间 
	 */
	public void setFinal_approval_time(java.sql.Timestamp value) {
		this.final_approval_time = value;
	}
	
	/**
	 * 终验批复时间 
	 */
	public java.sql.Timestamp getFinal_approval_time() {
		return final_approval_time;
	}
	
	/**
	 * 到货接收时间 
	 */
	public void setArrival_time(java.sql.Timestamp value) {
		this.arrival_time = value;
	}
	
	/**
	 * 到货接收时间 
	 */
	public java.sql.Timestamp getArrival_time() {
		return arrival_time;
	}
	
	/**
	 * 开支计划是否已完成 
	 */
	public void setCapex_plan_status(int value) {
		setCapex_plan_status(new Integer(value));
	}
	
	/**
	 * 开支计划是否已完成 
	 */
	public void setCapex_plan_status(Integer value) {
		this.capex_plan_status = value;
	}
	
	/**
	 * 开支计划是否已完成 
	 */
	public Integer getCapex_plan_status() {
		return capex_plan_status;
	}
	
	/**
	 * 转资计划是否已完成 
	 */
	public void setTruncap_plan_status(int value) {
		setTruncap_plan_status(new Integer(value));
	}
	
	/**
	 * 转资计划是否已完成 
	 */
	public void setTruncap_plan_status(Integer value) {
		this.truncap_plan_status = value;
	}
	
	/**
	 * 转资计划是否已完成 
	 */
	public Integer getTruncap_plan_status() {
		return truncap_plan_status;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
