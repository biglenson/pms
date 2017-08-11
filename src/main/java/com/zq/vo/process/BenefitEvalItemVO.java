package com.zq.vo.process;

import java.util.*;
import java.sql.Timestamp;
import java.io.Serializable;

public class BenefitEvalItemVO {

	private int itemID;
	private int tplItemID;
	private String evalDimension;
	private String evalItem;
	private String evalDesc;
	private String refValue;
	private String evalValue;
	private String evalNote;
	private int listOrder;

	public int getItemID() {
		return this.itemID;
	}

	/**
	 * 
	 * @param itemID
	 */
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getEvalItem() {
		return this.evalItem;
	}

	/**
	 * 
	 * @param evalItem
	 */
	public void setEvalItem(String evalItem) {
		this.evalItem = evalItem;
	}

	public String getEvalDimension() {
		return this.evalDimension;
	}

	public void setEvalDimension(String evalDimension) {
		this.evalDimension = evalDimension;
	}

	public String getEvalDesc() {
		return this.evalDesc;
	}

	public void setEvalDesc(String evalDesc) {
		this.evalDesc = evalDesc;
	}

	public String getRefValue() {
		return this.refValue;
	}

	/**
	 * 
	 * @param refValue
	 */
	public void setRefValue(String refValue) {
		this.refValue = refValue;
	}

	public String getEvalValue() {
		return this.evalValue;
	}

	/**
	 * 
	 * @param evalValue
	 */
	public void setEvalValue(String evalValue) {
		this.evalValue = evalValue;
	}

	public String getEvalNote() {
		return this.evalNote;
	}

	/**
	 * 
	 * @param evalNote
	 */
	public void setEvalNote(String evalNote) {
		this.evalNote = evalNote;
	}

	public int getListOrder() {
		return this.listOrder;
	}

	public void setListOrder(int listOrder) {
		this.listOrder = listOrder;
	}

	/**
	 * 
	 * @param tplItemID
	 */
	public int getTplItemID() {
		return this.tplItemID;
	}

	public void setTplItemID(int tplItemID) {
		this.tplItemID = tplItemID;
	}

}
