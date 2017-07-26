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
 * 一级集采台账
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="bas_first_bill")
public class BasFirstBill implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月12日 上午9:54:17 
	*/
	private static final long serialVersionUID = 1135953585289361363L;

	public BasFirstBill() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BAS_FIRST_BILL_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BAS_FIRST_BILL_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="company_id", nullable=true, length=10)	
	private Integer companyId;
	
	@Column(name="create_time", nullable=true)	
	private java.sql.Timestamp create_time;
	
	@Column(name="creator", nullable=true, length=50)	
	private String creator;
	
	@Column(name="modify_time", nullable=true)	
	private java.sql.Timestamp modifyTime;
	
	@Column(name="last_reviser", nullable=true, length=50)	
	private String lastReviser;
	
	@Column(name="purchasing_dept", nullable=true, length=50)	
	private String purchasingDept;
	
	@Column(name="purchasing_dealer", nullable=true, length=50)	
	private String purchasingDealer;
	
	@Column(name="expenditure_type", nullable=true, length=10)	
	private Integer expenditureType;
	
	@Column(name="category", nullable=true, length=10)	
	private Integer category;
	
	@Column(name="main_categories", nullable=true, length=50)	
	private String mainCategories;
	
	@Column(name="secondary_categories", nullable=true, length=50)	
	private String secondaryCategories;
	
	@Column(name="purchasing_type", nullable=true, length=10)	
	private Integer purchasingType;
	
	@Column(name="contract_approve_time", nullable=true)	
	private java.sql.Timestamp contractApproveTime;
	
	@Column(name="paper_contract_revise_time", nullable=true)	
	private java.sql.Timestamp paperContractReviseTime;
	
	@Column(name="frame_validatity_time", nullable=true, length=50)	
	private String frameValidatityTime;
	
	@Column(name="supplier_name", nullable=true, length=50)	
	private String supplierName;
	
	@Column(name="supplier_contacter", nullable=true, length=50)	
	private String supplierContacter;
	
	@Column(name="supplier_contact_phone", nullable=true, length=50)	
	private String supplierContactPhone;
	
	@Column(name="typein_erp_status", nullable=true, length=10)	
	private Integer typeinErpStatus;
	
	@Column(name="proj_code", nullable=true, length=50)	
	private String projCode;
	
	@Column(name="proj_setup_name", nullable=true, length=255)	
	private String projSetupName;
	
	@Column(name="year", nullable=true, length=50)	
	private String year;
	
	@Column(name="contract_code", nullable=true, length=50)	
	private String contractCode;
	
	@Column(name="contract_name", nullable=true, length=255)	
	private String contractName;
	
	@Column(name="contract_frame_status", nullable=true, length=10)	
	private Integer contractFrameStatus;
	
	@Column(name="contract_in_tax", nullable=true, length=50)	
	private String contractInTax;
	
	@Column(name="contract_tax", nullable=true, length=50)	
	private String contractTax;
	
	@Column(name="contract_no_tax", nullable=true, length=50)	
	private String contractNoTax;
	
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
	public void setCreateBy(String value) {
		this.creator = value;
	}
	
	/**
	 * 创建人
	 */
	public String getCreateBy() {
		return creator;
	}
	
	/**
	 * 最后修改时间
	 */
	public void setLastUpdateTime(java.sql.Timestamp value) {
		this.modifyTime = value;
	}
	
	/**
	 * 最后修改时间
	 */
	public java.sql.Timestamp getLastUpdateTime() {
		return modifyTime;
	}
	
	/**
	 * 修改人
	 */
	public void setLastUpdateBy(String value) {
		this.lastReviser = value;
	}
	
	/**
	 * 修改人
	 */
	public String getLastUpdateBy() {
		return lastReviser;
	}
	
	/**
	 * 采购承办部门 
	 */
	public void setPurchasingDept(String value) {
		this.purchasingDept = value;
	}
	
	/**
	 * 采购承办部门 
	 */
	public String getPurchasingDept() {
		return purchasingDept;
	}
	
	/**
	 * 采购承办人 
	 */
	public void setPurchasingDealer(String value) {
		this.purchasingDealer = value;
	}
	
	/**
	 * 采购承办人 
	 */
	public String getPurchasingDealer() {
		return purchasingDealer;
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
	 * 采购类型 代码表：采购类型代码表
	 */
	public void setPurchasing_type(int value) {
		setPurchasing_type(new Integer(value));
	}
	
	/**
	 * 采购类型 代码表：采购类型代码表
	 */
	public void setPurchasingType(Integer value) {
		this.purchasingType = value;
	}
	
	/**
	 * 采购类型 代码表：采购类型代码表
	 */
	public Integer getPurchasingType() {
		return purchasingType;
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
	public void setPaperContractReviseTime(java.sql.Timestamp value) {
		this.paperContractReviseTime = value;
	}
	
	/**
	 * 完成纸质版合同签订时间 
	 */
	public java.sql.Timestamp getPaperContractReviseTime() {
		return paperContractReviseTime;
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
	public void setSupplier_name(String value) {
		this.supplierName = value;
	}
	
	/**
	 * 成交供应商名称 
	 */
	public String getSupplier_name() {
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
	 * 是否需录入ERP系统 代码表：是否代码
	 */
	public void setTypein_erp_status(int value) {
		setTypein_erp_status(new Integer(value));
	}
	
	/**
	 * 是否需录入ERP系统 代码表：是否代码
	 */
	public void setTypeinErpStatus(Integer value) {
		this.typeinErpStatus = value;
	}
	
	/**
	 * 是否需录入ERP系统 代码表：是否代码
	 */
	public Integer getTypeinErpStatus() {
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
	 * 是否是框架 代码表：是否
	 */
	public void setContract_frame_status(int value) {
		setContract_frame_status(new Integer(value));
	}
	
	/**
	 * 是否是框架 代码表：是否
	 */
	public void setContractFrameStatus(Integer value) {
		this.contractFrameStatus = value;
	}
	
	/**
	 * 是否是框架 代码表：是否
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
