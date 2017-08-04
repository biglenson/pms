package com.zq.entity.process;
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
import java.util.*;

@Entity
@Table(name="g_benefit_eval_tpl")
public class BenefitEvalTpl implements Serializable {
	public BenefitEvalTpl() {
	}
	
	@Column(name="tplID", nullable=false, length=11)	
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tplID;
	
	@Column(name="tplTitle", nullable=false, length=255)	
	private String tplTitle;
	
	@Column(name="evalPhase", nullable=true, length=11)	
	private Integer evalPhase;
	
	@Column(name="evalFor", nullable=false, length=11)	
	private int evalFor;
	
	@Column(name="createTime", nullable=false)	
	private java.sql.Timestamp createTime;
	
	@Column(name="listOrder", nullable=false, length=11)	
	private int listOrder;
	
	@Column(name="version", nullable=true, length=50)	
	private String version;
	
	@Column(name="templateDesc", nullable=true, length=255)	
	private String templateDesc;
	
	public int getTplID() {
		return tplID;
	}
	
	public void setTplTitle(String value) {
		this.tplTitle = value;
	}
	
	public String getTplTitle() {
		return tplTitle;
	}
	
	public void setEvalPhase(int value) {
		setEvalPhase(new Integer(value));
	}
	
	public void setEvalPhase(Integer value) {
		this.evalPhase = value;
	}
	
	public Integer getEvalPhase() {
		return evalPhase;
	}
	
	public void setEvalFor(int value) {
		this.evalFor = value;
	}
	
	public int getEvalFor() {
		return evalFor;
	}
	
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
	
	public java.sql.Timestamp getCreateTime() {
		return createTime;
	}
	
	public void setListOrder(int value) {
		this.listOrder = value;
	}
	
	public int getListOrder() {
		return listOrder;
	}
	
	public void setVersion(String value) {
		this.version = value;
	}
	
	public String getVersion() {
		return version;
	}
	
	public void setTemplateDesc(String value) {
		this.templateDesc = value;
	}
	
	public String getTemplateDesc() {
		return templateDesc;
	}
	
	public String toString() {
		return String.valueOf(getTplID());
	}
	
}
