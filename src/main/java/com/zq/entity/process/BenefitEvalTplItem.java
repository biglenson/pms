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
@Table(name="g_benefit_eval_tpl_item")
public class BenefitEvalTplItem implements Serializable {
	public BenefitEvalTplItem() {
	}
	
	@Column(name="tplItemID", nullable=false, length=11)	
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int tplItemID;
	
	@Column(name="tplID", nullable=false, length=11)	
	private int tplID;
	
	@Column(name="evalDimension", nullable=false, length=50)	
	private String evalDimension;
	
	@Column(name="evalItem", nullable=false, length=50)	
	private String evalItem;
	
	@Column(name="evalDesc", nullable=false, length=255)	
	private String evalDesc;
	
	@Column(name="refValue", nullable=false, length=255)	
	private String refValue;
	
	@Column(name="listOrder", nullable=false, length=11)	
	private int listOrder;
	
	public int getTplItemID() {
		return tplItemID;
	}
	
	public void setEvalDimension(String value) {
		this.evalDimension = value;
	}
	
	public String getEvalDimension() {
		return evalDimension;
	}
	
	public void setTplID(int value) {
		this.tplID = value;
	}
	
	public int getTplID() {
		return tplID;
	}
	
	public void setEvalItem(String value) {
		this.evalItem = value;
	}
	
	public String getEvalItem() {
		return evalItem;
	}
	
	public void setEvalDesc(String value) {
		this.evalDesc = value;
	}
	
	public String getEvalDesc() {
		return evalDesc;
	}
	
	public void setRefValue(String value) {
		this.refValue = value;
	}
	
	public String getRefValue() {
		return refValue;
	}
	
	public void setListOrder(int value) {
		this.listOrder = value;
	}
	
	public int getListOrder() {
		return listOrder;
	}
	
	public String toString() {
		return String.valueOf(getTplItemID());
	}
	
}
