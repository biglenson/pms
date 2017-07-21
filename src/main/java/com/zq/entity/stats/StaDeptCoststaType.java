package com.zq.entity.stats;
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
 * 部门按类型成本统计
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="sta_dept_coststa_type")
public class StaDeptCoststaType implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年7月21日 上午8:21:38 
	*/
	private static final long serialVersionUID = -632717204073115748L;

	public StaDeptCoststaType() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="STADEPTCOSTSTATYPE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="STADEPTCOSTSTATYPE_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="company_id", nullable=true, length=10)	
	private Integer companyId;
	
	@Column(name="year", nullable=true, length=10)	
	private Integer year;
	
	@Column(name="month", nullable=true, length=10)	
	private Integer month;
	
	@Column(name="dept_id", nullable=true, length=10)	
	private Integer deptId;
	
	@Column(name="type_id", nullable=true, length=50)	
	private Integer typeId;
	
	@Column(name="cost", nullable=true, precision=20, scale=3)	
	private java.math.BigDecimal cost;
	
	@Column(name="dept_name", nullable=true, length=255)	
	private String deptName;
	
	@Column(name="type_name", nullable=true, length=255)	
	private String typeName;
	
	@Column(name="seq", nullable=true, length=10)	
	private Integer seq;
	
	@Column(name="modify_time", nullable=true)	
	private java.sql.Timestamp modifyTime;
	
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
	 * 年
	 */
	public void setYear(int value) {
		setYear(new Integer(value));
	}
	
	/**
	 * 年
	 */
	public void setYear(Integer value) {
		this.year = value;
	}
	
	/**
	 * 年
	 */
	public Integer getYear() {
		return year;
	}
	
	/**
	 * 月
	 */
	public void setMonth(int value) {
		setMonth(new Integer(value));
	}
	
	/**
	 * 月
	 */
	public void setMonth(Integer value) {
		this.month = value;
	}
	
	/**
	 * 月
	 */
	public Integer getMonth() {
		return month;
	}
	
	/**
	 * 部门ID
	 */
	public void setDeptId(int value) {
		setDeptId(new Integer(value));
	}
	
	/**
	 * 部门ID
	 */
	public void setDeptId(Integer value) {
		this.deptId = value;
	}
	
	/**
	 * 部门ID
	 */
	public Integer getDeptId() {
		return deptId;
	}
	
	/**
	 * 类型ID
	 */
	public void setTypeId(int value) {
		setTypeId(new Integer(value));
	}
	
	/**
	 * 类型ID
	 */
	public void setTypeId(Integer value) {
		this.typeId = value;
	}
	
	/**
	 * 类型ID
	 */
	public Integer getTypeId() {
		return typeId;
	}
	
	/**
	 * 成本
	 */
	public void setCost(java.math.BigDecimal value) {
		this.cost = value;
	}
	
	/**
	 * 成本
	 */
	public java.math.BigDecimal getCost() {
		return cost;
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
	 * 类型名称
	 */
	public void setTypeName(String value) {
		this.typeName = value;
	}
	
	/**
	 * 类型名称
	 */
	public String getTypeName() {
		return typeName;
	}
	
	/**
	 * 序号 同部门序号，用于部门排序
	 */
	public void setSeq(int value) {
		setSeq(new Integer(value));
	}
	
	/**
	 * 序号 同部门序号，用于部门排序
	 */
	public void setSeq(Integer value) {
		this.seq = value;
	}
	
	/**
	 * 序号 同部门序号，用于部门排序
	 */
	public Integer getSeq() {
		return seq;
	}
	
	/**
	 * 最后更新时间
	 */
	public void setModifyTime(java.sql.Timestamp value) {
		this.modifyTime = value;
	}
	
	/**
	 * 最后更新时间
	 */
	public java.sql.Timestamp getModifyTime() {
		return modifyTime;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
