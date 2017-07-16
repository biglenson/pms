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
 * 产品直销收入
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="bas_product_income")
public class BasProductIncome implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月16日 下午11:07:59 
	*/
	private static final long serialVersionUID = -8298626694389028103L;

	public BasProductIncome() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="BASPRODUCTINCOME_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="BASPRODUCTINCOME_ID_GENERATOR", strategy="native")	
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
	
	@Column(name="product_code", nullable=true, length=50)	
	private String productCode;
	
	@Column(name="year", nullable=true, length=50)	
	private String year;
	
	@Column(name="jan", nullable=true, length=50)	
	private String jan;
	
	@Column(name="feb", nullable=true, length=50)	
	private String feb;
	
	@Column(name="mar", nullable=true, length=50)	
	private String mar;
	
	@Column(name="apr", nullable=true, length=50)	
	private String apr;
	
	@Column(name="may", nullable=true, length=50)	
	private String may;
	
	@Column(name="jun", nullable=true, length=50)	
	private String jun;
	
	@Column(name="jul", nullable=true, length=50)	
	private String jul;
	
	@Column(name="aug", nullable=true, length=50)	
	private String aug;
	
	@Column(name="sep", nullable=true, length=50)	
	private String sep;
	
	@Column(name="oct", nullable=true, length=50)	
	private String oct;
	
	@Column(name="nov", nullable=true, length=50)	
	private String nov;
	
	@Column(name="dece", nullable=true, length=50)	
	private String dece;
	
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
	 * 产品编号 bas_product中product_code
	 */
	public void setProductCode(String value) {
		this.productCode = value;
	}
	
	/**
	 * 产品编号 bas_product中product_code
	 */
	public String getProductCode() {
		return productCode;
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
	 * 一月 
	 */
	public void setJan(String value) {
		this.jan = value;
	}
	
	/**
	 * 一月 
	 */
	public String getJan() {
		return jan;
	}
	
	/**
	 * 二月 
	 */
	public void setFeb(String value) {
		this.feb = value;
	}
	
	/**
	 * 二月 
	 */
	public String getFeb() {
		return feb;
	}
	
	/**
	 * 三月 
	 */
	public void setMar(String value) {
		this.mar = value;
	}
	
	/**
	 * 三月 
	 */
	public String getMar() {
		return mar;
	}
	
	/**
	 * 四月 
	 */
	public void setApr(String value) {
		this.apr = value;
	}
	
	/**
	 * 四月 
	 */
	public String getApr() {
		return apr;
	}
	
	/**
	 * 五月 
	 */
	public void setMay(String value) {
		this.may = value;
	}
	
	/**
	 * 五月 
	 */
	public String getMay() {
		return may;
	}
	
	/**
	 * 六月 
	 */
	public void setJun(String value) {
		this.jun = value;
	}
	
	/**
	 * 六月 
	 */
	public String getJun() {
		return jun;
	}
	
	/**
	 * 七月 
	 */
	public void setJul(String value) {
		this.jul = value;
	}
	
	/**
	 * 七月 
	 */
	public String getJul() {
		return jul;
	}
	
	/**
	 * 八月 
	 */
	public void setAug(String value) {
		this.aug = value;
	}
	
	/**
	 * 八月 
	 */
	public String getAug() {
		return aug;
	}
	
	/**
	 * 九月 
	 */
	public void setSep(String value) {
		this.sep = value;
	}
	
	/**
	 * 九月 
	 */
	public String getSep() {
		return sep;
	}
	
	/**
	 * 十月 
	 */
	public void setOct(String value) {
		this.oct = value;
	}
	
	/**
	 * 十月 
	 */
	public String getOct() {
		return oct;
	}
	
	/**
	 * 十一月 
	 */
	public void setNov(String value) {
		this.nov = value;
	}
	
	/**
	 * 十一月 
	 */
	public String getNov() {
		return nov;
	}
	
	/**
	 * 十二月 
	 */
	public void setDece(String value) {
		this.dece = value;
	}
	
	/**
	 * 十二月 
	 */
	public String getDece() {
		return dece;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
