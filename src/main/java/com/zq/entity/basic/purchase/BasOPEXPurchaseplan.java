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
	private Integer companyId;
	
	@Column(name="create_time", nullable=true)	
	private java.sql.Timestamp createTime;
	
	@Column(name="creator", nullable=true, length=50)	
	private String creator;
	
	@Column(name="modify_time", nullable=true)	
	private java.sql.Timestamp modifyTime;
	
	@Column(name="last_reviser", nullable=true, length=50)	
	private String lastReviser;
	
	@Column(name="Inplan_status", nullable=true, length=50)	
	private String inplanStatus;
	
	@Column(name="name", nullable=true, length=255)	
	private String name;
	
	@Column(name="description", nullable=true)	
	private String description;
	
	@Column(name="sub_proj_name", nullable=true, length=255)	
	private String subProjName;
	
	@Column(name="purchasing_content", nullable=true)	
	private String purchasingContent;
	
	@Column(name="req_dept", nullable=true, length=10)	
	private Integer reqDept;
	
	@Column(name="purchase_type", nullable=true, length=50)	
	private String purchaseType;
	
	@Column(name="budget_categories", nullable=true, length=50)	
	private String budgetCategories;
	
	@Column(name="budget_proj_name", nullable=true, length=255)	
	private String budgetProjName;
	
	@Column(name="budget_scale", nullable=true, length=50)	
	private String budgetScale;
	
	@Column(name="purchase_way", nullable=true, length=10)	
	private Integer purchaseWay;
	
	@Column(name="req_submit_time", nullable=true)	
	private java.sql.Timestamp reqSubmitTime;
	
	@Column(name="req_finish_time", nullable=true)	
	private java.sql.Timestamp reqFinishTime;
	
	@Column(name="req_principal", nullable=true, length=50)	
	private String reqPrincipal;
	
	@Column(name="req_dept2", nullable=true, length=50)	
	private String reqDept2;
	
	@Column(name="req_type", nullable=true, length=50)	
	private Integer reqType;
	
	@Column(name="purchase_dealer", nullable=true, length=50)	
	private String purchaseDealer;
	
	@Column(name="req_submit_stauts", nullable=true, length=10)	
	private Integer reqSubmitStauts;
	
	@Column(name="actual_req_submit_time", nullable=true)	
	private java.sql.Timestamp actualReqSubmitTime;
	
	@Column(name="req_receipt_num", nullable=true, length=50)	
	private String reqReceiptNum;
	
	@Column(name="purchase_status", nullable=true, length=10)	
	private Integer purchaseStatus;
	
	@Column(name="proj_status", nullable=true, length=10)	
	private Integer projStatus;
	
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
	 * 是否计划内项目 
	 */
	public void setInplanStatus(String value) {
		this.inplanStatus = value;
	}
	
	/**
	 * 是否计划内项目 
	 */
	public String getInplanStatus() {
		return inplanStatus;
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
	public void setSubProjName(String value) {
		this.subProjName = value;
	}
	
	/**
	 * 子项目名称 
	 */
	public String getSubProjName() {
		return subProjName;
	}
	
	/**
	 * 主要采购内容 
	 */
	public void setPurchasingContent(String value) {
		this.purchasingContent = value;
	}
	
	/**
	 * 主要采购内容 
	 */
	public String getPurchasingContent() {
		return purchasingContent;
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
	public void setReqDept(Integer value) {
		this.reqDept = value;
	}
	
	/**
	 * 需求部门 
	 */
	public Integer getReqDept() {
		return reqDept;
	}
	
	/**
	 * 采购物资类型 
	 */
	public void setPurchaseType(String value) {
		this.purchaseType = value;
	}
	
	/**
	 * 采购物资类型 
	 */
	public String getPurchaseType() {
		return purchaseType;
	}
	
	/**
	 * 预算科目类别 
	 */
	public void setBudgetCategories(String value) {
		this.budgetCategories = value;
	}
	
	/**
	 * 预算科目类别 
	 */
	public String getBudgetCategories() {
		return budgetCategories;
	}
	
	/**
	 * 对应预算项目名称 
	 */
	public void setBudgetProjName(String value) {
		this.budgetProjName = value;
	}
	
	/**
	 * 对应预算项目名称 
	 */
	public String getBudgetProjName() {
		return budgetProjName;
	}
	
	/**
	 * 预算规模 
	 */
	public void setBudgetScale(String value) {
		this.budgetScale = value;
	}
	
	/**
	 * 预算规模 
	 */
	public String getBudgetScale() {
		return budgetScale;
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
	public void setPurchaseWay(Integer value) {
		this.purchaseWay = value;
	}
	
	/**
	 * 采购方式 代码表：采购计划采购方式代码表
	 */
	public Integer getPurchaseWay() {
		return purchaseWay;
	}
	
	/**
	 * 预算采购需求提交时间 
	 */
	public void setReqSubmitTime(java.sql.Timestamp value) {
		this.reqSubmitTime = value;
	}
	
	/**
	 * 预算采购需求提交时间 
	 */
	public java.sql.Timestamp getReqSubmitTime() {
		return reqSubmitTime;
	}
	
	/**
	 * 要求完成采购时间 
	 */
	public void setReqFinishTime(java.sql.Timestamp value) {
		this.reqFinishTime = value;
	}
	
	/**
	 * 要求完成采购时间 
	 */
	public java.sql.Timestamp getReqFinishTime() {
		return reqFinishTime;
	}
	
	/**
	 * 需求部门负责人 
	 */
	public void setReqPrincipal(String value) {
		this.reqPrincipal = value;
	}
	
	/**
	 * 需求部门负责人 
	 */
	public String getReqPrincipal() {
		return reqPrincipal;
	}
	
	/**
	 * 需求申报部门 
	 */
	public void setReqDept2(String value) {
		this.reqDept2 = value;
	}
	
	/**
	 * 需求申报部门 
	 */
	public String getReqDept2() {
		return reqDept2;
	}
	
	/**
	 * 需求类型 代码表：采购计划需求类型代码表
	 */
	public void setReqType(int value) {
		setReqType(new Integer(value));
	}
	
	/**
	 * 需求类型 代码表：采购计划需求类型代码表
	 */
	public void setReqType(Integer value) {
		this.reqType = value;
	}
	
	/**
	 * 需求类型 代码表：采购计划需求类型代码表
	 */
	public Integer getReqType() {
		return reqType;
	}
	
	/**
	 * 采购负责人 
	 */
	public void setPurchaseDealer(String value) {
		this.purchaseDealer = value;
	}
	
	/**
	 * 采购负责人 
	 */
	public String getPurchaseDealer() {
		return purchaseDealer;
	}
	
	/**
	 * 是否提交需求 代码表：是否代码表
	 */
	public void setReqSubmitStauts(int value) {
		setReqSubmitStauts(new Integer(value));
	}
	
	/**
	 * 是否提交需求 代码表：是否代码表
	 */
	public void setReqSubmitStauts(Integer value) {
		this.reqSubmitStauts = value;
	}
	
	/**
	 * 是否提交需求 代码表：是否代码表
	 */
	public Integer getReqSubmitStauts() {
		return reqSubmitStauts;
	}
	
	/**
	 * 实际需求提交时间 
	 */
	public void setActualReqSubmitTime(java.sql.Timestamp value) {
		this.actualReqSubmitTime = value;
	}
	
	/**
	 * 实际需求提交时间 
	 */
	public java.sql.Timestamp getActualReqSubmitTime() {
		return actualReqSubmitTime;
	}
	
	/**
	 * 采购需求交接单文号 
	 */
	public void setReqReceiptNum(String value) {
		this.reqReceiptNum = value;
	}
	
	/**
	 * 采购需求交接单文号 
	 */
	public String getReqReceiptNum() {
		return reqReceiptNum;
	}
	
	/**
	 * 采购状态 代码表：采购状态代码表
	 */
	public void setPurchaseStatus(int value) {
		setPurchaseStatus(new Integer(value));
	}
	
	/**
	 * 采购状态 代码表：采购状态代码表
	 */
	public void setPurchaseStatus(Integer value) {
		this.purchaseStatus = value;
	}
	
	/**
	 * 采购状态 代码表：采购状态代码表
	 */
	public Integer getPurchaseStatus() {
		return purchaseStatus;
	}
	
	/**
	 * 项目是否取消 代码表：是否代码表
	 */
	public void setProjStatus(int value) {
		setProjStatus(new Integer(value));
	}
	
	/**
	 * 项目是否取消 代码表：是否代码表
	 */
	public void setProjStatus(Integer value) {
		this.projStatus = value;
	}
	
	/**
	 * 项目是否取消 代码表：是否代码表
	 */
	public Integer getProjStatus() {
		return projStatus;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
