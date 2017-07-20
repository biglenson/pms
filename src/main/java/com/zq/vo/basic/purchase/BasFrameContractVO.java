package com.zq.vo.basic.purchase;
/**
 * 框架合同台账
 */
public class BasFrameContractVO {
	
	private int id;
	
	private Integer companyId;
	
	private java.sql.Timestamp createTime;
	
	private String creator;
	
	private java.sql.Timestamp modifyTime;
		
	private String lastReviser;
		
	private String dealer;
	
	private Integer expenditureType;
		
	private String contractName;
	
	private String contractCode;
	
	private java.sql.Timestamp startTime;
	
	private java.sql.Timestamp approvalTime;
	
	private java.sql.Timestamp paperReviseTime;
	
	private String frameworkContractName;
	
	private Integer purchasingWay;
	
	private String soleSourceScene;
	
	private String sssNoticeStatus;
	
	private Integer frameCategories;
	
	private String frameContractCode;
	
	private String adversary;
	
	private String contractInTax;
	
	private String contractTax;
	
	private String contractNoTax;
	
	private Integer typeinErpStatus;
	
	private String erpProjCode;
	
	private String projSetupName;
	
	private String year;
	
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
	 * 订单/框架下合同承办人 
	 */
	public void setDealer(String value) {
		this.dealer = value;
	}
	
	/**
	 * 订单/框架下合同承办人 
	 */
	public String getDealer() {
		return dealer;
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
	 * 订单/框架下合同名称 
	 */
	public void setContractName(String value) {
		this.contractName = value;
	}
	
	/**
	 * 订单/框架下合同名称 
	 */
	public String getContractName() {
		return contractName;
	}
	
	/**
	 * 订单/框架下合同编号 
	 */
	public void setContractCode(String value) {
		this.contractCode = value;
	}
	
	/**
	 * 订单/框架下合同编号 
	 */
	public String getContractCode() {
		return contractCode;
	}
	
	/**
	 * 启动时间 
	 */
	public void setStartTime(java.sql.Timestamp value) {
		this.startTime = value;
	}
	
	/**
	 * 启动时间 
	 */
	public java.sql.Timestamp getStartTime() {
		return startTime;
	}
	
	/**
	 * 领导审批时间 
	 */
	public void setApprovalTime(java.sql.Timestamp value) {
		this.approvalTime = value;
	}
	
	/**
	 * 领导审批时间 
	 */
	public java.sql.Timestamp getApprovalTime() {
		return approvalTime;
	}
	
	/**
	 * 完成纸质版签订时间 
	 */
	public void setPaperReviseTime(java.sql.Timestamp value) {
		this.paperReviseTime = value;
	}
	
	/**
	 * 完成纸质版签订时间 
	 */
	public java.sql.Timestamp getPaperReviseTime() {
		return paperReviseTime;
	}
	
	/**
	 * 框架合同名称 
	 */
	public void setFrameworkContractName(String value) {
		this.frameworkContractName = value;
	}
	
	/**
	 * 框架合同名称 
	 */
	public String getFrameworkContractName() {
		return frameworkContractName;
	}
	
	/**
	 * 框架采购方式 代码表：集采采购方式代码表
	 */
	public void setPurchasing_way(int value) {
		setPurchasing_way(new Integer(value));
	}
	
	/**
	 * 框架采购方式 代码表：集采采购方式代码表
	 */
	public void setPurchasingWay(Integer value) {
		this.purchasingWay = value;
	}
	
	/**
	 * 框架采购方式 代码表：集采采购方式代码表
	 */
	public Integer getPurchasingWay() {
		return purchasingWay;
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
	 * 单一来源是否发公告 
	 */
	public void setSssNoticeStatus(String value) {
		this.sssNoticeStatus = value;
	}
	
	/**
	 * 单一来源是否发公告 
	 */
	public String getSssNoticeStatus() {
		return sssNoticeStatus;
	}
	
	/**
	 * 框架品类 代码表：  采购品类代码表
	 */
	public void setFrame_categories(int value) {
		setFrame_categories(new Integer(value));
	}
	
	/**
	 * 框架品类 代码表：  采购品类代码表
	 */
	public void setFrameCategories(Integer value) {
		this.frameCategories = value;
	}
	
	/**
	 * 框架品类 代码表：  采购品类代码表
	 */
	public Integer getFrameCategories() {
		return frameCategories;
	}
	
	/**
	 * 框架合同编号 
	 */
	public void setFrameContractCode(String value) {
		this.frameContractCode = value;
	}
	
	/**
	 * 框架合同编号 
	 */
	public String getFrameContractCode() {
		return frameContractCode;
	}
	
	/**
	 * 对方当事人名称 
	 */
	public void setAdversary(String value) {
		this.adversary = value;
	}
	
	/**
	 * 对方当事人名称 
	 */
	public String getAdversary() {
		return adversary;
	}
	
	/**
	 * 订单/框架下合同含税金额 
	 */
	public void setContractInTax(String value) {
		this.contractInTax = value;
	}
	
	/**
	 * 订单/框架下合同含税金额 
	 */
	public String getContractInTax() {
		return contractInTax;
	}
	
	/**
	 * 订单/框架下合同税额 
	 */
	public void setContractTax(String value) {
		this.contractTax = value;
	}
	
	/**
	 * 订单/框架下合同税额 
	 */
	public String getContractTax() {
		return contractTax;
	}
	
	/**
	 * 订单/框架下合同不含税金额 
	 */
	public void setContractNoTax(String value) {
		this.contractNoTax = value;
	}
	
	/**
	 * 订单/框架下合同不含税金额 
	 */
	public String getContractNoTax() {
		return contractNoTax;
	}
	
	/**
	 * 是否需录入ERP系统 代码表：是否代码表
	 */
	public void setTypein_erp_status(int value) {
		setTypein_erp_status(new Integer(value));
	}
	
	/**
	 * 是否需录入ERP系统 代码表：是否代码表
	 */
	public void setTypeinErpStatus(Integer value) {
		this.typeinErpStatus = value;
	}
	
	/**
	 * 是否需录入ERP系统 代码表：是否代码表
	 */
	public Integer getTypeinErpStatus() {
		return typeinErpStatus;
	}
	
	/**
	 * ERP项目编号 
	 */
	public void setErpProjCode(String value) {
		this.erpProjCode = value;
	}
	
	/**
	 * ERP项目编号 
	 */
	public String getErpProjCode() {
		return erpProjCode;
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
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
