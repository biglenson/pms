package com.zq.entity.system;

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
 * 字典表
 */
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="sys_dic")
public class SysDic implements Serializable {
	/** 
	* <p>Title: </p> 
	* <p>Description: </p> 
	* @date 2017年8月2日 上午9:44:59 
	*/
	private static final long serialVersionUID = 1L;

	public SysDic() {
	}
	
	@Column(name="id", nullable=false, length=11)	
	@Id	
	@GeneratedValue(generator="SYS_DIC_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="SYS_DIC_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="classcode", nullable=true, length=255)	
	private String classcode;
	
	@Column(name="classname", nullable=true, length=255)	
	private String classname;
	
	@Column(name="code", nullable=true, length=11)	
	private Integer code;
	
	@Column(name="name", nullable=true, length=255)	
	private String name;
	
	@Column(name="description", nullable=true, length=255)	
	private String description;
	
	@Column(name="seqno", nullable=true, length=11)	
	private Integer seqno;
	
	@Column(name="status", nullable=true, length=11)	
	private Integer status;
	
	/**
	 * id
	 */
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	/**
	 * 字典类
	 */
	public void setClasscode(String value) {
		this.classcode = value;
	}
	
	/**
	 * 字典类
	 */
	public String getClasscode() {
		return classcode;
	}
	
	/**
	 * 字典类名
	 */
	public void setClassname(String value) {
		this.classname = value;
	}
	
	/**
	 * 字典类名
	 */
	public String getClassname() {
		return classname;
	}
	
	/**
	 * 代码
	 */
	public void setCode(int value) {
		setCode(new Integer(value));
	}
	
	/**
	 * 代码
	 */
	public void setCode(Integer value) {
		this.code = value;
	}
	
	/**
	 * 代码
	 */
	public Integer getCode() {
		return code;
	}
	
	/**
	 * 名称
	 */
	public void setName(String value) {
		this.name = value;
	}
	
	/**
	 * 名称
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 描述
	 */
	public void setDescription(String value) {
		this.description = value;
	}
	
	/**
	 * 描述
	 */
	public String getDescription() {
		return description;
	}
	
	public void setSeqno(int value) {
		setSeqno(new Integer(value));
	}
	
	public void setSeqno(Integer value) {
		this.seqno = value;
	}
	
	public Integer getSeqno() {
		return seqno;
	}
	
	/**
	 * 状态
	 */
	public void setStatus(int value) {
		setStatus(new Integer(value));
	}
	
	/**
	 * 状态
	 */
	public void setStatus(Integer value) {
		this.status = value;
	}
	
	/**
	 * 状态
	 */
	public Integer getStatus() {
		return status;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
