package com.zq.vo.process;

import java.util.*;
import java.sql.Timestamp;
import java.io.Serializable;

public class BenefitEvalVO {

	private int evalID;
	private String processID;
	private String evalCode;
	private String evalTitle;
	private String creator;
	private Timestamp createDate;
	private int tplID;
	private String tplTitle;
	private int evalPhase;
	private int evalFor;
	private int hasDept;

	public int getEvalID() {
		return this.evalID;
	}

	/**
	 * 
	 * @param evalID
	 */
	public void setEvalID(int evalID) {
		this.evalID = evalID;
	}

	public String getProcessID() {
		return this.processID;
	}

	/**
	 * 
	 * @param processID
	 */
	public void setProcessID(String processID) {
		this.processID = processID;
	}

	public String getEvalCode() {
		return this.evalCode;
	}

	/**
	 * 
	 * @param evalCode
	 */
	public void setEvalCode(String evalCode) {
		this.evalCode = evalCode;
	}

	public String getEvalTitle() {
		return this.evalTitle;
	}

	/**
	 * 
	 * @param evalTitle
	 */
	public void setEvalTitle(String evalTitle) {
		this.evalTitle = evalTitle;
	}

	public String getCreator() {
		return this.creator;
	}

	/**
	 * 
	 * @param creator
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	/**
	 * 
	 * @param createDate
	 */
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public int getTplID() {
		return this.tplID;
	}

	public void setTplID(int tplID) {
		this.tplID = tplID;
	}

	public String getTplTitle() {
		return this.tplTitle;
	}

	/**
	 * 
	 * @param tplTitle
	 */
	public void setTplTitle(String tplTitle) {
		this.tplTitle = tplTitle;
	}

	public int getEvalPhase() {
		return this.evalPhase;
	}

	public void setEvalPhase(int evalPhase) {
		this.evalPhase = evalPhase;
	}

	public int getEvalFor() {
		return this.evalFor;
	}

	public void setEvalFor(int evalFor) {
		this.evalFor = evalFor;
	}

	public int getHasDept() {
		return this.hasDept;
	}

	public void setHasDept(int hasDept) {
		this.hasDept = hasDept;
	}

}
