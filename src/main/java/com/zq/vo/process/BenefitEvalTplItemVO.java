package com.zq.vo.process;

import java.util.*;
import java.io.Serializable;

public class BenefitEvalTplItemVO implements Serializable{

	private int tplItemID;
	private String evalDimension;
	private String evalItem;
	private String evalDesc;
	private String refValue;
	private int listOrder;
	private int tplID;

    public BenefitEvalTplItemVO() {
    }

	public int getTplItemID() {
		return this.tplItemID;
	}

	/**
	 * 
	 * @param tplItemID
	 */
	public void setTplItemID(int tplItemID) {
		this.tplItemID = tplItemID;
	}

	public String getEvalDimension() {
		return this.evalDimension;
	}

	/**
	 * 
	 * @param evalDimension
	 */
	public void setEvalDimension(String evalDimension) {
		this.evalDimension = evalDimension;
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

	public String getEvalDesc() {
		return this.evalDesc;
	}

	/**
	 * 
	 * @param evalDesc
	 */
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
	public void setTplID(int tplID) {
		this.tplID = tplID;
	}

	public int getTplID() {
		return this.tplID;
	}


	public int getListOrder() {
		return this.listOrder;
	}

	/**
	 * 
	 * @param listOrder
	 */
	public void setListOrder(int listOrder) {
		this.listOrder = listOrder;
	}

}
