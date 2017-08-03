package com.zq.vo.process;

import java.util.*;
import java.io.Serializable;

public class BenefitEvalTplVO implements Serializable  {

	private int tplID;
	private String tplTitle;
	private Integer evalPhase;
	private int evalFor;
	private Date createTime;
	private int listOrder;
	private String version;
	private String templateDesc;
	private String creator;

    public BenefitEvalTplVO() {
    }

	public int getTplID() {
		// TODO - implement BenefitEvalTplVO.getID
        return this.tplID;
	}


	/**
	 * 
	 * @param ID
	 */
	public void setTplID(int tplID) {
		// TODO - implement BenefitEvalTplVO.setID
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

	public Integer getEvalPhase() {
		return this.evalPhase;
	}

	/**
	 * 
	 * @param evalPhase
	 */
	public void setEvalPhase(Integer evalPhase) {
		this.evalPhase = evalPhase;
	}

	public int getEvalFor() {
		return this.evalFor;
	}

	/**
	 * 
	 * @param evalFor
	 */
	public void setEvalFor(int evalFor) {
		this.evalFor = evalFor;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	/**
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	public String getVersion() {
		return this.version;
	}

	/**
	 * 
	 * @param version
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	public String getTemplateDesc() {
		return this.templateDesc;
	}

	/**
	 * 
	 * @param templateDesc
	 */
	public void setTemplateDesc(String templateDesc) {
		this.templateDesc = templateDesc;
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

}
