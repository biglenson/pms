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
 * OPEX采购计划
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="bas_opex_purchaseplan")
public class BasOPEXPurchaseplan implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月12日 上午9:50:43 
	*/
	private static final long serialVersionUID = -8818894346307330811L;

	public BasOPEXPurchaseplan() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BAS_OPEX_PURCHASEPLAN_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BAS_OPEX_PURCHASEPLAN_ID_GENERATOR", strategy="native")	
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
	
	@Column(name="Inplan_status", nullable=true, length=50)	
	private String inplan_status;
	
	@Column(name="name", nullable=true, length=255)	
	private String name;
	
	@Column(name="description", nullable=true)	
	private String description;
	
	@Column(name="sub_proj_name", nullable=true, length=255)	
	private String sub_proj_name;
	
	@Column(name="purchasing_content", nullable=true)	
	private String purchasing_content;
	
	@Column(name="req_dept", nullable=true, length=10)	
	private Integer req_dept;
	
	@Column(name="purchase_type", nullable=true, length=50)	
	private String purchase_type;
	
	@Column(name="budget_categories", nullable=true, length=50)	
	private String budget_categories;
	
	@Column(name="budget_proj_name", nullable=true, length=255)	
	private String budget_proj_name;
	
	@Column(name="budget_scale", nullable=true, length=50)	
	private String budget_scale;
	
	@Column(name="purchase_way", nullable=true, length=10)	
	private Integer purchase_way;
	
	@Column(name="req_submit_time", nullable=true)	
	private java.sql.Timestamp req_submit_time;
	
	@Column(name="req_finish_time", nullable=true)	
	private java.sql.Timestamp req_finish_time;
	
	@Column(name="req_principal", nullable=true, length=50)	
	private String req_principal;
	
	@Column(name="req_dept2", nullable=true, length=50)	
	private String req_dept2;
	
	@Column(name="req_type", nullable=true, length=50)	
	private Integer req_type;
	
	@Column(name="purchase_dealer", nullable=true, length=50)	
	private String purchase_dealer;
	
	@Column(name="req_submit_stauts", nullable=true, length=10)	
	private Integer req_submit_stauts;
	
	@Column(name="actual_req_submit_time", nullable=true)	
	private java.sql.Timestamp actual_req_submit_time;
	
	@Column(name="req_receipt_num", nullable=true, length=50)	
	private String req_receipt_num;
	
	@Column(name="purchase_status", nullable=true, length=10)	
	private Integer purchase_status;
	
	@Column(name="proj_status", nullable=true, length=10)	
	private Integer proj_status;
	
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
	 * 是否计划内项目 
	 */
	public void setInplan_status(String value) {
		this.inplan_status = value;
	}
	
	/**
	 * 是否计划内项目 
	 */
	public String getInplan_status() {
		return inplan_status;
	}
	
	/**
	 * 产品/项目/服务名称 
	 */
	public void setName(String value) {
		this.name = value;
	}
	
	/**
	 * 产品/项目/服务名称 
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 项目描述 
	 */
	public void setDescription(String value) {
		this.description = value;
	}
	
	/**
	 * 项目描述 
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * 子项目名称 
	 */
	public void setSub_proj_name(String value) {
		this.sub_proj_name = value;
	}
	
	/**
	 * 子项目名称 
	 */
	public String getSub_proj_name() {
		return sub_proj_name;
	}
	
	/**
	 * 主要采购内容 
	 */
	public void setPurchasing_content(String value) {
		this.purchasing_content = value;
	}
	
	/**
	 * 主要采购内容 
	 */
	public String getPurchasing_content() {
		return purchasing_content;
	}
	
	/**
	 * 需求部门 
	 */
	public void setReq_dept(int value) {
		setReq_dept(new Integer(value));
	}
	
	/**
	 * 需求部门 
	 */
	public void setReq_dept(Integer value) {
		this.req_dept = value;
	}
	
	/**
	 * 需求部门 
	 */
	public Integer getReq_dept() {
		return req_dept;
	}
	
	/**
	 * 采购物资类型 
	 */
	public void setPurchase_type(String value) {
		this.purchase_type = value;
	}
	
	/**
	 * 采购物资类型 
	 */
	public String getPurchase_type() {
		return purchase_type;
	}
	
	/**
	 * 预算科目类别 
	 */
	public void setBudget_categories(String value) {
		this.budget_categories = value;
	}
	
	/**
	 * 预算科目类别 
	 */
	public String getBudget_categories() {
		return budget_categories;
	}
	
	/**
	 * 对应预算项目名称 
	 */
	public void setBudget_proj_name(String value) {
		this.budget_proj_name = value;
	}
	
	/**
	 * 对应预算项目名称 
	 */
	public String getBudget_proj_name() {
		return budget_proj_name;
	}
	
	/**
	 * 预算规模 
	 */
	public void setBudget_scale(String value) {
		this.budget_scale = value;
	}
	
	/**
	 * 预算规模 
	 */
	public String getBudget_scale() {
		return budget_scale;
	}
	
	/**
	 * 采购方式 代码表：采购计划采购方式代码表
	 */
	public void setPurchase_way(int value) {
		setPurchase_way(new Integer(value));
	}
	
	/**
	 * 采购方式 代码表：采购计划采购方式代码表
	 */
	public void setPurchase_way(Integer value) {
		this.purchase_way = value;
	}
	
	/**
	 * 采购方式 代码表：采购计划采购方式代码表
	 */
	public Integer getPurchase_way() {
		return purchase_way;
	}
	
	/**
	 * 预算采购需求提交时间 
	 */
	public void setReq_submit_time(java.sql.Timestamp value) {
		this.req_submit_time = value;
	}
	
	/**
	 * 预算采购需求提交时间 
	 */
	public java.sql.Timestamp getReq_submit_time() {
		return req_submit_time;
	}
	
	/**
	 * 要求完成采购时间 
	 */
	public void setReq_finish_time(java.sql.Timestamp value) {
		this.req_finish_time = value;
	}
	
	/**
	 * 要求完成采购时间 
	 */
	public java.sql.Timestamp getReq_finish_time() {
		return req_finish_time;
	}
	
	/**
	 * 需求部门负责人 
	 */
	public void setReq_principal(String value) {
		this.req_principal = value;
	}
	
	/**
	 * 需求部门负责人 
	 */
	public String getReq_principal() {
		return req_principal;
	}
	
	/**
	 * 需求申报部门 
	 */
	public void setReq_dept2(String value) {
		this.req_dept2 = value;
	}
	
	/**
	 * 需求申报部门 
	 */
	public String getReq_dept2() {
		return req_dept2;
	}
	
	/**
	 * 需求类型 代码表：采购计划需求类型代码表
	 */
	public void setReq_type(int value) {
		setReq_type(new Integer(value));
	}
	
	/**
	 * 需求类型 代码表：采购计划需求类型代码表
	 */
	public void setReq_type(Integer value) {
		this.req_type = value;
	}
	
	/**
	 * 需求类型 代码表：采购计划需求类型代码表
	 */
	public Integer getReq_type() {
		return req_type;
	}
	
	/**
	 * 采购负责人 
	 */
	public void setPurchase_dealer(String value) {
		this.purchase_dealer = value;
	}
	
	/**
	 * 采购负责人 
	 */
	public String getPurchase_dealer() {
		return purchase_dealer;
	}
	
	/**
	 * 是否提交需求 代码表：是否代码表
	 */
	public void setReq_submit_stauts(int value) {
		setReq_submit_stauts(new Integer(value));
	}
	
	/**
	 * 是否提交需求 代码表：是否代码表
	 */
	public void setReq_submit_stauts(Integer value) {
		this.req_submit_stauts = value;
	}
	
	/**
	 * 是否提交需求 代码表：是否代码表
	 */
	public Integer getReq_submit_stauts() {
		return req_submit_stauts;
	}
	
	/**
	 * 实际需求提交时间 
	 */
	public void setActual_req_submit_time(java.sql.Timestamp value) {
		this.actual_req_submit_time = value;
	}
	
	/**
	 * 实际需求提交时间 
	 */
	public java.sql.Timestamp getActual_req_submit_time() {
		return actual_req_submit_time;
	}
	
	/**
	 * 采购需求交接单文号 
	 */
	public void setReq_receipt_num(String value) {
		this.req_receipt_num = value;
	}
	
	/**
	 * 采购需求交接单文号 
	 */
	public String getReq_receipt_num() {
		return req_receipt_num;
	}
	
	/**
	 * 采购状态 代码表：采购状态代码表
	 */
	public void setPurchase_status(int value) {
		setPurchase_status(new Integer(value));
	}
	
	/**
	 * 采购状态 代码表：采购状态代码表
	 */
	public void setPurchase_status(Integer value) {
		this.purchase_status = value;
	}
	
	/**
	 * 采购状态 代码表：采购状态代码表
	 */
	public Integer getPurchase_status() {
		return purchase_status;
	}
	
	/**
	 * 项目是否取消 代码表：是否代码表
	 */
	public void setProj_status(int value) {
		setProj_status(new Integer(value));
	}
	
	/**
	 * 项目是否取消 代码表：是否代码表
	 */
	public void setProj_status(Integer value) {
		this.proj_status = value;
	}
	
	/**
	 * 项目是否取消 代码表：是否代码表
	 */
	public Integer getProj_status() {
		return proj_status;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
