package com.zq.entity.basic.purchase;
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
 * 二级集采台账
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="bas_second_bill")
public class BasSecondBill implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月12日 上午9:57:24 
	*/
	private static final long serialVersionUID = 5518561327598797177L;

	public BasSecondBill() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BAS_SECOND_BILL_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BAS_SECOND_BILL_ID_GENERATOR", strategy="native")	
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
	
	@Column(name="deptment", nullable=true, length=50)	
	private String deptment;
	
	@Column(name="dealer", nullable=true, length=50)	
	private String dealer;
	
	@Column(name="proj_name", nullable=true, length=50)	
	private String proj_name;
	
	@Column(name="proj_setup_time", nullable=true)	
	private java.sql.Timestamp proj_setup_time;
	
	@Column(name="proj_setup_name", nullable=true, length=50)	
	private String proj_setup_name;
	
	@Column(name="req_collect_time", nullable=true)	
	private java.sql.Timestamp req_collect_time;
	
	@Column(name="`req_ proposer`", nullable=true, length=50)	
	private String req__proposer;
	
	@Column(name="plan_decision_time", nullable=true)	
	private java.sql.Timestamp plan_decision_time;
	
	@Column(name="begin_time", nullable=true)	
	private java.sql.Timestamp begin_time;
	
	@Column(name="plan_decisioner", nullable=true, length=10)	
	private Integer plan_decisioner;
	
	@Column(name="plan_decision_amount", nullable=true, length=50)	
	private String plan_decision_amount;
	
	@Column(name="expenditure_type", nullable=true, length=10)	
	private Integer expenditure_type;
	
	@Column(name="category", nullable=true, length=10)	
	private Integer category;
	
	@Column(name="main_categories", nullable=true, length=50)	
	private String main_categories;
	
	@Column(name="secondary_categories", nullable=true, length=50)	
	private String secondary_categories;
	
	@Column(name="type", nullable=true, length=50)	
	private Integer type;
	
	@Column(name="sole_source_scene", nullable=true, length=50)	
	private String sole_source_scene;
	
	@Column(name="special_scene_explain", nullable=true)	
	private String special_scene_explain;
	
	@Column(name="sss_notice_status", nullable=true, length=50)	
	private Integer sss_notice_status;
	
	@Column(name="proj_es_code", nullable=true, length=10)	
	private String proj_es_code;
	
	@Column(name="type2", nullable=true, length=50)	
	private Integer type2;
	
	@Column(name="proj_resetupr_status", nullable=true, length=50)	
	private Integer proj_resetupr_status;
	
	@Column(name="evaluated_bids_time", nullable=true)	
	private java.sql.Timestamp evaluated_bids_time;
	
	@Column(name="fail_bids_status", nullable=true, length=10)	
	private Integer fail_bids_status;
	
	@Column(name="fail_bids_cycle", nullable=true, length=50)	
	private String fail_bids_cycle;
	
	@Column(name="purchase_res_confirm_time", nullable=true)	
	private java.sql.Timestamp purchase_res_confirm_time;
	
	@Column(name="purchase_res_confirm_level", nullable=true, length=10)	
	private Integer purchase_res_confirm_level;
	
	@Column(name="purchase_res_confirm_amount", nullable=true, length=50)	
	private String purchase_res_confirm_amount;
	
	@Column(name="contract_approve_time", nullable=true)	
	private java.sql.Timestamp contract_approve_time;
	
	@Column(name="paper_revise_time", nullable=true)	
	private java.sql.Timestamp paper_revise_time;
	
	@Column(name="frame_validatity_time", nullable=true, length=50)	
	private String frame_validatity_time;
	
	@Column(name="supplier_name", nullable=true, length=50)	
	private String supplier_name;
	
	@Column(name="supplier_contacter", nullable=true, length=50)	
	private String supplier_contacter;
	
	@Column(name="supplier_contact_phone", nullable=true, length=50)	
	private String supplier_contact_phone;
	
	@Column(name="doc_code", nullable=true, length=50)	
	private String doc_code;
	
	@Column(name="typein_erp_status", nullable=true, length=50)	
	private String typein_erp_status;
	
	@Column(name="proj_code", nullable=true, length=50)	
	private String proj_code;
	
	@Column(name="year", nullable=true, length=50)	
	private String year;
	
	@Column(name="contract_amount", nullable=true, length=50)	
	private String contract_amount;
	
	@Column(name="contract_code", nullable=true, length=50)	
	private String contract_code;
	
	@Column(name="contract_name", nullable=true, length=50)	
	private String contract_name;
	
	@Column(name="contract_frame_status", nullable=true, length=10)	
	private Integer contract_frame_status;
	
	@Column(name="contract_in_tax", nullable=true, length=50)	
	private String contract_in_tax;
	
	@Column(name="contract_tax", nullable=true, length=50)	
	private String contract_tax;
	
	@Column(name="contract_no_tax", nullable=true, length=50)	
	private String contract_no_tax;
	
	/**
	 * ID
	 */
	private void setId(int value) {
		this.id = value;
	}
	
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
	 * 采购承办部门 
	 */
	public void setDeptment(String value) {
		this.deptment = value;
	}
	
	/**
	 * 采购承办部门 
	 */
	public String getDeptment() {
		return deptment;
	}
	
	/**
	 * 采购承办人 
	 */
	public void setDealer(String value) {
		this.dealer = value;
	}
	
	/**
	 * 采购承办人 
	 */
	public String getDealer() {
		return dealer;
	}
	
	/**
	 * 采购项目名称 
	 */
	public void setProj_name(String value) {
		this.proj_name = value;
	}
	
	/**
	 * 采购项目名称 
	 */
	public String getProj_name() {
		return proj_name;
	}
	
	/**
	 * 项目立项时间 
	 */
	public void setProj_setup_time(java.sql.Timestamp value) {
		this.proj_setup_time = value;
	}
	
	/**
	 * 项目立项时间 
	 */
	public java.sql.Timestamp getProj_setup_time() {
		return proj_setup_time;
	}
	
	/**
	 * 项目立项名称 
	 */
	public void setProj_setup_name(String value) {
		this.proj_setup_name = value;
	}
	
	/**
	 * 项目立项名称 
	 */
	public String getProj_setup_name() {
		return proj_setup_name;
	}
	
	/**
	 * 需求收取时间 
	 */
	public void setReq_collect_time(java.sql.Timestamp value) {
		this.req_collect_time = value;
	}
	
	/**
	 * 需求收取时间 
	 */
	public java.sql.Timestamp getReq_collect_time() {
		return req_collect_time;
	}
	
	/**
	 * 需求人 
	 */
	public void setReq__proposer(String value) {
		this.req__proposer = value;
	}
	
	/**
	 * 需求人 
	 */
	public String getReq__proposer() {
		return req__proposer;
	}
	
	/**
	 * 采购方案决策时间 
	 */
	public void setPlan_decision_time(java.sql.Timestamp value) {
		this.plan_decision_time = value;
	}
	
	/**
	 * 采购方案决策时间 
	 */
	public java.sql.Timestamp getPlan_decision_time() {
		return plan_decision_time;
	}
	
	/**
	 * 采购启动时间 
	 */
	public void setBegin_time(java.sql.Timestamp value) {
		this.begin_time = value;
	}
	
	/**
	 * 采购启动时间 
	 */
	public java.sql.Timestamp getBegin_time() {
		return begin_time;
	}
	
	/**
	 * 采购方案决策层级 代码表：决策层级代码表
	 */
	public void setPlan_decisioner(int value) {
		setPlan_decisioner(new Integer(value));
	}
	
	/**
	 * 采购方案决策层级 代码表：决策层级代码表
	 */
	public void setPlan_decisioner(Integer value) {
		this.plan_decisioner = value;
	}
	
	/**
	 * 采购方案决策层级 代码表：决策层级代码表
	 */
	public Integer getPlan_decisioner() {
		return plan_decisioner;
	}
	
	/**
	 * 采购方案决策金额 
	 */
	public void setPlan_decision_amount(String value) {
		this.plan_decision_amount = value;
	}
	
	/**
	 * 采购方案决策金额 
	 */
	public String getPlan_decision_amount() {
		return plan_decision_amount;
	}
	
	/**
	 * 开支类型 代码表：开支类型代码表
	 */
	public void setExpenditure_type(int value) {
		setExpenditure_type(new Integer(value));
	}
	
	/**
	 * 开支类型 代码表：开支类型代码表
	 */
	public void setExpenditure_type(Integer value) {
		this.expenditure_type = value;
	}
	
	/**
	 * 开支类型 代码表：开支类型代码表
	 */
	public Integer getExpenditure_type() {
		return expenditure_type;
	}
	
	/**
	 * 品类 代码表：采购品类代码表
	 */
	public void setCategory(int value) {
		setCategory(new Integer(value));
	}
	
	/**
	 * 品类 代码表：采购品类代码表
	 */
	public void setCategory(Integer value) {
		this.category = value;
	}
	
	/**
	 * 品类 代码表：采购品类代码表
	 */
	public Integer getCategory() {
		return category;
	}
	
	/**
	 * 大类 
	 */
	public void setMain_categories(String value) {
		this.main_categories = value;
	}
	
	/**
	 * 大类 
	 */
	public String getMain_categories() {
		return main_categories;
	}
	
	/**
	 * 中类 
	 */
	public void setSecondary_categories(String value) {
		this.secondary_categories = value;
	}
	
	/**
	 * 中类 
	 */
	public String getSecondary_categories() {
		return secondary_categories;
	}
	
	/**
	 * 采购方式 代码表：集采采购方式代码表
	 */
	public void setType(int value) {
		setType(new Integer(value));
	}
	
	/**
	 * 采购方式 代码表：集采采购方式代码表
	 */
	public void setType(Integer value) {
		this.type = value;
	}
	
	/**
	 * 采购方式 代码表：集采采购方式代码表
	 */
	public Integer getType() {
		return type;
	}
	
	/**
	 * 单一来源场景 
	 */
	public void setSole_source_scene(String value) {
		this.sole_source_scene = value;
	}
	
	/**
	 * 单一来源场景 
	 */
	public String getSole_source_scene() {
		return sole_source_scene;
	}
	
	/**
	 * 特殊场景情况说明 
	 */
	public void setSpecial_scene_explain(String value) {
		this.special_scene_explain = value;
	}
	
	/**
	 * 特殊场景情况说明 
	 */
	public String getSpecial_scene_explain() {
		return special_scene_explain;
	}
	
	/**
	 * 单一来源是否发公告 代码表：是否
	 */
	public void setSss_notice_status(int value) {
		setSss_notice_status(new Integer(value));
	}
	
	/**
	 * 单一来源是否发公告 代码表：是否
	 */
	public void setSss_notice_status(Integer value) {
		this.sss_notice_status = value;
	}
	
	/**
	 * 单一来源是否发公告 代码表：是否
	 */
	public Integer getSss_notice_status() {
		return sss_notice_status;
	}
	
	/**
	 * 采购项目ES系统编号 代码表：采购类型代码表
	 */
	public void setProj_es_code(String value) {
		this.proj_es_code = value;
	}
	
	/**
	 * 采购项目ES系统编号 代码表：采购类型代码表
	 */
	public String getProj_es_code() {
		return proj_es_code;
	}
	
	/**
	 * 采购类型 
	 */
	public void setType2(int value) {
		setType2(new Integer(value));
	}
	
	/**
	 * 采购类型 
	 */
	public void setType2(Integer value) {
		this.type2 = value;
	}
	
	/**
	 * 采购类型 
	 */
	public Integer getType2() {
		return type2;
	}
	
	/**
	 * 是否失败重建新项 代码表：是否
	 */
	public void setProj_resetupr_status(int value) {
		setProj_resetupr_status(new Integer(value));
	}
	
	/**
	 * 是否失败重建新项 代码表：是否
	 */
	public void setProj_resetupr_status(Integer value) {
		this.proj_resetupr_status = value;
	}
	
	/**
	 * 是否失败重建新项 代码表：是否
	 */
	public Integer getProj_resetupr_status() {
		return proj_resetupr_status;
	}
	
	/**
	 * 完成评标时间 
	 */
	public void setEvaluated_bids_time(java.sql.Timestamp value) {
		this.evaluated_bids_time = value;
	}
	
	/**
	 * 完成评标时间 
	 */
	public java.sql.Timestamp getEvaluated_bids_time() {
		return evaluated_bids_time;
	}
	
	/**
	 * 是否存在流标 代码表：是否代
	 */
	public void setFail_bids_status(int value) {
		setFail_bids_status(new Integer(value));
	}
	
	/**
	 * 是否存在流标 代码表：是否代
	 */
	public void setFail_bids_status(Integer value) {
		this.fail_bids_status = value;
	}
	
	/**
	 * 是否存在流标 代码表：是否代
	 */
	public Integer getFail_bids_status() {
		return fail_bids_status;
	}
	
	/**
	 * 流标耗时 
	 */
	public void setFail_bids_cycle(String value) {
		this.fail_bids_cycle = value;
	}
	
	/**
	 * 流标耗时 
	 */
	public String getFail_bids_cycle() {
		return fail_bids_cycle;
	}
	
	/**
	 * 采购结果确认时间 
	 */
	public void setPurchase_res_confirm_time(java.sql.Timestamp value) {
		this.purchase_res_confirm_time = value;
	}
	
	/**
	 * 采购结果确认时间 
	 */
	public java.sql.Timestamp getPurchase_res_confirm_time() {
		return purchase_res_confirm_time;
	}
	
	/**
	 * 采购结果确认层级 代码表：决策层级代码表
	 */
	public void setPurchase_res_confirm_level(int value) {
		setPurchase_res_confirm_level(new Integer(value));
	}
	
	/**
	 * 采购结果确认层级 代码表：决策层级代码表
	 */
	public void setPurchase_res_confirm_level(Integer value) {
		this.purchase_res_confirm_level = value;
	}
	
	/**
	 * 采购结果确认层级 代码表：决策层级代码表
	 */
	public Integer getPurchase_res_confirm_level() {
		return purchase_res_confirm_level;
	}
	
	/**
	 * 采购结果确认金额 
	 */
	public void setPurchase_res_confirm_amount(String value) {
		this.purchase_res_confirm_amount = value;
	}
	
	/**
	 * 采购结果确认金额 
	 */
	public String getPurchase_res_confirm_amount() {
		return purchase_res_confirm_amount;
	}
	
	/**
	 * 完成合同审批时间 
	 */
	public void setContract_approve_time(java.sql.Timestamp value) {
		this.contract_approve_time = value;
	}
	
	/**
	 * 完成合同审批时间 
	 */
	public java.sql.Timestamp getContract_approve_time() {
		return contract_approve_time;
	}
	
	/**
	 * 完成纸质版合同签订时间 
	 */
	public void setPaper_revise_time(java.sql.Timestamp value) {
		this.paper_revise_time = value;
	}
	
	/**
	 * 完成纸质版合同签订时间 
	 */
	public java.sql.Timestamp getPaper_revise_time() {
		return paper_revise_time;
	}
	
	/**
	 * 框架有效期 
	 */
	public void setFrame_validatity_time(String value) {
		this.frame_validatity_time = value;
	}
	
	/**
	 * 框架有效期 
	 */
	public String getFrame_validatity_time() {
		return frame_validatity_time;
	}
	
	/**
	 * 成交供应商名称 
	 */
	public void setSupplier_name(String value) {
		this.supplier_name = value;
	}
	
	/**
	 * 成交供应商名称 
	 */
	public String getSupplier_name() {
		return supplier_name;
	}
	
	/**
	 * 供应商联系人姓名 
	 */
	public void setSupplier_contacter(String value) {
		this.supplier_contacter = value;
	}
	
	/**
	 * 供应商联系人姓名 
	 */
	public String getSupplier_contacter() {
		return supplier_contacter;
	}
	
	/**
	 * 供应商联系人联系方式 
	 */
	public void setSupplier_contact_phone(String value) {
		this.supplier_contact_phone = value;
	}
	
	/**
	 * 供应商联系人联系方式 
	 */
	public String getSupplier_contact_phone() {
		return supplier_contact_phone;
	}
	
	/**
	 * 采购档案编号 
	 */
	public void setDoc_code(String value) {
		this.doc_code = value;
	}
	
	/**
	 * 采购档案编号 
	 */
	public String getDoc_code() {
		return doc_code;
	}
	
	/**
	 * 是否需录入ERP系统 代码表：是否代码
	 */
	public void setTypein_erp_status(String value) {
		this.typein_erp_status = value;
	}
	
	/**
	 * 是否需录入ERP系统 代码表：是否代码
	 */
	public String getTypein_erp_status() {
		return typein_erp_status;
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
	 * 应签署合同总数 
	 */
	public void setContract_amount(String value) {
		this.contract_amount = value;
	}
	
	/**
	 * 应签署合同总数 
	 */
	public String getContract_amount() {
		return contract_amount;
	}
	
	/**
	 * 合同编号 
	 */
	public void setContract_code(String value) {
		this.contract_code = value;
	}
	
	/**
	 * 合同编号 
	 */
	public String getContract_code() {
		return contract_code;
	}
	
	/**
	 * 合同名称 
	 */
	public void setContract_name(String value) {
		this.contract_name = value;
	}
	
	/**
	 * 合同名称 
	 */
	public String getContract_name() {
		return contract_name;
	}
	
	/**
	 * 是否是框架 代码表：是否代码
	 */
	public void setContract_frame_status(int value) {
		setContract_frame_status(new Integer(value));
	}
	
	/**
	 * 是否是框架 代码表：是否代码
	 */
	public void setContract_frame_status(Integer value) {
		this.contract_frame_status = value;
	}
	
	/**
	 * 是否是框架 代码表：是否代码
	 */
	public Integer getContract_frame_status() {
		return contract_frame_status;
	}
	
	/**
	 * 合同含税金额 
	 */
	public void setContract_in_tax(String value) {
		this.contract_in_tax = value;
	}
	
	/**
	 * 合同含税金额 
	 */
	public String getContract_in_tax() {
		return contract_in_tax;
	}
	
	/**
	 * 合同税额 
	 */
	public void setContract_tax(String value) {
		this.contract_tax = value;
	}
	
	/**
	 * 合同税额 
	 */
	public String getContract_tax() {
		return contract_tax;
	}
	
	/**
	 * 合同不含税金额 
	 */
	public void setContract_no_tax(String value) {
		this.contract_no_tax = value;
	}
	
	/**
	 * 合同不含税金额 
	 */
	public String getContract_no_tax() {
		return contract_no_tax;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
