package com.zq.vo.basic.datamap;

/**
 * 产品直销收入
 */

public class BasProductIncomeVO {	
	
	private int id;
	
	private Integer companyId;
	
	private java.sql.Timestamp createTime;
	
	private String creator;
	
	private java.sql.Timestamp modifyTime;
	
	private String lastReviser;
	
	private String productCode;
	
	private String year;
	
	private String jan;
	
	private String feb;
		
	private String mar;
	
	private String apr;
	
	private String may;
	
	private String jun;
	
	private String jul;
		
	private String aug;
		
	private String sep;
		
	private String oct;
		
	private String nov;
		
	private String dece;
	
	/**
	 * ID
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * id
	 */
	public void setId(int id) {
		this.id = id;
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
