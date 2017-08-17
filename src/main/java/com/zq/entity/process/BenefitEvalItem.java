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
@Table(name="d_benefit_eval_item")
public class BenefitEvalItem implements Serializable {
	public BenefitEvalItem() {
	}
	
	@Column(name="itemID", nullable=false, length=11)	
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int itemID;
	
	@Column(name="evalID", nullable=false, length=11)	
	private int evalID;
	
	@Column(name="tplItemID", nullable=false, length=11)	
	private int tplItemID;
	
	@Column(name="evalValue", nullable=false, length=255)	
	private String evalValue;
	
	@Column(name="evalNote", nullable=true, length=255)	
	private String evalNote;
	
	private void setItemID(int value) {
		this.itemID = value;
	}
	
	public int getItemID() {
		return itemID;
	}
	
	public void setTplItemID(int value) {
		this.tplItemID = value;
	}
	
	public int getTplItemID() {
		return tplItemID;
	}
	
	public void setEvalID(int value) {
		this.evalID = value;
	}
	
	public int getEvalID() {
		return evalID;
	}
	
	public int getORMID() {
		return getItemID();
	}
	
	public void setEvalValue(String value) {
		this.evalValue = value;
	}
	
	public String getEvalValue() {
		return evalValue;
	}
	
	public void setEvalNote(String value) {
		this.evalNote = value;
	}
	
	public String getEvalNote() {
		return evalNote;
	}
	
	public String toString() {
		return String.valueOf(getItemID());
	}
	
}
