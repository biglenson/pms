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
	private Integer company_id;
	
	@Column(name="create_time", nullable=true)	
	private java.sql.Timestamp create_time;
	
	@Column(name="creator", nullable=true, length=50)	
	private String creator;
	
	@Column(name="modify_time", nullable=true)	
	private java.sql.Timestamp modify_time;
	
	@Column(name="last_reviser", nullable=true, length=50)	
	private String last_reviser;
	
	@Column(name="dealer", nullable=true, length=50)	
	private String dealer;
	
	@Column(name="expenditure_type", nullable=true, length=10)	
	private Integer expenditure_type;
	
	@Column(name="contract_name", nullable=true, length=255)	
	private String contract_name;
	
	@Column(name="contract_code", nullable=true, length=50)	
	private String contract_code;
	
	@Column(name="start_time", nullable=true)	
	private java.sql.Timestamp start_time;
	
	@Column(name="approval_time", nullable=true)	
	private java.sql.Timestamp approval_time;
	
	@Column(name="paper_revise_time", nullable=true)	
	private java.sql.Timestamp paper_revise_time;
	
	@Column(name="framework_contract_name", nullable=true, length=255)	
	private String framework_contract_name;
	
	@Column(name="purchasing_way", nullable=true, length=10)	
	private Integer purchasing_way;
	
	@Column(name="sole_source_scene", nullable=true, length=50)	
	private String sole_source_scene;
	
	@Column(name="sss_notice_status", nullable=true, length=50)	
	private String sss_notice_status;
	
	@Column(name="frame_categories", nullable=true, length=10)	
	private Integer frame_categories;
	
	@Column(name="frame_contract_code", nullable=true, length=50)	
	private String frame_contract_code;
	
	@Column(name="adversary", nullable=true, length=50)	
	private String adversary;
	
	@Column(name="contract_in_tax", nullable=true, length=50)	
	private String contract_in_tax;
	
	@Column(name="contract_tax", nullable=true, length=50)	
	private String contract_tax;
	
	@Column(name="contract_no_tax", nullable=true, length=50)	
	private String contract_no_tax;
	
	@Column(name="typein_erp_status", nullable=true, length=10)	
	private Integer typein_erp_status;
	
	@Column(name="erp_proj_code", nullable=true, length=50)	
	private String erp_proj_code;
	
	@Column(name="proj_setup_name", nullable=true, length=50)	
	private String proj_setup_name;
	
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
	 * 订单/框架下合同名称 
	 */
	public void setContract_name(String value) {
		this.contract_name = value;
	}
	
	/**
	 * 订单/框架下合同名称 
	 */
	public String getContract_name() {
		return contract_name;
	}
	
	/**
	 * 订单/框架下合同编号 
	 */
	public void setContract_code(String value) {
		this.contract_code = value;
	}
	
	/**
	 * 订单/框架下合同编号 
	 */
	public String getContract_code() {
		return contract_code;
	}
	
	/**
	 * 启动时间 
	 */
	public void setStart_time(java.sql.Timestamp value) {
		this.start_time = value;
	}
	
	/**
	 * 启动时间 
	 */
	public java.sql.Timestamp getStart_time() {
		return start_time;
	}
	
	/**
	 * 领导审批时间 
	 */
	public void setApproval_time(java.sql.Timestamp value) {
		this.approval_time = value;
	}
	
	/**
	 * 领导审批时间 
	 */
	public java.sql.Timestamp getApproval_time() {
		return approval_time;
	}
	
	/**
	 * 完成纸质版签订时间 
	 */
	public void setPaper_revise_time(java.sql.Timestamp value) {
		this.paper_revise_time = value;
	}
	
	/**
	 * 完成纸质版签订时间 
	 */
	public java.sql.Timestamp getPaper_revise_time() {
		return paper_revise_time;
	}
	
	/**
	 * 框架合同名称 
	 */
	public void setFramework_contract_name(String value) {
		this.framework_contract_name = value;
	}
	
	/**
	 * 框架合同名称 
	 */
	public String getFramework_contract_name() {
		return framework_contract_name;
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
	public void setPurchasing_way(Integer value) {
		this.purchasing_way = value;
	}
	
	/**
	 * 框架采购方式 代码表：集采采购方式代码表
	 */
	public Integer getPurchasing_way() {
		return purchasing_way;
	}
	
	/**
	 * 单一来源场景 
	 */
	public void setSole_source_scene(String value) {
		this.sole_source_scene = value;
	}
	
	/**
	 * 单一来源场景 
	 */
	public String getSole_source_scene() {
		return sole_source_scene;
	}
	
	/**
	 * 单一来源是否发公告 
	 */
	public void setSss_notice_status(String value) {
		this.sss_notice_status = value;
	}
	
	/**
	 * 单一来源是否发公告 
	 */
	public String getSss_notice_status() {
		return sss_notice_status;
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
	public void setFrame_categories(Integer value) {
		this.frame_categories = value;
	}
	
	/**
	 * 框架品类 代码表：  采购品类代码表
	 */
	public Integer getFrame_categories() {
		return frame_categories;
	}
	
	/**
	 * 框架合同编号 
	 */
	public void setFrame_contract_code(String value) {
		this.frame_contract_code = value;
	}
	
	/**
	 * 框架合同编号 
	 */
	public String getFrame_contract_code() {
		return frame_contract_code;
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
	public void setContract_in_tax(String value) {
		this.contract_in_tax = value;
	}
	
	/**
	 * 订单/框架下合同含税金额 
	 */
	public String getContract_in_tax() {
		return contract_in_tax;
	}
	
	/**
	 * 订单/框架下合同税额 
	 */
	public void setContract_tax(String value) {
		this.contract_tax = value;
	}
	
	/**
	 * 订单/框架下合同税额 
	 */
	public String getContract_tax() {
		return contract_tax;
	}
	
	/**
	 * 订单/框架下合同不含税金额 
	 */
	public void setContract_no_tax(String value) {
		this.contract_no_tax = value;
	}
	
	/**
	 * 订单/框架下合同不含税金额 
	 */
	public String getContract_no_tax() {
		return contract_no_tax;
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
	public void setTypein_erp_status(Integer value) {
		this.typein_erp_status = value;
	}
	
	/**
	 * 是否需录入ERP系统 代码表：是否代码表
	 */
	public Integer getTypein_erp_status() {
		return typein_erp_status;
	}
	
	/**
	 * ERP项目编号 
	 */
	public void setErp_proj_code(String value) {
		this.erp_proj_code = value;
	}
	
	/**
	 * ERP项目编号 
	 */
	public String getErp_proj_code() {
		return erp_proj_code;
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
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
