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
@Table(name="d_attachments")
public class Attachments implements Serializable {
	public Attachments() {
	}
	
	@Column(name="attachID", nullable=false, length=11)	
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int attachID;
	
	@Column(name="fileCount", nullable=true, length=11)	
	private Integer fileCount;
	
	@OneToMany(targetEntity=UploadFile.class, fetch=FetchType.EAGER , cascade = { CascadeType.ALL})	
	@JoinColumns({ @JoinColumn(name="attachID", nullable=false) })	
    private java.util.List<UploadFile> uploadFile = new ArrayList<UploadFile>();
	
	private void setAttachID(int value) {
		this.attachID = value;
	}
	
	public int getAttachID() {
		return attachID;
	}
	
	public int getORMID() {
		return getAttachID();
	}
	
	public void setFileCount(int value) {
		setFileCount(new Integer(value));
	}
	
	public void setFileCount(Integer value) {
		this.fileCount = value;
	}
	
	public Integer getFileCount() {
		return fileCount;
	}
	
	public void setUploadFile(java.util.List<UploadFile> value) {
		this.uploadFile = value;
	}
	
	public java.util.List<UploadFile> getUploadFile() {
		return uploadFile;
	}
	
	
	public String toString() {
		return String.valueOf(getAttachID());
	}
	
}
