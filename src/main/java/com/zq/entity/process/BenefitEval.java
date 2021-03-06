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
@Table(name="d_benefit_eval")
public class BenefitEval implements Serializable {
	public BenefitEval() {
	}
	
	@Column(name="evalID", nullable=false, length=11)	
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int evalID;
	
	@Column(name="processID", nullable=true, unique=true, length=50)	
	private String processID;
	
	@Column(name="evalCode", nullable=false, length=50)	
	private String evalCode;
	
	@Column(name="evalTitle", nullable=false, length=255)	
	private String evalTitle;
	
	@Column(name="creator", nullable=false, length=50)	
	private String creator;
	
	@Column(name="hasDept", nullable=false)	
	private int hasDept;
	
	@Column(name="createDate", nullable=false)	
	private java.sql.Timestamp createDate;
	
	@ManyToOne(targetEntity=Attachments.class, fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumns({ @JoinColumn(name="evalAttach", referencedColumnName="attachID") })	
	private Attachments evalAttach;
	
	@OneToMany(targetEntity=BenefitEvalItem.class, fetch=FetchType.EAGER , cascade = { CascadeType.ALL})
	@JoinColumns({ @JoinColumn(name="evalID", nullable=false) })	
	private java.util.List<BenefitEvalItem> benefitEvalItem = new java.util.ArrayList<BenefitEvalItem>();
	
	private void setEvalID(int value) {
		this.evalID = value;
	}
	
	public int getEvalID() {
		return evalID;
	}
	
	private void setHasDept(int value) {
		this.hasDept = value;
	}
	
	public int getHasDept() {
		return hasDept;
	}
	
	public int getORMID() {
		return getEvalID();
	}
	
	public void setProcessID(String value) {
		this.processID = value;
	}
	
	public String getProcessID() {
		return processID;
	}
	
	public void setEvalCode(String value) {
		this.evalCode = value;
	}
	
	public String getEvalCode() {
		return evalCode;
	}
	
	public void setEvalTitle(String value) {
		this.evalTitle = value;
	}
	
	public String getEvalTitle() {
		return evalTitle;
	}
	
	public void setCreator(String value) {
		this.creator = value;
	}
	
	public String getCreator() {
		return creator;
	}
	
	public void setCreateDate(java.sql.Timestamp value) {
		this.createDate = value;
	}
	
	public java.sql.Timestamp getCreateDate() {
		return createDate;
	}
	
	public void setEvalAttach(Attachments value) {
		this.evalAttach = value;
	}
	
	public Attachments getEvalAttach() {
		return evalAttach;
	}
	
	public void setBenefitEvalItem(java.util.List<BenefitEvalItem> value) {
		this.benefitEvalItem = value;
	}
	
	public java.util.List<BenefitEvalItem> getBenefitEvalItem() {
		return benefitEvalItem;
	}
	
	
	public String toString() {
		return String.valueOf(getEvalID());
	}
	
}
