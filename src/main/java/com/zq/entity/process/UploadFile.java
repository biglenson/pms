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

/**
 * 上传附件表。
 */
@Entity
@Table(name="d_upload_file")
public class UploadFile implements Serializable {
	public UploadFile() {
	}
	
	@Column(name="upFileID", nullable=false, length=11)	
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int upFileID;
	
	@Column(name="upFileCode", nullable=true, length=50)	
	private String upFileCode;
	
	@Column(name="upFileOriginName", nullable=true, length=255)	
	private String upFileOriginName;
	
	@Column(name="upFileSavedName", nullable=true, length=255)	
	private String upFileSavedName;
	
	@Column(name="uploadTime", nullable=true)	
    @Temporal(TemporalType.TIMESTAMP)
	private Date uploadTime;
	
	@Column(name="commitTime", nullable=false)	
    @Temporal(TemporalType.TIMESTAMP)
	private Date commitTime;
	
	@Column(name="uploadStatus", nullable=true, length=11)	
	private Integer uploadStatus;
	
	/**
	 * 上传文件ID：物理主键
	 */
	private void setUpFileID(int value) {
		this.upFileID = value;
	}
	
	/**
	 * 上传文件ID：物理主键
	 */
	public int getUpFileID() {
		return upFileID;
	}
	
	public int getORMID() {
		return getUpFileID();
	}
	
	/**
	 * 上传文件编码：逻辑主键：保留字段
	 */
	public void setUpFileCode(String value) {
		this.upFileCode = value;
	}
	
	/**
	 * 上传文件编码：逻辑主键：保留字段
	 */
	public String getUpFileCode() {
		return upFileCode;
	}
	
	/**
	 * 上传文件原始名称
	 */
	public void setUpFileOriginName(String value) {
		this.upFileOriginName = value;
	}
	
	/**
	 * 上传文件原始名称
	 */
	public String getUpFileOriginName() {
		return upFileOriginName;
	}
	
	/**
	 * 上传文件存储名称
	 */
	public void setUpFileSavedName(String value) {
		this.upFileSavedName = value;
	}
	
	/**
	 * 上传文件存储名称
	 */
	public String getUpFileSavedName() {
		return upFileSavedName;
	}
	
	/**
	 * 上传时间
	 */
	public void setUploadTime(Date value) {
		this.uploadTime = value;
	}
	
	/**
	 * 上传时间
	 */
	public Date getUploadTime() {
		return uploadTime;
	}
	
	/**
	 * 提交时间
	 */
	public void setCommitTime(Date value) {
		this.commitTime = value;
	}
	
	/**
	 * 提交时间
	 */
	public Date getCommitTime() {
		return commitTime;
	}
	
	/**
	 * 上传状态：1-上传、2-删除、3-提交
	 */
	public void setUploadStatus(int value) {
		setUploadStatus(new Integer(value));
	}
	
	/**
	 * 上传状态：1-上传、2-删除、3-提交
	 */
	public void setUploadStatus(Integer value) {
		this.uploadStatus = value;
	}
	
	/**
	 * 上传状态：1-上传、2-删除、3-提交
	 */
	public Integer getUploadStatus() {
		return uploadStatus;
	}
	
	public String toString() {
		return String.valueOf(getUpFileID());
	}
	
}
