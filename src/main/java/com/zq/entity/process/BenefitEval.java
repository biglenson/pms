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
	
	@Column(name="tplID", nullable=true, unique=true, length=50)	
	private int tplID;
	
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
    @Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@ManyToOne(targetEntity=Attachments.class, fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumns({ @JoinColumn(name="evalAttach", referencedColumnName="attachID") })	
	private Attachments evalAttach;
	
	public int getEvalID() {
		return evalID;
	}
	
	public void setTplID(int value) {
		this.tplID = value;
	}
	
	public int getTplID() {
		return tplID;
	}
	public void setHasDept(int value) {
		this.hasDept = value;
	}
	
	public int getHasDept() {
		return hasDept;
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
	
	public void setCreateDate(Date value) {
		this.createDate = value;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setEvalAttach(Attachments value) {
		this.evalAttach = value;
	}
	
	public Attachments getEvalAttach() {
		return evalAttach;
	}
	
	
	public String toString() {
		return String.valueOf(getEvalID());
	}
	
}
