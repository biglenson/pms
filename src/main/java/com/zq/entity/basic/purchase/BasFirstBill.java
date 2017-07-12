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
	private Integer company_id;
	
	@Column(name="create_time", nullable=true)	
	private java.sql.Timestamp create_time;
	
	@Column(name="create_by", nullable=true, length=50)	
	private String create_by;
	
	@Column(name="last_update_time", nullable=true)	
	private java.sql.Timestamp last_update_time;
	
	@Column(name="last_update_by", nullable=true, length=50)	
	private String last_update_by;
	
	@Column(name="purchasing_dept", nullable=true, length=50)	
	private String purchasing_dept;
	
	@Column(name="purchasing_dealer", nullable=true, length=50)	
	private String purchasing_dealer;
	
	@Column(name="expenditure_type", nullable=true, length=10)	
	private Integer expenditure_type;
	
	@Column(name="category", nullable=true, length=10)	
	private Integer category;
	
	@Column(name="main_categories", nullable=true, length=50)	
	private String main_categories;
	
	@Column(name="secondary_categories", nullable=true, length=50)	
	private String secondary_categories;
	
	@Column(name="purchasing_type", nullable=true, length=10)	
	private Integer purchasing_type;
	
	@Column(name="contract_approve_time", nullable=true)	
	private java.sql.Timestamp contract_approve_time;
	
	@Column(name="paper_contract_revise_time", nullable=true)	
	private java.sql.Timestamp paper_contract_revise_time;
	
	@Column(name="frame_validatity_time", nullable=true, length=50)	
	private String frame_validatity_time;
	
	@Column(name="supplier_name", nullable=true, length=50)	
	private String supplier_name;
	
	@Column(name="supplier_contacter", nullable=true, length=50)	
	private String supplier_contacter;
	
	@Column(name="supplier_contact_phone", nullable=true, length=50)	
	private String supplier_contact_phone;
	
	@Column(name="typein_erp_status", nullable=true, length=10)	
	private Integer typein_erp_status;
	
	@Column(name="proj_code", nullable=true, length=50)	
	private String proj_code;
	
	@Column(name="proj_setup_name", nullable=true, length=255)	
	private String proj_setup_name;
	
	@Column(name="year", nullable=true, length=50)	
	private String year;
	
	@Column(name="contract_code", nullable=true, length=50)	
	private String contract_code;
	
	@Column(name="contract_name", nullable=true, length=255)	
	private String contract_name;
	
	@Column(name="contract_frame_status", nullable=true, length=10)	
	private Integer contract_frame_status;
	
	@Column(name="contract_in_tax", nullable=true, length=50)	
	private String contract_in_tax;
	
	@Column(name="contract_tax", nullable=true, length=50)	
	private String contract_tax;
	
	@Column(name="contract_no_tax", nullable=true, length=50)	
	private String contract_no_tax;
	
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
	public void setCreate_by(String value) {
		this.create_by = value;
	}
	
	/**
	 * 创建人
	 */
	public String getCreate_by() {
		return create_by;
	}
	
	/**
	 * 最后修改时间
	 */
	public void setLast_update_time(java.sql.Timestamp value) {
		this.last_update_time = value;
	}
	
	/**
	 * 最后修改时间
	 */
	public java.sql.Timestamp getLast_update_time() {
		return last_update_time;
	}
	
	/**
	 * 修改人
	 */
	public void setLast_update_by(String value) {
		this.last_update_by = value;
	}
	
	/**
	 * 修改人
	 */
	public String getLast_update_by() {
		return last_update_by;
	}
	
	/**
	 * 采购承办部门 
	 */
	public void setPurchasing_dept(String value) {
		this.purchasing_dept = value;
	}
	
	/**
	 * 采购承办部门 
	 */
	public String getPurchasing_dept() {
		return purchasing_dept;
	}
	
	/**
	 * 采购承办人 
	 */
	public void setPurchasing_dealer(String value) {
		this.purchasing_dealer = value;
	}
	
	/**
	 * 采购承办人 
	 */
	public String getPurchasing_dealer() {
		return purchasing_dealer;
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
	public void setExpenditure_type(Integer value) {
		this.expenditure_type = value;
	}
	
	/**
	 * 开支类型 代码表：开支类型代码表
	 */
	public Integer getExpenditure_type() {
		return expenditure_type;
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
	public void setMain_categories(String value) {
		this.main_categories = value;
	}
	
	/**
	 * 大类 
	 */
	public String getMain_categories() {
		return main_categories;
	}
	
	/**
	 * 中类 
	 */
	public void setSecondary_categories(String value) {
		this.secondary_categories = value;
	}
	
	/**
	 * 中类 
	 */
	public String getSecondary_categories() {
		return secondary_categories;
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
	public void setPurchasing_type(Integer value) {
		this.purchasing_type = value;
	}
	
	/**
	 * 采购类型 代码表：采购类型代码表
	 */
	public Integer getPurchasing_type() {
		return purchasing_type;
	}
	
	/**
	 * 完成合同审批时间 
	 */
	public void setContract_approve_time(java.sql.Timestamp value) {
		this.contract_approve_time = value;
	}
	
	/**
	 * 完成合同审批时间 
	 */
	public java.sql.Timestamp getContract_approve_time() {
		return contract_approve_time;
	}
	
	/**
	 * 完成纸质版合同签订时间 
	 */
	public void setPaper_contract_revise_time(java.sql.Timestamp value) {
		this.paper_contract_revise_time = value;
	}
	
	/**
	 * 完成纸质版合同签订时间 
	 */
	public java.sql.Timestamp getPaper_contract_revise_time() {
		return paper_contract_revise_time;
	}
	
	/**
	 * 框架有效期 
	 */
	public void setFrame_validatity_time(String value) {
		this.frame_validatity_time = value;
	}
	
	/**
	 * 框架有效期 
	 */
	public String getFrame_validatity_time() {
		return frame_validatity_time;
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
	 * 供应商联系人联系方式 
	 */
	public void setSupplier_contact_phone(String value) {
		this.supplier_contact_phone = value;
	}
	
	/**
	 * 供应商联系人联系方式 
	 */
	public String getSupplier_contact_phone() {
		return supplier_contact_phone;
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
	public void setTypein_erp_status(Integer value) {
		this.typein_erp_status = value;
	}
	
	/**
	 * 是否需录入ERP系统 代码表：是否代码
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
	 * 是否是框架 代码表：是否
	 */
	public void setContract_frame_status(int value) {
		setContract_frame_status(new Integer(value));
	}
	
	/**
	 * 是否是框架 代码表：是否
	 */
	public void setContract_frame_status(Integer value) {
		this.contract_frame_status = value;
	}
	
	/**
	 * 是否是框架 代码表：是否
	 */
	public Integer getContract_frame_status() {
		return contract_frame_status;
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
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
