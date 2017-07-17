package com.zq.entity.system;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sys_form database table.
 * 
 */
@Entity
@Table(name="sys_form")
public class SysForm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String attribute;

	private String description;

	private String form;

	private String name;

	private int seqno;

	private String style;
	
	private String fieldType;
	
	private int editFlag;
	
	private int editWidth;

	public SysForm() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAttribute() {
		return this.attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getForm() {
		return this.form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeqno() {
		return this.seqno;
	}

	public void setSeqno(int seqno) {
		this.seqno = seqno;
	}

	public String getStyle() {
		return this.style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
	public String getClassName() {
		return this.getClass().getName();
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public int getEditFlag() {
		return editFlag;
	}

	public void setEditFlag(int editFlag) {
		this.editFlag = editFlag;
	}

	public int getEditWidth() {
		return editWidth;
	}

	public void setEditWidth(int editWidth) {
		this.editWidth = editWidth;
	}

}