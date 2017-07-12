package com.zq.entity.basic.opex;
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
 * OPEX项
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="bas_opex_project")
public class BasOPEXProject implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月12日 上午9:50:25 
	*/
	private static final long serialVersionUID = -239693861172972548L;

	public BasOPEXProject() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BAS_OPEX_PROJECT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BAS_OPEX_PROJECT_ID_GENERATOR", strategy="native")	
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
	
	@Column(name="budget_proj_code", nullable=true, length=50)	
	private String budget_proj_code;
	
	@Column(name="req_code", nullable=true, length=50)	
	private String req_code;
	
	@Column(name="proj_code", nullable=true, length=50)	
	private String proj_code;
	
	@Column(name="proj_name", nullable=true, length=255)	
	private String proj_name;
	
	@Column(name="bel_proj", nullable=true, length=50)	
	private String bel_proj;
	
	@Column(name="proj_type", nullable=true, length=10)	
	private Integer proj_type;
	
	@Column(name="budsys_proj_code", nullable=true, length=50)	
	private String budsys_proj_code;
	
	@Column(name="year", nullable=true, length=50)	
	private String year;
	
	@Column(name="proj_setup_time", nullable=true)	
	private java.sql.Timestamp proj_setup_time;
	
	@Column(name="proj_decision_time", nullable=true)	
	private java.sql.Timestamp proj_decision_time;
	
	@Column(name="proj_decision_way", nullable=true, length=50)	
	private String proj_decision_way;
	
	@Column(name="proj_decision_base", nullable=true, length=50)	
	private String proj_decision_base;
	
	@Column(name="proj_decision_status", nullable=true, length=50)	
	private Integer proj_decision_status;
	
	@Column(name="proj_setup_amount", nullable=true, length=50)	
	private String proj_setup_amount;
	
	@Column(name="reimbursement_amount", nullable=true, length=50)	
	private String reimbursement_amount;
	
	@Column(name="recorded_amount", nullable=true, length=50)	
	private String recorded_amount;
	
	@Column(name="jan_plan", nullable=true, length=50)	
	private String jan_plan;
	
	@Column(name="feb_plan", nullable=true, length=50)	
	private String feb_plan;
	
	@Column(name="mar_plan", nullable=true, length=50)	
	private String mar_plan;
	
	@Column(name="apr_plan", nullable=true, length=50)	
	private String apr_plan;
	
	@Column(name="may_plan", nullable=true, length=50)	
	private String may_plan;
	
	@Column(name="jun_plan", nullable=true, length=50)	
	private String jun_plan;
	
	@Column(name="jul_plan", nullable=true, length=50)	
	private String jul_plan;
	
	@Column(name="aug_plan", nullable=true, length=50)	
	private String aug_plan;
	
	@Column(name="sep_plan", nullable=true, length=50)	
	private String sep_plan;
	
	@Column(name="oct_plan", nullable=true, length=50)	
	private String oct_plan;
	
	@Column(name="nov_plan", nullable=true, length=50)	
	private String nov_plan;
	
	@Column(name="dec_plan", nullable=true, length=50)	
	private String dec_plan;
	
	@Column(name="jan_actual", nullable=true, length=50)	
	private String jan_actual;
	
	@Column(name="feb_actual", nullable=true, length=50)	
	private String feb_actual;
	
	@Column(name="mar_actual", nullable=true, length=50)	
	private String mar_actual;
	
	@Column(name="apr_actual", nullable=true, length=50)	
	private String apr_actual;
	
	@Column(name="may_actual", nullable=true, length=50)	
	private String may_actual;
	
	@Column(name="jun_actual", nullable=true, length=50)	
	private String jun_actual;
	
	@Column(name="jul_actual", nullable=true, length=50)	
	private String jul_actual;
	
	@Column(name="aug_actual", nullable=true, length=50)	
	private String aug_actual;
	
	@Column(name="sept_actual", nullable=true, length=50)	
	private String sept_actual;
	
	@Column(name="oct_actual", nullable=true, length=50)	
	private String oct_actual;
	
	@Column(name="nov_actual", nullable=true, length=50)	
	private String nov_actual;
	
	@Column(name="dec_actual", nullable=true, length=50)	
	private String dec_actual;
	
	@Column(name="description", nullable=true)	
	private String description;
	
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
	 * 预算项目编号 bas_opex_budget_project中budget_proj_code
	 */
	public void setBudget_proj_code(String value) {
		this.budget_proj_code = value;
	}
	
	/**
	 * 预算项目编号 bas_opex_budget_project中budget_proj_code
	 */
	public String getBudget_proj_code() {
		return budget_proj_code;
	}
	
	/**
	 * 需求编号 bas_opex_requirment中req_code
	 */
	public void setReq_code(String value) {
		this.req_code = value;
	}
	
	/**
	 * 需求编号 bas_opex_requirment中req_code
	 */
	public String getReq_code() {
		return req_code;
	}
	
	/**
	 * 项目编号 
	 */
	public void setProj_code(String value) {
		this.proj_code = value;
	}
	
	/**
	 * 项目编号 
	 */
	public String getProj_code() {
		return proj_code;
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
	 * 所属产品/项目 
	 */
	public void setBel_proj(String value) {
		this.bel_proj = value;
	}
	
	/**
	 * 所属产品/项目 
	 */
	public String getBel_proj() {
		return bel_proj;
	}
	
	/**
	 * 项目类型 代码表：OPEX项目类型代码表
	 */
	public void setProj_type(int value) {
		setProj_type(new Integer(value));
	}
	
	/**
	 * 项目类型 代码表：OPEX项目类型代码表
	 */
	public void setProj_type(Integer value) {
		this.proj_type = value;
	}
	
	/**
	 * 项目类型 代码表：OPEX项目类型代码表
	 */
	public Integer getProj_type() {
		return proj_type;
	}
	
	/**
	 * 预算系统项目编码 
	 */
	public void setBudsys_proj_code(String value) {
		this.budsys_proj_code = value;
	}
	
	/**
	 * 预算系统项目编码 
	 */
	public String getBudsys_proj_code() {
		return budsys_proj_code;
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
	 * 计划立项时间 
	 */
	public void setProj_setup_time(java.sql.Timestamp value) {
		this.proj_setup_time = value;
	}
	
	/**
	 * 计划立项时间 
	 */
	public java.sql.Timestamp getProj_setup_time() {
		return proj_setup_time;
	}
	
	/**
	 * 立项决策时间 
	 */
	public void setProj_decision_time(java.sql.Timestamp value) {
		this.proj_decision_time = value;
	}
	
	/**
	 * 立项决策时间 
	 */
	public java.sql.Timestamp getProj_decision_time() {
		return proj_decision_time;
	}
	
	/**
	 * 立项决策方式 
	 */
	public void setProj_decision_way(String value) {
		this.proj_decision_way = value;
	}
	
	/**
	 * 立项决策方式 
	 */
	public String getProj_decision_way() {
		return proj_decision_way;
	}
	
	/**
	 * 立项决策依据 
	 */
	public void setProj_decision_base(String value) {
		this.proj_decision_base = value;
	}
	
	/**
	 * 立项决策依据 
	 */
	public String getProj_decision_base() {
		return proj_decision_base;
	}
	
	/**
	 * 立项决策状态  代码表：立项决策状态代码表
	 */
	public void setProj_decision_status(int value) {
		setProj_decision_status(new Integer(value));
	}
	
	/**
	 * 立项决策状态  代码表：立项决策状态代码表
	 */
	public void setProj_decision_status(Integer value) {
		this.proj_decision_status = value;
	}
	
	/**
	 * 立项决策状态  代码表：立项决策状态代码表
	 */
	public Integer getProj_decision_status() {
		return proj_decision_status;
	}
	
	/**
	 * 立项金额（元） 
	 */
	public void setProj_setup_amount(String value) {
		this.proj_setup_amount = value;
	}
	
	/**
	 * 立项金额（元） 
	 */
	public String getProj_setup_amount() {
		return proj_setup_amount;
	}
	
	/**
	 * 报账金额（元） 
	 */
	public void setReimbursement_amount(String value) {
		this.reimbursement_amount = value;
	}
	
	/**
	 * 报账金额（元） 
	 */
	public String getReimbursement_amount() {
		return reimbursement_amount;
	}
	
	/**
	 * 入账金额（元） 
	 */
	public void setRecorded_amount(String value) {
		this.recorded_amount = value;
	}
	
	/**
	 * 入账金额（元） 
	 */
	public String getRecorded_amount() {
		return recorded_amount;
	}
	
	/**
	 * 1月计划（元） 
	 */
	public void setJan_plan(String value) {
		this.jan_plan = value;
	}
	
	/**
	 * 1月计划（元） 
	 */
	public String getJan_plan() {
		return jan_plan;
	}
	
	/**
	 * 2月计划（元） 
	 */
	public void setFeb_plan(String value) {
		this.feb_plan = value;
	}
	
	/**
	 * 2月计划（元） 
	 */
	public String getFeb_plan() {
		return feb_plan;
	}
	
	/**
	 * 3月计划（元） 
	 */
	public void setMar_plan(String value) {
		this.mar_plan = value;
	}
	
	/**
	 * 3月计划（元） 
	 */
	public String getMar_plan() {
		return mar_plan;
	}
	
	/**
	 * 4月计划（元） 
	 */
	public void setApr_plan(String value) {
		this.apr_plan = value;
	}
	
	/**
	 * 4月计划（元） 
	 */
	public String getApr_plan() {
		return apr_plan;
	}
	
	/**
	 * 5月计划（元） 
	 */
	public void setMay_plan(String value) {
		this.may_plan = value;
	}
	
	/**
	 * 5月计划（元） 
	 */
	public String getMay_plan() {
		return may_plan;
	}
	
	/**
	 * 6月计划（元） 
	 */
	public void setJun_plan(String value) {
		this.jun_plan = value;
	}
	
	/**
	 * 6月计划（元） 
	 */
	public String getJun_plan() {
		return jun_plan;
	}
	
	/**
	 * 7月计划（元） 
	 */
	public void setJul_plan(String value) {
		this.jul_plan = value;
	}
	
	/**
	 * 7月计划（元） 
	 */
	public String getJul_plan() {
		return jul_plan;
	}
	
	/**
	 * 8月计划（元） 
	 */
	public void setAug_plan(String value) {
		this.aug_plan = value;
	}
	
	/**
	 * 8月计划（元） 
	 */
	public String getAug_plan() {
		return aug_plan;
	}
	
	/**
	 * 9月计划（元） 
	 */
	public void setSep_plan(String value) {
		this.sep_plan = value;
	}
	
	/**
	 * 9月计划（元） 
	 */
	public String getSep_plan() {
		return sep_plan;
	}
	
	/**
	 * 10月计划（元） 
	 */
	public void setOct_plan(String value) {
		this.oct_plan = value;
	}
	
	/**
	 * 10月计划（元） 
	 */
	public String getOct_plan() {
		return oct_plan;
	}
	
	/**
	 * 11月计划（元） 
	 */
	public void setNov_plan(String value) {
		this.nov_plan = value;
	}
	
	/**
	 * 11月计划（元） 
	 */
	public String getNov_plan() {
		return nov_plan;
	}
	
	/**
	 * 12月计划（元） 
	 */
	public void setDec_plan(String value) {
		this.dec_plan = value;
	}
	
	/**
	 * 12月计划（元） 
	 */
	public String getDec_plan() {
		return dec_plan;
	}
	
	/**
	 * 1月实际（元） 
	 */
	public void setJan_actual(String value) {
		this.jan_actual = value;
	}
	
	/**
	 * 1月实际（元） 
	 */
	public String getJan_actual() {
		return jan_actual;
	}
	
	/**
	 * 2月实际（元） 
	 */
	public void setFeb_actual(String value) {
		this.feb_actual = value;
	}
	
	/**
	 * 2月实际（元） 
	 */
	public String getFeb_actual() {
		return feb_actual;
	}
	
	/**
	 * 3月实际（元） 
	 */
	public void setMar_actual(String value) {
		this.mar_actual = value;
	}
	
	/**
	 * 3月实际（元） 
	 */
	public String getMar_actual() {
		return mar_actual;
	}
	
	/**
	 * 4月实际（元） 
	 */
	public void setApr_actual(String value) {
		this.apr_actual = value;
	}
	
	/**
	 * 4月实际（元） 
	 */
	public String getApr_actual() {
		return apr_actual;
	}
	
	/**
	 * 5月实际（元） 
	 */
	public void setMay_actual(String value) {
		this.may_actual = value;
	}
	
	/**
	 * 5月实际（元） 
	 */
	public String getMay_actual() {
		return may_actual;
	}
	
	/**
	 * 6月实际（元） 
	 */
	public void setJun_actual(String value) {
		this.jun_actual = value;
	}
	
	/**
	 * 6月实际（元） 
	 */
	public String getJun_actual() {
		return jun_actual;
	}
	
	/**
	 * 7月实际（元） 
	 */
	public void setJul_actual(String value) {
		this.jul_actual = value;
	}
	
	/**
	 * 7月实际（元） 
	 */
	public String getJul_actual() {
		return jul_actual;
	}
	
	/**
	 * 8月实际（元） 
	 */
	public void setAug_actual(String value) {
		this.aug_actual = value;
	}
	
	/**
	 * 8月实际（元） 
	 */
	public String getAug_actual() {
		return aug_actual;
	}
	
	/**
	 * 9月实际（元） 
	 */
	public void setSept_actual(String value) {
		this.sept_actual = value;
	}
	
	/**
	 * 9月实际（元） 
	 */
	public String getSept_actual() {
		return sept_actual;
	}
	
	/**
	 * 10月实际（元） 
	 */
	public void setOct_actual(String value) {
		this.oct_actual = value;
	}
	
	/**
	 * 10月实际（元） 
	 */
	public String getOct_actual() {
		return oct_actual;
	}
	
	/**
	 * 11月实际（元） 
	 */
	public void setNov_actual(String value) {
		this.nov_actual = value;
	}
	
	/**
	 * 11月实际（元） 
	 */
	public String getNov_actual() {
		return nov_actual;
	}
	
	/**
	 * 12月实际（元） 
	 */
	public void setDec_actual(String value) {
		this.dec_actual = value;
	}
	
	/**
	 * 12月实际（元） 
	 */
	public String getDec_actual() {
		return dec_actual;
	}
	
	/**
	 * 备注 
	 */
	public void setDescription(String value) {
		this.description = value;
	}
	
	/**
	 * 备注 
	 */
	public String getDescription() {
		return description;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
