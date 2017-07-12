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
	
	@Column(name="contract_code", nullable=true, length=50)	
	private String contract_code;
	
	@Column(name="contract_name", nullable=true, length=255)	
	private String contract_name;
	
	@Column(name="supplier_name", nullable=true, length=50)	
	private String supplier_name;
	
	@Column(name="contract_in_tax", nullable=true, length=50)	
	private String contract_in_tax;
	
	@Column(name="contract_tax", nullable=true, length=50)	
	private String contract_tax;
	
	@Column(name="contract_no_tax", nullable=true, length=50)	
	private String contract_no_tax;
	
	@Column(name="supplier_contacter", nullable=true, length=50)	
	private String supplier_contacter;
	
	@Column(name="supplier_contact_phone", nullable=true, length=50)	
	private String supplier_contact_phone;
	
	@Column(name="typein_erp_status", nullable=true, length=10)	
	private Integer typein_erp_status;
	
	@Column(name="proj_code", nullable=true, length=50)	
	private String proj_code;
	
	@Column(name="proj_setup_name", nullable=true, length=50)	
	private String proj_setup_name;
	
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
	 * 供应商联系人的联系方式 
	 */
	public void setSupplier_contact_phone(String value) {
		this.supplier_contact_phone = value;
	}
	
	/**
	 * 供应商联系人的联系方式 
	 */
	public String getSupplier_contact_phone() {
		return supplier_contact_phone;
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
	public void setTypein_erp_status(Integer value) {
		this.typein_erp_status = value;
	}
	
	/**
	 * 是否录入ERP系统 
	 */
	public Integer getTypein_erp_status() {
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
