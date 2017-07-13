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
 * 框架合同台账
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="bas_frame_contract")
public class BasFrameContract implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月12日 上午9:55:38 
	*/
	private static final long serialVersionUID = 7002792777715756060L;

	public BasFrameContract() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BAS_FRAME_CONTRACT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BAS_FRAME_CONTRACT_ID_GENERATOR", strategy="native")	
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
	
	@Column(name="dealer", nullable=true, length=50)	
	private String dealer;
	
	@Column(name="expenditure_type", nullable=true, length=10)	
	private Integer expenditureType;
	
	@Column(name="contract_name", nullable=true, length=255)	
	private String contractName;
	
	@Column(name="contract_code", nullable=true, length=50)	
	private String contractCode;
	
	@Column(name="start_time", nullable=true)	
	private java.sql.Timestamp startTime;
	
	@Column(name="approval_time", nullable=true)	
	private java.sql.Timestamp approvalTime;
	
	@Column(name="paper_revise_time", nullable=true)	
	private java.sql.Timestamp paperReviseTime;
	
	@Column(name="framework_contract_name", nullable=true, length=255)	
	private String frameworkContractName;
	
	@Column(name="purchasing_way", nullable=true, length=10)	
	private Integer purchasingWay;
	
	@Column(name="sole_source_scene", nullable=true, length=50)	
	private String soleSourceScene;
	
	@Column(name="sss_notice_status", nullable=true, length=50)	
	private String sssNoticeStatus;
	
	@Column(name="frame_categories", nullable=true, length=10)	
	private Integer frameCategories;
	
	@Column(name="frame_contract_code", nullable=true, length=50)	
	private String frameContractCode;
	
	@Column(name="adversary", nullable=true, length=50)	
	private String adversary;
	
	@Column(name="contract_in_tax", nullable=true, length=50)	
	private String contractInTax;
	
	@Column(name="contract_tax", nullable=true, length=50)	
	private String contractTax;
	
	@Column(name="contract_no_tax", nullable=true, length=50)	
	private String contractNoTax;
	
	@Column(name="typein_erp_status", nullable=true, length=10)	
	private Integer typeinErpStatus;
	
	@Column(name="erp_proj_code", nullable=true, length=50)	
	private String erpProjCode;
	
	@Column(name="proj_setup_name", nullable=true, length=50)	
	private String projSetupName;
	
	@Column(name="year", nullable=true, length=50)	
	private String year;
	
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
