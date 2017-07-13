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
 * 其他合同台账
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="bas_other_contract")
public class BasOtherContract implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月12日 上午9:56:20 
	*/
	private static final long serialVersionUID = -6322164563402726019L;

	public BasOtherContract() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BAS_OTHER_CONTRACT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BAS_OTHER_CONTRACT_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="company_id", nullable=true, length=10)	
	private Integer companyId;
	
	@Column(name="create_time", nullable=true)	
	private java.sql.Timestamp createTime;
	
	@Column(name="creator", nullable=true, length=50)	
	private String creator;
	
	@Column(name="modifTtime", nullable=true)	
	private java.sql.Timestamp modifyTime;
	
	@Column(name="last_reviser", nullable=true, length=50)	
	private String lastReviser;
	
	@Column(name="deptment", nullable=true, length=50)	
	private String deptment;
	
	@Column(name="dealer", nullable=true, length=50)	
	private String dealer;
	
	@Column(name="contract_code", nullable=true, length=50)	
	private String contractCode;
	
	@Column(name="contract_name", nullable=true, length=255)	
	private String contractName;
	
	@Column(name="supplier_name", nullable=true, length=50)	
	private String supplierName;
	
	@Column(name="contract_in_tax", nullable=true, length=50)	
	private String contractInTax;
	
	@Column(name="contract_tax", nullable=true, length=50)	
	private String contractTax;
	
	@Column(name="contract_no_tax", nullable=true, length=50)	
	private String contractNoTax;
	
	@Column(name="supplier_contacter", nullable=true, length=50)	
	private String supplierContacter;
	
	@Column(name="supplier_contact_phone", nullable=true, length=50)	
	private String supplierContactPhone;
	
	@Column(name="typein_erp_status", nullable=true, length=10)	
	private Integer typeinErpStatus;
	
	@Column(name="proj_code", nullable=true, length=50)	
	private String projCode;
	
	@Column(name="proj_setup_name", nullable=true, length=50)	
	private String projSetupName;
	
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
