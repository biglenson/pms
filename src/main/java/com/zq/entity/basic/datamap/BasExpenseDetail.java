package com.zq.entity.basic.datamap;
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
 * 费用明细
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="bas_expense_detail")
public class BasExpenseDetail implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月16日 下午11:11:21 
	*/
	private static final long serialVersionUID = -4927837210490736154L;

	public BasExpenseDetail() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BASEXPENSEDETAIL_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASEXPENSEDETAIL_ID_GENERATOR", strategy="native")	
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
	
	@Column(name="dept_name", nullable=true, length=50)	
	private String deptName;
	
	@Column(name="dept_code", nullable=true, length=50)	
	private String deptCode;
	
	@Column(name="budget_code", nullable=true, length=50)	
	private String budgetCode;
	
	@Column(name="budget_name", nullable=true, length=255)	
	private String budgetName;
	
	@Column(name="industry", nullable=true, length=50)	
	private String industry;
	
	@Column(name="prod_code", nullable=true, length=50)	
	private String prodCode;
	
	@Column(name="supplier_code", nullable=true, length=50)	
	private String supplierCode;
	
	@Column(name="supplier_name", nullable=true, length=50)	
	private String supplierName;
	
	@Column(name="module", nullable=true, length=50)	
	private String module;
	
	@Column(name="expense_subject_code", nullable=true, length=50)	
	private String expenseSubjectCode;
	
	@Column(name="customer", nullable=true, length=50)	
	private String customer;
	
	@Column(name="charge_account_year", nullable=true, length=50)	
	private String chargeAccountYear;
	
	@Column(name="charge_account_month", nullable=true, length=50)	
	private String chargeAccountMonth;
	
	@Column(name="bank_code", nullable=true, length=50)	
	private String bankCode;
	
	@Column(name="amount", nullable=true, length=50)	
	private String amount;
	
	@Column(name="charge_account_date", nullable=true)	
	private java.sql.Timestamp chargeAccountDate;
	
	@Column(name="account_sets", nullable=true, length=50)	
	private String accountSets;
	
	@Column(name="description", nullable=true)	
	private String description;
	
	@Column(name="voucher_code", nullable=true, length=50)	
	private String voucherCode;
	
	@Column(name="bill_code", nullable=true, length=255)	
	private String billCode;
	
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
	 * 部门名称 
	 */
	public void setDeptName(String value) {
		this.deptName = value;
	}
	
	/**
	 * 部门名称 
	 */
	public String getDeptName() {
		return deptName;
	}
	
	/**
	 * 部门代码 
	 */
	public void setDeptCode(String value) {
		this.deptCode = value;
	}
	
	/**
	 * 部门代码 
	 */
	public String getDeptCode() {
		return deptCode;
	}
	
	/**
	 * 预算项目编号 
	 */
	public void setBudgetCode(String value) {
		this.budgetCode = value;
	}
	
	/**
	 * 预算项目编号 
	 */
	public String getBudgetCode() {
		return budgetCode;
	}
	
	/**
	 * 预算项目名称
	 */
	public void setBudgetName(String value) {
		this.budgetName = value;
	}
	
	/**
	 * 预算项目名称
	 */
	public String getBudgetName() {
		return budgetName;
	}
	
	/**
	 * 行业 
	 */
	public void setIndustry(String value) {
		this.industry = value;
	}
	
	/**
	 * 行业 
	 */
	public String getIndustry() {
		return industry;
	}
	
	/**
	 * 产品代码 
	 */
	public void setProdCode(String value) {
		this.prodCode = value;
	}
	
	/**
	 * 产品代码 
	 */
	public String getProdCode() {
		return prodCode;
	}
	
	/**
	 * 供应商编号 
	 */
	public void setSupplierCode(String value) {
		this.supplierCode = value;
	}
	
	/**
	 * 供应商编号 
	 */
	public String getSupplierCode() {
		return supplierCode;
	}
	
	/**
	 * 供应商名称 
	 */
	public void setSupplierName(String value) {
		this.supplierName = value;
	}
	
	/**
	 * 供应商名称 
	 */
	public String getSupplierName() {
		return supplierName;
	}
	
	/**
	 * 模块 
	 */
	public void setModule(String value) {
		this.module = value;
	}
	
	/**
	 * 模块 
	 */
	public String getModule() {
		return module;
	}
	
	/**
	 * 费用科目代码 
	 */
	public void setExpenseSubjectCode(String value) {
		this.expenseSubjectCode = value;
	}
	
	/**
	 * 费用科目代码 
	 */
	public String getExpenseSubjectCode() {
		return expenseSubjectCode;
	}
	
	/**
	 * 客户 
	 */
	public void setCustomer(String value) {
		this.customer = value;
	}
	
	/**
	 * 客户 
	 */
	public String getCustomer() {
		return customer;
	}
	
	/**
	 * 记账年 
	 */
	public void setChargeAccountYear(String value) {
		this.chargeAccountYear = value;
	}
	
	/**
	 * 记账年 
	 */
	public String getChargeAccountYear() {
		return chargeAccountYear;
	}
	
	/**
	 * 记账月 
	 */
	public void setChargeAccountMonth(String value) {
		this.chargeAccountMonth = value;
	}
	
	/**
	 * 记账月 
	 */
	public String getChargeAccountMonth() {
		return chargeAccountMonth;
	}
	
	/**
	 * 行号 
	 */
	public void setBankCode(String value) {
		this.bankCode = value;
	}
	
	/**
	 * 行号 
	 */
	public String getBankCode() {
		return bankCode;
	}
	
	/**
	 * 金额 
	 */
	public void setAmount(String value) {
		this.amount = value;
	}
	
	/**
	 * 金额 
	 */
	public String getAmount() {
		return amount;
	}
	
	/**
	 * 记账日期 
	 */
	public void setChargeAccountDate(java.sql.Timestamp value) {
		this.chargeAccountDate = value;
	}
	
	/**
	 * 记账日期 
	 */
	public java.sql.Timestamp getChargeAccountDate() {
		return chargeAccountDate;
	}
	
	/**
	 * 账户组合 
	 */
	public void setAccountSets(String value) {
		this.accountSets = value;
	}
	
	/**
	 * 账户组合 
	 */
	public String getAccountSets() {
		return accountSets;
	}
	
	/**
	 * 摘要 
	 */
	public void setDescription(String value) {
		this.description = value;
	}
	
	/**
	 * 摘要 
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * 凭证编号 
	 */
	public void setVoucherCode(String value) {
		this.voucherCode = value;
	}
	
	/**
	 * 凭证编号 
	 */
	public String getVoucherCode() {
		return voucherCode;
	}
	
	/**
	 * 发票编号 
	 */
	public void setBillCode(String value) {
		this.billCode = value;
	}
	
	/**
	 * 发票编号 
	 */
	public String getBillCode() {
		return billCode;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
