package com.zq.vo.basic.purchase;

/**
 * 二级集采台账
 */

public class BasSecondBillVO {

	private int id;
	
	private Integer companyId;
	
	private java.sql.Timestamp createTime;
	
	private String creator;
	
	private java.sql.Timestamp modifyTime;
	
	private String lastReviser;
	
	private String deptment;
	
	private String dealer;
	
	private String projName;
	
	private java.sql.Timestamp projSetupTime;
		
	private String projSetupName;
	
	private java.sql.Timestamp reqCollectTime;
	
	private String reqProposer;
	
	private java.sql.Timestamp planDecisionTime;
	
	private java.sql.Timestamp beginTime;
	
	private Integer planDecisioner;
		
	private String planDecisionAmount;
	
	private Integer expenditureType;
	
	private Integer category;
	
	private String mainCategories;
		
	private String secondaryCategories;
	
	private Integer purchasingMethod;
	
	private String soleSourceScene;
	
	private String specialSceneExplain;
	
	private Integer sssNoticeStatus;
	
	private String projEsCode;
	
	private Integer purchasingType;
		
	private Integer projResetuprStatus;
	
	private java.sql.Timestamp evaluatedBidsTime;
	
	private Integer failBidsStatus;
	
	private String failBidsCycle;
	
	private java.sql.Timestamp purchaseResConfirmTime;
	
	private Integer purchaseResConfirmLevel;
	
	private String purchaseResConfirmAmount;
	
	private java.sql.Timestamp contractApproveTime;
	
	private java.sql.Timestamp paperReviseTime;
	
	private String frameValidatityTime;
	
	private String supplierName;
	
	private String supplierContacter;
	
	private String supplierContactPhone;
	
	private String docCode;
	
	private String typeinErpStatus;
	
	private String projCode;
	
	private String year;
	
	private String contractAmount;
	
	private String contractCode;
	
	private String contractName;
	
	private Integer contractFrameStatus;
	
	private String contractInTax;
	
	private String contractTax;
	
	private String contractNoTax;
	
	/**
	 * ID
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * id
	 */
	public void setId(int id) {
		this.id = id;
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
	public void setProjName(String value) {
		this.projName = value;
	}
	
	/**
	 * 采购项目名称 
	 */
	public String getProjName() {
		return projName;
	}
	
	/**
	 * 项目立项时间 
	 */
	public void setProjSetupTime(java.sql.Timestamp value) {
		this.projSetupTime = value;
	}
	
	/**
	 * 项目立项时间 
	 */
	public java.sql.Timestamp getProjSetupTime() {
		return projSetupTime;
	}
	
	/**
	 * 项目立项名称 
	 */
	public void setProjSetupName(String value) {
		this.projSetupName = value;
	}
	
	/**
	 * 项目立项名称 
	 */
	public String getProjSetupName() {
		return projSetupName;
	}
	
	/**
	 * 需求收取时间 
	 */
	public void setReqCollectTime(java.sql.Timestamp value) {
		this.reqCollectTime = value;
	}
	
	/**
	 * 需求收取时间 
	 */
	public java.sql.Timestamp getReqCollectTime() {
		return reqCollectTime;
	}
	
	/**
	 * 需求人 
	 */
	public void setReqProposer(String value) {
		this.reqProposer = value;
	}
	
	/**
	 * 需求人 
	 */
	public String getReqProposer() {
		return reqProposer;
	}
	
	/**
	 * 采购方案决策时间 
	 */
	public void setPlanDecisionTime(java.sql.Timestamp value) {
		this.planDecisionTime = value;
	}
	
	/**
	 * 采购方案决策时间 
	 */
	public java.sql.Timestamp getPlanDecisionTime() {
		return planDecisionTime;
	}
	
	/**
	 * 采购启动时间 
	 */
	public void setBeginTime(java.sql.Timestamp value) {
		this.beginTime = value;
	}
	
	/**
	 * 采购启动时间 
	 */
	public java.sql.Timestamp getBeginTime() {
		return beginTime;
	}
	
	/**
	 * 采购方案决策层级 代码表：决策层级代码表
	 */
	public void setPlanDecisioner(int value) {
		setPlanDecisioner(new Integer(value));
	}
	
	/**
	 * 采购方案决策层级 代码表：决策层级代码表
	 */
	public void setPlanDecisioner(Integer value) {
		this.planDecisioner = value;
	}
	
	/**
	 * 采购方案决策层级 代码表：决策层级代码表
	 */
	public Integer getPlanDecisioner() {
		return planDecisioner;
	}
	
	/**
	 * 采购方案决策金额 
	 */
	public void setPlanDecisionAmount(String value) {
		this.planDecisionAmount = value;
	}
	
	/**
	 * 采购方案决策金额 
	 */
	public String getPlanDecisionAmount() {
		return planDecisionAmount;
	}
	
	/**
	 * 开支类型 代码表：开支类型代码表
	 */
	public void setExpenditureType(int value) {
		setExpenditureType(new Integer(value));
	}
	
	/**
	 * 开支类型 代码表：开支类型代码表
	 */
	public void setExpenditureType(Integer value) {
		this.expenditureType = value;
	}
	
	/**
	 * 开支类型 代码表：开支类型代码表
	 */
	public Integer getExpenditureType() {
		return expenditureType;
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
	public void setMainCategories(String value) {
		this.mainCategories = value;
	}
	
	/**
	 * 大类 
	 */
	public String getMainCategories() {
		return mainCategories;
	}
	
	/**
	 * 中类 
	 */
	public void setSecondaryCategories(String value) {
		this.secondaryCategories = value;
	}
	
	/**
	 * 中类 
	 */
	public String getSecondaryCategories() {
		return secondaryCategories;
	}
	
	/**
	 * 采购方式 代码表：集采采购方式代码表
	 */
	public void setPurchasingMethod(int value) {
		setPurchasingMethod(new Integer(value));
	}
	
	/**
	 * 采购方式 代码表：集采采购方式代码表
	 */
	public void setPurchasingMethod(Integer value) {
		this.purchasingMethod = value;
	}
	
	/**
	 * 采购方式 代码表：集采采购方式代码表
	 */
	public Integer getPurchasingMethod() {
		return purchasingMethod;
	}
	
	/**
	 * 单一来源场景 
	 */
	public void setSoleSourceScene(String value) {
		this.soleSourceScene = value;
	}
	
	/**
	 * 单一来源场景 
	 */
	public String getSoleSourceScene() {
		return soleSourceScene;
	}
	
	/**
	 * 特殊场景情况说明 
	 */
	public void setSpecialSceneExplain(String value) {
		this.specialSceneExplain = value;
	}
	
	/**
	 * 特殊场景情况说明 
	 */
	public String getSpecialSceneExplain() {
		return specialSceneExplain;
	}
	
	/**
	 * 单一来源是否发公告 代码表：是否
	 */
	public void setSssNoticeStatus(int value) {
		setSssNoticeStatus(new Integer(value));
	}
	
	/**
	 * 单一来源是否发公告 代码表：是否
	 */
	public void setSssNoticeStatus(Integer value) {
		this.sssNoticeStatus = value;
	}
	
	/**
	 * 单一来源是否发公告 代码表：是否
	 */
	public Integer getSssNoticeStatus() {
		return sssNoticeStatus;
	}
	
	/**
	 * 采购项目ES系统编号 代码表：采购类型代码表
	 */
	public void setProjEsCode(String value) {
		this.projEsCode = value;
	}
	
	/**
	 * 采购项目ES系统编号 代码表：采购类型代码表
	 */
	public String getProjEsCode() {
		return projEsCode;
	}
	
	/**
	 * 采购类型 
	 */
	public void setPurchasingType(int value) {
		setPurchasingType(new Integer(value));
	}
	
	/**
	 * 采购类型 
	 */
	public void setPurchasingType(Integer value) {
		this.purchasingType = value;
	}
	
	/**
	 * 采购类型 
	 */
	public Integer getPurchasingType() {
		return purchasingType;
	}
	
	/**
	 * 是否失败重建新项 代码表：是否
	 */
	public void setProjResetuprStatus(int value) {
		setProjResetuprStatus(new Integer(value));
	}
	
	/**
	 * 是否失败重建新项 代码表：是否
	 */
	public void setProjResetuprStatus(Integer value) {
		this.projResetuprStatus = value;
	}
	
	/**
	 * 是否失败重建新项 代码表：是否
	 */
	public Integer getProjResetuprStatus() {
		return projResetuprStatus;
	}
	
	/**
	 * 完成评标时间 
	 */
	public void setEvaluatedBidsTime(java.sql.Timestamp value) {
		this.evaluatedBidsTime = value;
	}
	
	/**
	 * 完成评标时间 
	 */
	public java.sql.Timestamp getEvaluatedBidsTime() {
		return evaluatedBidsTime;
	}
	
	/**
	 * 是否存在流标 代码表：是否代
	 */
	public void setFailBidsStatus(int value) {
		setFailBidsStatus(new Integer(value));
	}
	
	/**
	 * 是否存在流标 代码表：是否代
	 */
	public void setFailBidsStatus(Integer value) {
		this.failBidsStatus = value;
	}
	
	/**
	 * 是否存在流标 代码表：是否代
	 */
	public Integer getFailBidsStatus() {
		return failBidsStatus;
	}
	
	/**
	 * 流标耗时 
	 */
	public void setFailBidsCycle(String value) {
		this.failBidsCycle = value;
	}
	
	/**
	 * 流标耗时 
	 */
	public String getFailBidsCycle() {
		return failBidsCycle;
	}
	
	/**
	 * 采购结果确认时间 
	 */
	public void setPurchaseResConfirmTime(java.sql.Timestamp value) {
		this.purchaseResConfirmTime = value;
	}
	
	/**
	 * 采购结果确认时间 
	 */
	public java.sql.Timestamp getPurchaseResConfirmTime() {
		return purchaseResConfirmTime;
	}
	
	/**
	 * 采购结果确认层级 代码表：决策层级代码表
	 */
	public void setPurchaseResConfirLlevel(int value) {
		setPurchaseResConfirmLevel(new Integer(value));
	}
	
	/**
	 * 采购结果确认层级 代码表：决策层级代码表
	 */
	public void setPurchaseResConfirmLevel(Integer value) {
		this.purchaseResConfirmLevel = value;
	}
	
	/**
	 * 采购结果确认层级 代码表：决策层级代码表
	 */
	public Integer getPurchaseResConfirmLevel() {
		return purchaseResConfirmLevel;
	}
	
	/**
	 * 采购结果确认金额 
	 */
	public void setPurchaseResConfirmAmount(String value) {
		this.purchaseResConfirmAmount = value;
	}
	
	/**
	 * 采购结果确认金额 
	 */
	public String getPurchaseResConfirmAmount() {
		return purchaseResConfirmAmount;
	}
	
	/**
	 * 完成合同审批时间 
	 */
	public void setContractApproveTime(java.sql.Timestamp value) {
		this.contractApproveTime = value;
	}
	
	/**
	 * 完成合同审批时间 
	 */
	public java.sql.Timestamp getContractApproveTime() {
		return contractApproveTime;
	}
	
	/**
	 * 完成纸质版合同签订时间 
	 */
	public void setPaperReviseTime(java.sql.Timestamp value) {
		this.paperReviseTime = value;
	}
	
	/**
	 * 完成纸质版合同签订时间 
	 */
	public java.sql.Timestamp getPaperReviseTime() {
		return paperReviseTime;
	}
	
	/**
	 * 框架有效期 
	 */
	public void setFrameValidatityTime(String value) {
		this.frameValidatityTime = value;
	}
	
	/**
	 * 框架有效期 
	 */
	public String getFrameValidatityTime() {
		return frameValidatityTime;
	}
	
	/**
	 * 成交供应商名称 
	 */
	public void setSupplierName(String value) {
		this.supplierName = value;
	}
	
	/**
	 * 成交供应商名称 
	 */
	public String getSupplierName() {
		return supplierName;
	}
	
	/**
	 * 供应商联系人姓名 
	 */
	public void setSupplierContacter(String value) {
		this.supplierContacter = value;
	}
	
	/**
	 * 供应商联系人姓名 
	 */
	public String getSupplierContacter() {
		return supplierContacter;
	}
	
	/**
	 * 供应商联系人联系方式 
	 */
	public void setSupplierContactPhone(String value) {
		this.supplierContactPhone = value;
	}
	
	/**
	 * 供应商联系人联系方式 
	 */
	public String getSupplierContactPhone() {
		return supplierContactPhone;
	}
	
	/**
	 * 采购档案编号 
	 */
	public void setDocCode(String value) {
		this.docCode = value;
	}
	
	/**
	 * 采购档案编号 
	 */
	public String getDocCode() {
		return docCode;
	}
	
	/**
	 * 是否需录入ERP系统 代码表：是否代码
	 */
	public void setTypeinErpStatus(String value) {
		this.typeinErpStatus = value;
	}
	
	/**
	 * 是否需录入ERP系统 代码表：是否代码
	 */
	public String getTypeinErpStatus() {
		return typeinErpStatus;
	}
	
	/**
	 * 项目编号 
	 */
	public void setProjCode(String value) {
		this.projCode = value;
	}
	
	/**
	 * 项目编号 
	 */
	public String getProjCode() {
		return projCode;
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
	public void setContractAmount(String value) {
		this.contractAmount = value;
	}
	
	/**
	 * 应签署合同总数 
	 */
	public String getContractAmount() {
		return contractAmount;
	}
	
	/**
	 * 合同编号 
	 */
	public void setContractCode(String value) {
		this.contractCode = value;
	}
	
	/**
	 * 合同编号 
	 */
	public String getContractCode() {
		return contractCode;
	}
	
	/**
	 * 合同名称 
	 */
	public void setContractName(String value) {
		this.contractName = value;
	}
	
	/**
	 * 合同名称 
	 */
	public String getContractName() {
		return contractName;
	}
	
	/**
	 * 是否是框架 代码表：是否代码
	 */
	public void setContractframeStatus(int value) {
		setContractframeStatus(new Integer(value));
	}
	
	/**
	 * 是否是框架 代码表：是否代码
	 */
	public void setContractFrameStatus(Integer value) {
		this.contractFrameStatus = value;
	}
	
	/**
	 * 是否是框架 代码表：是否代码
	 */
	public Integer getContractFrameStatus() {
		return contractFrameStatus;
	}
	
	/**
	 * 合同含税金额 
	 */
	public void setContractInTax(String value) {
		this.contractInTax = value;
	}
	
	/**
	 * 合同含税金额 
	 */
	public String getContractInTax() {
		return contractInTax;
	}
	
	/**
	 * 合同税额 
	 */
	public void setContractTax(String value) {
		this.contractTax = value;
	}
	
	/**
	 * 合同税额 
	 */
	public String getContractTax() {
		return contractTax;
	}
	
	/**
	 * 合同不含税金额 
	 */
	public void setContractNoTax(String value) {
		this.contractNoTax = value;
	}
	
	/**
	 * 合同不含税金额 
	 */
	public String getContractNoTax() {
		return contractNoTax;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
