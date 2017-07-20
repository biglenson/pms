package com.zq.vo.basic.purchase;
/**
 * 其他合同台账
 */

public class BasOtherContractVO {

	private int id;
		
	private Integer companyId;
	
	private java.sql.Timestamp createTime;
	
	private String creator;
	
	private java.sql.Timestamp modifyTime;
	
	private String lastReviser;
	
	private String deptment;
		
	private String dealer;
	
	private String contractCode;
		
	private String contractName;
	
	private String supplierName;
	
	private String contractInTax;
	
	private String contractTax;
		
	private String contractNoTax;
		
	private String supplierContacter;
		
	private String supplierContactPhone;
	
	private Integer typeinErpStatus;
	
	private String projCode;
	
	private String projSetupName;
	
	private String description;
	
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
	 * 合同承办部门 
	 */
	public void setDeptment(String value) {
		this.deptment = value;
	}
	
	/**
	 * 合同承办部门 
	 */
	public String getDeptment() {
		return deptment;
	}
	
	/**
	 * 合同承办人 
	 */
	public void setDealer(String value) {
		this.dealer = value;
	}
	
	/**
	 * 合同承办人 
	 */
	public String getDealer() {
		return dealer;
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
	 * 供应商联系人的联系方式 
	 */
	public void setSupplierContactPhone(String value) {
		this.supplierContactPhone = value;
	}
	
	/**
	 * 供应商联系人的联系方式 
	 */
	public String getSupplierContactPhone() {
		return supplierContactPhone;
	}
	
	/**
	 * 是否录入ERP系统 
	 */
	public void setTypein_erp_status(int value) {
		setTypein_erp_status(new Integer(value));
	}
	
	/**
	 * 是否录入ERP系统 
	 */
	public void setTypeinErpStatus(Integer value) {
		this.typeinErpStatus = value;
	}
	
	/**
	 * 是否录入ERP系统 
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
	 * 备注 代码表：是否代码表
	 */
	public void setDescription(String value) {
		this.description = value;
	}
	
	/**
	 * 备注 代码表：是否代码表
	 */
	public String getDescription() {
		return description;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
