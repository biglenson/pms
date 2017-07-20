package com.zq.vo.basic.purchase;

/**
 * OPEX采购计划
 */

public class BasOPEXPurchaseplanVO {
	
	private int id;
	
	private Integer companyId;
	
	private java.sql.Timestamp createTime;
	
	private String creator;
	
	private java.sql.Timestamp modifyTime;
	
	private String lastReviser;
	
	private String inplanStatus;
	
	private String name;
	
	private String description;
	
	private String subProjName;
	
	private String purchasingContent;
	
	private Integer reqDept;
	
	private String purchaseType;
	
	private String budgetCategories;
	
	private String budgetProjName;
	
	private String budgetScale;
	
	private Integer purchaseWay;
	
	private java.sql.Timestamp reqSubmitTime;
	
	private java.sql.Timestamp reqFinishTime;
	
	private String reqPrincipal;
	
	private String reqDeclareDept;
	
	private Integer reqType;
	
	private String purchaseDealer;
	
	private Integer reqSubmitStauts;
	
	private java.sql.Timestamp actualReqSubmitTime;
	
	private String reqReceiptNum;
	
	private Integer purchaseStatus;
	
	private Integer projStatus;
	
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
	public void setReqDeclareDept(String value) {
		this.reqDeclareDept = value;
	}
	
	/**
	 * 需求申报部门 
	 */
	public String getReqDeclareDept() {
		return reqDeclareDept;
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
